package bl.implementation;

import java.util.ArrayList;

import bl.dataservice.HotelDataService;
import bl.dataservice.MemberDataService;
import bl.dataservice.ManagerDataService;
import bl.dataservice.SalerDataService;
import bl.service.ManagerBLService;
import other.User;
import po.HotelPO;
import po.MemberPO;
import po.SalerPO;
import vo.HotelVO;
import vo.MemberVO;
import vo.SalerVO;

public class Manager extends User implements ManagerBLService {

	private HotelVO hotel;
	private MemberVO member;
	private ArrayList<HotelVO> hotels;
	private ArrayList<MemberVO> members;
	private HotelDataService hot;
	private MemberDataService mem;
	private ManagerDataService user;
	private SalerDataService saler;


	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<Saler> salerList = new ArrayList<Saler>();
	//以下为单件模式改动
	private Manager() {}

	private static Manager manager= new Manager();

	public static Manager getInstance(){
		return manager;
	}
	//到此
	

	public HotelVO getHotel(String hotelID) {
		// TODO Auto-generated method stub
		if(hotel.getHotelID().equals(hotelID))return hotel;
		for (HotelVO temp : hotels) {
			if(temp.getHotelID().equals(hotelID)){
				hotel=temp;
				return temp;
			}
		}
		HotelPO temp=hot.getHotelInformat(hotelID);
		hotel.setAddress(temp.getAddress());
		hotel.setDistrict(temp.getDistrict());
		hotel.setHotelID(temp.getHotelID());
		hotel.setLevel(temp.getLevel());
		hotel.setName(temp.getName());
		//hotel.setRoomList(temp.getRoomList());		
		return hotel;
	}

	public boolean updateHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		this.hotel=hotel;
		//HotelPO temp = new HotelPO(hotel.getHotelID(), hotel.getName(), hotel.getAddress(), hotel.getLevel(), hotel.getDistrict());
		new HotelPO(hotel.getHotelID(), hotel.getName(), hotel.getAddress(), hotel.getLevel(), hotel.getDistrict());
		//hot.updataHotelInformat(hotel.getHotelID(), temp);
		return true;
	}

	public boolean addHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		this.hotel=hotel;
		//HotelPO temp = new HotelPO(hotel.getHotelID(), hotel.getName(), hotel.getAddress(), hotel.getLevel(), hotel.getDistrict());
		//user.addHotel(temp);
		new HotelPO(hotel.getHotelID(), hotel.getName(), hotel.getAddress(), hotel.getLevel(), hotel.getDistrict());
		return true;
	}

	public boolean deleteHotel(HotelVO hotel) {
		// TODO Auto-generated method stub
		this.hotel=hotel;
		//HotelPO temp = new HotelPO(hotel.getHotelID(), hotel.getName(), hotel.getAddress(), hotel.getLevel(), hotel.getDistrict());
		//user.deleteHotel(temp);
		 new HotelPO(hotel.getHotelID(), hotel.getName(), hotel.getAddress(), hotel.getLevel(), hotel.getDistrict());
		hotel=null;
		 return true;
	}

	public ArrayList<HotelVO> getHotelList(String limit) {
		// TODO Auto-generated method stub
		ArrayList<HotelPO> temp=user.getHotelList(limit);
		for (HotelPO h : temp) {
			hotels.add(			new HotelVO(h.getHotelID(), h.getName(), h.getAddress(), h.getLevel(), h.getDistrict()));
		}
		return hotels;
	}

	public MemberVO getMember(String memberID) {
		// TODO Auto-generated method stub
//		if(member.getMemberID().equals(memberID))return member;
//		for (MemberVO temp : members) {
//			if(temp.getMemberID().equals(memberID)){
//				member=temp;
//				return temp;
//			}
//		}
//		MemberPO temp=mem.getMInformation(memberID);
//		member.setCredit(temp.getCredit());
//		member.setBirthday(temp.getBirthday());
//		member.setMemberID(temp.getMemberID());
//		member.setName(temp.getName());
//		member.setPassword(temp.getPassword());
//		member.setTel(temp.getPhone());
		//hotel.setRoomList(temp.getRoomList());		
		return member;
	}

	public boolean updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		this.member=member;
		//HotelPO temp = new HotelPO(hotel.getHotelID(), hotel.getName(), hotel.getAddress(), hotel.getLevel(), hotel.getDistrict());
		//new MemberPO(member.getMemberID(),member.getName(), member.getPassword(), member.getBirthday(), member.getCredit(),member.getTel());
		//hot.updataHotelInformat(hotel.getHotelID(), temp);
		//System.out.println(this.member.getCredit());
		return true;
	}

	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
		this.member=member;
		//MemberPO temp = new MemberPO(member.getMemberID(), member.getName(), member.getPassword(), member.getBirthday(), member.getCredit(), member.getTel());
		//mem.saveMInformation(temp.getMemberID(), temp);
		//new MemberPO(member.getMemberID(), member.getName(), member.getPassword(), member.getBirthday(), member.getCredit(), member.getTel());
		return true;
	}

	public boolean deleteMember(MemberVO member) {
		// TODO Auto-generated method stub
		this.member=member;
		//MemberPO temp = new MemberPO(member.getMemberID(), member.getName(), member.getPassword(), member.getBirthday(), member.getCredit(), member.getTel());
		//user.deleteMember(temp);
		member=null;
		return true;
	}

	public ArrayList<MemberVO> getMemberList(String limit) {
		// TODO Auto-generated method stub
		ArrayList<MemberPO> temp=user.getMemberList(limit);
//		for (MemberPO m : temp) {
//			members.add(new MemberVO(m.getMemberID(), m.getPassword(), m.getName(), m.getBirthday(), m.getPhone(), m.getCredit()));
//		}
		return members;
	}

	@Override
	public SalerVO getSaler(String account) {
		SalerPO gotten = saler.getSaler(account);
		SalerVO temp = new SalerVO(gotten.getAccount(),gotten.getPassword());
		return temp;
	}

	@Override
	public boolean updateSaler(SalerVO theSaler) {
		SalerPO temp = new SalerPO(theSaler.getAccount(),theSaler.getPassword());
		return saler.updateSaler(temp);
	}

	@Override
	public boolean addSaler(SalerVO theSaler) {
		SalerPO temp = new SalerPO(theSaler.getAccount(),theSaler.getPassword());
		return saler.addSaler(temp);
	}

	@Override
	public boolean deleteSaler(SalerVO theSaler) {
		return saler.deleteSaler(theSaler.getAccount());
	}

}
