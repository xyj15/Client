package bl.dataservice;

import other.User;
import po.HotelPO;
import po.MemberPO;
import po.SalerPO;

import java.util.ArrayList;

/**
 * Manager模块bl层和data层之间的接口
 * @author CROFF
 * @version 2016-11-29
 */
public interface ManagerDataService {
	
	public boolean addMember(MemberPO memberPO);	//添加客户
	public boolean deleteMember(String memberID);	//删除客户
	public ArrayList<MemberPO> getMemberList();	//获得客户列表
	public void updateMemberInformation(String memberID, MemberPO memberPO);	//更新客户信息
	public MemberPO getMemberInfomation(String memberID);	//获得客户信息
	
	public void addHotel(HotelPO hotelPO);	//添加酒店
	public void addHotelManager(String hotelID, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public void deleteHotel(String hotelID);	//删除酒店
	public void updateHotelManagerInformation(String hotelID, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public ArrayList<HotelPO> getHotelList();	//获得酒店列表
	public HotelPO getHotelInformation(String hotelID);	//获得酒店信息
	
	public boolean addSaler(SalerPO salerPO);	//添加营销人员
	public boolean deleteSaler(String salerID);	//删除营销人员
	public void updateSalerInformation(String salerID, SalerPO salerPO);	//更新营销人员信息
	public ArrayList<SalerPO> getSalerList();	//获得营销人员列表
	public SalerPO getSalerInformation(String salerID);	//获得营销人员信息
	
	public ArrayList<User> getUserList();	//获得所有用户的列表
}
