package demo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (context == null) {
            context = applicationContext;
        }
    }

    public static ApplicationContext getContext(){
        return context;
    }

    public static <T> T getBean(Class<T> t){
        return context.getBean(t);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName){
        return (T) context.getBean(beanName);
    }
}
