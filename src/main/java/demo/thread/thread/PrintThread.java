package demo.thread.thread;

/**
 * @author imnot
 */
public class PrintThread extends Thread {

    private final String varName;

    public PrintThread(String varName) {
        this.varName = varName;
    }

    @Override
    public void run() {
        System.out.println("varName:" + this.varName);
    }

}
