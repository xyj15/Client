package bl.implementation;

import data.service.HotelDataService;
import data.service.RoomDataService;
import bl.service.HotelBLService;
import other.RoomType;
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
	private Date date;

	public Order order;
	public Room room;
	public Promotion promotion;
	
	private HotelDataService hotelDataService;
	
	/**
	 * 新增酒店时调用这个构造方法，自动分配可用ID
	 */
	public Hotel(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
		hotelVO.setUserID(hotelDataService.getAvailableID());
		hotelID = hotelVO.getUserID();
	}
	
	/**
	 * 一般酒店的构造方法，提供酒店ID
	 * @param hotelID 酒店ID
	 */
	public Hotel(String hotelID) {
		this.hotelID = hotelID;
		updateDateFromFile();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String getHotelName() {
		updateDateFromFile();
		return hotelVO.getName();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String getHotelAddress() {
		updateDateFromFile();
		return hotelVO.getAddress();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String getCity() {
		updateDateFromFile();
		return hotelVO.getCity();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public int getHotelLevel() {
		updateDateFromFile();
		return hotelVO.getLevel();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String getDistrict() {
		updateDateFromFile();
		return hotelVO.getDistrict();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public double getHotelScore() {
		updateDateFromFile();
		return hotelVO.getScore();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String getHotelService() {
		updateDateFromFile();
		return hotelVO.getService();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String getHotelIntroduction() {
		updateDateFromFile();
		return hotelVO.getIntroduction();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String getHotelManagerName() {
		updateDateFromFile();
		return hotelVO.getManagerName();
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String getHotelManagerTel() {
		updateDateFromFile();
		return hotelVO.getManagerTel();
	}
	
	/**
	 *
	 * @param hotelInformation
	 * @return
	 */
	@Override
	public boolean setHotelInformation(HotelVO hotelInformation) {
		this.hotelVO = hotelInformation;
		updateDateToFile();
		return false;
	}
	
	/**
	 * 获取酒店信息
	 * @return 酒店信息
	 */
	@Override
	public HotelVO getHotelInformation() {
		return null;
	}
	
	/**
	 *
	 * @param orderID
	 * @param roomID
	 * @return
	 */
	@Override
	public boolean checkin(String orderID, String roomID) {
		return false;
	}
	
	/**
	 *
	 * @param orderID
	 * @param roomID
	 * @return
	 */
	@Override
	public boolean checkout(String orderID, String roomID) {
		return false;
	}
	
	/**
	 *
	 * @param orderID
	 * @return
	 */
	@Override
	public boolean delay(String orderID) {
		return false;
	}
	
	/**
	 * 通过给定日期获取当天酒店的客房信息
	 * @param date 日期
	 */
	public void updateDailyInformation(Date date) {
		ArrayList<RoomType> roomTypeList = new ArrayList<RoomType>();
		ArrayList<Integer> roomNumberList = new ArrayList<Integer>();
		
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
			
			RoomType roomType = roomVO.getRoomType();
			if(roomTypeList.contains(roomType)) {
				int index = roomTypeList.indexOf(roomType);
				roomNumberList.set(index, roomNumberList.get(index)+1);
			} else {
				roomTypeList.add(roomType);
			}
		}
		
		hotelVO.setLowestPrice(lowestPrice);
		hotelVO.setRoomTypeList(roomTypeList);
		hotelVO.setRoomNumberList(roomNumberList);
	}
	
	/**
	 * 从Data层更新数据
	 */
	public void updateDateFromFile() {
		hotelVO = hotelPOtoVO(hotelDataService.getHotelByID(hotelID));
		order = new Order(hotelID);
		room = new Room(hotelID);
		promotion = new Promotion(hotelID);
	}
	
	/**
	 * 将数据更新到Data层
	 */
	public boolean updateDateToFile() {
		HotelPO hotelPO = hotelVOtoPO(hotelVO);
		return hotelDataService.updateHotel(hotelPO);
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
	
	/**
	 * 更新酒店工作人员信息
	 * @param managerName 酒店工作人员名称
	 * @param managerTel 酒店工作人员联系方式
	 * @return 更新成功则返回true，否则返回false
	 */
	public boolean updateHotelManagerInformation(String managerName, String managerTel) {
		hotelVO.setManagerName(managerName);
		hotelVO.setManagerTel(managerTel);
		updateDateToFile();
		return true;
	}
}