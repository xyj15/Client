package po;

import other.User;

/**
 * Created by CROFF on 2016/12/1.
 */
public class ManagerPO extends User {
	
	private String name;
	private String tel;
	
	public ManagerPO(String name, String tel) {
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
