package vo;

import other.UserType;

public class UserVO {

	private String username;
	private String password;
	private UserType userType;
	
	public UserVO() {
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public UserType getUserType() {
		return userType;
	}
}