package vo;

import other.User;
import other.UserType;

import java.util.ArrayList;

public class HotelVO extends User {

	private String name;
	private String address;
	private int level;
	private String city;
	private String district;
	private double score;	//酒店评分
	private String service;	//酒店设施服务
	private String introduction;	//酒店简介
	private String managerName;	//酒店管理人员的姓名
	private String managerTel;	//酒店管理人员的联系方式
	
	private ArrayList<String> enterpriseList;	//合作企业列表
	private ArrayList<RoomVO> roomList;
	private ArrayList<OrderVO> orderList;
	
	public HotelVO() {
		enterpriseList = new ArrayList<String>();
		roomList = new ArrayList<RoomVO>();
		orderList = new ArrayList<OrderVO>();
	}
	
	public HotelVO(String name, String address, String district, int level, double score, String service,
				   String introduction, String managerName, String managerTel, ArrayList<String> enterpriseList,
				   ArrayList<RoomVO> roomList, ArrayList<OrderVO> orderList) {
		this.name = name;
		this.address = address;
		this.district = district;
		this.level = level;
		this.score = score;
		this.service = service;
		this.introduction = introduction;
		this.managerName = managerName;
		this.managerTel = managerTel;
		this.enterpriseList = enterpriseList;
		this.roomList = roomList;
		this.orderList = orderList;
	}
	
	public HotelVO(String username, String password, String name, String address, String district,
				   int level, double score, String service, String introduction, String managerName,
				   String managerTel, ArrayList<String> enterpriseList, ArrayList<RoomVO> roomList, ArrayList<OrderVO> orderList) {
		super(username, password, UserType.Hotel);
		this.name = name;
		this.address = address;
		this.district = district;
		this.level = level;
		this.score = score;
		this.service = service;
		this.introduction = introduction;
		this.managerName = managerName;
		this.managerTel = managerTel;
		this.enterpriseList = enterpriseList;
		this.roomList = roomList;
		this.orderList = orderList;
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
	
	public ArrayList<String> getEnterpriseList() {
		return enterpriseList;
	}
	
	public void setEnterpriseList(ArrayList<String> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}
	
	public ArrayList<RoomVO> getRoomList() {
		return roomList;
	}
	
	public void setRoomList(ArrayList<RoomVO> roomList) {
		this.roomList = roomList;
	}
	
	public ArrayList<OrderVO> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(ArrayList<OrderVO> orderList) {
		this.orderList = orderList;
	}
	
	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		this.service = service;
	}
}