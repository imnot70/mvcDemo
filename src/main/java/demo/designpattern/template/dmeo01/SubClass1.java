package demo.designpattern.template.dmeo01;

/**
 * @author imnot
 */
public class SubClass1 extends Template{
    @Override
    protected void subMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
