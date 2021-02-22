package demo.temp;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@Component
public class Bean implements BeanNameAware {

    private int id;

    public int getId() {
        return id;
    }

    public Bean setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName:" + name);
    }
}
