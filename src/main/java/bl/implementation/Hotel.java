package bl.implementation;

import data.service.HotelDataService;
import data.service.RoomDataService;
import bl.service.HotelBLService;
import po.HotelPO;
import vo.HotelVO;

public class Hotel implements HotelBLService {

	public Order order;
	public Room room;
	public Promotion promotion;

	private HotelVO hotelVO;
	private HotelPO hotelPO;
	private HotelDataService hotelDataService;
	private RoomDataService roomDataService;

	public Hotel() {
		
	}
	
	public Hotel(String hotelID) {
		
	}
	
	@Override
	public String getHotelName() {
		return null;
	}
	
	@Override
	public String getHotelAddress() {
		return null;
	}
	
	@Override
	public String getCity() {
		return null;
	}
	
	@Override
	public int getHotelLevel() {
		return 0;
	}
	
	@Override
	public String getDistrict() {
		return null;
	}
	
	@Override
	public double getHotelScore() {
		return 0;
	}
	
	@Override
	public String getHotelService() {
		return null;
	}
	
	@Override
	public String getHotelIntroduction() {
		return null;
	}
	
	@Override
	public String getHotelManagerName() {
		return null;
	}
	
	@Override
	public String getHotelManagerTel() {
		return null;
	}
	
	@Override
	public boolean setHotelInformation(HotelVO hotelInformation) {
		return false;
	}
	
	@Override
	public boolean checkin(String orderID, String roomID) {
		return false;
	}
	
	@Override
	public boolean checkout(String orderID, String roomID) {
		return false;
	}
	
	@Override
	public boolean delay(String orderID) {
		return false;
	}

//	public void changeHotelManager(String hoMa,String hoMaID){
//		//setHotelManager(hoMa);
//		//setHotelManagerID(hoMaID);
//	}
//	public List<OrderVO> getOrderList (String hotelID,Date time){
//		if(getUserID().equals(hotelID)){
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
//		if(getUserID().equals(hotelID)){
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