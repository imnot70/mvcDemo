package springdemo.processor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springdemo.bean.SpringBean01;
import springdemo.bean.SpringBean02;
import springdemo.bean.SpringBean03;

/**
 * @author imnot
 */
@ComponentScan("springdemo")
public class BeanFactoryPostProcessTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanFactoryPostProcessTest.class);
        SpringBean02 sb02 = context.getBean(SpringBean02.class);
        System.out.println(sb02);

        SpringBean03 sb03 = (SpringBean03) context.getBean("springBean01");
        System.out.println(sb03);
    }
}
