package demo.thread;

import demo.thread.thread.DemoTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhangpeng
 * @description
 * @date 2020-08-12 8:25 下午
 **/
public class DemoFutureTask {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        DemoTask task1 = new DemoTask();
        Future<Integer> futureResult1 = service.submit(task1);

        while (true) {
            try {
                if (futureResult1.isDone()) {
                    Integer result = futureResult1.get();
                    System.out.println(result);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                service.shutdown();
            }
        }
    }
}
