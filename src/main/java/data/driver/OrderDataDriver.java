package data.driver;

import data.service.OrderDataService;
import data.stub.OrderDataStub;
import po.OrderPO;

/**
 * Created by CROFF on 2016/12/12.
 */
public class OrderDataDriver {
	
	private OrderDataService orderDataService = new OrderDataStub();
	
	public void drive() {
		String memberID = "000000";
		String orderID = "00";
		System.out.println(orderDataService.getAbnormalOrders(memberID));
		System.out.println(orderDataService.getCancledOrders(memberID));
		System.out.println(orderDataService.getFinishedOrders(memberID));
		System.out.println(orderDataService.getUnfinishedOrders(memberID));
		System.out.println(orderDataService.getOrderList(memberID));
		System.out.println(orderDataService.makeOrderAbnormal(orderID));
		System.out.println(orderDataService.recoverOrder(orderID, 0.5));
		System.out.println(orderDataService.updateOrder(new OrderPO()));
		System.out.println(orderDataService.cancelOrder(orderID));
		System.out.println(orderDataService.getOrder(""));
		System.out.println(orderDataService.addOrder(new OrderPO()));
	}
	
	public static void main(String[] args) {
		OrderDataDriver orderDataDriver = new OrderDataDriver();
		orderDataDriver.drive();
	}
}
