package bl.driver;

import bl.service.OrderBLService;
import bl.stub.OrderBLStub;

public class OrderBLDriver {

	OrderBLService orderBLService = new OrderBLStub();

	public void drive() {
		String orderID = "2011111112323232345678";
		System.out.println(orderBLService.getOrderList());
		System.out.println(orderBLService.getAbnormalOrders());
		System.out.println(orderBLService.getCanceledOrders());
		System.out.println(orderBLService.getExcutedOrders());
		System.out.println(orderBLService.getUnexcutedOrders());
		System.out.println(orderBLService.cancelOrder(orderID));
		System.out.println(orderBLService.evaluateOrder(orderID, 5, "comment"));
		System.out.println(orderBLService.cancelAbnormalOrder(orderID, 0.5));
	}

	public static void main(String[] args) {
		OrderBLDriver orderBLDriver = new OrderBLDriver();
		orderBLDriver.drive();
	}

}
