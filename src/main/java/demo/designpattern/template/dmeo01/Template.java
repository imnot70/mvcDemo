package demo.designpattern.template.dmeo01;

/**
 * @author imnot
 */
public abstract class Template {

    public void test1(){
        long start = System.currentTimeMillis();
        subMethod();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    protected abstract void subMethod();

}
