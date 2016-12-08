package test;

import bl.implementation.Credit;
import org.junit.Before;
import org.junit.Test;
import other.OrderAction;
import vo.CreditChangeVO;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class CreditTest {
	
	Credit credit;
	
	@Before
	public void setUp() throws Exception {
		credit = new Credit("12345678");
	}
	
	@Test
	public void getCreditChangeList() throws Exception {
		ArrayList<CreditChangeVO> creditChangeList = credit.getCreditChangeList();
		for(int i=0; i<creditChangeList.size(); i++) {
			CreditChangeVO creditChangeVO = creditChangeList.get(i);
			assertEquals(creditChangeVO.getOrderID(), "1234567890123456789012");
		}
		CreditChangeVO creditChangeVO = creditChangeList.get(0);
		assertEquals((int)creditChangeVO.getChange(), -50);
		assertEquals((int)creditChangeVO.getResult(), 50);
		assertEquals(creditChangeVO.getOrderAction(), OrderAction.CancelOrder);
		creditChangeVO = creditChangeList.get(1);
		assertEquals((int)creditChangeVO.getChange(), 100);
		assertEquals((int)creditChangeVO.getResult(), 150);
		assertEquals(creditChangeVO.getOrderAction(), OrderAction.RechargeCredit);
		creditChangeVO = creditChangeList.get(2);
		assertEquals((int)creditChangeVO.getChange(), 300);
		assertEquals((int)creditChangeVO.getResult(), 450);
		assertEquals(creditChangeVO.getOrderAction(), OrderAction.ExecuteOrder);
		creditChangeVO = creditChangeList.get(3);
		assertEquals((int)creditChangeVO.getChange(), -200);
		assertEquals((int)creditChangeVO.getResult(), 250);
		assertEquals(creditChangeVO.getOrderAction(), OrderAction.CancelOrder);
	}
	
	@Test
	public void getCredit() throws Exception {
		assertEquals((int)credit.getCredit(), 100);
	}
	
	@Test
	public void checkCredit() throws Exception {
		assertEquals(credit.checkCredit(), true);
		credit.addCreditChange(new CreditChangeVO(new Date(),
				"1234567890123456789012", OrderAction.CancelOrder, -200, -100));
		assertEquals(credit.checkCredit(), false);
	}
	
	@Test
	public void addCreditChange() throws Exception {
		credit.addCreditChange(new CreditChangeVO(new Date(),
				"1234567890123456789012", OrderAction.CancelOrder, -200, -100));
		assertEquals((int)credit.getCredit(), -100);
	}
	
	@Test
	public void initialCredit() throws Exception {
		credit.initialCredit();
		assertEquals((int)credit.getCredit(), 0);
	}
	
	@Test
	public void updateCreditChangeListFromFile() throws Exception {
		
	}
	
	@Test
	public void updateCreditFromFile() throws Exception {
		
	}
	
}