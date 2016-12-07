package bl.driver;

import bl.service.MemberBLService;
import bl.stub.MemberBLStub;
import vo.MemberVO;
import vo.OrderVO;

public class MemberBLDriver {
	
	private MemberBLService memberBLService = new MemberBLStub();

	public void drive() {
		System.out.println(memberBLService.getName());
		System.out.println(memberBLService.getTel());
		System.out.println(memberBLService.getCredit());
		System.out.println(memberBLService.getCreditChangeList());
		System.out.println(memberBLService.getLevel());
		System.out.println(memberBLService.getDiscount());
		System.out.println(memberBLService.getMemberType());
		System.out.println(memberBLService.getBirthday());
		System.out.println(memberBLService.getEnterprise());
		System.out.println(memberBLService.getMemberInformation());
		System.out.println(memberBLService.updateMemberInformation(new MemberVO()));
		System.out.println(memberBLService.newReservation("12345678"));
		System.out.println(memberBLService.createOrder(new OrderVO()));
	}

	public static void main(String[] args) {
		MemberBLDriver memberBLDriver = new MemberBLDriver();
		memberBLDriver.drive();
	}

}

