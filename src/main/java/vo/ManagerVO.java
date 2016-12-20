package vo;

import other.User;
import other.UserType;

/**
 * Created by CROFF on 2016/12/1.
 * 存储Manager信息的VO类
 * @author CROFF
 * @version 2016-12-1
 */
public class ManagerVO extends User {
	
	private String name;	//姓名或名称
	private String tel;	//联系方式
	
	/**
	 * 构造方法
	 * @param userID 用户名
	 * @param password 密码
	 * @param name 姓名或名称
	 * @param tel 联系方式
	 */
	public ManagerVO(String userID, String password, String name, String tel) {
		super(userID, password, UserType.Manager);
		this.name = name;
		this.tel = tel;
	}
	
	public ManagerVO() {
		setUserType(UserType.Manager);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
}
