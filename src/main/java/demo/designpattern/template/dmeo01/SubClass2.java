package demo.designpattern.template.dmeo01;

/**
 * @author imnot
 */
public class SubClass2 extends Template{

    @Override
    protected void subMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
