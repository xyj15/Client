package bl.service;

import java.util.ArrayList;

import other.UserType;
import vo.HotelVO;
import vo.ManagerVO;
import vo.MemberVO;
import vo.SalerVO;

/**
 * Manager模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-12-3
 */
public interface ManagerBLService {
	
	public boolean addMember(MemberVO memberVO);	//添加客户
	public boolean deleteMember(String memberID);	//删除客户
	public boolean updateMemberInformation(MemberVO memberVO);	//更新客户信息
	public MemberVO getMemberInfomation(String memberID);	//获得客户信息
	
	public boolean addHotel(HotelVO hotelVO);	//添加酒店
	public boolean deleteHotel(String hotelID);	//删除酒店
	public boolean updateHotelManagerInformation(String hotelID, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public HotelVO getHotelInformation(String hotelID);	//获得酒店信息
	
	public boolean addSaler(SalerVO salerVO);	//添加网站营销人员
	public boolean deleteSaler(String salerID);	//删除网站营销人员
	public boolean updateSalerInformation(SalerVO salerVO);	//更新网站营销人员信息
	public SalerVO getSalerInformation(String salerID);	//获得网站营销人员信息
	
	public boolean updateManagerInformation(ManagerVO managerVO);	//更新网站管理人员信息
	public ManagerVO getManagerInformation();	//获得网站管理人员信息
	public UserType getUserType(String userID);	//根据ID获得用户类型
}
