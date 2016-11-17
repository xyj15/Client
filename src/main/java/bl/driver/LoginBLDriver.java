package bl.driver;

import bl.service.LoginBLService;
import bl.stub.LoginBLStub;

public class LoginBLDriver {

	LoginBLService service = new LoginBLStub();
	
	public void isCorrect(String ID, String password){
		System.out.println("---登陆————");
		System.out.println(service.isCorrect(ID, password));
	}
	
	public void isValid(String ID, String password){
		System.out.println("---yanzheng————");
		System.out.println(service.isCorrect(ID, password));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginBLDriver driver = new LoginBLDriver();
		driver.isCorrect("541322049", "DREAMING");
		driver.isValid("541322049", "DREAMING");
		
	}

}
