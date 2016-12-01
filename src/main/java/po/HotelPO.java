package po;

import other.Enterprise;
import other.HotelService;
import other.User;

import java.util.ArrayList;

public class HotelPO extends User {
	
	private String name;
	private int level;
	private String city;
	private String address;
	private String district;
	private double score;	//酒店评分
	private HotelService hotelService;	//酒店设施服务
	private String introduction;	//酒店简介
	private String managerName;	//酒店管理人员的姓名
	private String managerTel;	//酒店管理人员的联系方式
	
	private ArrayList<Enterprise> enterpriseList;	//合作企业列表
	
	public HotelPO() {
		hotelService = null;
		enterpriseList = new ArrayList<Enterprise>();
	}
	
	public HotelPO(String name, String address, String district, int level, double score, HotelService hotelService,
				   String introduction, String managerName, String managerTel, ArrayList<Enterprise> enterpriseList) {
		this.name = name;
		this.address = address;
		this.district = district;
		this.level = level;
		this.score = score;
		this.hotelService = hotelService;
		this.introduction = introduction;
		this.managerName = managerName;
		this.managerTel = managerTel;
		this.enterpriseList = enterpriseList;
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
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public HotelService getHotelService() {
		return hotelService;
	}
	
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getManagerName() {
		return managerName;
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public String getManagerTel() {
		return managerTel;
	}
	
	public void setManagerTel(String managerTel) {
		this.managerTel = managerTel;
	}
	
	public ArrayList<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}
	
	public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
}