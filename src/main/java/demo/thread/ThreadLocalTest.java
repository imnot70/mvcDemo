package demo.thread;

import demo.utils.TimeUtil;

import java.util.Date;

/**
 * @author imnot
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        test0();
    }

    public static void test0(){
        ThreadLocal<String> container1 = new ThreadLocal<>();
        ThreadLocal<String> container2 = new ThreadLocal<>();
        container1.set("A");
        container2.set("B");
        System.out.println(container1.get());
        System.out.println(container2.get());
    }

    public static void test1(){
        Date date = new Date();
        System.out.println(TimeUtil.formatTimeStandard(date));
        System.out.println(TimeUtil.formatTimeMinute(date));
    }
}
