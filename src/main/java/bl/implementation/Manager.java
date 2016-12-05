package bl.implementation;

import bl.service.ManagerBLService;
import data.service.ManagerDataService;
import other.UserType;
import po.ManagerPO;
import vo.HotelVO;
import vo.ManagerVO;
import vo.MemberVO;
import vo.SalerVO;

/**
 * Manager模块bl的实现类
 * @author CROFF
 * @version 2016-12-5
 */
public class Manager implements ManagerBLService {
	
	private Login login;
	private Member member;
	private Hotel hotel;
	private Saler saler;
	
	private ManagerDataService managerDataService;
	
	/**
	 * 构造方法
	 */
	public Manager() {
		init();
	}
	
	/**
	 * 初始化成员变量
	 */
	public void init() {
		login = new Login();
	}
	
	/**
	 * 添加客户
	 * @param memberVO 客户信息
	 * @return 添加成功则返回true，否则false
	 */
	@Override
	public boolean addMember(MemberVO memberVO) {
		return login.register(memberVO);
	}
	
	/**
	 * 删除客户
	 * @param memberID 客户ID
	 * @return 删除成功则返回true，否则false
	 */
	@Override
	public boolean deleteMember(String memberID) {
		member = new Member(memberID);
		return member.deleteMember();
	}
	
	/**
	 * 更新客户信息
	 * @param memberVO 客户信息
	 * @return 更新成功则返回true，否则false
	 */
	@Override
	public boolean updateMemberInformation(MemberVO memberVO) {
		member = new Member(memberVO.getUserID());
		return member.updateMemberInformation(memberVO);
	}
	
	/**
	 * 获取客户信息
	 * @param memberID 客户ID
	 * @return 客户信息
	 */
	@Override
	public MemberVO getMemberInfomation(String memberID) {
		member = new Member(memberID);
		return member.getMemberInformation();
	}
	
	/**
	 * 添加酒店
	 * @param hotelVO 酒店信息
	 * @return 添加成功则返回true，否则false
	 */
	@Override
	public boolean addHotel(HotelVO hotelVO) {
		hotel = new Hotel();
		String hotelID = hotel.getHotelInformation().getUserID();
		hotelVO.setUserID(hotelID);
		return hotel.setHotelInformation(hotelVO);
	}
	
	/**
	 * 删除酒店
	 * @param hotelID 酒店ID
	 * @return 删除成功则返回true，否则false
	 */
	@Override
	public boolean deleteHotel(String hotelID) {
		hotel = new Hotel(hotelID);
		return hotel.deleteHotel();
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
		hotel = new Hotel(hotelID);
		return hotel.updateHotelManagerInformation(name, tel);
	}
	
	/**
	 * 获取酒店信息
	 * @param hotelID 酒店ID
	 * @return 酒店信息
	 */
	@Override
	public HotelVO getHotelInformation(String hotelID) {
		hotel = new Hotel(hotelID);
		return hotel.getHotelInformation();
	}
	
	/**
	 * 添加营销人员
	 * @param salerVO 营销人员信息
	 * @return 添加成功则返回true，否则false
	 */
	@Override
	public boolean addSaler(SalerVO salerVO) {
		saler = new Saler();
		String salerID = saler.getSalerInformation().getUserID();
		salerVO.setUserID(salerID);
		return saler.setSalerInformation(salerVO);
	}
	
	/**
	 * 删除营销人员
	 * @param salerID 营销人员ID
	 * @return 删除成功则返回true，否则false
	 */
	@Override
	public boolean deleteSaler(String salerID) {
		saler = new Saler(salerID);
		return saler.deleteSaler();
	}
	
	/**
	 * 更新营销人员信息
	 * @param salerVO 营销人员信息
	 * @return 更新成功则返回true，否则false
	 */
	@Override
	public boolean updateSalerInformation(SalerVO salerVO) {
		saler = new Saler(salerVO.getUserID());
		return saler.setSalerInformation(salerVO);
	}
	
	/**
	 * 获取营销人员信息
	 * @param salerID 营销人员ID
	 * @return 营销人员信息
	 */
	@Override
	public SalerVO getSalerInformation(String salerID) {
		saler = new Saler(salerID);
		return saler.getSalerInformation();
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
	
	/**
	 * 根据用户ID返回用户的类型，不存在则返回null
	 * @param userID 用户ID
	 * @return 用户类型
	 */
	@Override
	public UserType getUserType(String userID) {
		return login.getUserType(userID);
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
