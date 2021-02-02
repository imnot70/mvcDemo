package demo.designpattern.decorator;

/**
 * @author imnot
 */
public abstract class Coffee extends Drink{

	@Override
	public double cost() {
//		System.out.println("coffee,getPrice:"+getPrice());
		return getPrice();
	}
	
}
