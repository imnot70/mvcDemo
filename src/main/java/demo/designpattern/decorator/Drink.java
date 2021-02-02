package demo.designpattern.decorator;

/**
 * @author imnot
 */
public abstract class Drink {
	
	private String name;
	private Double price;
	
	abstract protected double cost();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
