package demo.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangpeng
 * @description
 * @date 2020-09-16 11:31 下午
 **/
public class ArrayListDemo {

    private static final int LENGTH = 128;

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>(256);

        Runnable r1 = () -> {
            for (int i = 0; i < LENGTH; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("r1" + i);
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < LENGTH; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add("r2" + i);
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(list);
    }

}
