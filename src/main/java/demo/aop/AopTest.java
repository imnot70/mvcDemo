package demo.aop;

import demo.beans.BasicBean;
import demo.beans.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author imnot
 */
@EnableAspectJAutoProxy
@ComponentScan("demo")
public class AopTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopTest.class);
        BasicBean bean = (BasicBean) context.getBean("basicBean");
        bean.setId(100);

        User user = (User) context.getBean("user");
        user.setAge(10);
        System.out.println(bean);

        System.out.println("=============================================");

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String name:beanDefinitionNames){
            System.out.println(name);
        }
    }

}
