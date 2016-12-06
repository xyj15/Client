package bl.implementation;

import bl.service.ReserveBLService;
import vo.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Reserve模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Reserve implements ReserveBLService {

	private String memberID;	//客户ID
	private String hotelID;	//目标酒店ID

	private Promotion promotion;
	private PromotionVO promotionVO;	//使用的促销策略
	
	private String hotelName;	//目标酒店名称
	private String hotelAddress;	//目标酒店地址
	private int hotelLevel;	//目标酒店星级
	private String hotelTel;	//目标酒店联系方式
	
	private String roomName;	//要预订的客房名称
	private int numberOfRooms;	//要预订的客房数量
	private Date checkinTime;	//预期入住时间
	private Date checkoutTime;	//预期离店时间
	private Date latestArriveTime;	//最晚到店时间
	private String clientName;	//客户名称
	private String clientTel;	//客户联系方式
	private int numberOfClient;	//预计入住人数
	private boolean haveKids;	//是否有儿童
	private String otherReq;	//其它要求
	
	/**
	 * 构造方法，需要客户ID和目标酒店ID
	 * @param memberID 客户ID
	 * @param hotelID 目标酒店ID
	 */
	public Reserve(String memberID, String hotelID) {
		this.memberID = memberID;
		this.hotelID = hotelID;
		promotion = new Promotion();
	}
	
	/**
	 * 获取适用的促销列表供选择
	 * @return 适用的促销列表
	 */
	@Override
	public ArrayList<PromotionVO> getPromotionList() {
		return null;
	}
	
	/**
	 * 获取当前选用的促销策略
	 * @return 当前选用的促销策略
	 */
	@Override
	public PromotionVO getPromotion() {
		return null;
	}
	
	/**
	 * 设置选用的促销策略
	 * @param promotionVO 促销策略信息
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setPromotion(PromotionVO promotionVO) {
		this.promotionVO = promotionVO;
		return false;
	}
	
	/**
	 * 获取订单价值
	 * @return 订单价值
	 */
	@Override
	public double getPrice() {
		return 0;
	}
	
	/**
	 * 获取目标酒店名称
	 * @return 目标酒店名称
	 */
	@Override
	public String getHotelName() {
		return hotelName;
	}
	
	/**
	 * 获取目标酒店地址
	 * @return 目标酒店地址
	 */
	@Override
	public String getHotelAddress() {
		return hotelAddress;
	}
	
	/**
	 * 获取目标酒店星级
	 * @return 目标酒店星级
	 */
	@Override
	public int getHotelLevel() {
		return hotelLevel;
	}
	
	/**
	 * 获取目标酒店联系方式
	 * @return 目标酒店联系方式
	 */
	@Override
	public String getHotelTel() {
		return hotelTel;
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
	
	@Override
	public RoomVO getSelectedRoom() {
		return null;
	}
	
	@Override
	public boolean setSelectedRoom(RoomVO roomVO) {
		return false;
	}
	
	/**
	 *
	 * @param checkinTime
	 * @return
	 */
	@Override
	public boolean setCheckinTime(Date checkinTime) {
		return false;
	}
	
	/**
	 *
	 * @param chekckoutTime
	 * @return
	 */
	@Override
	public boolean setChekckoutTime(Date chekckoutTime) {
		return false;
	}
	
	/**
	 *
	 * @param date
	 * @return
	 */
	@Override
	public boolean setLatestArriveTime(Date date) {
		return false;
	}
	
	/**
	 *
	 * @param clientName
	 * @return
	 */
	@Override
	public boolean setClientName(String clientName) {
		this.clientName = clientName;
		return false;
	}
	
	/**
	 *
	 * @param clientTel
	 * @return
	 */
	@Override
	public boolean setClientTel(String clientTel) {
		this.clientTel = clientTel;
		return false;
	}
	
	/**
	 *
	 * @param numberOfClient
	 * @return
	 */
	@Override
	public boolean setNumberOfClient(int numberOfClient) {
		return false;
	}
	
	/**
	 *
	 * @param haveKids
	 * @return
	 */
	@Override
	public boolean setHaveKids(boolean haveKids) {
		return false;
	}
	
	/**
	 *
	 * @param numberOfRoom
	 * @return
	 */
	@Override
	public boolean setNumberOfRoom(int numberOfRoom) {
		return false;
	}
	
	/**
	 *
	 * @param otherReq
	 * @return
	 */
	@Override
	public boolean setOtherReq(String otherReq) {
		this.otherReq = otherReq;
		return false;
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public boolean createOrder() {
		return false;
	}
}
