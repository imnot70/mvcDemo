package demo.designpattern.decorator;

/**
 * @author imnot
 */
public abstract class Decorator extends Drink {

	private Drink drink;
	
	public Decorator(Drink drink) {
//		System.out.println("drink.price:"+drink.getPrice());
		this.drink = drink;
	}
	
	@Override
	public double cost() {
//		System.out.println("decorator,getPrice:"+getPrice()+",drink.price:"+drink.getPrice());
		return getPrice()+drink.cost();
	}
	
}
