package springdemo.bean;

import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@Component
public class SpringBean01 {
    private int id;

    private SpringBean02 sb02;

    public SpringBean01() {
        System.out.println("SpringBean01 Constructor");
    }

    public int getId() {
        return id;
    }

    public SpringBean01 setId(int id) {
        this.id = id;
        return this;
    }

    public SpringBean02 getSb02() {
        return sb02;
    }

    public SpringBean01 setSb02(SpringBean02 sb02) {
        this.sb02 = sb02;
        return this;
    }
}
