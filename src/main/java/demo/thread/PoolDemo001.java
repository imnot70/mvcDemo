package demo.thread;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolDemo001 {


    @Test
    public void test001(){
        ExecutorService exe = Executors.newCachedThreadPool();
    }

}
