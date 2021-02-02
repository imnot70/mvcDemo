package demo.reflect;

import demo.beans.User;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author imnot
 */
public class IntrospectorDemo {

	public static void main(String[] args) throws Exception {
		
		String name = "name";
		
		User user = new User();
//		user.setId(1);
//		user.setAddress("addr");
//		user.setBirthday(new Date());
//		user.setName(name);
		
		PropertyDescriptor descriptor = new PropertyDescriptor(name,User.class);
		Method writeMethod = descriptor.getWriteMethod();
		writeMethod.invoke(user,name);
		Method readMethod = descriptor.getReadMethod();
		System.out.println(readMethod.invoke(user));
		System.out.println(user.getName());
	}
	
}
