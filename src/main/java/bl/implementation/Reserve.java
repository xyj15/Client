package bl.implementation;

import bl.service.ReserveBLService;
import vo.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Reserve模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Reserve implements ReserveBLService {

	private String memberID;	//客户ID
	private String hotelID;	//目标酒店ID

	private ArrayList<PromotionVO> availablePromotionList;	//可用的营销策略列表
	private Promotion promotion;	//营销策略信息
	private PromotionVO promotionVO;	//使用的促销策略
	private Hotel hotel;	//目标酒店信息
	
	private RoomVO roomVO;	//要预订的客房
	private int numberOfRooms;	//要预订的客房数量
	private Date checkinTime;	//预期入住时间
	private Date checkoutTime;	//预期离店时间
	private Date latestArriveTime;	//最晚到店时间
	private String clientName;	//客户名称
	private String clientTel;	//客户联系方式
	private int numberOfClient;	//预计入住人数
	private boolean haveKids;	//是否有儿童
	private String otherReq;	//其它要求
	private double price;	//订单价值
	
	/**
	 * 构造方法，需要客户ID和目标酒店ID
	 * @param memberID 客户ID
	 * @param hotelID 目标酒店ID
	 */
	public Reserve(String memberID, String hotelID) {
		this.memberID = memberID;
		this.hotelID = hotelID;
		promotion = new Promotion();
		hotel = new Hotel(hotelID);
		
		//以下为初始化的默认信息
		Room room = new Room(hotelID);
		roomVO = room.getDailyRoomList(new Date()).get(0);
		numberOfRooms = 1;
		checkinTime = new Date();
		checkoutTime = Search.nextDay(new Date());
		
		Date latestArriveTime = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(latestArriveTime);
		calendar.set(Calendar.HOUR, 21);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		this.latestArriveTime = calendar.getTime();
		
		Member member = new Member(memberID);
		clientName = member.getName();
		clientTel = member.getTel();
		
		numberOfClient = 1;
		haveKids = false;
		otherReq = "";
		price = getPrice();
		
		availablePromotionList = promotion.getAvailablePromotionList(memberID, hotelID, numberOfRooms);
		double minPrice = Double.MAX_VALUE;
		int index = 0;
		for(int i=0; i<availablePromotionList.size(); i++) {
			promotionVO = availablePromotionList.get(i);
			price = getPrice();
			if(price<minPrice) {
				index = i;
				minPrice = price;
			}
		}
		promotionVO = availablePromotionList.get(index);
		price = minPrice;
	}
	
	/**
	 * 获取适用的促销列表供选择
	 * @return 适用的促销列表
	 */
	@Override
	public ArrayList<PromotionVO> getPromotionList() {
		return availablePromotionList;
	}
	
	/**
	 * 获取当前选用的促销策略
	 * @return 当前选用的促销策略
	 */
	@Override
	public PromotionVO getPromotion() {
		return promotionVO;
	}
	
	/**
	 * 设置选用的促销策略
	 * @param promotionVO 促销策略信息
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setPromotion(PromotionVO promotionVO) {
		this.promotionVO = promotionVO;
		return true;
	}
	
	/**
	 * 获取订单价值
	 * @return 订单价值
	 */
	@Override
	public double getPrice() {
		if(roomVO==null) {
			return 0;
		} else {
			if(promotionVO==null) {
				return roomVO.getPrice()*numberOfRooms;
			} else {
				return promotionVO.calculatePrice(roomVO.getPrice())*numberOfRooms;
			}
		}
	}
	
	/**
	 * 获取目标酒店名称
	 * @return 目标酒店名称
	 */
	@Override
	public String getHotelName() {
		hotel.updateDateFromFile();
		return hotel.getHotelName();
	}
	
	/**
	 * 获取目标酒店地址
	 * @return 目标酒店地址
	 */
	@Override
	public String getHotelAddress() {
		hotel.updateDateFromFile();
		return hotel.getHotelAddress();
	}
	
	/**
	 * 获取目标酒店星级
	 * @return 目标酒店星级
	 */
	@Override
	public int getHotelLevel() {
		hotel.updateDateFromFile();
		return hotel.getHotelLevel();
	}
	
	/**
	 * 根据酒店ID和日期获取酒店某天的客房列表
	 * @param date 日期
	 * @return 酒店某天的客房列表
	 */
	@Override
	public ArrayList<RoomVO> getRoomList(Date date) {
		Room room = new Room(hotelID);
		return room.getDailyRoomList(date);
	}
	
	/**
	 * 获取选择的房型信息
	 * @return 客房信息
	 */
	@Override
	public RoomVO getSelectedRoom() {
		return roomVO;
	}
	
	/**
	 * 设置选择的房型
	 * @param roomVO 选择的客房
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setSelectedRoom(RoomVO roomVO) {
		this.roomVO = roomVO;
		return true;
	}
	
	/**
	 * 设置预期入住时间
	 * @param checkinTime 预期入住时间
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
		return true;
	}
	
	/**
	 * 设置预期离店时间
	 * @param chekckoutTime 预期离店时间
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setChekckoutTime(Date chekckoutTime) {
		this.checkoutTime = chekckoutTime;
		return true;
	}
	
	/**
	 * 设置最晚到店时间
	 * @param latestArriveTime 最晚到店时间
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setLatestArriveTime(Date latestArriveTime) {
		this.latestArriveTime = latestArriveTime;
		return true;
	}
	
	/**
	 * 设置客户名称
	 * @param clientName 客户名称
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setClientName(String clientName) {
		this.clientName = clientName;
		return true;
	}
	
	/**
	 * 设置客户联系方式
	 * @param clientTel 客户联系方式
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setClientTel(String clientTel) {
		this.clientTel = clientTel;
		return true;
	}
	
	/**
	 * 设置入住人数
	 * @param numberOfClient 入住人数
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setNumberOfClient(int numberOfClient) {
		this.numberOfClient = numberOfClient;
		return true;
	}
	
	/**
	 * 设置是否有儿童
	 * @param haveKids 是否有儿童
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setHaveKids(boolean haveKids) {
		this.haveKids = haveKids;
		return true;
	}
	
	/**
	 * 设置预订间数
	 * @param numberOfRoom 预订间数
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setNumberOfRoom(int numberOfRoom) {
		this.numberOfRooms = numberOfRoom;
		return true;
	}
	
	/**
	 * 设置其他要求
	 * @param otherReq 其他要求
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setOtherReq(String otherReq) {
		this.otherReq = otherReq;
		return true;
	}
	
	/**
	 * 创建新订单
	 * @return 创建成功则返回true，否则返回false
	 */
	@Override
	public boolean createOrder() {
		Order order = new Order(memberID);
		Hotel hotel = new Hotel(hotelID);
		Member member = new Member(memberID);
		hotel.reserveSingleRoom(checkinTime, roomVO.getRoomName());
		
		OrderVO orderVO = new OrderVO(memberID, hotelID, checkinTime,
				checkoutTime, latestArriveTime, roomVO.getRoomName(),
				numberOfRooms, numberOfClient, haveKids,
				promotionVO.getPromotionID(), price);
		orderVO.setMemberVO(member.getMemberInformation());
		orderVO.setHotelVO(hotel.getHotelInformation());
		return order.createOrder(orderVO);
	}
}
