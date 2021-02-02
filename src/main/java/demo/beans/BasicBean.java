package demo.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author imnot
 */
@Component("basicBean")
public class BasicBean implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
