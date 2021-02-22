package demo.temp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@ComponentScan("demo.temp")
@Component
public class BeanFactoryAwareTest implements BeanFactoryAware {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanFactoryAwareTest.class);
        BeanFactoryAwareTest test = context.getBean(BeanFactoryAwareTest.class);
        System.out.println(test);
        BeanFactory factory = test.getFactory();
        System.out.println(factory);
        System.out.println(factory.containsBean("bean1"));
        System.out.println(factory.containsBean("beanFactoryAwareTest"));
    }

    private BeanFactory factory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
       this.factory = beanFactory;
    }

    public BeanFactory getFactory() {
        return factory;
    }
}
