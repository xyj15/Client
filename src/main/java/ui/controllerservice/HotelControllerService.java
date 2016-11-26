package ui.controllerservice;

import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 97147 on 2016/11/26.
 */
public interface HotelControllerService {
    public List<OrderVO> getOrderList (String hotelID, Date time);
    public OrderVO getOrder(String orderID);
    public HotelVO getHotelInformat (String hotelID);
    public boolean updataOrder (String orderID,OrderVO OR);
    public boolean updataHotelInformat (String hotelID,HotelVO HO);
    public boolean check (String orderID, String memberID, String roomID, RoomVO RO, int mark);
    public boolean delay(String orderID);
    public ArrayList<OrderVO> getUnOrder(String hotelID);
    public ArrayList<OrderVO> getAlOrder(String hotelID);
    public ArrayList<OrderVO> getAandCOrder(String hotelID);
}
