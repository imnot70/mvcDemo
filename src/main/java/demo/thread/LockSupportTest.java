package demo.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author imnot
 */
public class LockSupportTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test2(){
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("2");
    }
    public static void test1(){
        LockSupport.park();
        System.out.println("1");
    }
}
