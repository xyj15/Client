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
	
	private String name;
	private String tel;
	
	public ManagerVO(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	public ManagerVO(String username, String password, String name, String tel) {
		super(username, password, UserType.Manager);
		this.name = name;
		this.tel = tel;
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
