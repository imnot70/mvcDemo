package demo.thread;

import java.util.concurrent.*;

/**
 * @author imnot
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(2, 2, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        executor.execute(() -> System.out.println("A"));
        executor.execute(() -> System.out.println("B"));
        executor.execute(() -> System.out.println("C"));

        executor.shutdown();
    }

}
