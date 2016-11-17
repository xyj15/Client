package bl.stub;

import bl.service.LoginBLService;

public class LoginBLStub implements LoginBLService {

	@Override
	public boolean isCorrect(String ID, String password) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isValid(String ID, String password) {
		// TODO Auto-generated method stub
		return true;
	}

}
