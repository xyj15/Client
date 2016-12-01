package po;

import other.User;
import other.UserType;

import java.util.ArrayList;

/**
 * Created by apple on 2016/11/22.
 */
public class SalerPO extends User {
    
    private String name;
    private String tel;

    public SalerPO(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }
    
    public SalerPO(String username, String password, String name, String tel) {
		super(username, password, UserType.Saler);
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
