package bl.implementation;

import data.service.MemberDataService;
import bl.service.LoginBLService;
import other.MemberType;
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
	
	public Login() {
		
	}
	
	@Override
	public boolean checkNetwork() {
		return true;
	}
	
	@Override
	public boolean existUsername(String username) {
		return false;
	}
	
	@Override
	public boolean validPassword(String password) {
		return true;
	}
	
	@Override
	public boolean login(String username, String password) {
		return false;
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
		return null;
	}
}
