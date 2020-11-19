package demo.dependence;

import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@Component
public class DependClassD {

    private DependClassC dcc;

    public DependClassD() {
    }

    public DependClassD(DependClassC dcc) {
        this.dcc = dcc;
    }

    public DependClassC getDcc() {
        return dcc;
    }

    public void setDcc(DependClassC dcc) {
        this.dcc = dcc;
    }
}
