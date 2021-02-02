package demo.designpattern.builder;


import demo.utils.JsonUtil;

/**
 * @author imnot
 */
public class Client {

	public static void main(String[] args) {
		
		House house = new House();
		AbstractBuilder builder = new CommonHouseBuilder(house);
		builder.build();
		JsonUtil.jackPrint(house);
		
		System.out.println("======================================");
		
		House house1 = new House();
		builder = new HighBuilder(house1);
		builder.build();
		JsonUtil.jackPrint(house1);
	}
	
}
