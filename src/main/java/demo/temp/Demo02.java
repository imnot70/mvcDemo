package demo.temp;

/**
 * @author imnot
 */
public class Demo02 {
    public static void main(String[] args) {
        ParentTest pt = new ParentTest();
        pt.test();

        System.out.println("=================");

        ParentTest ct = new ChildTest();
        ct.test();
    }
}
