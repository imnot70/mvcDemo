package demo.errorcode;

/**
 * @author imnot
 */
public final class EntityCode extends Code{

	public static final EntityCode ENTITY_NOT_FOUND;
	
	public EntityCode(Integer code,String desc) {
		super.setCode(code);
		super.setDesc(desc);
	}
	
	static {
		ENTITY_NOT_FOUND = new EntityCode(10000,"未找到实体");
	}
	
}
