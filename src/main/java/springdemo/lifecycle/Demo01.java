package springdemo.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author imnot
 */
@ComponentScan("springdemo.lifecycle")
public class Demo01 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo01.class);
        AwareProcessorBean apb = context.getBean(AwareProcessorBean.class);
        System.out.println(apb);
    }
}
