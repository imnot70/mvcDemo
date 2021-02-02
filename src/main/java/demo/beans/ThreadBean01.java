package demo.beans;

/**
 * @author imnot
 */
public class ThreadBean01 {
	
	public static void m1(String name) {
		int x = 0;
		for(int i=0;i<100;i++) {
			x++;
			System.out.println(name+":"+x);
		}
//		System.out.println(x);
	}
	
	public void m2() {
		System.out.println("m2");
	}
	
	public void m3() {
		System.out.println("m3");
		try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize");
	}

}
