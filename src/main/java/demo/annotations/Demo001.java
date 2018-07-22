package demo.annotations;


import org.junit.Test;

public class Demo001 {

    @Test
    public void test001(){
        AnnoDemo001 a = new AnnoDemo001();
        System.out.println(a.getTestFiled());
    }

}
