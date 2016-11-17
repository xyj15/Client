package bl.driver;

import bl.service.OrderBLService;
import bl.stub.OrderBLStub;
import vo.OrderVO;

public class OrderBLDriver {
	
	OrderBLService orderbl = new OrderBLStub();
	
	public void drive(OrderVO ordervo){
		System.out.println(orderbl.addOrder(ordervo));
		System.out.println(orderbl.abnormalOrder(ordervo));
		System.out.println(orderbl.cancelOrder(ordervo));
		System.out.println(orderbl.cancelAbnormalOrder(ordervo));
		System.out.println(orderbl.getOrder());
		System.out.println(orderbl.getOrderList());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderBLDriver driver =new OrderBLDriver();
		driver.drive(new OrderVO(2, "1997-2-2", "1997-2-5", 1, 2, "��", 0, 450, "123"));
	}
	
}
