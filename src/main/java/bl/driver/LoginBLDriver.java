package bl.driver;

import bl.service.LoginBLService;
import bl.stub.LoginBLStub;
import vo.MemberVO;

public class LoginBLDriver {

	LoginBLService loginBLService = new LoginBLStub();
	
	public void drive() {
		String memberID = "12345678";
		String password = "12345678910";
		System.out.println(loginBLService.checkNetwork());
		System.out.println(loginBLService.existUserID(memberID));
		System.out.println(loginBLService.getUserType(memberID));
		System.out.println(loginBLService.login(memberID, password));
		System.out.println(loginBLService.register(new MemberVO()));
		System.out.println(loginBLService.validPassword(password));
	}

	public static void main(String[] args) {
		LoginBLDriver loginBLDriver = new LoginBLDriver();
		loginBLDriver.drive();
	}

}
