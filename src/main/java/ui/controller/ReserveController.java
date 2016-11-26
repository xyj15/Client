package ui.controller;

import other.Date;
import other.RoomType;
import ui.controllerservice.ReserveControllerService;
import ui.presentation.ReserveUI;

/**
 * Created by CROFF on 2016/11/26.
 * @author CROFF
 * @version 2016-11-26
 */
public class ReserveController implements ReserveControllerService {
	
	private ReserveUI reserveUI;

    @Override
    public String getHotelName() {
        return null;
    }

    @Override
    public String getHotelAddress() {
        return null;
    }

    @Override
    public String getHotelLevel() {
        return null;
    }

    @Override
    public String getHotelTel() {
        return null;
    }

    @Override
    public RoomType getRoomType() {
        return null;
    }

    @Override
    public void setCheckinTime(Date checkinTime) {

    }

    @Override
    public void setChekckoutTime(Date chekckoutTime) {

    }

    @Override
    public void setClientName(String clientName) {

    }

    @Override
    public void setClientTel(String clientTel) {

    }

    @Override
    public void setOtherReq(String otherReq) {

    }

    @Override
    public void createOrder() {

    }
}
