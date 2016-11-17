package bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bl.implementation.Hotel;
import bl.mock.MockOrder;
import bl.mock.MockRoom;
import vo.OrderVO;;
/**
 * 
 * @author	 庄刚轻
 * @version	2016/11/6
 */
public class HotelTest {
	
	private Hotel hotel;

	MockOrder order1;
	MockOrder order2;
	MockRoom room1;
	MockRoom room2;
	@Before
	public void setUp(){
		hotel=new Hotel("123", null, null, null, null);
		order1=new MockOrder("1100",2, null, 1, 2, 110	, "50% off", 251 );
		order2=new MockOrder("1101",2, null, 3, 4, 120	, "40% off", 666);
		
	}
	
	@Test
	public void testGetOrderList(){
		hotel.ordermanager.addOrder(order1);
		hotel.ordermanager.addOrder(order2);
		List<OrderVO> List = hotel.getOrderList(hotel.getID(), null);
		
		assertEquals(List.get(0),order1);
		assertEquals(List.get(1),order2);
	}
	@Test
	public void testGetOrder(){
		hotel.ordermanager.addOrder(order1);
		hotel.ordermanager.addOrder(order2);
		assertEquals((MockOrder)hotel.getOrder("1100"),order1);
		assertEquals((MockOrder)hotel.getOrder("1101"),order2);
	}
	@Test
	public void testGetHotelInformat(){
		assertEquals(hotel.getHotelInformat(hotel.getID()),hotel.getVO());
	}
	@Test
	public void testUpdataOrder(){
		hotel.ordermanager.addOrder(order1);
		MockOrder order3=new MockOrder("1100",2, null, 3, 4, 120	, "40% off", 666);
		hotel.updataOrder(order1.getOrderID(), order3);
		assertEquals(hotel.getOrder(order1.getOrderID()),order3);
	}
	@Test
	public void testDelay(){
		MockOrder order3=new MockOrder("1110",3, null, 3, 4, 120	, "40% off", 666);
		hotel.ordermanager.addOrder(order3);
		hotel.delay(order3.getOrderID());
		order3.setState(2);
		assertEquals(hotel.getOrder(order3.getOrderID()),order3);
	}
	
	@Test
	public void testUpdataHotelInformat(){
		Hotel x=new Hotel("123", "155", null, null, null);
		hotel.updataHotelInformat(hotel.getID(), x.getVO());
		assertEquals(hotel.getHotelInformat(hotel.getID()),x.getVO());
	}
	@Test
	public void testCheck(){
		room1=new MockRoom(1, "123", 321);
		room2=new MockRoom(2,"222",555);
		hotel.roommanager.addRoom(room1);
		hotel.roommanager.updateRoom(room2);
		assertEquals((MockRoom)hotel.roommanager.findRoom(room2.getNumber()),room2);
	}
}
