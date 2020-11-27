package demo.pressure;

/**
 * @author zhangpeng
 * @description
 * @date 2020-11-18 下午2:25
 **/
public class TestMainClass {
    public static void main(String[] args) throws InterruptedException {
        int size = 10000000;

        long startTime = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                CounterCas.increase();
            }
        });
        t1.start();
        for (int i = 0; i < size; i++) {
            CounterCas.increase();
        }
        t1.join();

        long endTime = System.currentTimeMillis();
        System.out.println(CounterCas.getNum());
        System.out.println(endTime - startTime);
    }
}
