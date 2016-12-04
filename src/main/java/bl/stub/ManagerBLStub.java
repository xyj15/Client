package bl.stub;

import bl.service.ManagerBLService;
import other.MemberType;
import vo.HotelVO;
import vo.ManagerVO;
import vo.MemberVO;
import vo.SalerVO;

import java.util.Date;

public class ManagerBLStub implements ManagerBLService {
	
	private MemberVO memberVO;
	private HotelVO hotelVO;
	private SalerVO salerVO;
	private ManagerVO managerVO;
	
	public ManagerBLStub() {
		String memberID = "12345678";
		String password = "12345678910";
		String name = "周杰伦";
		String tel = "12345678910";
		int level = 1;
		double discount = 1;
		MemberType memberType = MemberType.Orinary;
		Date birthday = new Date();
		String enterprise = "南京大学有限公司";
		memberVO = new MemberVO(memberID, password, name, tel, level, discount,
				memberType, birthday, enterprise);
		
		String hotelID = "123456";
		password = "12345678910";
		name = "新悦大酒店";
		String address = "栖霞区仙林大道163号";
		String district = "南京大学仙林校区";
		String city = "江苏省南京市";
		level = 5;
		double score = 5;
		String service = "免费高速Wi-Fi";
		String introduction = "这个酒店是全世界坠吼的";
		String managerName = "张新悦";
		String managerTel = "12345678910";
		hotelVO = new HotelVO(hotelID, password, name, address, district,
				city, level, score, service, introduction, managerName, managerTel);
		
		String salerID = "1234";
		password = "12345678910";
		name = "传销人员";
		tel = "12345678910";
		salerVO = new SalerVO(salerID, password, name, tel);
		
		String managerID = "12";
		password = "12345678910";
		name = "管理人员";
		tel = "12345678910";
		managerVO = new ManagerVO(managerID, password, name, tel);
	}
	
	@Override
	public boolean addMember(MemberVO memberVO) {
		System.out.println("添加客户成功");
		return true;
	}
	
	@Override
	public boolean deleteMember(String memberID) {
		System.out.println("删除客户成功");
		return true;
	}
	
	@Override
	public boolean updateMemberInformation(MemberVO memberVO) {
		System.out.println("更新客户信息成功");
		return true;
	}
	
	@Override
	public MemberVO getMemberInfomation(String memberID) {
		System.out.println("获取客户信息成功");
		return memberVO;
	}
	
	@Override
	public boolean addHotel(HotelVO hotelVO) {
		System.out.println("添加酒店成功");
		return true;
	}
	
	@Override
	public boolean deleteHotel(String hotelID) {
		System.out.println("删除酒店成功");
		return true;
	}
	
	@Override
	public boolean updateHotelManagerInformation(String hotelID, String name, String tel) {
		System.out.println("更新酒店工作人员信息成功");
		return true;
	}
	
	@Override
	public HotelVO getHotelInformation(String hotelID) {
		System.out.println("获取酒店信息成功");
		return hotelVO;
	}
	
	@Override
	public boolean addSaler(SalerVO salerVO) {
		System.out.println("添加营销人员成功");
		return true;
	}
	
	@Override
	public boolean deleteSaler(String salerID) {
		System.out.println("删除营销人员成功");
		return true;
	}
	
	@Override
	public boolean updateSalerInformation(SalerVO salerVO) {
		System.out.println("更新营销人员信息成功");
		return true;
	}
	
	@Override
	public SalerVO getSalerInformation(String salerID) {
		System.out.println("获取营销人员信息成功");
		return salerVO;
	}
	
	@Override
	public boolean updateManagerInformation(ManagerVO managerVO) {
		System.out.println("更新网站管理人员信息成功");
		return true;
	}
	
	@Override
	public ManagerVO getManagerInformation() {
		System.out.println("获取网站管理人员信息成功");
		return managerVO;
	}
}
