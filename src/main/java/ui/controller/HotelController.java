package ui.controller;

import bl.implementation.Hotel;
import bl.service.HotelBLService;
import ui.controllerservice.HotelControllerService;
import ui.presentation.HotelUI;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**     帮助Hotel模块完成界面转跳以及连接UI层与BL层
 *
 * Created by 庄刚轻 on 2016/11/26.
 */
public class HotelController implements HotelControllerService{

    private HotelUI hotelUI;
    private HotelBLService hotelBL = new Hotel();

    public HotelController(HotelUI hotelUI){
        this.hotelUI=hotelUI;
    }
    
    public void getOrderListButtonClicked(){
        hotelUI.getOrderListButtonClicked();
    }
    public void getOrderButtonClicked(){
        hotelUI.getOrderButtonClicked();
    }
    public void checkInButtonClicked(){
        hotelUI.checkInButtonClicked();
    }
    public void delayButtonClicked(){
        hotelUI.delayButtonClicked();
    }
    public void checkOutButtonClicked(){
        hotelUI.checkOutButtonClicked();
    }
    public void getHotelInformatButtonClicked(){
        hotelUI.getHotelInformatButtonClicked();
    }
    public void changeHotelInformatButtonClicked(){
        hotelUI.changeHotelInformatButtonClicked();
    }
    public void saveHotelInformatButtonClicked(){
        hotelUI.saveHotelInformatButtonClicked();
    }
    
    @Override
    public List<OrderVO> getOrderList(String hotelID, Date time) {
        return null;
    }
    
    @Override
    public OrderVO getOrder(String orderID) {
        return null;
    }
    
    @Override
    public HotelVO getHotelInformat(String hotelID) {
        return null;
    }
    
    @Override
    public boolean updataOrder(String orderID, OrderVO OR) {
        return false;
    }
    
    @Override
    public boolean updataHotelInformat(String hotelID, HotelVO HO) {
        return false;
    }
    
    @Override
    public boolean check(String orderID, String memberID, String roomID, RoomVO RO, int mark) {
        return false;
    }
    
    @Override
    public boolean delay(String orderID) {
        return false;
    }
    
    @Override
    public ArrayList<OrderVO> getUnOrder(String hotelID) {
        return null;
    }
    
    @Override
    public ArrayList<OrderVO> getAlOrder(String hotelID) {
        return null;
    }
    
    @Override
    public ArrayList<OrderVO> getAandCOrder(String hotelID) {
        return null;
    }
}
