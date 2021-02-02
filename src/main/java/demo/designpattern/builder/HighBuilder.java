package demo.designpattern.builder;

/**
 * @author imnot
 */
public class HighBuilder extends AbstractBuilder {

	public HighBuilder(House house) {
		super(house);
	}

	@Override
	public void buildBase() {
		System.out.println("hignBase");
		super.getHouse().setBase("highBase");
	}

	@Override
	public void buildWall() {
		System.out.println("highWall");
		super.getHouse().setWall("highWall");
	}

	@Override
	public void buildRoof() {
		System.out.println("highRoof");
		super.getHouse().setRoof("highRoof");
	}

}
