package demo.designpattern.factory.simplefactory;

/**
 * @author imnot
 */
public class Pizza {

	private String name;
	private Double price;
	
	public String getName() {
		return name;
	}
	public Pizza setName(String name) {
		this.name = name;
		return this;
	}
	public Double getPrice() {
		return price;
	}
	public Pizza setPrice(Double price) {
		this.price = price;
		return this;
	}
	
}
