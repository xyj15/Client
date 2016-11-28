package bl.service;

import java.util.ArrayList;

import other.Date;
import other.Enterprise;
import other.MemberType;
import vo.MemberVO;
import vo.OrderVO;

/**
 * member模块的bl提供给ui的接口类
 * @author CROFF
 * @version 2016-11-28
 */
public interface MemberBLService {

	public String getName();
	public String getTel();
	public double getCredit();
	public int getLevel();
	public double getDiscount();
	public MemberType getMemberType();
	public Date getBirthday();
	public Enterprise getEnterprise();
	
	public MemberVO getMemberInformation();
	public boolean setMemberInformation(MemberVO memberVO);

	public ArrayList<OrderVO> getAllOrder();
	public ArrayList<OrderVO> getExcutedOrder();
	public ArrayList<OrderVO> getAbnormalOrder ();
	public ArrayList<OrderVO> getCanceledOrder();
	
	public void cancelOrder(String orderID);
	public void evaluateOrder(double score, String comment);	//评价酒店，包括评分和评论
	public void startSearch();
	public void newReservation();
}
