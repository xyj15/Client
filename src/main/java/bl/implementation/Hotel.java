package bl.implementation;

import bl.dataservice.HotelDataService;
import bl.service.HotelBLService;
import other.HotelService;
import po.HotelPO;
import vo.HotelVO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomVO;

import java.util.ArrayList;

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
	public String getHotelName() {
		return null;
	}
	
	@Override
	public String getHotelAddress() {
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
	public HotelService getHotelService() {
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
	public ArrayList<RoomVO> getRoomList() {
		return null;
	}
	
	@Override
	public boolean addRoom(RoomVO roomVO) {
		return false;
	}
	
	@Override
	public boolean deleteRoom(String roomID) {
		return false;
	}
	
	@Override
	public boolean updateRoom(String roomID, RoomVO roomVO) {
		return false;
	}
	
	@Override
	public ArrayList<PromotionVO> getPromotionList() {
		return null;
	}
	
	@Override
	public boolean createPromotion(PromotionVO promotionVO) {
		return false;
	}
	
	@Override
	public boolean deletePromotion(String promotionID) {
		return false;
	}
	
	@Override
	public boolean updatePromotion(String promotionID, PromotionVO promotionVO) {
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
	
	@Override
	public ArrayList<OrderVO> getUnexcutedOrderList() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getExcutedOrderList() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getAbnormalOrderList() {
		return null;
	}
	
	@Override
	public ArrayList<OrderVO> getCanceledOrderList() {
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