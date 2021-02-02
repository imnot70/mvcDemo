package demo.thread;

/**
 * @author imnot
 * 验证stop和interrupt
 */
public class Demo003 {

    public static void main(String[] args) throws Exception {
        test1();
    }

    private static void test2() throws InterruptedException {
        InnerThread t1 = new InnerThread();

        t1.start();
        Thread.sleep(3500);
        t1.interrupt();
        System.out.println("finish");
    }

    private static void test1() throws InterruptedException {
        InnerThread t1 = new InnerThread();

        t1.start();
        Thread.sleep(3500);
        t1.stop();
        System.out.println("finish");
    }

    static class InnerThread extends Thread{
        @Override
        public void run() {
            int size = 10;
            for (int i = 1; i<= size; i++){
                System.out.println("i:"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
