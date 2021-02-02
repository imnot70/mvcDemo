package demo.collections;

import java.util.Stack;

/**
 * @author imnot
 */
public class Demo002 {

	public static void main(String[] args) {
		Stack<String> strings = new Stack<String>();
		strings.push("1");
		strings.push("2");
		strings.push("3");
		System.out.println(strings);
		System.out.println(strings.peek());
		System.out.println(strings);
		System.out.println(strings.pop());
		System.out.println(strings);
	}
	
}
