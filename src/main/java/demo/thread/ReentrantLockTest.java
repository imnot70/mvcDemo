package demo.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangpeng
 * @description
 * @date 2021-01-11 上午9:42
 **/
public class ReentrantLockTest {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);
        try {
            lock.lock();
            System.out.println("after lock");
            System.out.println(lock.toString());
        } finally {
            lock.unlock();
        }
        System.out.println("after unlock");


    }
}
