package bl.service;

import java.util.ArrayList;

import other.CreditChange;
import other.Date;
import other.Enterprise;
import other.MemberType;
import vo.MemberVO;

/**
 * member模块的bl提供给ui的接口类
 * @author CROFF
 * @version 2016-11-28
 */
public interface MemberBLService {

	public String getName();
	public String getTel();
	public double getCredit();
	public ArrayList<CreditChange> getCreditChangeList();
	public int getLevel();
	public double getDiscount();
	public MemberType getMemberType();
	public Date getBirthday();
	public Enterprise getEnterprise();
	
	public MemberVO getMemberInformation();
	public boolean setMemberInformation(MemberVO memberVO);

	public void startSearch();
	public void newReservation();
	public void showOrder();	//查看订单
	public void markHotel();	//收藏（标记）酒店
	public void CreateOrder();	//创建订单
}
