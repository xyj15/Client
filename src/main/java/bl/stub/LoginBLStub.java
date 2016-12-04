package bl.stub;

import bl.service.LoginBLService;
import other.UserType;
import vo.MemberVO;

public class LoginBLStub implements LoginBLService {
	
	@Override
	public boolean checkNetwork() {
		System.out.println("检查网络情况成功");
		return true;
	}
	
	@Override
	public boolean existUserID(String userID) {
		System.out.println("检查用户ID是否存在成功");
		return true;
	}
	
	@Override
	public boolean validPassword(String password) {
		System.out.println("检查密码是否合法成功");
		return true;
	}
	
	@Override
	public boolean login(String userID, String password) {
		System.out.println("检查密码是否正确成功");
		return false;
	}
	
	@Override
	public boolean register(MemberVO memberVO) {
		System.out.println("注册用户成功");
		return true;
	}
	
	@Override
	public UserType getUserType(String userID) {
		System.out.println("返回用户类型为客户成功");
		return UserType.Member;
	}
}
