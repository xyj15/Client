package bl.driver;

import bl.service.ManagerBLService;
import bl.stub.ManagerBLStub;
import vo.MemberVO;

public class ManagerBLDriver {
	
	ManagerBLService userbl = new ManagerBLStub();;
	
	public void drive(MemberVO uservo){
		System.out.println(userbl.addMember(uservo));
		System.out.println(userbl.updateMember(uservo));
		System.out.println(userbl.deleteMember(uservo));
		System.out.println(userbl.getMember("541322049"));
		System.out.println(userbl.getMemberList("limit"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManagerBLDriver driver =new ManagerBLDriver();
		driver.drive(new MemberVO("12545663","sdas asd ", "110", "110", "123456", 5000));
	}

}
