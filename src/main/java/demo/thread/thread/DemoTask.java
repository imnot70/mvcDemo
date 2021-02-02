package demo.thread.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author zhangpeng
 * @description
 * @date 2020-08-12 8:19 下午
 **/
public class DemoTask implements Callable<Integer> {

    private Integer num = null;

    public DemoTask() {
    }

    public DemoTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {

        Random random = new Random();
        long sleep = random.nextInt(5000);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        if (num != null) {
            System.out.println("ThreadId:" + Thread.currentThread().getId() + ",num:" + num + ",sleep:" + sleep + ",time:" + sdf.format(new Date()));
        } else {
            System.out.println("ThreadId:" + Thread.currentThread().getId() + ",sleep:" + sleep + ",time:" + sdf.format(new Date()));
        }

        Thread.sleep(sleep);

        return new Long(Thread.currentThread().getId()).intValue();
    }

    public int getNum() {
        return num;
    }

    public DemoTask setNum(int num) {
        this.num = num;
        return this;
    }
}
