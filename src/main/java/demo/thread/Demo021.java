package demo.thread;

import demo.beans.User;

/**
 * @author imnot
 */
public class Demo021 {

    private static final User USER = new User();

    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    private static void test2(){
        System.out.println("main,user:"+USER.toString());
        Thread[] threads = new Thread[6];
        for(int i=0;i<6;i++){
            threads[i] = new InnerThread1(USER);
        }
        for(int i=0;i<6;i++){
            threads[i].start();
        }
    }

    private static void test1() throws InterruptedException {
        Thread[] threads = new Thread[6];
        for(int i=0;i<6;i++){
            threads[i] = new InnerThread();

        }
        for(int i=0;i<6;i++){
            threads[i].start();
        }
        for(int i=0;i<6;i++){
            threads[i].join();
        }
    }

    static class InnerThread1 extends Thread{
        private final User user;
        public InnerThread1(User user) {
            this.user = user;
        }
        @Override
        public void run() {
            System.out.println("ThreadName:"+getName()+",user:"+user.toString());
        }
    }

    static class InnerThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 1000; i++) {
                    Thread.sleep(2);
                    System.out.println("ThreadName:" + getName() + ",i:" + i);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
