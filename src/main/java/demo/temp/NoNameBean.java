package demo.temp;

import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@Component
public class NoNameBean {

    private int id;

    public int getId() {
        return id;
    }

    public NoNameBean setId(int id) {
        this.id = id;
        return this;
    }
}
