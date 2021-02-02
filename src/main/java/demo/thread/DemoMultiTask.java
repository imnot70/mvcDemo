package demo.thread;

import demo.thread.thread.DemoTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhangpeng
 * @description
 * @date 2020-08-12 9:12 下午
 **/
public class DemoMultiTask {

    public static void main(String[] args) {
        List<Future<Integer>> futures = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for(int i=0;i<10;i++ ){
            Future<Integer> future = service.submit(new DemoTask(i));
            futures.add(future);
        }

        while(true){
            Iterator<Future<Integer>> iterator = futures.iterator();
            while(iterator.hasNext()){
                Future<Integer> future = iterator.next();
                try{
                    if(future.isDone()){
                        System.out.println(future.get());
                        iterator.remove();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                if(futures.size() == 0){
                    service.shutdown();
                    return;
                }
            }
        }
    }
}
