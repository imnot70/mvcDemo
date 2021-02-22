package demo.temp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@Component
public class Bean1 implements BeanNameAware, BeanPostProcessor {

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName:" + name);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization,beanName:" + beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization,beanName:" + beanName);
        return null;
    }
}
