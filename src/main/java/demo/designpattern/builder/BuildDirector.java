package demo.designpattern.builder;

/**
 * @author imnot
 */
public class BuildDirector {

	private AbstractBuilder builder;
	
	public BuildDirector(AbstractBuilder builder) {
		this.builder = builder;
	}

	public AbstractBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(AbstractBuilder builder) {
		this.builder = builder;
	}
	
}
