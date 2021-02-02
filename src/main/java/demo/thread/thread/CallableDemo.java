package demo.thread.thread;

import java.util.concurrent.Callable;

/**
 * @author imnot
 */
public class CallableDemo implements Callable<Integer>{

	private int i = 0;
	
	public Integer call() throws Exception {
		int sum = 0;
		for(;i<100;i++) {
			sum += i;
		}
		return sum;
	}

}
