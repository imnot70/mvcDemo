package demo.designpattern.decorator;

/**
 * @author imnot
 */ // 调用端
public class Client {
	
	public static void main(String[] args) {
//		Drink coffee = new ShortBlack();
//		System.out.println(coffee.cost());
//		
//		System.out.println("===============================");
//
//		Drink coffee1 = new ShortBlack();
//		coffee1 = new Sugar(coffee1);
//		System.out.println(coffee1.cost());
//		
//		System.out.println("===============================");
		
		Drink coffee2 = new ShortBlack();
		coffee2 = new Milk(coffee2);
		System.out.println(coffee2.cost());
		coffee2 = new Sugar(coffee2);
		System.out.println(coffee2.cost());
	}
	

}
