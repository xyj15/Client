package test;

import static org.junit.Assert.*;

import org.junit.*;

import bl.implementation.Reserve;
import bl.mock.MockPromotion;
import other.Date;

/**
 * Reserve的测试类
 * @author CROFF
 * @version 2016-11-13
 */
public class ReserveTest {
	
	private Reserve r;
	
	@Before
	public void setUp() {
		r = new Reserve(null);
	}

	@Test
	public void tesetSetPromotion() {
		Date birthday = new Date(1996, 1, 1);
		int roomNum = 3304;
		boolean isCoordinate = false;
		Date date = new Date(2016, 10, 10);
		boolean isVIP = false;
		String district = "南京市新街口";
		double discount = 0.8;
		MockPromotion promo = new MockPromotion(birthday, roomNum, isCoordinate,
				date, isVIP, district, discount, "0011");
		r.setPromotion(promo);
		
		assertEquals(r.getPromotion(), promo);
	}

}
