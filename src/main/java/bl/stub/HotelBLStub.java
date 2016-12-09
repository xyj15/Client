package bl.stub;

import bl.service.HotelBLService;
import other.RoomType;
import vo.HotelVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

public class HotelBLStub implements HotelBLService{
	
	private String hotelID;
	
	private String name = "新悦大酒店";
	private String address = "栖霞区仙林大道163号";
	private int level = 5;
	private String city = "江苏省南京市";
	private String district = "南京大学仙林校区";
	private double score = 5;
	private String service = "免费高速Wi-Fi";
	private String introduction = "这个酒店是全世界坠吼的";
	private String managerName = "张新悦";
	private String managerTel = "12345678910";
	
	public HotelBLStub(String hotelID) {
		this.hotelID = hotelID;
	}
	
	public HotelBLStub() {
		this.hotelID = null;
	}
	
	@Override
	public String getHotelName() {
		System.out.println("获取酒店名称成功");
		return name;
	}
	
	@Override
	public String getHotelAddress() {
		System.out.println("获取酒店地址成功");
		return address;
	}
	
	@Override
	public String getCity() {
		System.out.println("获取酒店所在城市成功");
		return city;
	}
	
	@Override
	public int getHotelLevel() {
		System.out.println("获取酒店星级成功");
		return level;
	}
	
	@Override
	public String getDistrict() {
		System.out.println("获取酒店所属商圈成功");
		return district;
	}
	
	@Override
	public double getHotelScore() {
		System.out.println("获取酒店评分成功");
		return score;
	}
	
	@Override
	public String getHotelService() {
		System.out.println("获取酒店提供服务成功");
		return service;
	}
	
	@Override
	public String getHotelIntroduction() {
		System.out.println("获取酒店简介成功");
		return introduction;
	}
	
	@Override
	public String getHotelManagerName() {
		System.out.println("获取酒店工作人员成功");
		return managerName;
	}
	
	@Override
	public String getHotelManagerTel() {
		System.out.println("获取酒店工作人员联系方式成功");
		return managerTel;
	}
	
	@Override
	public boolean setHotelInformation(HotelVO hotelInformation) {
		System.out.println("更新酒店信息成功");
		return true;
	}
	
	@Override
	public HotelVO getHotelInformation() {
		System.out.println("获取酒店信息成功");
		return new HotelVO("123456", "12345678910", name, address, district, city,
				level, score, service, introduction, managerName, managerTel);
	}
	
	@Override
	public boolean checkin(String orderID, String roomID) {
		System.out.println("客户入住成功");
		return true;
	}
	
	@Override
	public boolean checkout(String orderID, String roomID) {
		System.out.println("客户退房成功");
		return true;
	}
	
	@Override
	public boolean delay(String orderID, String roomID) {
		System.out.println("客户延迟入住成功");
		return true;
	}
}