package ui.controller;

import bl.implementation.Hotel;
import bl.implementation.Search;
import bl.service.SearchBLService;
import other.Date;
import other.RoomType;
import ui.controllerservice.SearchControllerService;
import ui.presentation.SearchUI;
import vo.HotelVO;
import vo.RoomVO;

import java.util.ArrayList;

/**
 * Search的controller类
 * Created by CROFF on 2016/11/26.
 * @author CROFF
 * @version 2016-11-27
 */
public class SearchController implements SearchControllerService {

    private SearchBLService searchBL;
    private SearchUI searchUI;

    public SearchController(SearchUI searchUI) {
        this.searchUI = searchUI;
        searchBL = new Search();
    }

    @Override
    public void setAddress(String address) {
		
    }

    @Override
    public void setDistrict(String district) {

    }

    @Override
    public void setHotelName(String hotelName) {

    }

    @Override
    public void setLevel(int level) {

    }

    @Override
    public void setScore(double score) {

    }

    @Override
    public void setRoomType(RoomType roomType) {

    }

    @Override
    public void setLowerPrice(double lowerPrice) {

    }

    @Override
    public void setUpperPrice(double upperPrice) {

    }

    @Override
    public void setCheckinTime(Date checkinTime) {

    }

    @Override
    public void setCheckoutTime(Date checkoutTime) {

    }

    @Override
    public void setOnlyReservationBefore(boolean onlyReservationBefore) {

    }

    @Override
    public ArrayList<HotelVO> getHotelList() {
        return null;
    }

    @Override
    public ArrayList<RoomVO> getRoomList(Hotel hotel) {
        return null;
    }

    @Override
    public void newReservation() {

    }
	
	public SearchUI getSearchUI() {
		return searchUI;
	}
	
	public void setSearchUI(SearchUI searchUI) {
		this.searchUI = searchUI;
	}
	
	public SearchBLService getSearchBL() {
		return searchBL;
	}
	
	public void setSearchBL(SearchBLService searchBL) {
		this.searchBL = searchBL;
	}
}
