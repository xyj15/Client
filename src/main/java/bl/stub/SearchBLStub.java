package bl.stub;

import java.util.ArrayList;
import java.util.Date;

import bl.implementation.Promotion;
import bl.service.SearchBLService;
import other.RoomType;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class SearchBLStub implements SearchBLService {
	
	private ArrayList<HotelVO> hotelList;
	private ArrayList<RoomVO> roomList;
	
	public SearchBLStub() {
		hotelList = new ArrayList<HotelVO>();
		String hotelID = "123456";
		String password = "12345678910";
		String name = "新悦大酒店";
		String address = "栖霞区仙林大道163号";
		String district = "南京大学仙林校区";
		String city = "江苏省南京市";
		int level = 5;
		double score = 5;
		String service = "免费高速Wi-Fi";
		String introduction = "这个酒店是全世界坠吼的";
		String managerName = "张新悦";
		String managerTel = "12345678910";
		ArrayList<String> enterpriseList = new ArrayList<String>();
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		HotelVO hotelVO = new HotelVO(hotelID, password, name, address, district,
				city, level, score, service, introduction, managerName, managerTel,
				enterpriseList, roomList, orderList);
		hotelList.add(hotelVO);
		
		roomList = new ArrayList<RoomVO>();
		boolean available = false;
		String roomNumber = "3304";
		String roomName = "总统专用豪华研讨间";
		RoomType roomType = RoomType.Suite;
		double price = 99999;
		hotelID = "123456";
		RoomVO roomVO = new RoomVO(available, roomNumber, roomName, roomType, price, hotelID);
		roomList.add(roomVO);
	}
	
	@Override
	public boolean setAddress(String address) {
		System.out.println("设置地址成功");
		return true;
	}
	
	@Override
	public boolean setDistrict(String district) {
		System.out.println("设置商圈成功");
		return true;
	}
	
	@Override
	public boolean setHotelName(String hotelName) {
		System.out.println("设置酒店名称成功");
		return true;
	}
	
	@Override
	public boolean setLevel(int level) {
		System.out.println("设置酒店星级成功");
		return true;
	}
	
	@Override
	public boolean setRoomType(RoomType roomType) {
		System.out.println("设置客房类型成功");
		return true;
	}
	
	@Override
	public boolean setLowerPrice(double lowerPrice) {
		System.out.println("设置价格下限成功");
		return true;
	}
	
	@Override
	public boolean setUpperPrice(double upperPrice) {
		System.out.println("设置价格上限成功");
		return true;
	}
	
	@Override
	public boolean setLowerScore(double lowerScore) {
		System.out.println("设置评分下限成功");
		return true;
	}
	
	@Override
	public boolean setUpperScore(double upperScore) {
		System.out.println("设置评分上限成功");
		return true;
	}
	
	@Override
	public boolean setCheckinTime(Date checkinTime) {
		System.out.println("设置入住时间成功");
		return true;
	}
	
	@Override
	public boolean setCheckoutTime(Date checkoutTime) {
		System.out.println("设置退房时间成功");
		return true;
	}
	
	@Override
	public boolean setOnlyReservationBefore(boolean onlyReservationBefore) {
		System.out.println("设置是否只搜索预定过的酒店成功");
		return true;
	}
	
	@Override
	public ArrayList<HotelVO> search() {
		System.out.println("搜索成功");
		return hotelList;
	}
	
	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		System.out.println("获取客房列表成功");
		return roomList;
	}
	
	@Override
	public ArrayList<HotelVO> sortByPriceHighToLow() {
		System.out.println("设置价格从高到低排序");
		return hotelList;
	}
	
	@Override
	public ArrayList<HotelVO> sortByPriceLowToHigh() {
		System.out.println("设置价格从低到高排序");
		return hotelList;
	}
	
	@Override
	public ArrayList<HotelVO> sortByScoreHighToLow() {
		System.out.println("设置评分从高到低排序");
		return hotelList;
	}
	
	@Override
	public ArrayList<HotelVO> sortByScoreLowToHigh() {
		System.out.println("设置评分从低到高排序");
		return hotelList;
	}
	
	@Override
	public ArrayList<HotelVO> sortByLevelHighToLow() {
		System.out.println("设置星级从高到低排序");
		return hotelList;
	}
	
	@Override
	public ArrayList<HotelVO> sortByLevelLowToHigh() {
		System.out.println("设置星级从低到高排序");
		return hotelList;
	}
}
