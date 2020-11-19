package demo.dependence;

import org.springframework.stereotype.Component;

/**
 * @author imnot
 */
@Component
public class DependClassB {
    private DependClassA dca;

    public DependClassA getDca() {
        return dca;
    }

    public void setDca(DependClassA dca) {
        this.dca = dca;
    }
}
