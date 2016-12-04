package bl.implementation;

import java.util.ArrayList;
import java.util.Date;

import data.service.HotelDataService;
import data.service.ManagerDataService;
import bl.service.ManagerBLService;
import data.service.MemberDataService;
import data.service.SalerDataService;
import other.MemberType;
import other.User;
import other.UserType;
import po.HotelPO;
import po.ManagerPO;
import po.MemberPO;
import po.SalerPO;
import vo.*;

/**
 * Manager模块bl的实现类
 * @author CROFF
 * @version 2016-12-3
 */
public class Manager implements ManagerBLService {

	private MemberDataService memberDataService;
	private HotelDataService hotelDataService;
	private SalerDataService salerDataService;
	private ManagerDataService managerDataService;
	
	/**
	 * 构造方法
	 */
	public Manager() {
		
	}
	
	/**
	 * 添加客户
	 * @param memberVO 客户信息
	 * @return 添加成功则返回true，否则false
	 */
	@Override
	public boolean addMember(MemberVO memberVO) {
		return memberDataService.addMember(memberVOtoPO(memberVO));
	}
	
	/**
	 * 删除客户
	 * @param memberID 客户ID
	 * @return 删除成功则返回true，否则false
	 */
	@Override
	public boolean deleteMember(String memberID) {
		return memberDataService.deleteMember(memberID);
	}
	
	/**
	 * 更新客户信息
	 * @param memberVO 客户信息
	 * @return 更新成功则返回true，否则false
	 */
	@Override
	public boolean updateMemberInformation(MemberVO memberVO) {
		return memberDataService.updateMember(memberVOtoPO(memberVO));
	}
	
	/**
	 * 获取客户信息
	 * @param memberID 客户ID
	 * @return 客户信息
	 */
	@Override
	public MemberVO getMemberInfomation(String memberID) {
		return memberPOtoVO(memberDataService.getMember(memberID));
	}
	
	/**
	 * 添加酒店
	 * @param hotelVO 酒店信息
	 * @return 添加成功则返回true，否则false
	 */
	@Override
	public boolean addHotel(HotelVO hotelVO) {
		return hotelDataService.addHotel(hotelVOtoPO(hotelVO));
	}
	
	/**
	 * 删除酒店
	 * @param hotelID 酒店ID
	 * @return 删除成功则返回true，否则false
	 */
	@Override
	public boolean deleteHotel(String hotelID) {
		return hotelDataService.deleteHotel(hotelID);
	}
	
	/**
	 * 更新酒店工作人员信息
	 * @param hotelID 酒店ID
	 * @param name 酒店工作人员姓名
	 * @param tel 酒店工作人员联系方式
	 * @return 更新成功则返回true，否则false
	 */
	@Override
	public boolean updateHotelManagerInformation(String hotelID, String name, String tel) {
		HotelPO hotelPO = hotelDataService.getHotelByID(hotelID);
		hotelPO.setManagerName(name);
		hotelPO.setManagerTel(tel);
		return hotelDataService.updateHotel(hotelPO);
	}
	
	/**
	 * 获取酒店信息
	 * @param hotelID 酒店ID
	 * @return 酒店信息
	 */
	@Override
	public HotelVO getHotelInformation(String hotelID) {
		return hotelPOtoVO(hotelDataService.getHotelByID(hotelID));
	}
	
	/**
	 * 添加营销人员
	 * @param salerVO 营销人员信息
	 * @return 添加成功则返回true，否则false
	 */
	@Override
	public boolean addSaler(SalerVO salerVO) {
		return salerDataService.addSaler(salerVOtoPO(salerVO));
	}
	
	/**
	 * 删除营销人员
	 * @param salerID 营销人员ID
	 * @return 删除成功则返回true，否则false
	 */
	@Override
	public boolean deleteSaler(String salerID) {
		return salerDataService.deleteSaler(salerID);
	}
	
	/**
	 * 更新营销人员信息
	 * @param salerVO 营销人员信息
	 * @return 更新成功则返回true，否则false
	 */
	@Override
	public boolean updateSalerInformation(SalerVO salerVO) {
		return salerDataService.updateSaler(salerVOtoPO(salerVO));
	}
	
	/**
	 * 获取营销人员信息
	 * @param salerID 营销人员ID
	 * @return 营销人员信息
	 */
	@Override
	public SalerVO getSalerInformation(String salerID) {
		return salerPOtoVO(salerDataService.getSaler(salerID));
	}
	
	/**
	 * 更新管理人员信息
	 * @param managerVO 管理人员信息
	 * @return 更新成功则返回true，否则false
	 */
	@Override
	public boolean updateManagerInformation(ManagerVO managerVO) {
		return managerDataService.updateManager(managerVOtoPO(managerVO));
	}
	
	/**
	 * 获取管理人员信息
	 * @return 管理人员信息
	 */
	@Override
	public ManagerVO getManagerInformation() {
		return managerPOtoVO(managerDataService.getManager());
	}
	
	@Override
	public UserType getUserType(String userID) {
		return null;
	}
	
	/**
	 * member的VO转换成PO
	 * @param memberVO VO
	 * @return PO
	 */
	public MemberPO memberVOtoPO(MemberVO memberVO) {
		String memberID = memberVO.getUserID();
		String password = memberVO.getPassword();
		String name = memberVO.getName();
		String tel = memberVO.getTel();
		int level = memberVO.getLevel();
		double discount = memberVO.getDiscount();
		MemberType memberType = memberVO.getMemberType();
		Date birthday = memberVO.getBirthday();
		String enterprise = memberVO.getEnterprise();
		MemberPO memberPO = new MemberPO(memberID, password, name, tel,
				level, discount, memberType, birthday, enterprise);
		return memberPO;
	}
	
	/**
	 * member的PO转换成VO
	 * @param memberPO PO
	 * @return VO
	 */
	public MemberVO memberPOtoVO(MemberPO memberPO) {
		String memberID = memberPO.getMemberID();
		String password = memberPO.getPassword();
		String name = memberPO.getName();
		String tel = memberPO.getPhone();
		int level = memberPO.getLevel();
		double discount = memberPO.getDiscount();
		MemberType memberType = memberPO.getMemberType();
		Date birthday = memberPO.getBirthday();
		String enterprise = memberPO.getEnterprise();
		MemberVO memberVO = new MemberVO(memberID, password, name, tel, level, discount,
				memberType, birthday, enterprise);
		return memberVO;
	}
	
	/**
	 * hotel的VO转换成PO
	 * @param hotelVO VO
	 * @return PO
	 */
	public HotelPO hotelVOtoPO(HotelVO hotelVO) {
		String hotelID = hotelVO.getUserID();
		String password = hotelVO.getPassword();
		String name = hotelVO.getName();
		String address = hotelVO.getAddress();
		String district = hotelVO.getDistrict();
		String city = hotelVO.getCity();
		int level = hotelVO.getLevel();
		double score = hotelVO.getScore();
		String service = hotelVO.getService();
		String introduction = hotelVO.getIntroduction();
		String managerName = hotelVO.getManagerName();
		String managerTel = hotelVO.getManagerTel();
		ArrayList<String> enterpriseList = new ArrayList<String>();
		HotelPO hotelPO = new HotelPO(hotelID, password, name, address, district, city,
				level, score, service, introduction, managerName, managerTel, enterpriseList);
		return hotelPO;
	}
	
	/**
	 * hotel的PO转换成VO
	 * @param hotelPO PO
	 * @return VO
	 */
	public HotelVO hotelPOtoVO(HotelPO hotelPO) {
		String hotelID = hotelPO.getUserID();
		String password = hotelPO.getPassword();
		String name = hotelPO.getName();
		String address = hotelPO.getAddress();
		String district = hotelPO.getDistrict();
		String city = hotelPO.getCity();
		int level = hotelPO.getLevel();
		double score = hotelPO.getScore();
		String service = hotelPO.getService();
		String introduction = hotelPO.getIntroduction();
		String managerName = hotelPO.getManagerName();
		String managerTel = hotelPO.getManagerTel();
		ArrayList<String> enterpriseList = new ArrayList<String>();
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		HotelVO hotelVO = new HotelVO(hotelID, password, name, address, district,
				city, level, score, service, introduction, managerName, managerTel);
		return hotelVO;
	}
	
	/**
	 * saler的VO转换成PO
	 * @param salerVO VO
	 * @return PO
	 */
	public SalerPO salerVOtoPO(SalerVO salerVO) {
		String salerID = salerVO.getUserID();
		String password = salerVO.getPassword();
		String name = salerVO.getName();
		String tel = salerVO.getTel();
		SalerPO salerPO = new SalerPO(salerID, password, name, tel);
		return salerPO;
	}
	
	/**
	 * saler的PO转换成VO
	 * @param salerPO PO
	 * @return VO
	 */
	public SalerVO salerPOtoVO(SalerPO salerPO) {
		String salerID = salerPO.getUserID();
		String password = salerPO.getPassword();
		String name = salerPO.getName();
		String tel = salerPO.getTel();
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		ArrayList<OrderVO> dailyOrderList = new ArrayList<OrderVO>();
		SalerVO salerVO = new SalerVO(salerID, password, name, tel);
		return salerVO;
	}
	
	/**
	 * manager的VO转换成PO
	 * @param managerVO VO
	 * @return PO
	 */
	public ManagerPO managerVOtoPO(ManagerVO managerVO) {
		String managerID = managerVO.getUserID();
		String password = managerVO.getPassword();
		String name = managerVO.getName();
		String tel = managerVO.getTel();
		ManagerPO managerPO = new ManagerPO(managerID, password, name, tel);
		return managerPO;
	}
	
	/**
	 * manager的PO转换成VO
	 * @param managerPO PO
	 * @return VO
	 */
	public ManagerVO managerPOtoVO(ManagerPO managerPO) {
		String managerID = managerPO.getUserID();
		String password = managerPO.getPassword();
		String name = managerPO.getName();
		String tel = managerPO.getTel();
		ManagerVO managerVO = new ManagerVO(managerID, password, name, tel);
		return managerVO;
	}
}
