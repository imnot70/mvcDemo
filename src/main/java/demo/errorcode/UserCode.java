package demo.errorcode;

/**
 * @author imnot
 */
public final class UserCode extends Code{
	
	public static final UserCode USER_NOT_EXIST;
	public static final UserCode NOT_LOGIN;
	
	private UserCode(Integer code,String desc) {
		super.setCode(code);
		super.setDesc(desc);
	}

	static {
		USER_NOT_EXIST = new UserCode(10000,"用户不存在");
		NOT_LOGIN = new UserCode(10001,"未登录");
	}

}
