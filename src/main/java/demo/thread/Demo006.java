package demo.thread;

/**
 * @author imnot
 */
public class Demo006 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("i:" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        System.out.println("main sleep");
        Thread.sleep(1000);
        t1.suspend();
        Thread.sleep(1000);
        System.out.println("main wake");
        t1.resume();
    }
}
