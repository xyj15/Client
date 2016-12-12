package data.driver;

import data.service.MemberDataService;
import data.stub.MemberDataStub;
import po.MemberPO;

/**
 * Created by CROFF on 2016/12/12.
 */
public class MemberDataDriver {
	
	private MemberDataService memberDataService = new MemberDataStub();
	
	public void drive() {
		System.out.println(memberDataService.addMember(new MemberPO()));
		System.out.println(memberDataService.getMember("00000000"));
		System.out.println(memberDataService.updateMember(new MemberPO()));
		System.out.println(memberDataService.deleteMember("00000000"));
		System.out.println(memberDataService.getAvailableMemberID());
	}
	
	public static void main(String[] args) {
		MemberDataDriver memberDataDriver = new MemberDataDriver();
		memberDataDriver.drive();
	}
}
