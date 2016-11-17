package bl.implementation;

import java.util.List;

import bl.service.HotelBLService;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class Hotel extends User implements HotelBLService{

	public Order ordermanager = new Order();
	public Room roommanager = new Room();
	private HotelVO VO;
	private String name;
	private String address;
	private String level;
	private String district;
	
	
	public Hotel(String hotelID, String name, String address, String level, String district) {
		setID(hotelID);
		//VO = new HotelVO(hotelID, name, address, level, district);
		this.setName(name);
		this.setAddress(address);
		this.setLevel(level);
		this.setDistrict(district);
	}
	
	public List<OrderVO> getOrderList (String hotelID,String time){
		if(ID.equals(hotelID)){
			return ordermanager.getOrderList();
		} else {
			return null;
		}
	}
	
	public OrderVO getOrder(String orderID){
		return ordermanager.getOrder(orderID);
	}
	
	public HotelVO getHotelInformat (String hotelID){
		return VO;
	}
	
	public boolean updataOrder (String orderID,OrderVO OR){
		for(int i=0;i<ordermanager.getOrderList().size();i++){
			if(ordermanager.getOrderList().get(i).getOrderID().equals(orderID)){
				ordermanager.orderList.set(i, OR);
				return true;
			}
		}
		return false;
	}
	
	public boolean updataHotelInformat (String hotelID,HotelVO HO){
		if(getID().equals(hotelID)){
			setVO(HO);
		}
		return false;
	}
	
	public boolean check (String orderID,String memberID,String roomID,RoomVO RO,int mark){
		roommanager.updateRoom(RO);
		return true;
	}
	
	@Override
	public boolean delay(String orderID) {
		for(int i=0;i<ordermanager.getOrderList().size();i++){
			if(ordermanager.getOrderList().get(i).getOrderID().equals(orderID)){
				if(ordermanager.getOrderList().get(i).getState()==3){
					ordermanager.getOrderList().get(i).setState(2);
					return true;
				}
				else{
					return false;
				}
			}
		
		}
		return false;
	}
	
	public void setVO(HotelVO vO) {
		VO = vO;
	}
	public HotelVO getVO() {
		return VO;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}