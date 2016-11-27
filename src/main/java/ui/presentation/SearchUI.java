package ui.presentation;

import other.Date;
import other.RoomType;
import ui.controller.SearchController;
import ui.controllerservice.SearchControllerService;
import vo.HotelVO;
import vo.RoomVO;

import java.util.ArrayList;

/**
 * Search的UI界面类
 * @author CROFF
 * @version 2016-11-27
 */
public class SearchUI {
	
	private SearchControllerService searchController;
	private ArrayList<HotelVO> hotelList;
	
	public SearchUI() {
		searchController = new SearchController(this);
		hotelList = new ArrayList<HotelVO>();
	}
	
	public String getAddress() {
		return null;
	}
	
	public String getDistrict() {
		return null;
	}
	
	public String getHotelName() {
		return null;
	}
	
	public int getHotelLevel() {
		return 0;
	}
	
	public double getScore() {
		return 0;
	}
	
	public RoomType getRoomType() {
		return null;
	}
	
	public double getLowerPrice() {
		return 0;
	}
	
	public double getUpperPrice() {
		return 0;
	}
	
	public Date getCheckinTime() {
		return null;
	}
	
	public Date getCheckoutTime() {
		return null;
	}
	
	public boolean getOnlyReservationBefore() {
		return false;
	}
	
	public void getHotelList() {
		this.hotelList = searchController.search();
	}
	
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		return searchController.getRoomList(hotelID);
	}
	
	public void newReservation() {
		
	}

	public SearchControllerService getSearchController() {
		return searchController;
	}

	public void setSearchController(SearchControllerService searchControllerService) {
		this.searchController = searchControllerService;
	}
	
	public void setHotelList(ArrayList<HotelVO> hotelList) {
		this.hotelList = hotelList;
	}
}
