package bl.implementation;

import data.service.HotelDataService;
import data.service.RoomDataService;
import bl.service.HotelBLService;
import po.HotelPO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 97147 on 2016/11/18.
 * Hotel模块的bl实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Hotel implements HotelBLService {
	
	private String hotelID;
	private HotelVO hotelVO;

	public Order order;
	public Room room;
	public Promotion promotion;
	
	private HotelDataService hotelDataService;
	
	/**
	 * 新增酒店时调用这个构造方法，自动分配可用ID
	 */
	public Hotel() {
		hotelVO = new HotelVO();
		hotelVO.setUserID(hotelDataService.getAvailableID());
		hotelID = hotelVO.getUserID();
		updateDateToFile();
	}

	public Hotel(String hotelID) {
		this.hotelID = hotelID;
		updateDateFromFile();
	}
	
	@Override
	public String getHotelName() {
		return null;
	}
	
	@Override
	public String getHotelAddress() {
		return null;
	}
	
	@Override
	public String getCity() {
		return null;
	}
	
	@Override
	public int getHotelLevel() {
		return 0;
	}
	
	@Override
	public String getDistrict() {
		return null;
	}
	
	@Override
	public double getHotelScore() {
		return 0;
	}
	
	@Override
	public String getHotelService() {
		return null;
	}
	
	@Override
	public String getHotelIntroduction() {
		return null;
	}
	
	@Override
	public String getHotelManagerName() {
		return null;
	}
	
	@Override
	public String getHotelManagerTel() {
		return null;
	}
	
	@Override
	public boolean setHotelInformation(HotelVO hotelInformation) {
		return false;
	}
	
	@Override
	public boolean checkin(String orderID, String roomID) {
		return false;
	}
	
	@Override
	public boolean checkout(String orderID, String roomID) {
		return false;
	}
	
	@Override
	public boolean delay(String orderID) {
		return false;
	}
	
	public double getLowestPrice(Date date) {
		ArrayList<RoomVO> dailyRoomList = room.getDailyRoomList(date);
		double lowestPrice = 10000;
		RoomVO roomVO;
		double price;
		for(int i=0; i<dailyRoomList.size(); i++) {
			roomVO = dailyRoomList.get(i);
			price = roomVO.getPrice();
			if(price < lowestPrice) {
				lowestPrice = price;
			}
		}
		return lowestPrice;
	}
	
	public HotelVO getHotelInformation() {
		updateDateFromFile();
		return hotelVO;
	}
	
	public void updateDateFromFile() {
		hotelVO = hotelPOtoVO(hotelDataService.getHotelByID(hotelID));
		order = new Order(hotelID);
		room = new Room(hotelID);
		promotion = new Promotion(hotelID);
	}
	
	public void updateDateToFile() {
		HotelPO hotelPO = hotelVOtoPO(hotelVO);
		hotelDataService.updateHotel(hotelPO);
	}
	
	/**
	 * hotel的PO转换成VO
	 * @param hotelPO PO
	 * @return VO
	 */
	public static HotelVO hotelPOtoVO(HotelPO hotelPO) {
		String hotelID = hotelPO.getUserID();
		String password = hotelPO.getPassword();
		String name = hotelPO.getName();
		String address = hotelPO.getAddress();
		String district = hotelPO.getDistrict();
		String city = hotelPO.getCity();
		int level = hotelPO.getLevel();
		double score = hotelPO.getScore();
		String service = hotelPO.getService();
		String introduction = hotelPO.getIntroduction();
		String managerName = hotelPO.getManagerName();
		String managerTel = hotelPO.getManagerTel();
		HotelVO hotelVO = new HotelVO(hotelID, password, name, address, district,
				city, level, score, service, introduction, managerName, managerTel);
		return hotelVO;
	}
	
	/**
	 * hotel的VO转换成PO
	 * @param hotelVO VO
	 * @return PO
	 */
	public static HotelPO hotelVOtoPO(HotelVO hotelVO) {
		String hotelID = hotelVO.getUserID();
		String password = hotelVO.getPassword();
		String name = hotelVO.getName();
		String address = hotelVO.getAddress();
		String district = hotelVO.getDistrict();
		String city = hotelVO.getCity();
		int level = hotelVO.getLevel();
		double score = hotelVO.getScore();
		String service = hotelVO.getService();
		String introduction = hotelVO.getIntroduction();
		String managerName = hotelVO.getManagerName();
		String managerTel = hotelVO.getManagerTel();
		ArrayList<String> enterpriseList = new ArrayList<String>();
		HotelPO hotelPO = new HotelPO(hotelID, password, name, address, district, city,
				level, score, service, introduction, managerName, managerTel, enterpriseList);
		return hotelPO;
	}
	
	/**
	 * 删除当前酒店
	 * @return 删除成功则返回true，否则返回false
	 */
	public boolean deleteHotel() {
		return hotelDataService.deleteHotel(hotelID);
	}

	public boolean updateHotelManagerInformation(String managerName, String managerTel) {
		hotelVO.setManagerName(managerName);
		hotelVO.setManagerTel(managerTel);
		updateDateToFile();
		return true;
	}
}