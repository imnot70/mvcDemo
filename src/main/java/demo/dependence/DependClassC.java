package demo.dependence;

import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@Component
public class DependClassC {
    private DependClassD dcd;

    public DependClassC() {
    }

    public DependClassC(DependClassD dcd) {
        this.dcd = dcd;
    }

    public DependClassD getDcd() {
        return dcd;
    }

    public void setDcd(DependClassD dcd) {
        this.dcd = dcd;
    }
}
