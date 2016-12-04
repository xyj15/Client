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
 * @version 2016-12-2
 */
public class Search implements SearchBLService {
	
	private ArrayList<HotelVO> allHotelList;	//所有酒店的列表
	private ArrayList<HotelVO> searchHotelList;	//搜索出来的酒店列表
	private ArrayList<HotelVO> reservedHotelList;	//预定过的酒店列表
	private SearchInfomation searchInfomation;	//搜索限制条件
	private MemberPO memberPO;	//持有的客户信息
	
	private HotelDataService hotelDataService;
	private MemberDataService memberDataService;
	private OrderDataService orderDataService;
	
	/**
	 * 构造方法，提供客户ID
	 * @param memberID 客户ID
	 */
	public Search(String memberID) {
		searchInfomation = new SearchInfomation();
		memberPO = memberDataService.getMember(memberID);
	}
	
	/**
	 * 设置搜索地址
	 * @param address 搜索地址
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setAddress(String address) {
		searchInfomation.setAddress(address);
		return true;
	}
	
	/**
	 * 设置搜索商圈
	 * @param district 搜索商圈
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setDistrict(String district) {
		searchInfomation.setDistrict(district);
		return true;
	}
	
	/**
	 * 设置搜索酒店名称
	 * @param hotelName 酒店名称
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setHotelName(String hotelName) {
		searchInfomation.setHotelName(hotelName);
		return true;
	}
	
	/**
	 * 设置搜索酒店星级
	 * @param level 酒店星级
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setLevel(int level) {
		searchInfomation.setLevel(level);
		return true;
	}
	
	/**
	 * 设置搜索客房类型
	 * @param roomType 客房类型
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setRoomType(RoomType roomType) {
		searchInfomation.setRoomType(roomType);
		return true;
	}
	
	/**
	 * 设置搜索价格下限
	 * @param lowerPrice 搜索价格下限
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setLowerPrice(double lowerPrice) {
		searchInfomation.setLowerPrice(lowerPrice);
		return true;
	}
	
	/**
	 * 设置搜索价格上限
	 * @param upperPrice 搜索价格上限
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setUpperPrice(double upperPrice) {
		searchInfomation.setUpperPrice(upperPrice);
		return true;
	}
	
	/**
	 * 设置搜索评分下限
	 * @param lowerScore 搜索评分下限
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setLowerScore(double lowerScore) {
		searchInfomation.setLowerScore(lowerScore);
		return true;
	}
	
	/**
	 * 设置搜索评分上限
	 * @param upperScore 搜索评分上限
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setUpperScore(double upperScore) {
		searchInfomation.setUpperScore(upperScore);
		return true;
	}
	
	/**
	 * 设置入住时间
	 * @param checkinTime 入住时间
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setCheckinTime(Date checkinTime) {
		searchInfomation.setCheckinTime(checkinTime);
		return true;
	}
	
	/**
	 * 设置离店时间
	 * @param checkoutTime 离店时间
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setCheckoutTime(Date checkoutTime) {
		searchInfomation.setCheckoutTime(checkoutTime);
		return true;
	}
	
	/**
	 * 设置是否只搜索预定过的酒店
	 * @param onlyReservationBefore 是否只搜索预定过的酒店
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setOnlyReservationBefore(boolean onlyReservationBefore) {
		searchInfomation.setOnlyReservationBefore(onlyReservationBefore);
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
	 * 根据酒店ID获取
	 * @param hotelID
	 * @return
	 */
	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		return null;
	}
	
	@Override
	public ArrayList<HotelVO> sortByPriceHighToLow() {
		return null;
	}
	
	@Override
	public ArrayList<HotelVO> sortByPriceLowToHigh() {
		return null;
	}
	
	@Override
	public ArrayList<HotelVO> sortByScoreHighToLow() {
		return null;
	}
	
	@Override
	public ArrayList<HotelVO> sortByScoreLowToHigh() {
		return null;
	}
	
	@Override
	public ArrayList<HotelVO> sortByLevelHighToLow() {
		return null;
	}
	
	@Override
	public ArrayList<HotelVO> sortByLevelLowToHigh() {
		return null;
	}
}
