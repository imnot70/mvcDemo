package demo.temp;

/**
 * @author zhangpeng
 * @description
 * @date 2020-12-30 下午5:46
 **/
public class Demo01 {
    public static void main(String[] args) {
        Class clazz = InterFaceA.class;
        System.out.println(clazz.getPackage().getName());
    }
}
