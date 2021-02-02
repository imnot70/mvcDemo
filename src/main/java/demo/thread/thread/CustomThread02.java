package demo.thread.thread;

/**
 * @author imnot
 */
public class CustomThread02 extends Thread{

    public CustomThread02(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadName:"+super.getName());
    }
}
