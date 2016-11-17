package bl.mock;

import vo.UserRole;
import vo.UserVO;

/**
 * User的Mock类
 * @author CROFF
 * @version 2016-11-05 16:33
 */
public class MockUser extends UserVO {

	private String ID;
	private String password;
	private String name;
	private UserRole role;
	
	/**
	 * 构造MockUser的方法
	 * @param ID 帐号
	 * @param password 密码
	 * @param name 名称
	 * @param role 角色
	 */
	public MockUser(String ID, String password, String name, UserRole role){
		super(ID, password, name, role);
	}
	
	/**
	 * 获取用户帐号
	 * @return 用户帐号
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * 获取用户密码
	 * @return 用户密码
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * 获取用户名称
	 * @return 用户名称
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 获取用户类型
	 * @return 用户类型
	 */
	public UserRole getUserRole(){
		return role;
	}
}
