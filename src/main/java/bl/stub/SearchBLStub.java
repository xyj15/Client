package bl.stub;

import java.util.ArrayList;

import bl.service.SearchBLService;
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

	public ArrayList<HotelVO> getHotelList() {
		System.out.println("获取酒店列表");
		return new ArrayList<HotelVO>();
	}

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
