package demo.thread.thread;

import java.util.Random;

public class CustomThread01 extends Thread {
	
	boolean flag = true;
	@Override
	public void run() {
		while(flag) {			
			System.out.println("threadName:"+this.getName());
			
			Random random = new Random();
			int result = random.nextInt(100);
			if(result <=50) {
				System.out.println("result:"+result);
				flag = false;
			}			
		}
	}
	
}
