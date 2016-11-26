package ui.presentation;

import other.Date;
import other.RoomType;
import ui.controller.SearchController;

/**
 * Search的UI界面类
 * @author CROFF
 * @version 2016-11-27
 */
public class SearchUI {
	
	private SearchController searchController;
	
	public SearchUI() {
		searchController = new SearchController(this);
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
		
	}
	
	public void newReservation() {
		
	}

	public SearchController getSearchController() {
		return searchController;
	}

	public void setSearchController(SearchController searchController) {
		this.searchController = searchController;
	}
}
