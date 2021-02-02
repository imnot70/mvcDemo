package demo.designpattern.factory.simplefactory;

import demo.utils.JsonUtil;

/**
 * @author imnot
 */
public class Client {

	public static void main(String[] args) {
	    JsonUtil.jackPrint(new BJFactory().makePizza());
	}
}
