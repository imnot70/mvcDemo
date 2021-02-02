package demo.thread;

import demo.thread.thread.CustomThread02;
import org.springframework.util.StopWatch;

/**
 * @author imnot
 */
public class ThreadCoordinatorTest {

    public static void main(String[] args) throws InterruptedException {

        StopWatch watch = new StopWatch();
        Thread t1 = new CustomThread02("A");
        Thread t2 = new CustomThread02("B");
        Thread t3 = new CustomThread02("C");

        watch.start();
        t3.start();
        t3.join();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        watch.stop();
        System.out.println(watch.prettyPrint());
    }

}
