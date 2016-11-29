package vo;

import other.District;
import other.Enterprise;
import other.HotelService;

import java.util.ArrayList;

public class HotelVO {

	private String hotelID;
	private String name;
	private String address;
	private int level;
	private District district;
	private double score;	//酒店评分
	private HotelService hotelService;	//酒店设施服务
	private String introduction;	//酒店简介
	private String managerID;	//酒店管理人员的ID
	
	private ArrayList<RoomVO> roomList;
	private ArrayList<Enterprise> enterpriseArrayList;	//合作企业列表
	private ArrayList<OrderVO> orderList;
	
	public HotelVO() {
		
	}
}