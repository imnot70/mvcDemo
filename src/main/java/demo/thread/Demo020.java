package demo.thread;

import demo.beans.User;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhangpeng
 */
public class Demo020 {

    private static final int SIZE = 10000000;

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        test1();
        long current = System.currentTimeMillis();
        System.out.println(current - start);
    }

    private static void testJol() throws Exception {
        User user = new User();
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println("=============================================");
        // JVM启动一定时间后会启用偏向锁，在这段时间后，新创建的对象，markword 都是101
        Thread.sleep(5000);
        User user1 = new User();
        System.out.println(ClassLayout.parseInstance(user1).toPrintable());
        System.out.println("=============================================");
        synchronized (user) {
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }
    }

    private static void test() throws Exception {
        AtomicInteger ai = new AtomicInteger(0);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < SIZE; i++) {
                ai.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < SIZE; i++) {
                ai.incrementAndGet();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ai.get());
    }

    private static void test1() throws Exception{
        LongAdder longAdder = new LongAdder();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < SIZE; i++) {
                longAdder.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < SIZE; i++) {
                longAdder.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(longAdder.longValue());
    }
}
