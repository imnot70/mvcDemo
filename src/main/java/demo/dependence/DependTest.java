package demo.dependence;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author imnot
 */
@ComponentScan("demo")
public class DependTest {

    public static void main(String[] args) {

        BeanFactory bf = null;

        Aware aware = null;

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DependTest.class);

        String[] names = ac.getBeanDefinitionNames();
        for (String name:names){
            System.out.println(name);
        }

        DependClassA dca = ac.getBean(DependClassA.class);
        System.out.println(dca);
    }

    public static void printString(final String content){
        System.out.println(content);
    }
}
