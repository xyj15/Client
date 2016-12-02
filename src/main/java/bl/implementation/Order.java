package bl.implementation;

import bl.service.OrderBLService;
import data.service.OrderDataService;
import other.OrderStatus;
import po.OrderPO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Order模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Order implements OrderBLService {
	
	private ArrayList<OrderVO> orderList;
	private OrderDataService orderDataService;
	private String userID;
	
	public Order(String userID) {
		this.userID = userID;
		updateDataFromFile();
	}
	
	@Override
	public ArrayList<OrderVO> getOrderList() {
		updateDataFromFile();
		return orderList;
	}
	
	@Override
	public ArrayList<OrderVO> getExcutedOrders() {
		updateDataFromFile();
		return filterList(orderList, OrderStatus.Executed);
	}
	
	@Override
	public ArrayList<OrderVO> getUnexcutedOrders() {
		updateDataFromFile();
		return filterList(orderList, OrderStatus.Unexecuted);
	}
	
	@Override
	public ArrayList<OrderVO> getAbnormalOrders() {
		updateDataFromFile();
		return filterList(orderList, OrderStatus.Abnormal);
	}
	
	@Override
	public ArrayList<OrderVO> getCanceledOrders() {
		updateDataFromFile();
		return filterList(orderList, OrderStatus.Canceled);
	}
	
	@Override
	public boolean cancelOrder(String orderID) {
		updateDataFromFile();
		OrderVO orderVO;
		boolean foundOrder = false;
		for(int i=0; i<orderList.size(); i++) {
			orderVO = orderList.get(i);
			if(orderVO.getOrderID().equals(orderID)) {
				foundOrder = true;
				break;
			}
		}
		if(!foundOrder) {
			return false;
		} else {
			
			return true;
		}
	}
	
	@Override
	public boolean evaluateOrder(double score, String comment) {
		return false;
	}
	
	@Override
	public boolean cancelAbnormalOrder(String orderID, double recover) {
		return false;
	}
	
	public void updateDataFromFile() {
		ArrayList<OrderPO> orderPOArrayList = orderDataService.getOrderList(userID);
		orderList = new ArrayList<OrderVO>();
		OrderPO orderPO;
		OrderVO orderVO;
		for (int i = 0; i < orderList.size(); i++) {
			orderPO = orderPOArrayList.get(i);
			String memberID = orderPO.getMemberID();
			String hotelID = orderPO.getHotelID();
			String orderID = orderPO.getOrderID();
			OrderStatus orderStatus = orderPO.getOrderStatus();
			Date createTime = orderPO.getCreateTime();
			Date checkinTime = orderPO.getCheckinTime();
			Date actualCheckinTime = orderPO.getActualCheckinTime();
			Date latestCheckinTime = orderPO.getLatestCheckinTime();
			Date checkoutTime = orderPO.getCheckoutTime();
			Date actualCheckoutTime = orderPO.getActualCheckoutTime();
			int numberOfRoom = orderPO.getNumberOfRoom();
			String roomName = orderPO.getRoomName();
			int numberOfClient = orderPO.getNumberOfClient();
			boolean haveKids = orderPO.getHaveKids();
			double score = orderPO.getScore();
			String evaluation = orderPO.getEvaluation();
			double recover = orderPO.getRecover();
			String promotionID = orderPO.getPromotionID();
			double price = orderPO.getPrice();
			Date cancelTime = orderPO.getCancelTime();
			orderVO = new OrderVO(memberID, hotelID, orderID, orderStatus, createTime,
					checkinTime, actualCheckinTime, latestCheckinTime, checkoutTime,
					actualCheckoutTime, numberOfRoom, roomName, numberOfClient, haveKids,
					score, evaluation, recover, promotionID, price, cancelTime);
			orderList.add(orderVO);
		}
	}
	
	public ArrayList<OrderVO> filterList(ArrayList<OrderVO> orderList, OrderStatus orderStatus) {
		ArrayList<OrderVO> orderVOArrayList = new ArrayList<OrderVO>();
		OrderVO orderVO;
		for(int i=0; i<orderList.size(); i++) {
			orderVO = orderList.get(i);
			if(orderVO.getOrderStatus().equals(orderStatus)) {
				orderVOArrayList.add(orderVO);
			}
		}
		return orderVOArrayList;
	}
}