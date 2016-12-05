package bl.implementation;

import bl.service.SearchBLService;
import other.HotelQuickSort;
import other.RoomType;
import other.SortValueOrder;
import vo.HotelVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Search模块bl的实现类
 * @author CROFF
 * @version 2016-12-4
 */
public class Search implements SearchBLService {
	
	private String memberID;	//持有的客户ID
	
	private String city;	//城市，必须设置
	private String district;	//商圈，必须设置
	private String hotelName = "";	//酒店名称，若未设置则为""
	private int level = 0;	//星级，若未设置则为0
	private RoomType roomType = null;	//房间类型，若未设置则为null
	private int numberOfRooms = 1;  //可用空房数量，若未设置则为1
	private double lowerPrice = -1;	//价格区间下限，若未设置则为-1
	private double upperPrice = -1;	//价格区间上限，若未设置则为-1
	private double lowerScore = -1;	//评分区间下限，若未设置则为-1
	private double upperScore = -1;	//评分区间上限，若未设置则为-1
	private Date checkinTime = new Date();	//入住日期，若未设置则为当天
	private Date checkoutTime;	//退房日期，若未设置则为一天后
	private boolean onlyReservationBefore = false;	//是否只搜索自己预定过的酒店，默认为false
	
	/**
	 * 构造方法，提供客户ID
	 * @param memberID 客户ID
	 */
	public Search(String memberID) {
		this.memberID = memberID;
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
		this.numberOfRooms = numberOfRooms;
		return true;
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
		if(city.equals("") || district.equals("")) {
			return null;
		}
		ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
		
		if(!hotelName.equals("")) {
			hotelList = filterByhotelName(hotelList);
			if(hotelList.size()==0) {
				return hotelList;
			}
		}
		
		if(level!=0) {
			hotelList = filterByLevel(hotelList);
			if(hotelList.size()==0) {
				return hotelList;
			}
		}
		
		if(roomType!=null) {
			hotelList = filterByRoomType(hotelList);
			if(hotelList.size()==0) {
				return hotelList;
			}
		}
		
		if(numberOfRooms!=1) {
			hotelList = filterByNumberOfRooms(hotelList);
			if(hotelList.size()==0) {
				return hotelList;
			}
		}
		
		if(onlyReservationBefore==true) {
			hotelList = filterByReservedBefore(hotelList);
			if(hotelList.size()==0) {
				return hotelList;
			}
		}
		
		hotelList = filterByDate(hotelList);
		hotelList = filterByPrice(hotelList);
		hotelList = filterByScore(hotelList);
		
		return hotelList;
	}
	
	/**
	 * 根据酒店ID和日期获取酒店某天的客房列表
	 * @param hotelID 酒店ID
	 * @param date 日期
	 * @return 酒店某天的客房列表
	 */
	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID, Date date) {
		Room room = new Room(hotelID);
		return room.getDailyRoomList(date);
	}
	
	/**
	 * 酒店按价格从高到低排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByPriceHighToLow() {
		ArrayList<HotelVO> hotelList = search();
		HotelQuickSort.quickSort(hotelList, SortValueOrder.priceHtoL);
		return hotelList;
	}
	
	/**
	 * 酒店按价格从低到高排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByPriceLowToHigh() {
		ArrayList<HotelVO> hotelList = search();
		HotelQuickSort.quickSort(hotelList, SortValueOrder.priceLtoH);
		return hotelList;
	}
	
	/**
	 * 酒店按评分从高到低排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByScoreHighToLow() {
		ArrayList<HotelVO> hotelList = search();
		HotelQuickSort.quickSort(hotelList, SortValueOrder.scoreHtoL);
		return hotelList;
	}
	
	/**
	 * 酒店按评分从低到高排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByScoreLowToHigh() {
		ArrayList<HotelVO> hotelList = search();
		HotelQuickSort.quickSort(hotelList, SortValueOrder.scoreLtoH);
		return hotelList;
	}
	
	/**
	 * 酒店按星级从高到低排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByLevelHighToLow() {
		ArrayList<HotelVO> hotelList = search();
		HotelQuickSort.quickSort(hotelList, SortValueOrder.levelHtoL);
		return hotelList;
	}
	
	/**
	 * 酒店按星级从低到高排序
	 * @return 排序完成的酒店列表
	 */
	@Override
	public ArrayList<HotelVO> sortByLevelLowToHigh() {
		ArrayList<HotelVO> hotelList = search();
		HotelQuickSort.quickSort(hotelList, SortValueOrder.levelLtoH);
		return hotelList;
	}
	
	/**
	 * 按酒店名称筛选酒店
	 * @param hotelList 酒店列表
	 * @return 筛选后的酒店列表
	 */
	public ArrayList<HotelVO> filterByhotelName(ArrayList<HotelVO> hotelList) {
		ArrayList<HotelVO> newList = new ArrayList<HotelVO>();
		HotelVO hotelVO;
		for(int i=0; i<hotelList.size(); i++) {
			hotelVO = hotelList.get(i);
			if(hotelVO.getName().equals(hotelName)) {
				newList.add(hotelVO);
			}
		}
		return newList;
	}
	
	/**
	 * 按星级筛选酒店
	 * @param hotelList 酒店列表
	 * @return 筛选后的酒店列表
	 */
	public ArrayList<HotelVO> filterByLevel(ArrayList<HotelVO> hotelList) {
		ArrayList<HotelVO> newList = new ArrayList<HotelVO>();
		HotelVO hotelVO;
		for(int i=0; i<hotelList.size(); i++) {
			hotelVO = hotelList.get(i);
			if(hotelVO.getLevel()==level) {
				newList.add(hotelVO);
			}
		}
		return newList;
	}
	
	/**
	 * 按可订房型筛选酒店
	 * @param hotelList 酒店列表
	 * @return 筛选后的酒店列表
	 */
	public ArrayList<HotelVO> filterByRoomType(ArrayList<HotelVO> hotelList) {
		return null;
	}
	
	/**
	 * 按可订客房数量筛选酒店
	 * @param hotelList 酒店列表
	 * @return 筛选后的酒店列表
	 */
	public ArrayList<HotelVO> filterByNumberOfRooms(ArrayList<HotelVO> hotelList) {
		return null;
	}
	
	/**
	 * 按价格区间筛选酒店
	 * @param hotelList 酒店列表
	 * @return 筛选后的酒店列表
	 */
	public ArrayList<HotelVO> filterByPrice(ArrayList<HotelVO> hotelList) {
		return null;
	}
	
	
	/**
	 * 按评分区间筛选酒店
	 * @param hotelList 酒店列表
	 * @return 筛选后的酒店列表
	 */
	public ArrayList<HotelVO> filterByScore(ArrayList<HotelVO> hotelList) {
		return null;
	}
	
	
	/**
	 * 筛选酒店只留下以前预定过的酒店
	 * @param hotelList 酒店列表
	 * @return 筛选后的酒店列表
	 */
	public ArrayList<HotelVO> filterByReservedBefore(ArrayList<HotelVO> hotelList) {
		return null;
	}
	
	
	/**
	 * 按入住日期和退房日期筛选酒店
	 * @param hotelList 酒店列表
	 * @return 筛选后的酒店列表
	 */
	public ArrayList<HotelVO> filterByDate(ArrayList<HotelVO> hotelList) {
		return null;
	}
}
