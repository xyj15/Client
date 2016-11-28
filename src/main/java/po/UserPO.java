package po;

import other.UserType;

import java.io.Serializable;

public class UserPO implements Serializable{
	
	private String username;
	private String password;
	private UserType userType;
	
	public UserPO() {
		
	}
	
	public String getID() {
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public UserType getUserType() {
		return userType;
	}
}
