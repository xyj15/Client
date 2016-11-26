package ui.controllerservice;

import other.Date;
import other.RoomType;

/**
 * Created by CROFF on 2016/11/23.
 * @author CROFF
 * @version 2016-11-23
 */
public interface ReserveControllerService {

    public String getHotelName();
    public String getHotelAddress();
    public String getHotelLevel();
    public String getHotelTel();
    public RoomType getRoomType();
    public void setCheckinTime(Date checkinTime);
    public void setChekckoutTime(Date chekckoutTime);
    public void setClientName(String clientName);
    public void setClientTel(String clientTel);
    public void setOtherReq(String otherReq);
    public void createOrder();

}
