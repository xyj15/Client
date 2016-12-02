package bl.implementation;

import data.service.HotelDataService;
import data.service.ManagerDataService;
import data.service.MemberDataService;
import bl.service.LoginBLService;
import data.service.SalerDataService;
import other.MemberType;
import other.User;
import other.UserType;
import po.MemberPO;
import vo.MemberVO;

import java.util.Date;

/**
 * login模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Login implements LoginBLService {
	
	private MemberDataService memberDataService;
	private SalerDataService salerDataService;
	private HotelDataService hotelDataService;
	private ManagerDataService managerDataService;
	
	/**
	 * 空构造方法
	 */
	public Login() {
		
	}
	
	/**
	 * 检查网络情况
	 * @return 可以连接到网络则true，否则false
	 */
	@Override
	public boolean checkNetwork() {
		return true;
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
			boolean valid = false;
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
		String userID = memberVO.getUserID();
		String password = memberVO.getPassword();
		String name = memberVO.getName();
		String tel = memberVO.getTel();
		int level = 1;
		double discount = 1;
		MemberType memberType = memberVO.getMemberType();
		Date birthday = memberVO.getBirthday();
		String enterprise = memberVO.getEnterprise();
		MemberPO memberPO = new MemberPO(userID, password, name, tel,
				level, discount, memberType, birthday, enterprise);
		return memberDataService.addMember(memberPO);
	}
	
	/**
	 * 获得用户类型
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
		switch(userType.getValue()) {
			case 0:
				user = memberDataService.getMember(userID);
				break;
			case 1:
				user = hotelDataService.getHotelByID(userID);
				break;
			case 2:
				user = salerDataService.getSaler(userID);
				break;
			case 3:
				user = managerDataService.getManager();
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
}
