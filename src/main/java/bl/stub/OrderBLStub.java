package bl.stub;

import bl.service.OrderBLService;
import other.MemberType;
import other.OrderStatus;
import vo.HotelVO;
import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Date;

public class OrderBLStub implements OrderBLService {
	
	private ArrayList<OrderVO> orderList;
	
	public OrderBLStub() {
		orderList = new ArrayList<OrderVO>();
		String memberID = "12345678";
		String hotelID = "123456";
		String orderID = "00000";
		OrderStatus orderStatus = OrderStatus.Executed;
		Date createTime = new Date();
		Date checkinTime = new Date();
		Date actualCheckinTime = new Date();
		Date latestCheckinTime = new Date();
		Date checkoutTime = new Date();
		Date actualCheckoutTime = new Date();
		int numberOfRoom = 4;
		String roomName = "商务大床房";
		int numberOfClient = 4;
		boolean haveKids = false;
		double score = 5;
		String evaluation = "床太硬了不酥服555555";
		double recover = 0.5;
		String promotionID = "00000";
		double price = 99999;
		Date cancelTime = new Date();
		MemberVO memberVO = new MemberVO("12345678", "12345678910", "XXX", "12345678910",
				2, 0.9, MemberType.Orinary, new Date(), "新悦公司");
		HotelVO hotelVO = new HotelVO("123456", "12345678910",
				"新悦大酒店", "南京大学仙林校区", "南京大学商圈", "南京市",
				5, 5, "什么服务都有", "酒店简介", "张新悦", "12345678910");
		OrderVO orderVO = new OrderVO(memberID, hotelID, orderID, orderStatus, createTime,
				checkinTime, actualCheckinTime, latestCheckinTime, checkoutTime, actualCheckoutTime,
				numberOfRoom, roomName, numberOfClient, haveKids, score, evaluation, recover,
				promotionID, price, cancelTime);
		orderVO.setHotelVO(hotelVO);
		orderVO.setMemberVO(memberVO);
		orderList.add(orderVO);
	}
	
	@Override
	public ArrayList<OrderVO> getOrderList() {
		System.out.println("获取订单列表成功");
		return orderList;
	}
	
	@Override
	public ArrayList<OrderVO> getExcutedOrders() {
		System.out.println("获取已执行订单列表成功");
		orderList.get(0).setOrderStatus(OrderStatus.Executed);
		return orderList;
	}
	
	@Override
	public ArrayList<OrderVO> getUnexcutedOrders() {
		System.out.println("获取未执行订单列表成功");
		orderList.get(0).setOrderStatus(OrderStatus.Unexecuted);
		return orderList;
	}
	
	@Override
	public ArrayList<OrderVO> getAbnormalOrders() {
		System.out.println("获取异常订单列表成功");
		orderList.get(0).setOrderStatus(OrderStatus.Abnormal);
		return orderList;
	}
	
	@Override
	public ArrayList<OrderVO> getCanceledOrders() {
		System.out.println("获取已撤销订单列表成功");
		orderList.get(0).setOrderStatus(OrderStatus.Canceled);
		return orderList;
	}
	
	@Override
	public boolean cancelOrder(String orderID) {
		System.out.println("撤销订单成功");
		return true;
	}
	
	@Override
	public boolean evaluateOrder(String orderID, double score, String comment) {
		System.out.println("评价订单成功");
		return true;
	}
	
	@Override
	public boolean cancelAbnormalOrder(String orderID, double recover) {
		System.out.println("撤销异常订单成功");
		return true;
	}
}
