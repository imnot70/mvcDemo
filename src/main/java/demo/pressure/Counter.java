package demo.pressure;

/**
 * @author zhangpeng
 * @description
 * @date 2020-11-20 下午5:36
 **/
public class Counter {
    private static int num = 0;

    public static synchronized void increase(){
        num++;
    }

    public static int getNum() {
        return num;
    }

}
