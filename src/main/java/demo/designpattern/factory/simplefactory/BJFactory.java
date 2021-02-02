package demo.designpattern.factory.simplefactory;

/**
 * @author imnot
 */
public class BJFactory extends AbstractFactory {

	@Override
	public Pizza makePizza() {
		return new Pizza().setName("BJPizza").setPrice(10.0);
	}

}
