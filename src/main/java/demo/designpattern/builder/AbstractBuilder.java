package demo.designpattern.builder;

/**
 * @author imnot
 */
public abstract class AbstractBuilder {
	
	private House house;
	
	public AbstractBuilder(House house) {
		super();
		this.house = house;
	}

	public abstract void buildBase();
	
	public abstract void buildWall();
	
	public abstract void buildRoof();
	
	public void build() {
		buildBase();
		buildWall();
		buildRoof();
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}
