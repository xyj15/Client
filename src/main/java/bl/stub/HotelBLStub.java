package bl.stub;

import bl.service.HotelBLService;
import vo.HotelVO;

public class HotelBLStub implements HotelBLService{
	
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
	
	@Override
	public String getHotelName() {
		System.out.println("设置酒店名称为新悦大酒店成功");
		return name;
	}
	
	@Override
	public String getHotelAddress() {
		System.out.println("设置酒店地址为栖霞区仙林大道163号成功");
		return address;
	}
	
	@Override
	public String getCity() {
		System.out.println("设置酒店所在城市为江苏省南京市成功");
		return city;
	}
	
	@Override
	public int getHotelLevel() {
		System.out.println("设置酒店星级为五星级成功");
		return level;
	}
	
	@Override
	public String getDistrict() {
		System.out.println("设置酒店所属商圈为南京大学仙林校区成功");
		return district;
	}
	
	@Override
	public double getHotelScore() {
		System.out.println("设置酒店评分为5分成功");
		return score;
	}
	
	@Override
	public String getHotelService() {
		System.out.println("设置酒店提供服务为免费高速Wi-Fi成功");
		return service;
	}
	
	@Override
	public String getHotelIntroduction() {
		System.out.println("设置酒店简介为这个酒店是全世界坠吼的成功");
		return introduction;
	}
	
	@Override
	public String getHotelManagerName() {
		System.out.println("设置酒店工作人员为张新悦成功");
		return managerName;
	}
	
	@Override
	public String getHotelManagerTel() {
		System.out.println("设置酒店工作人员联系方式为12345678910成功");
		return managerTel;
	}
	
	@Override
	public boolean setHotelInformation(HotelVO hotelInformation) {
		System.out.println("更新酒店信息成功");
		return true;
	}
	
	@Override
	public HotelVO getHotelInformation() {
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
	public boolean delay(String orderID) {
		System.out.println("客户延迟入住成功");
		return true;
	}
}