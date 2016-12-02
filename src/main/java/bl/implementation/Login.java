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
 * @version 2016-11-28
 */
public class Login implements LoginBLService {
	
	private MemberDataService memberDataService;
	private SalerDataService salerDataService;
	private HotelDataService hotelDataService;
	private ManagerDataService managerDataService;
	
	public Login() {
		
	}
	
	@Override
	public boolean checkNetwork() {
		return true;
	}
	
	@Override
	public boolean existUserID(String userID) {
		User user = getUser(userID);
		if(user==null) {
			return false;
		} else {
			return true;
		}
	}
	
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
	
	private boolean isCharAndNum(char c) {
		if((c>='0'&&c<='9') || (c>='a'&&c<='z') || (c>='A'&&c<='Z')) {
			return true;
		} else {
			return false;
		}
	}
}
