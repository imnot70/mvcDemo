package springdemo.bean;

/**
 * @author imnot
 */
public class SpringBean02 {
    private int id;

    private SpringBean01 sb01;

    public SpringBean02() {
        System.out.println("SpringBean02 Constructor");
    }

    public int getId() {
        return id;
    }

    public SpringBean02 setId(int id) {
        this.id = id;
        return this;
    }

    public SpringBean01 getSb01() {
        return sb01;
    }

    public SpringBean02 setSb01(SpringBean01 sb01) {
        this.sb01 = sb01;
        return this;
    }
}
