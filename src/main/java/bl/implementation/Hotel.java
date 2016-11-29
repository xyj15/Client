package bl.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bl.dataservice.HotelDataService;
import bl.service.HotelBLService;
import other.Enterprise;
import other.HotelService;
import other.User;
import po.HotelPO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class Hotel implements HotelBLService {

	public Order order;
	public Room room;
	public Promotion promotion;

	private HotelVO hotelVO;
	private HotelPO hotelPO;
	private HotelDataService hotelDataService;

	public Hotel() {
		
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
	public ArrayList<OrderVO> getUnOrder(String userID) {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getAlOrder(String userID) {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getAandCOrder(String userID) {
		return null;
	}
	
//	public void changeHotelManager(String hoMa,String hoMaID){
//		//setHotelManager(hoMa);
//		//setHotelManagerID(hoMaID);
//	}
//	public List<OrderVO> getOrderList (String hotelID,Date time){
//		if(getUsername().equals(hotelID)){
//			return ordermanager.getOrderList();
//		} else {
//			return null;
//		}
//	}
//
//	public OrderVO getOrder(String orderID){
//		return ordermanager.getOrder(orderID);
//	}
//
//	public HotelVO getHotelInformat (String hotelID){
//		return hotelVO;
//	}
//
//	public boolean updataOrder (String orderID,OrderVO OR){
//		for(int i=0;i<ordermanager.getOrderList().size();i++){
//			if(ordermanager.getOrderList().get(i).getOrderID().equals(orderID)){
//				ordermanager.orderList.set(i, OR);
//				return true;
//			}
//		}
//		return false;
//	}
	
//	public boolean updataHotelInformat (String hotelID,HotelVO HO){
//		if(getUsername().equals(hotelID)){
//			//setVO(HO);
//			return true;
//		}
//		return false;
//	}
//
//	public boolean check (String orderID,String memberID,String roomID,RoomVO RO,int mark){
//		roommanager.updateRoom(RO);
//		return true;
//	}
//
//
//	public boolean delay(String orderID) {
//		for(int i=0;i<ordermanager.getOrderList().size();i++){
//			if(ordermanager.getOrderList().get(i).getOrderID().equals(orderID)){
//				if(ordermanager.getOrderList().get(i).getState()==3){
//					ordermanager.getOrderList().get(i).setState(2);
//					return true;
//				}
//				else{
//					return false;
//				}
//			}
//
//		}
//		return false;
//	}
}