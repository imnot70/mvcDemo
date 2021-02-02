package demo.beans;

/**
 * @author imnot
 */
public class Person {
	
	public Person() {
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
