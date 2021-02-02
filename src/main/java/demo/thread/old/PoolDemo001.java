package demo.thread.old;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author imnot
 */
public class PoolDemo001 {

    private int corePoolSize = 2;
    private int maximumPoolSize = 10;
    private int keepAliveTime = 1000*30;

    @Test
    public void test001(){
        ExecutorService exe = Executors.newCachedThreadPool();
        for(int i = 0;i<10;i++){
            exe.submit(new PoolThread());
        }
        exe.shutdown();
    }

    @Test
    public void test002(){

        ExecutorService exs = new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        for(int i = 0;i<10;i++){
            exs.submit(new PoolThread("t-"+i));
        }

        exs.shutdown();
    }

}
