package demo.thread;

/**
 * @author imnot
 * https://blog.csdn.net/qq_36333309/article/details/105298194
 * catch中捕获的是Exception，stop会拋出ThreadDeath，是一种Error，catch Exception是无效的
 * 如果改成catch Throwable或者Error，则可以正常执行“重要的业务方法”
 */
public class Demo004 {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("子线程开始执行");
                // 模拟业务处理
                Thread.sleep(1000);
            } catch (Error | InterruptedException e) { }
            // 伪代码：重要的业务方法
            System.out.println("子线程的重要业务方法");
        });
        t1.start();
        // 让子线程先运行一点业务
        Thread.sleep(100);
        // 终止子线程
        t1.stop();
        // 等待一段时间，确保子线程“执行完”
        Thread.sleep(3000);
        System.out.println("主线程执行完成");
    }
}
