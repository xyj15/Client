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
        searchBL = new Search(null);
    }

    @Override
    public void setAddress(String address) {
        searchBL.setAddress(searchUI.getAddress());
    }

    @Override
    public void setDistrict(String district) {
        searchBL.setDistrict(searchUI.getDistrict());
    }

    @Override
    public void setHotelName(String hotelName) {
        searchBL.setHotelName(searchUI.getHotelName());
    }

    @Override
    public void setLevel(int level) {
        searchBL.setLevel(searchUI.getHotelLevel());
    }

    @Override
    public void setScore(double score) {
        searchBL.setScore(searchUI.getScore());
    }

    @Override
    public void setRoomType(RoomType roomType) {
        searchBL.setRoomType(searchUI.getRoomType());
    }

    @Override
    public void setLowerPrice(double lowerPrice) {
        searchBL.setLowerPrice(searchUI.getLowerPrice());
    }

    @Override
    public void setUpperPrice(double upperPrice) {
        searchBL.setUpperPrice(searchUI.getUpperPrice());
    }

    @Override
    public void setCheckinTime(Date checkinTime) {
        searchBL.setCheckinTime(searchUI.getCheckinTime());
    }

    @Override
    public void setCheckoutTime(Date checkoutTime) {
        searchBL.setCheckoutTime(searchUI.getCheckoutTime());
    }

    @Override
    public void setOnlyReservationBefore(boolean onlyReservationBefore) {
        searchBL.setOnlyReservationBefore(searchUI.getOnlyReservationBefore());
    }

    @Override
    public ArrayList<HotelVO> search() {
        return searchBL.search();
    }

    @Override
    public ArrayList<RoomVO> getRoomList(String hotelID) {
        return searchBL.getRoomList(hotelID);
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
