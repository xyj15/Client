package vo;

import bl.implementation.Credit;
import other.Date;
import other.Enterprise;
import other.MemberType;
import other.User;

import java.util.ArrayList;

public class MemberVO extends User {

	private String name;
	private String tel;
	private Credit credit;
	private int level;
	private double discount;
	private MemberType memberType;
	private Date birthday;
	private Enterprise enterprise;
	private ArrayList<OrderVO> orderList;
	private ArrayList<HotelVO> reservedHotelList;
	
	public MemberVO() {
		
	}
}