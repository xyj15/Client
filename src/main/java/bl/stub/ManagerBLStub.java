package bl.stub;

import java.util.ArrayList;

import bl.service.ManagerBLService;
import vo.HotelVO;
import vo.MemberVO;

public class ManagerBLStub implements ManagerBLService {

	private String ID="541322049";
	private String phone="541322049";
	private String password="DREAMING";
	private String name="zhangxinyue";
	private String birth="16263";
	private String level="5";
	private String address="仙林大道163号";
	private String district="栖霞区";
	private double credit=5;
	private ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
	private ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();

	public ManagerBLStub() {
		memberList.add(new MemberVO(ID,password, name, birth, phone, credit));
		hotelList.add(new HotelVO(ID,name,address,level,district));
	}
	
	public MemberVO getMember(String userID) {
		// TODO Auto-generated method stub
		for(int i=0;i<memberList.size();i++){
			if(memberList.get(i).getMemberID().equals(userID)){
				System.out.println("----查找用户———");
				return memberList.get(i);
			}
		}
		System.out.println("----未找到（查找用户）———");
		return null;
	}

	public boolean updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		for(int i=0;i<memberList.size();i++){
			if(memberList.get(i).getMemberID().equals(member.getMemberID())){
				memberList.remove(i);
				memberList.add(member);
			}
		}
		System.out.println("----更新———");
		return true; 
	}

	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
//		ID=user.getID();
//		password=user.getPassword();
//		name=user.getName();
//		role=user.getUserRole();
		memberList.add(member);
		System.out.println("----新添———");
		return true;
	}

	public boolean deleteMember(MemberVO member) {
		// TODO Auto-generated method stub
		for(int i=0;i<memberList.size();i++){
			if(memberList.get(i).getMemberID().equals(member.getMemberID())){
				memberList.remove(i);
			}
		}
		System.out.println("----删除———");
		return true;
	}

	public ArrayList<MemberVO> getMemberList(String limit) {
		// TODO Auto-generated method stub
		System.out.println("----查看列表———");
		return memberList;
	}

	public HotelVO getHotel(String hotelID) {
		// TODO Auto-generated method stub
		for(int i=0;i<hotelList.size();i++){
			if(hotelList.get(i).getHotelID().equals(hotelID)){
				System.out.println("----查找酒店———");
				return hotelList.get(i);
			}
		}
		System.out.println("----未找到（查找酒店）———");
		return null;
	}
	
	public boolean updateHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		for(int i=0;i<hotelList.size();i++){
			if(hotelList.get(i).getHotelID().equals(hotel.getHotelID())){
				hotelList.remove(i);
				hotelList.add(hotel);
			}
		}
		System.out.println("----更新酒店———");
		return true; 
	}
	
	public boolean addHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		hotelList.add(hotel);
		System.out.println("----新添酒店———");
		return true;
	}
	
	public boolean deleteHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		for(int i=0;i<hotelList.size();i++){
			if(hotelList.get(i).getHotelID().equals(hotel.getHotelID())){
				hotelList.remove(i);
			}
		}
		System.out.println("----删除酒店———");
		return true;
	}
	
	public ArrayList<HotelVO> getHotelList(String limit) {
		// TODO Auto-generated method stub
		System.out.println("----查看酒店列表———");
		return hotelList;
	}

}
