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
	
	private ArrayList<HotelVO> allHotelList;	//所有酒店的列表，暂时使用ArrayList存储
	private ArrayList<HotelVO> searchHotelList;	//搜索出来的酒店列表，暂时使用ArrayList存储
	private ArrayList<HotelVO> reservedHotelList;	//预定过的酒店列表，暂时使用ArrayList存储
	private SearchInfomation searchInfomation;	//搜索限制条件
	private MemberPO memberPO;	//持有的客户信息
	
	private HotelDataService hotelDataService;
	private MemberDataService memberDataService;
	private OrderDataService orderDataService;
	
	public Search(String memberID) {
		searchInfomation = new SearchInfomation();
		memberPO = memberDataService.getMember(memberID);
	}
	
	public Search() {
		
	}

	@Override
	public boolean setAddress(String address) {
		searchInfomation.setAddress(address);
		return true;
	}
	
	@Override
	public boolean setDistrict(String district) {
		searchInfomation.setDistrict(district);
		return true;
	}
	
	@Override
	public boolean setHotelName(String hotelName) {
		searchInfomation.setHotelName(hotelName);
		return true;
	}
	
	@Override
	public boolean setLevel(int level) {
		searchInfomation.setLevel(level);
		return true;
	}
	
	@Override
	public boolean setRoomType(RoomType roomType) {
		searchInfomation.setRoomType(roomType);
		return true;
	}
	
	@Override
	public boolean setLowerPrice(double lowerPrice) {
		searchInfomation.setLowerPrice(lowerPrice);
		return true;
	}
	
	@Override
	public boolean setUpperPrice(double upperPrice) {
		searchInfomation.setUpperPrice(upperPrice);
		return true;
	}
	
	@Override
	public boolean setLowerScore(double lowerScore) {
		searchInfomation.setLowerScore(lowerScore);
		return true;
	}
	
	@Override
	public boolean setUpperScore(double upperScore) {
		searchInfomation.setUpperScore(upperScore);
		return true;
	}
	
	@Override
	public boolean setCheckinTime(Date checkinTime) {
		searchInfomation.setCheckinTime(checkinTime);
		return true;
	}
	
	@Override
	public boolean setCheckoutTime(Date checkoutTime) {
		searchInfomation.setCheckoutTime(checkoutTime);
		return true;
	}
	
	@Override
	public boolean setOnlyReservationBefore(boolean onlyReservationBefore) {
		searchInfomation.setOnlyReservationBefore(onlyReservationBefore);
		return true;
	}
	
	@Override
	public ArrayList<HotelVO> search() {
		return null;
	}
	
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
	
	public MemberPO getMemberPO() {
		return memberPO;
	}
	
	public void setMemberPO(MemberPO memberPO) {
		this.memberPO = memberPO;
	}
	
	public SearchInfomation getSearchInfomation() {
		return searchInfomation;
	}
	
	public ArrayList<HotelVO> getAllHotelList() {
		return allHotelList;
	}
	
	public void setAllHotelList(ArrayList<HotelVO> allHotelList) {
		this.allHotelList = allHotelList;
	}
	
	public ArrayList<HotelVO> getSearchHotelList() {
		return searchHotelList;
	}
	
	public void setSearchHotelList(ArrayList<HotelVO> searchHotelList) {
		this.searchHotelList = searchHotelList;
	}
	
	public ArrayList<HotelVO> getReservedHotelList() {
		return reservedHotelList;
	}
	
	public void setReservedHotelList(ArrayList<HotelVO> reservedHotelList) {
		this.reservedHotelList = reservedHotelList;
	}
}
