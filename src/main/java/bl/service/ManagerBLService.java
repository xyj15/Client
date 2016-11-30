package bl.service;

import java.util.ArrayList;

import bl.implementation.Hotel;
import vo.HotelVO;
import vo.MemberVO;
import vo.SalerVO;

/**
 * Manager模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface ManagerBLService {
	
	public boolean addMember(MemberVO memberVO);	//添加客户
	public boolean deleteMember(String memberID);	//删除客户
	public boolean updateMemberInformation(String memberID, MemberVO memberVO);	//更新客户信息
	public ArrayList<MemberVO> getMemberList();	//获得客户列表
	public MemberVO getMemberInfomation(String memberID);	//获得客户信息
	
	public boolean addHotel(HotelVO hotelVO);	//添加酒店
	public boolean addHotelManager(String hotelID, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public boolean deleteHotel(String hotelID);	//删除酒店
	public boolean updateHotelManagerInformation(String hotelID, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public ArrayList<HotelVO> getHotelList();	//获得酒店列表
	public HotelVO getHotelInformation(String hotelID);	//获得酒店信息
	
	public boolean addSaler(SalerVO salerVO);	//添加网站营销人员
	public boolean deleteSaler(String salerID);	//删除网站营销人员
	public boolean updateSalerInformation(String salerID, SalerVO salerVO);	//更新网站营销人员信息
	public ArrayList<SalerVO> getSalerList();	//获得网站营销人员列表
	public SalerVO getSalerInformation(String salerID);	//获得网站营销人员信息
}
