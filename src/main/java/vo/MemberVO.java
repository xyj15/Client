package vo;

import bl.implementation.Credit;
import other.Date;
import other.Enterprise;
import other.MemberType;

import java.util.ArrayList;

public class MemberVO {

	private String name;
	private String tel;
	private Credit credit;
	private int level;
	private double discount;
	private MemberType memberType;
	private Date birthday;
	private Enterprise enterprise;
	
	public MemberVO() {
		
	}
}