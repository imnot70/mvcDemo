package demo.designpattern.decorator;

/**
 * @author imnot
 */
public class Sugar extends Decorator {
	
	public Sugar(Drink drink) {
		super(drink);
		setName("sugar");
		setPrice(1.0);
	}

}
