package bl.implementation;

import bl.service.LoginBLService;
import other.User;
import other.UserType;
import rmi.RemoteHelper;
import vo.MemberVO;

/**
 * Login模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Login implements LoginBLService {
	
	/**
	 * 构造方法
	 */
	public Login() {
		
	}
	
	/**
	 * 检查网络情况
	 * @return 可以连接到网络则true，否则false
	 */
	@Override
	public boolean checkNetwork() {
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		if(remoteHelper.isConnected()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 检查用户ID是否存在
	 * @param userID 用户ID
	 * @return 存在则true，否则false
	 */
	@Override
	public boolean existUserID(String userID) {
		User user = getUser(userID);
		if(user==null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 检查密码是否合法可用
	 * @param password 密码
	 * @return 合法则true，否则false
	 */
	@Override
	public boolean validPassword(String password) {
		int lengthOfPassword = password.length();
		if(lengthOfPassword<10) {
			return false;
		}
		
		char c;
		for(int i=0; i<password.length(); i++) {
			c = password.charAt(i);
			if(!isCharAndNum(c)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 用户登录
	 * @param userID 用户ID
	 * @param password 密码
	 * @return 登录成功则true，密码错误则false
	 */
	@Override
	public boolean login(String userID, String password) {
		User user = getUser(userID);
		if(user==null) {
			return false;
		}
		String correctPassword = user.getPassword();
		if(password.equals(correctPassword)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 注册客户
	 * @param memberVO 新注册客户的信息
	 * @return 注册成功则true，否则false
	 */
	@Override
	public boolean register(MemberVO memberVO) {
		Member member = new Member(memberVO);
		return member.updateDataToFile();
	}
	
	/**
	 * 根据用户ID获得用户类型，不存在则返回null
	 * @param userID 用户ID
	 * @return 用户类型：Member、Hotel、Saler、Manager
	 */
	@Override
	public UserType getUserType(String userID) {
		int lengthOfUserID = userID.length();
		switch(lengthOfUserID) {
			case 8:
				return UserType.Member;
			case 6:
				return UserType.Hotel;
			case 4:
				return UserType.Saler;
			case 2:
				return UserType.Manager;
		}
		return null;
	}
	
	/**
	 * 根据userID获取User的信息
	 * @param userID
	 * @return user的信息
	 */
	private User getUser(String userID) {
		User user = null;
		UserType userType = getUserType(userID);
		System.out.print(userType);
		switch(userType.getValue()) {
			case 0:
				Member member = new Member(userID);
				user = member.getMemberInformation();
				break;
			case 1:
				Hotel hotel = new Hotel(userID);
				user = hotel.getHotelInformation();
				break;
			case 2:
				Saler saler = new Saler(userID);
				user = saler.getSalerInformation();
				break;
			case 3:
				Manager manager = new Manager();
				user = manager.getManagerInformation();
				break;
		}
		return user;
	}
	
	/**
	 * 判断一个char字符是否是数字或字母
	 * @param c 字符
	 * @return true or false
	 */
	private boolean isCharAndNum(char c) {
		if((c>='0'&&c<='9') || (c>='a'&&c<='z') || (c>='A'&&c<='Z')) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Login login = new Login();
		System.out.println(login.existUserID("00000001"));
		System.out.println(login.getUserType("000000"));
	}
}
