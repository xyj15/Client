package bl.service;

import java.util.ArrayList;

import vo.HotelVO;
import vo.MemberVO;
import vo.SalerVO;

public interface ManagerBLService {
	public HotelVO getHotel(String hotelID);
	public boolean updateHotel(HotelVO hotel);
	public boolean addHotel(HotelVO hotel);
	public boolean deleteHotel(HotelVO hotel);
	public ArrayList<HotelVO> getHotelList(String limit);
	public MemberVO getMember(String memberID);
	public boolean updateMember(MemberVO member);
	public boolean addMember(MemberVO member);
	public boolean deleteMember(MemberVO member);
	public ArrayList<MemberVO> getMemberList(String limit);
	public SalerVO getSaler(String account);
	public boolean updateSaler(SalerVO saler);
	public boolean addSaler(SalerVO saler);
	public boolean deleteSaler(SalerVO saler);
}
