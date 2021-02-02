package demo.thread;

import demo.thread.thread.CallableDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo001 {
	public static void main(String[] args) {
//		Thread t1 = new CustomThread01();
//		t1.start();
		
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableDemo());
		Thread thread = new Thread(futureTask);
		thread.start();
		try {
			Integer sumInteger = futureTask.get();
			System.out.println("sum:"+sumInteger);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
