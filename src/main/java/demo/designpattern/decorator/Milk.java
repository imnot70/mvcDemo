package demo.designpattern.decorator;

/**
 * @author imnot
 */
public class Milk extends Decorator {

	public Milk(Drink drink) {
		super(drink);
		setName("milk");
		setPrice(2.0);
	}

}
