package demo.thread;

/**
 * @author imnot
 * interrupt，与{@link demo.thread.Demo003}类似
 */
public class Demo005 {

    public static void main(String[] args) throws Exception {
        test4();
    }

    private static void test4() throws Exception{
        Thread t1 = new Thread(() -> {
            for (int i=0;i<50;i++){
                if(Thread.interrupted()){
                    System.out.println("t1 is interrupted");
                    break;
                }
                System.out.println("i:" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("out of forEach");
        });

        t1.start();
        Thread.sleep(50);
        t1.interrupt();

    }

    /**
     * 尝试使用标识
     */
    private static void test3() throws Exception {
        InnerThread  t1 = new InnerThread();
        t1.start();
        Thread.sleep(100);
        t1.setExit(true);
        System.out.println("t1 interrupted:" + t1.isInterrupted());
    }

    /**
     * stop会强制结束正在运行的线程，下面的out of forEach不会输出
     */
    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("i:" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("out of forEach");
            System.out.println("interrupted:" + Thread.interrupted());
        });

        t1.start();
        Thread.sleep(100);
        t1.stop();
        System.out.println(t1.isInterrupted());
    }

    /**
     * interrupt并不能立即中断正在运行的线程，调用了interrupt后，
     * for循环仍然会继续执行
     */
    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("i:" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("out of forEach");
            System.out.println("interrupted:" + Thread.interrupted());
        });

        t1.start();
        Thread.sleep(100);
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }
    static class InnerThread extends Thread{
        private volatile boolean exit = false;

        public boolean isExit() {
            return exit;
        }

        public void setExit(boolean exit) {
            this.exit = exit;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                if(exit){
                    break;
                }
                System.out.println("i:" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("out of forEach");
            System.out.println("interrupted:" + Thread.interrupted());
        }
    }
}
