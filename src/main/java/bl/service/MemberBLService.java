package bl.service;

import java.util.ArrayList;
import java.util.List;

import bl.implementation.Search;
import vo.MemberVO;
import vo.OrderVO;

public interface MemberBLService {

	public MemberVO getMInformation (String memberID);
	public boolean saveMInformation (String memberID,MemberVO M);

	public OrderVO getOrder(String orderID);
	public ArrayList<OrderVO> gerOrderList(String userID);
	public void cancelOrder(String orderID);
	public ArrayList<OrderVO> getUnOrder(String userID);
	public ArrayList<OrderVO> getAlOrder (String userID);
	public ArrayList<OrderVO> getAandCOrder(String userID);
	
	public void startSearch();
}
