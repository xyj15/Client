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
		int index = getOrderIndex(orderID);
		if(index==-1) {
			return false;
		}
		
		OrderVO orderVO = orderList.get(index);
		orderVO.setOrderStatus(OrderStatus.Canceled);
		orderVO.setCancelTime(new Date());
		orderList.set(index, orderVO);
		OrderPO orderPO = orderVOTransferToPO(orderVO);
		return orderDataService.updateOrder(orderPO);
	}
	
	@Override
	public boolean evaluateOrder(String orderID, double score, String comment) {
		updateDataFromFile();
		OrderVO orderVO = null;
		
		return false;
	}
	
	@Override
	public boolean cancelAbnormalOrder(String orderID, double recover) {
		return false;
	}
	
	/**
	 *
	 */
	public void updateDataFromFile() {
		ArrayList<OrderPO> orderPOArrayList = orderDataService.getOrderList(userID);
		orderList = new ArrayList<OrderVO>();
		OrderPO orderPO;
		OrderVO orderVO;
		for(int i = 0; i < orderList.size(); i++) {
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
	
	/**
	 *
	 * @param orderList
	 * @param orderStatus
	 * @return
	 */
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
	
	/**
	 *
	 * @param orderID
	 * @return
	 */
	public int getOrderIndex(String orderID) {
		int i;
		for(i=0; i<orderList.size(); i++) {
			if(orderList.get(i).getOrderID().equals(orderID)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 *
	 * @param orderVO
	 * @return
	 */
	public OrderPO orderVOTransferToPO(OrderVO orderVO) {
		String memberID = orderVO.getMemberID();
		String hotelID = orderVO.getHotelID();
		String orderID = orderVO.getOrderID();
		OrderStatus orderStatus = orderVO.getOrderStatus();
		Date createTime = orderVO.getCreateTime();
		Date checkinTime = orderVO.getCheckinTime();
		Date actualCheckinTime = orderVO.getActualCheckinTime();
		Date latestCheckinTime = orderVO.getLatestCheckinTime();
		Date checkoutTime = orderVO.getCheckoutTime();
		Date actualCheckoutTime = orderVO.getActualCheckoutTime();
		int numberOfRoom = orderVO.getNumberOfRoom();
		String roomName = orderVO.getRoomName();
		int numberOfClient = orderVO.getNumberOfClient();
		boolean haveKids = orderVO.getHaveKids();
		double score = orderVO.getScore();
		String evaluation = orderVO.getEvaluation();
		double recover = orderVO.getRecover();
		String promotionID = orderVO.getPromotionID();
		double price = orderVO.getPrice();
		Date cancelTime = orderVO.getCancelTime();
		OrderPO orderPO = new OrderPO(memberID, hotelID, orderID, orderStatus, createTime,
				checkinTime, actualCheckinTime, latestCheckinTime, checkoutTime,
				actualCheckoutTime, numberOfRoom, roomName, numberOfClient, haveKids,
				score, evaluation, recover, promotionID, price, cancelTime);
		return orderPO;
	}
}