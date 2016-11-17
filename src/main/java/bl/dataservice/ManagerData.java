package bl.dataservice;

import java.util.ArrayList;

import po.HotelPO;
import po.MemberPO;

public interface ManagerData {
	
	public boolean addMember(MemberPO member);
	public boolean deleteMember(MemberPO member);
	public ArrayList<MemberPO> getMemberList(String limit);	
	public boolean addHotel(HotelPO hotel);
	public boolean deleteHotel(HotelPO hotel);
	public ArrayList<HotelPO> getHotelList(String limit);
	
}
