package bl.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bl.service.HotelBLService;
import other.Enterprise;
import other.HotelService;
import other.User;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class Hotel implements HotelBLService {

	public Order ordermanager = new Order();
	public Room roommanager = new Room();
	public Promotion promotionmanager = new Promotion();

	private HotelVO hotelVO;

	public Hotel(){};
	public Hotel(String name, String address, int level, String district) {
		//VO = new HotelVO(hotelID, name, address, level, district);
		//setName(name);
		//setAddress(address);
		//setLevel(level);
		//setDistrict(district);
	}
	

	private String hotelManager;
	private String hotelManagerID;
	public void changeHotelManager(String hoMa,String hoMaID){
		//setHotelManager(hoMa);
		//setHotelManagerID(hoMaID);
	}

	
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

	public ArrayList<OrderVO> getUnOrder(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> getAlOrder(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderVO> getAandCOrder(String userID) {
		// TODO Auto-generated method stub
		return null;
	}
}