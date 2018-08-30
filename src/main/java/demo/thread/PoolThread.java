package demo.thread;

public class PoolThread extends Thread {

    public PoolThread() {
    }

    public PoolThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("thread name:"+this.getName());
    }
}
