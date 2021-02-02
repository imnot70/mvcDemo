package demo.temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangpeng
 * @description
 * @date 2020-06-29 5:07 下午
 **/
public class ExecutorDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });

    }

}
