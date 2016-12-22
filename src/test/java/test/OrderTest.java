package test;

import bl.implementation.Order;
import org.junit.Before;
import org.junit.Test;
import other.OrderStatus;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class OrderTest {
	
	private Order order;
	
	@Before
	public void setUp() throws Exception {
		order = new Order("00000000");
	}
	
	@Test
	public void getOrderList() throws Exception {
		ArrayList<OrderVO> orderList = order.getOrderList();
		OrderVO orderVO = orderList.get(0);
		assertEquals(orderVO.getHotelID(), "000000");
		assertEquals(orderVO.getHaveKids(), false);
		assertEquals(orderVO.getEvaluation(), "敲棒～～～");
	}
	
	@Test
	public void getExcutedOrders() throws Exception {
		ArrayList<OrderVO> orderList = order.getExcutedOrders();
		OrderVO orderVO = orderList.get(0);
		assertEquals(orderVO.getHotelID(), "000000");
		assertEquals(orderVO.getHaveKids(), false);
		assertEquals(orderVO.getEvaluation(), "敲棒～～～");
	}
	
	@Test
	public void getUnexcutedOrders() throws Exception {
		ArrayList<OrderVO> orderList = order.getUnexcutedOrders();
		OrderVO orderVO = orderList.get(0);
		assertEquals(orderVO.getHotelID(), "000000");
		assertEquals(orderVO.getHaveKids(), false);
	}
	
	@Test
	public void getAbnormalOrders() throws Exception {
		ArrayList<OrderVO> orderList = order.getAbnormalOrders();
		OrderVO orderVO = orderList.get(0);
		assertEquals(orderVO.getHotelID(), "000001");
		assertEquals(orderVO.getNumberOfClient(), 2);
		assertEquals(orderVO.getPrice(), 500, 0.01);
	}
	
	@Test
	public void getCanceledOrders() throws Exception {
		ArrayList<OrderVO> orderList = order.getCanceledOrders();
		OrderVO orderVO = orderList.get(0);
		assertEquals(orderVO.getHotelID(), "000000");
		assertEquals(orderVO.getNumberOfClient(), 4);
		assertEquals(orderVO.getPrice(), 1200, 0.01);
		assertEquals(orderVO.getNumberOfRoom(), 2);
	}
	
	@Test
	public void cancelOrder() throws Exception {
		assertEquals(order.cancelOrder("003"), true);
		assertEquals(order.getCanceledOrders().size(), 2);
	}
	
	@Test
	public void evaluateOrder() throws Exception {
		assertEquals(order.evaluateOrder("000", 5, "好评"), true);
		assertEquals(order.getOrderInformation("000").getEvaluation(), "好评");
	}
	
	@Test
	public void cancelAbnormalOrder() throws Exception {
		assertEquals(order.cancelAbnormalOrder("001", 0.5), true);
		assertEquals(order.getOrderInformation("001").getRecover(), 0.5, 0.001);
	}
	
	@Test
	public void getOrderIndex() throws Exception {
		assertEquals(order.getOrderIndex("000"), 0);
		assertEquals(order.getOrderIndex("001"), 1);
		assertEquals(order.getOrderIndex("002"), 2);
	}
	
	@Test
	public void getOrderInformation() throws Exception {
		OrderVO orderVO = order.getOrderInformation("001");
		assertEquals(orderVO.getOrderStatus(), OrderStatus.Abnormal);
		orderVO = order.getOrderInformation("002");
		assertEquals(orderVO.getRoomName(), "双床房");
	}
	
	@Test
	public void createOrder() throws Exception {
		OrderVO orderVO = new OrderVO();
		order.createOrder(orderVO);
		assertEquals(order.getOrderList().size(), 5);
	}
	
	@Test
	public void getNewOrderID() {
		System.out.println(Order.getNewOrderID());
	}
}