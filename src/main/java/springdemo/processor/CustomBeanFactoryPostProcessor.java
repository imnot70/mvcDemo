package springdemo.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import springdemo.bean.SpringBean02;

/**
 * @author imnot
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 测试添加Bean
        System.out.println("test add SpringBean02");
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(SpringBean02.class);
        factory.registerBeanDefinition("springBean02",beanDefinition);

        // 测试修改Bean名称
        BeanDefinition sb01 = factory.getBeanDefinition("springBean01");
        // 将springBean01指向的类改为SpringBean03
        sb01.setBeanClassName("springdemo.bean.SpringBean03");
    }
}
