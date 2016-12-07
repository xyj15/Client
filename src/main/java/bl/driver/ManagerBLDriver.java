package bl.driver;

import bl.service.ManagerBLService;
import bl.stub.ManagerBLStub;
import vo.HotelVO;
import vo.ManagerVO;
import vo.MemberVO;
import vo.SalerVO;

public class ManagerBLDriver {

	ManagerBLService managerBLService = new ManagerBLStub();

	public void drive() {
		String memberID = "12345678";
		String hotelID = "123456";
		String salerID = "1234";
		System.out.println(managerBLService.getUserType(memberID));
		System.out.println(managerBLService.addHotel(new HotelVO()));
		System.out.println(managerBLService.addMember(new MemberVO()));
		System.out.println(managerBLService.addSaler(new SalerVO()));
		System.out.println(managerBLService.deleteHotel(hotelID));
		System.out.println(managerBLService.deleteMember(memberID));
		System.out.println(managerBLService.deleteSaler(salerID));
		System.out.println(managerBLService.getHotelInformation(hotelID));
		System.out.println(managerBLService.getManagerInformation());
		System.out.println(managerBLService.getMemberInfomation(memberID));
		System.out.println(managerBLService.getSalerInformation(salerID));
		System.out.println(managerBLService.updateHotelManagerInformation(hotelID, "XXX", "12345678910"));
		System.out.println(managerBLService.updateManagerInformation(new ManagerVO()));
		System.out.println(managerBLService.updateMemberInformation(new MemberVO()));
		System.out.println(managerBLService.updateSalerInformation(new SalerVO()));
	}

	public static void main(String[] args) {
		ManagerBLDriver managerBLDriver = new ManagerBLDriver();
		managerBLDriver.drive();
	}

}
