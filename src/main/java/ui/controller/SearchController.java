package ui.controller;

import bl.implementation.Hotel;
import bl.service.SearchBLService;
import setup.Date;
import setup.RoomType;
import ui.controllerservice.SearchControllerService;
import ui.presentation.SearchUI;
import vo.HotelVO;
import vo.RoomVO;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/11/26.
 */
public class SearchController implements SearchControllerService {

    private SearchBLService searchBL;
    private SearchUI searchUI;

    public SearchController()

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
}
