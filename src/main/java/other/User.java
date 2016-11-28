package other;

/**
 * 所有用户的父类，存储用户名和密码，提供验证用户名和密码的功能
 * @author CROFF
 * @version 2016-11-28
 */
public class User {
	
	private String username;
	private String password;
	private UserType userType;
	
	public User() {
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, UserType userType) {
		this.username = username;
		this.password = password;
		this.username = username;
	}
	
	public boolean checkIdentity(String username, String password) {
		if(this.username.equals(username) && this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public UserType getUserType() {
		return userType;
	}
	
	public String getUsername() {
		return username;
	}
}
