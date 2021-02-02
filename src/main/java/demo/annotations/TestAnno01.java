package demo.annotations;

import demo.beans.Person;

import java.lang.reflect.Field;

/**
 * @author imnot
 */
public class TestAnno01 {
	
	public static void main(String[] args) {
		Person person = new Person();
		System.out.println(person.getName());
		
		Class<Person> clazz = Person.class;
		Field[] fields = clazz.getDeclaredFields();
		if(fields == null || fields.length == 0) {
			
		}
	}
	
}
