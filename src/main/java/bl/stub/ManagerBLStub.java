package bl.stub;

import java.util.ArrayList;
import java.util.Date;

import bl.service.ManagerBLService;
import other.MemberType;
import vo.*;

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
		Date birthday = new Date(96, 11, 11);
		String enterprise = "南京大学有限公司";
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
		memberVO = new MemberVO(memberID, password, name, tel, level, discount,
				memberType, birthday, enterprise, orderList, hotelList);
		
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
		ArrayList<String> enterpriseList = new ArrayList<String>();
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		orderList = new ArrayList<OrderVO>();
		hotelVO = new HotelVO(hotelID, password, name, address, district,
				city, level, score, service, introduction, managerName, managerTel,
				enterpriseList, roomList, orderList);
		
		String salerID = "1234";
		password = "12345678910";
		name = "传销人员";
		tel = "12345678910";
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		ArrayList<OrderVO> dailyOrderList = new ArrayList<OrderVO>();
		salerVO = new SalerVO(salerID, password, name, tel, promotionList, dailyOrderList);
		
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
	public boolean updateMemberInformation(String memberID, MemberVO memberVO) {
		System.out.println("更新客户信息成功");
		return true;
	}
	
	@Override
	public ArrayList<MemberVO> getMemberList() {
		System.out.println("获取客户列表成功");
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList.add(memberVO);
		return memberList;
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
	public boolean addHotelManager(String hotelID, String name, String tel) {
		System.out.println("添加酒店工作人员成功");
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
	public ArrayList<HotelVO> getHotelList() {
		System.out.println("获取酒店列表成功");
		ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
		hotelList.add(hotelVO);
		return hotelList;
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
	public boolean updateSalerInformation(String salerID, SalerVO salerVO) {
		System.out.println("更新营销人员信息成功");
		return true;
	}
	
	@Override
	public ArrayList<SalerVO> getSalerList() {
		System.out.println("获取营销人员列表成功");
		ArrayList<SalerVO> salerList = new ArrayList<SalerVO>();
		salerList.add(salerVO);
		return salerList;
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
