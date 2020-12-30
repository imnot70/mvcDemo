package demo.pressure;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangpeng
 * @description
 * @date 2020-11-20 下午5:37
 **/
public class CounterCas {

    private static AtomicInteger num = new AtomicInteger();

    public static void increase(){
        num.incrementAndGet();
    }

    public static int getNum() {
        return num.get();
    }
}
