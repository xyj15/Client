package bl.implementation;

import bl.dataservice.LoginDataService;
import bl.service.LoginBLService;
import other.User;
import vo.MemberVO;

/**
 * login模块bl的实现类
 * @author CROFF
 * @version 2016-11-28
 */
public class Login implements LoginBLService {
	
	private LoginDataService loginDataService;
	
	public Login() {
		
	}
	
	@Override
	public boolean checkNetwork() {
		return false;
	}
	
	@Override
	public boolean existUsername(String username) {
		return false;
	}
	
	@Override
	public boolean validPassword(String password) {
		return false;
	}
	
	@Override
	public boolean login(String username, String password) {
		return false;
	}
	
	@Override
	public boolean register(MemberVO memberVO) {
		return false;
	}
}
