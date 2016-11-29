package bl.service;

import java.util.ArrayList;

import bl.implementation.Hotel;
import vo.HotelVO;
import vo.MemberVO;
import vo.SalerVO;

public interface ManagerBLService {
	
	public boolean addMember(MemberVO memberVO);
	public boolean deleteMember(String memberID);
	public ArrayList<MemberVO> getMemberList();
	public void updateMemberInformation(String memberID, MemberVO memberVO);
	public MemberVO getMemberInfomation(String memberID);
	
	public void addHotel(HotelVO hotelVO);
	public void addHotelManager(String hotelID, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public void deleteHotel(String hotelID);
	public void updateHotelManagerInformation(String hotelID, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public ArrayList<HotelVO> getHotelList();
	public HotelVO getHotelInformation(String hotelID);
	
	public boolean addSaler(SalerVO salerVO);
	public boolean deleteSaler(String salerID);
	public void updateSalerInformation(String salerID, SalerVO salerVO);
	public ArrayList<SalerVO> getSalerList();
	public SalerVO getSalerInformation(String salerID);
}
