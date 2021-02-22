package demo.temp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author imnot
 */
@ComponentScan("demo.temp")
public class BeanNameAwareTest {

    public static void main(String[] args) {
        test2();
    }

    private static void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanNameAwareTest.class);
        Bean bean = context.getBean(Bean.class);
        System.out.println(bean);
        Bean bean1 = (Bean) context.getBean("bean");
        System.out.println(bean1);
        NoNameBean nnb = context.getBean(NoNameBean.class);
        System.out.println(nnb);
        NoNameBean nnb1 = (NoNameBean) context.getBean("noNameBean");
        System.out.println(nnb1);
    }

    private static void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanNameAwareTest.class);
        Bean1 b1 = context.getBean(Bean1.class);
        Bean2 b2 = context.getBean(Bean2.class);
        System.out.println(b1);
        System.out.println(b2);
    }
}
