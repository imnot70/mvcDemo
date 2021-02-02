package demo.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author imnot
 */
public class CrossPrintTest {

    private static final char[] NUM_ARRAY = "1234567".toCharArray();
    private static final char[] STR_ARRAY = "ABCDEFG".toCharArray();

    private static Thread t1 = null;
    private static Thread t2 = null;
    private static final Object LOCK = CrossPrintTest.class;

    public static void main(String[] args) {
        test3();
    }

    private static void test3(){
        t1 = new Thread(() -> {
            for (char aChar:NUM_ARRAY){
                synchronized (LOCK){
                    System.out.println(aChar);
                    LOCK.notify();
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2 = new Thread(() -> {
            for (char aChar:STR_ARRAY){
                synchronized (LOCK){
                    System.out.println(aChar);
                    LOCK.notify();
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    private static void test2() {
        t1 = new Thread(() -> {
            for (char aChar : NUM_ARRAY) {
                System.out.println(aChar);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2 = new Thread(() -> {
            for (char aChar : STR_ARRAY) {
                LockSupport.park();
                System.out.println(aChar);
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }

    /**
     * dead lock,不能使用相同的run方法来解决，只能使用不同的run方法逻辑来加锁/解锁
     */
    private static void test1() {
        t1 = new CustomThread(t2, NUM_ARRAY);
        t2 = new CustomThread(t1, STR_ARRAY);

        t1.start();
        t2.start();
    }

    static class CustomThread extends Thread {
        private final char[] chars;
        private final Thread thread;

        public CustomThread(Thread thread, char[] chars) {
            this.thread = thread;
            this.chars = chars;
        }

        @Override
        public void run() {
//            System.out.println("thread:" + thread);
            if (chars != null) {
                for (char aChar : chars) {
                    System.out.println(aChar);
                    LockSupport.unpark(thread);
                    LockSupport.park();
                }
            }
        }
    }

}
