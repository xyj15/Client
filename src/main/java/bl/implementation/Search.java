package bl.implementation;

import java.util.*;

import data.service.HotelDataService;
import data.service.MemberDataService;
import data.service.OrderDataService;
import bl.service.SearchBLService;
import other.*;
import po.MemberPO;
import vo.*;

/**
 * Search模块bl的实现类
 * @author CROFF
 * @version 2016-12-4
 */
public class Search implements SearchBLService {
	
	private MemberVO memberVO;	//持有的客户信息
	
	private String city;	//城市，若未设置则为""
	private String district;	//商圈，若未设置则为""
	private String hotelName;	//酒店名称，若未设置则为""
	private int level;	//星级，若未设置则为-1
	private RoomType roomType;	//房间类型，若未设置则为""
	private int numberOfRooms;  //可用空房数量，若未设置则为1
	private double lowerPrice;	//价格区间下限，若未设置则为-1
	private double upperPrice;	//价格区间上限，若未设置则为-1
	private double lowerScore;	//评分区间下限，若未设置则为-1
	private double upperScore;	//评分区间上限，若未设置则为-1
	private Date checkinTime;	//入住日期，若未设置则为当天
	private Date checkoutTime;	//退房日期，若未设置则为一天后
	private boolean onlyReservationBefore;	//是否只搜索自己预定过的酒店，默认为false
	
	private HotelDataService hotelDataService;
	private MemberDataService memberDataService;
	private OrderDataService orderDataService;
	
	/**
	 * 构造方法，提供客户ID
	 * @param memberID 客户ID
	 */
	public Search(String memberID) {
		MemberPO memberPO = memberDataService.getMember(memberID);
		String name = memberPO.getName();
		String tel = memberPO.getPhone();
		int level = memberPO.getLevel();
		double discount = memberPO.getDiscount();
		MemberType memberType = memberPO.getMemberType();
		Date birthday = memberPO.getBirthday();
		String enterprise = memberPO.getEnterprise();
		memberVO = new MemberVO(name, tel, level, discount, memberType, birthday, enterprise);
	}
	
	/**
	 * 设置搜索城市
	 * @param city 搜索城市
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setCity(String city) {
		this.city = city;
		return true;
	}
	
	/**
	 * 设置搜索商圈
	 * @param district 搜索商圈
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setDistrict(String district) {
		this.district = district;
		return true;
	}
	
	/**
	 * 设置搜索酒店名称
	 * @param hotelName 酒店名称
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setHotelName(String hotelName) {
		this.hotelName = hotelName;
		return true;
	}
	
	/**
	 * 设置搜索酒店星级
	 * @param level 酒店星级
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setLevel(int level) {
		this.level = level;
		return true;
	}
	
	/**
	 * 设置搜索客房类型
	 * @param roomType 客房类型
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setRoomType(RoomType roomType) {
		this.roomType = roomType;
		return true;
	}
	
	@Override
	public boolean setNumberOfRooms(int numberOfRooms) {
		return false;
	}
	
	/**
	 * 设置搜索价格下限
	 * @param lowerPrice 搜索价格下限
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setLowerPrice(double lowerPrice) {
		this.lowerPrice = lowerPrice;
		return true;
	}
	
	/**
	 * 设置搜索价格上限
	 * @param upperPrice 搜索价格上限
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setUpperPrice(double upperPrice) {
		this.upperPrice = upperPrice;
		return true;
	}
	
	/**
	 * 设置搜索评分下限
	 * @param lowerScore 搜索评分下限
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setLowerScore(double lowerScore) {
		this.lowerScore = lowerScore;
		return true;
	}
	
	/**
	 * 设置搜索评分上限
	 * @param upperScore 搜索评分上限
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setUpperScore(double upperScore) {
		this.upperScore = upperScore;
		return true;
	}
	
	/**
	 * 设置入住时间
	 * @param checkinTime 入住时间
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
		return true;
	}
	
	/**
	 * 设置离店时间
	 * @param checkoutTime 离店时间
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
		return true;
	}
	
	/**
	 * 设置是否只搜索预定过的酒店
	 * @param onlyReservationBefore 是否只搜索预定过的酒店
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setOnlyReservationBefore(boolean onlyReservationBefore) {
		this.onlyReservationBefore = onlyReservationBefore;
		return true;
	}
	
	/**
	 * 根据之前设置的搜索条件返回酒店列表
	 * @return 符合条件的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> search() {
		return null;
	}
	
	/**
	 * 根据酒店ID和日期获取酒店某天的客房列表
	 * @param hotelID 酒店ID
	 * @param date 日期
	 * @return 酒店某天的客房列表
	 */
	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID, Date date) {
		
		return null;
	}
	
	/**
	 * 酒店按价格从高到低排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByPriceHighToLow() {
		ArrayList<HotelVO> resultList = new ArrayList<HotelVO>();
		return null;
	}
	
	/**
	 * 酒店按价格从低到高排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByPriceLowToHigh() {
		ArrayList<HotelVO> resultList = new ArrayList<HotelVO>();
		return null;
	}
	
	/**
	 * 酒店按评分从高到低排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByScoreHighToLow() {
		ArrayList<HotelVO> resultList = new ArrayList<HotelVO>();
		return null;
	}
	
	/**
	 * 酒店按评分从低到高排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByScoreLowToHigh() {
		ArrayList<HotelVO> resultList = new ArrayList<HotelVO>();
		return null;
	}
	
	/**
	 * 酒店按星级从高到低排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByLevelHighToLow() {
		ArrayList<HotelVO> resultList = new ArrayList<HotelVO>();
		return null;
	}
	
	/**
	 * 酒店按星级从低到高排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByLevelLowToHigh() {
		ArrayList<HotelVO> resultList = new ArrayList<HotelVO>();
		return null;
	}
}
