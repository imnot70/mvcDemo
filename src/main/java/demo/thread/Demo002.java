package demo.thread;

import demo.beans.ThreadBean01;
import org.junit.jupiter.api.Test;


public class Demo002 {

	public static void main(String[] args) {
		new Thread(() -> {
			ThreadBean01.m1("t1");
		}).start();
		System.out.println("~~~~~~~~~~~~~");
		new Thread(() -> {
			ThreadBean01.m1("t2");
		}).start();
		System.gc();
	}
	
	@Test
	public void test01() {
		ThreadBean01.m1("test");
		System.gc();
	}

	@Test
	public void test02() {
		ThreadBean01 tb = new ThreadBean01();
		tb.m2();
		System.gc();
	}
	
	@Test
	public void test03() {
		ThreadBean01 tb = new ThreadBean01();
		tb.m3();
	}
}
