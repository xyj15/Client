package bl.service;

import java.util.ArrayList;

import bl.implementation.Hotel;
import vo.HotelVO;
import vo.MemberVO;
import vo.SalerVO;

public interface ManagerBLService {
	
	public boolean addMember(MemberVO member);
	public boolean deleteMember(MemberVO member);
	public ArrayList<MemberVO> getMemberList();
	public void updateMemberInformation(MemberVO memberVO);
	public MemberVO getMemberInfomation(String username);
	
	public void addHotel(HotelVO hotelVO);
	public void addHotelManager(String hotelId, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public void deleteHotel(HotelVO hotel);
	public void updateHotelManagerInformation(String hotelId, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public ArrayList<HotelVO> getHotelList();
	public HotelVO getHotelInformation(String username);
	
	public boolean addSaler(SalerVO saler);
	public boolean deleteSaler(SalerVO saler);
	public void updateSalerInformation(SalerVO salerVO);
	public ArrayList<SalerVO> getSalerList();
	public SalerVO getSalerInformation(String username);
}
