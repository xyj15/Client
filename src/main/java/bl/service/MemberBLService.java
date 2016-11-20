package bl.service;

import java.util.ArrayList;
import java.util.List;

import vo.MemberVO;
import vo.OrderVO;

public interface MemberBLService {

	public MemberVO getMInformation (String memberID);
	public boolean saveMInformation (String memberID,MemberVO M);

	public OrderVO getOrder(String orderID);
	public List<OrderVO> gerOrderList(String userID);
	public void cancelOrder(String orderID);
	public List<OrderVO> getUnOrder(ArrayList<OrderVO> orderList);
	public List<OrderVO> getAlOrder (ArrayList<OrderVO> orderList);
	public List<OrderVO> getAandCOrder(ArrayList<OrderVO> orderList);
}
