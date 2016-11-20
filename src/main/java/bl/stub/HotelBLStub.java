package bl.stub;

import java.util.ArrayList;

import bl.service.HotelBLService;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class HotelBLStub implements HotelBLService{

	String memberID;
	String name;
	String level;
	String address;
	String district;
	int credit;
	int phone;
	String checkInTime;
	String checkOutTime;
	int roomType;
	int roomNumber;
	String promotion;
	double discount;
	double price;
	
	public HotelBLStub(String memberID, String name, String level, String address,
			String district, int credit, int phone, String checkInTime, String checkOutTime,
			int roomType, int roomNumber, String promotion, double discount, double price) {
		this.memberID = memberID;
		this.name = name;
		this.level = level;
		this.address = address;
		this.district = district;
		this.credit = credit;
		this.phone = phone;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.roomType = roomType;
		this.roomNumber = roomNumber;
		this.promotion = promotion;
		this.district = district;
		this.price = price;
	}
	

	@Override
	public ArrayList<OrderVO> getOrderList(String hotelID, String time) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		orderList.add(new OrderVO(2, checkInTime, checkOutTime, roomType, roomNumber,
				promotion, discount, price,"1100"));
		return orderList;
	}

	@Override
	public OrderVO getOrder(String orderID) {
		// TODO Auto-generated method stub
		return new OrderVO(2, checkInTime, checkOutTime, roomType, roomNumber,
				promotion, discount, price,"1100");
	}

	@Override
	public HotelVO getHotelInformat(String hotelID) {
		// TODO Auto-generated method stub
		return new HotelVO(hotelID, name, address, level, district);
	}

	@Override
	public boolean updataOrder(String orderID, OrderVO OR) {
		// TODO Auto-generated method stub
		System.out.println("订单更新成功");
		return true;
	}

	@Override
	public boolean updataHotelInformat(String hotelID, HotelVO HO) {
		// TODO Auto-generated method stub
		System.out.println("酒店信息更新成功");
		return true;
	}

	@Override
	public boolean check(String orderID, String memberID, String roomID, RoomVO RO, int mark) {
		// TODO Auto-generated method stub
		if(mark==1){
			System.out.println("入住成功");
			return true;
		} else if(mark==0){
			System.out.println("退房成功");
			return true;
		} else {
			System.out.println("操作失败");
			return false;
		}
	}


	@Override
	public boolean delay(String orderID) {
		// TODO Auto-generated method stub
		return false;
	}
	
}