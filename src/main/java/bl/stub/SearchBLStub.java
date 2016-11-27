package bl.stub;

import java.util.ArrayList;

import bl.implementation.Hotel;
import bl.service.SearchBLService;
import other.Date;
import other.RoomType;
import vo.HotelVO;
import vo.RoomVO;

public class SearchBLStub implements SearchBLService {

	public void setAddress(String address) {
		// TODO Auto-generated method stub
		System.out.println("设置地址ַ");
	}

	public void setDistrict(String district) {
		// TODO Auto-generated method stub
		System.out.println("设置商圈");
	}
	
	@Override
	public void setHotelName(String hotelName) {
		
	}
	
	@Override
	public void setLevel(int level) {
		
	}
	
	@Override
	public void setScore(double score) {
		
	}
	
	@Override
	public void setRoomType(RoomType roomType) {
		
	}
	
	@Override
	public void setLowerPrice(double lowerPrice) {
		
	}
	
	@Override
	public void setUpperPrice(double upperPrice) {
		
	}
	
	@Override
	public void setCheckinTime(Date checkinTime) {
		
	}
	
	@Override
	public void setCheckoutTime(Date checkoutTime) {
		
	}
	
	@Override
	public void setOnlyReservationBefore(boolean onlyReservationBefore) {
		
	}
	
	@Override
	public ArrayList<HotelVO> search() {
		System.out.println("获取酒店列表");
		return new ArrayList<HotelVO>();
	}
	
	@Override
	public ArrayList<RoomVO> getRoomList(String hotelID) {
		System.out.println("获取客房列表");
		return new ArrayList<RoomVO>();
	}

	public String getAddress() {
		System.out.println("获取地址");
		return null;
	}

	public String getDistrict() {
		System.out.println("获取商圈");
		return null;
	}

}
