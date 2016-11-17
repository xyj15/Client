package bl.driver;

import bl.service.MemberBLService;
import bl.stub.MemberBLStub;
import vo.MemberVO;

public class MemberBLDriver {
	
	static String memberID="0001";
	static String name="sadasd";
	static String pass="sadasd";
	static String birth="110";
	static String level="max";
	static double credit=5000;
	
	static String phone="12348555";
	
	public void drive(MemberVO M){
		MemberBLService memberBL = new MemberBLStub(level,memberID,pass, name, birth, phone, credit);
		System.out.println(memberBL.saveMInformation(memberID, M));
		System.out.println(memberBL.getMInformation(memberID));
		System.out.println(memberBL.getCreditList(memberID));
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberBLDriver drive =new MemberBLDriver();
		drive.drive(new MemberVO(memberID,pass, name, birth, phone, credit));
	}

}

