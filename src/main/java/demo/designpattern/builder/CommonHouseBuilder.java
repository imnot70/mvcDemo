package demo.designpattern.builder;

/**
 * @author imnot
 */
public class CommonHouseBuilder extends AbstractBuilder {
	
	public CommonHouseBuilder(House house) {
		super(house);
	}

	@Override
	public void buildBase() {
		System.out.println("commonBase");
		super.getHouse().setBase("commonBase");
	}

	@Override
	public void buildWall() {
		System.out.println("commonWall");
		super.getHouse().setWall("commonWall");
	}

	@Override
	public void buildRoof() {
		System.out.println("commonRoof");
		super.getHouse().setRoof("commonRoof");
	}

}
