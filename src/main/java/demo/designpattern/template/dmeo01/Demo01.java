package demo.designpattern.template.dmeo01;

/**
 * @author imnot
 */
public class Demo01 {
    public static void main(String[] args) {
        SubClass1 sc1 = new SubClass1();
        sc1.test1();

        System.out.println("===========================");
        SubClass2 sc2 = new SubClass2();
        sc2.test1();
    }
}
