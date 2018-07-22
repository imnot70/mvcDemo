package demo.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo001 {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>(Arrays.asList("1","2","3","4","5","6","7","8"));

        List<String> strs1 = strs.subList(0,4);
        List<String> strs2 = strs.subList(4,8);

        System.out.println(strs1);
        System.out.println(strs2);

        Thread t1 = new TestThread(strs1);
        Thread t2 = new TestThread(strs2);

        t1.start();
        t2.start();
    }


    @Test
    public void test01(){

    }

}
