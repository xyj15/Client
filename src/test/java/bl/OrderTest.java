package bl;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import bl.mock.*;
import vo.OrderVO;
import bl.implementation.*;
public class OrderTest {
	private Order Order;
	MockOrder Order1;

	@Before
	public void setUp() {
		Order = new Order();
		Order1=new MockOrder("123", 0, null, 0, 0, 0, null, 0);
	}
	
	@Test
	public void testGetOrderList(){
		Order.addOrder(Order1);
		List<OrderVO> List = Order.getOrderList();
		assertEquals(List.get(0),Order1);
	}
	@Test
	public void testGetOrder(){
		Order.addOrder(Order1);
		assertEquals((MockOrder)Order.getOrder("123"),Order1);
	}
	@Test
	public void testCancelOrder(){
		Order.addOrder(Order1);
		Order.cancelOrder(Order1.getOrderID());
		assertEquals(Order1.getState(),4);
	}
	
	@Test
	public void testAbnormalOrder(){
		Order.addOrder(Order1);
		Order.abnormalOrder(Order1.getOrderID());
		assertEquals(Order1.getState(),3);
	}
}
