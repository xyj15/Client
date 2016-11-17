package bl;

import static org.junit.Assert.*;

import org.junit.*;

import bl.implementation.Reserve;
import bl.mock.MockDate;
import bl.mock.MockPromotion;

/**
 * Reserve的测试类
 * @author CROFF
 * @version 2016-11-13
 */
public class ReserveTest {
	
	private Reserve r;
	
	@Before
	public void setUp() {
		r = new Reserve(500);
	}

	@Test
	public void testSetDate() {
		MockDate mockDate = new MockDate(2016, 10, 01);
		r.setDate(mockDate);
		
		assertEquals(r.getDate().getYear(), mockDate.getYear());
		assertEquals(r.getDate().getMonth(), mockDate.getMonth());
		assertEquals(r.getDate().getDay(), mockDate.getDay());
	}

	@Test
	public void testSetDays() {
		int days = 5;
		r.setDays(days);
		
		assertEquals(r.getDays(), days);
	}

	@Test
	public void tesetSetPromotion() {
		MockDate birthday = new MockDate(1996, 1, 1);
		int roomNum = 3304;
		boolean isCoordinate = false;
		MockDate date = new MockDate(2016, 10, 10);
		boolean isVIP = false;
		String district = "南京市新街口";
		double discount = 0.8;
		MockPromotion promo = new MockPromotion(birthday, roomNum, isCoordinate,
				date, isVIP, district, discount, "0011");
		r.setPromotion(promo);
		
		assertEquals(r.getPromotion(), promo);
	}

}
