package po;

import bl.implementation.Credit;
import other.Date;
import other.Enterprise;
import other.MemberType;
import other.User;

import java.util.ArrayList;

public class MemberPO extends User {
	
	private String name;
	private String tel;
	private Credit credit;
	private int level;
	private double discount;
	private MemberType memberType;
	private Date birthday;
	private Enterprise enterprise;
	private ArrayList<OrderPO> orderList;
	private ArrayList<HotelPO> reservedHotelList;
	
	public MemberPO() {
		
	}
}