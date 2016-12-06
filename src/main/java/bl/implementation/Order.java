package bl.implementation;

import bl.service.OrderBLService;
import data.service.OrderDataService;
import other.OrderAction;
import other.OrderStatus;
import po.OrderPO;
import vo.CreditChangeVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Order模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Order implements OrderBLService {
	
	private String userID;	//用户ID
	private ArrayList<OrderVO> orderList;	//所有订单列表
	
	private OrderDataService orderDataService;
	
	/**
	 * 提供用户ID的构造方法（客户和酒店）
	 * @param userID 用户ID
	 */
	public Order(String userID) {
		this.userID = userID;
		updateDataFromFile();
	}
	
	/**
	 * 获得用户的所有订单
	 * @return 所有订单列表
	 */
	@Override
	public ArrayList<OrderVO> getOrderList() {
		updateDataFromFile();
		return orderList;
	}
	
	/**
	 * 获得用户的已执行订单
	 * @return 已执行订单列表
	 */
	@Override
	public ArrayList<OrderVO> getExcutedOrders() {
		updateDataFromFile();
		return filterList(orderList, OrderStatus.Executed);
	}
	
	/**
	 * 获得用户的未执行订单
	 * @return 未执行订单列表
	 */
	@Override
	public ArrayList<OrderVO> getUnexcutedOrders() {
		updateDataFromFile();
		return filterList(orderList, OrderStatus.Unexecuted);
	}
	
	/**
	 * 获得用户的异常订单
	 * @return 异常订单列表
	 */
	@Override
	public ArrayList<OrderVO> getAbnormalOrders() {
		updateDataFromFile();
		return filterList(orderList, OrderStatus.Abnormal);
	}
	
	/**
	 * 获得用户的已撤销订单
	 * @return 已撤销订单列表
	 */
	@Override
	public ArrayList<OrderVO> getCanceledOrders() {
		updateDataFromFile();
		return filterList(orderList, OrderStatus.Canceled);
	}
	
	/**
	 * 撤销订单
	 * @param orderID 订单ID
	 * @return 撤销成功则返回true，否则返回false
	 */
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
		OrderPO orderPO = orderVOtoPO(orderVO);
		return orderDataService.updateOrder(orderPO);
	}
	
	/**
	 * 评价订单
	 * @param orderID 订单ID
	 * @param score 评分
	 * @param comment 评价
	 * @return 评价成功则返回true，否则返回false
	 */
	@Override
	public boolean evaluateOrder(String orderID, double score, String comment) {
		updateDataFromFile();
		int index = getOrderIndex(orderID);
		if(index==-1) {
			return false;
		}
		
		OrderVO orderVO = orderList.get(index);
		orderVO.setScore(score);
		orderVO.setEvaluation(comment);
		orderList.set(index, orderVO);
		OrderPO orderPO = orderVOtoPO(orderVO);
		return orderDataService.updateOrder(orderPO);
	}
	
	/**
	 * 撤销异常订单，撤销后该订单变为已执行订单，并按比例恢复客户的信用
	 * @param orderID 订单ID
	 * @param recover 恢复信用的比例
	 * @return 撤销成功则返回true，否则返回false
	 */
	@Override
	public boolean cancelAbnormalOrder(String orderID, double recover) {
		updateDataFromFile();
		int index = getOrderIndex(orderID);
		if(index==-1) {
			return false;
		}
		
		OrderVO orderVO = orderList.get(index);
		orderVO.setOrderStatus(OrderStatus.Executed);
		orderVO.setRecover(recover);
		orderList.set(index, orderVO);
		OrderPO orderPO = orderVOtoPO(orderVO);
		orderDataService.updateOrder(orderPO);
		
		Credit credit = new Credit(orderVO.getMemberID());
		double creditChange = orderVO.getPrice()*recover;
		double changeResult = credit.getCredit()+creditChange;
		CreditChangeVO creditChangeVO = new CreditChangeVO(new Date(), orderID,
				OrderAction.CancelAbnormal, creditChange, changeResult);
		return credit.addCreditChange(creditChangeVO);
	}
	
	/**
	 * 从Data层更新数据
	 */
	public void updateDataFromFile() {
		ArrayList<OrderPO> orderPOArrayList = orderDataService.getOrderList(userID);
		orderList = new ArrayList<OrderVO>();
		OrderPO orderPO;
		OrderVO orderVO;
		for(int i=0; i<orderList.size(); i++) {
			orderPO = orderPOArrayList.get(i);
			orderVO = orderPOtoVO(orderPO);
			orderList.add(orderVO);
		}
	}
	
	/**
	 * 根据订单状态过滤订单列表
	 * @param orderList 原始订单列表
	 * @param orderStatus 过滤用的订单状态
	 * @return 过滤后的订单列表
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
	 * 获取某订单在列表中的下标，若不存在则返回-1
	 * @param orderID 订单ID
	 * @return 其在列表中的下标
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
	 * 将Order从VO转换成PO
	 * @param orderVO VO变量
	 * @return PO变量
	 */
	public static OrderPO orderVOtoPO(OrderVO orderVO) {
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
	
	/**
	 * 将Order从PO转换成VO
	 * @param orderPO PO
	 * @return VO
	 */
	public static OrderVO orderPOtoVO(OrderPO orderPO) {
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
		OrderVO orderVO = new OrderVO(memberID, hotelID, orderID, orderStatus, createTime,
				checkinTime, actualCheckinTime, latestCheckinTime, checkoutTime,
				actualCheckoutTime, numberOfRoom, roomName, numberOfClient, haveKids,
				score, evaluation, recover, promotionID, price, cancelTime);
		return orderVO;
	}
}