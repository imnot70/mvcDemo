package springdemo.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@Component
public class AwareProcessorBean implements BeanFactoryPostProcessor, BeanPostProcessor, BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, BeanDefinitionRegistryPostProcessor {

    /**
     * 实现自BeanFactoryPostProcessor
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor#postProcessBeanFactory");
    }

    /**
     * 实现自BeanPostProcessor,接口中有默认实现
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor#postProcessBeforeInitialization,beanName:" + beanName);
        return bean;
    }

    /**
     * 实现自BeanPostProcessor,接口中有默认实现
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor#postProcessAfterInitialization,beanName:" + beanName);
        return bean;
    }

    /**
     * 实现自BeanNameAware
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware#setBeanName,name:"+name);
    }

    /**
     * 实现自BeanFactoryAware
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware#setBeanFactory");
    }

    /**
     * 实现自BeanClassLoaderAware
     * @param classLoader
     */
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware#setBeanClassLoader");
    }

    /**
     * 实现自BeanDefinitionRegistryPostProcessor
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry");
    }
}
