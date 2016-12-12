package data.stub;

import data.service.HotelDataService;
import po.HotelPO;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/12/2.
 */
public class HotelDataStub implements HotelDataService {
	
	ArrayList<HotelPO> hotelList;
	
	public HotelDataStub() {
		hotelList = new ArrayList<>();
		String password = "12345678910";
		String tel = password;
		String city = "南京市";
		
		HotelPO hotelPO1 = new HotelPO("000000", password, "新悦大酒店", city, "南京大学商圈",
				"仙林大道163号", 5, 5, "24小时Wi-Fi", "这个酒店是全世界坠吼的", "张新悦", tel, new ArrayList<>());
		hotelPO1.getEnterpriseList().add("企业1");
		hotelList.add(hotelPO1);
		
		HotelPO hotelPO2 = new HotelPO("000001", password, "婧婧大酒店", city, "南京大学商圈",
				"仙林大道163号", 5, 5, "24小时Wi-Fi", "这个酒店也是全世界坠吼的", "徐亚婧", tel, new ArrayList<>());
		hotelPO2.getEnterpriseList().add("企业2");
		hotelList.add(hotelPO2);
		
		HotelPO hotelPO3 = new HotelPO("000002", password, "辣鸡酒店1", city, "马群商圈",
				"马群街道1号", 3, 3, "免费自来水饮用", "辣鸡酒店就是辣鸡", "王思聪", tel, new ArrayList<>());
		hotelList.add(hotelPO3);
		
		HotelPO hotelPO4 = new HotelPO("000003", password, "辣鸡酒店2", city, "新街口商圈",
				"中山南路1号", 4, 4, "免费接送机", "辣鸡酒店真辣鸡", "王健林", tel, new ArrayList<>());
		hotelList.add(hotelPO4);
	}
	
	@Override
	public boolean addHotel(HotelPO hotel) {
		System.out.println("添加酒店成功");
		return hotelList.add(hotel);
	}
	
	@Override
	public boolean deleteHotel(String hotelID) {
		System.out.println("删除酒店成功");
		if(hotelID==null) {
			return false;
		}
		
		for(int i=0; i<hotelList.size(); i++) {
			if(hotelList.get(i).getUserID().equals(hotelID)) {
				hotelList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean updateHotel(HotelPO hotel) {
		System.out.println("更新酒店信息成功");
		String hotelID = hotel.getUserID();
		if(hotelID==null) {
			return false;
		}
		
		for(int i=0; i<hotelList.size(); i++) {
			if(hotelList.get(i).getUserID().equals(hotelID)) {
				hotelList.set(i, hotel);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public HotelPO getHotelByID(String hotelID) {
		System.out.println("通过酒店ID获取酒店成功");
		for(int i=0; i<hotelList.size(); i++) {
			HotelPO hotelPO = hotelList.get(i);
			if(hotelPO.getUserID().equals(hotelID)) {
				return hotelPO;
			}
		}
		return null;
	}
	
	@Override
	public HotelPO getHotelByName(String hotelName) {
		System.out.println("通过酒店名称获取酒店成功");
		for(int i=0; i<hotelList.size(); i++) {
			HotelPO hotelPO = hotelList.get(i);
			if(hotelPO.getName().equals(hotelName)) {
				return hotelPO;
			}
		}
		return null;
	}
	
	@Override
	public String getAvailableHotelID() {
		System.out.println("获取可用酒店ID成功");
		int size =hotelList.size();
		String availableID = String.valueOf(size);
		switch (availableID.length()) {
			case 1:
				availableID = "0" + availableID;
			case 2:
				availableID = "0" + availableID;
			case 3:
				availableID = "0" + availableID;
			case 4:
				availableID = "0" + availableID;
			case 5:
				availableID = "0" + availableID;
			case 6:
				break;
		}
		return availableID;
	}
	
	public ArrayList<HotelPO> getHotelList() {
		return hotelList;
	}
}
