package demo.errorcode;

/**
 * @author imnot
 */
public class Client {
	
	public static void main(String[] args) {
		CodeTest.showCode(EntityCode.ENTITY_NOT_FOUND);
		CodeTest.showCode(UserCode.NOT_LOGIN);
		CodeTest.showCode(UserCode.USER_NOT_EXIST);
	}
}
