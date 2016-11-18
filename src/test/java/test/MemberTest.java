package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bl.implementation.Member;
import bl.mock.MockOrder;
import vo.OrderVO;

/**
 * 
 * @author	 庄刚轻
 * @version	2016/11/13
 */

public class MemberTest {

	private Member member;
	
	MockOrder order1;
	MockOrder order2;
	Member m;
	
	@Before
	public void setUp(){
		member=new Member("123", "321", null, null,null, 500.0,null,null);
		
		order1=new MockOrder("1100",2, null, 1, 2, 110	, "50% off", 251 );
		order2=new MockOrder("1101",2, null, 3, 4, 120	, "40% off", 666);
	}
	@Test
	public void testGetMInformation(){
		assertEquals(member.getMInformation(member.getID()),member.getVo());
	}
	@Test
	public void testSaveMInformation(){
		m=new Member("123", "321", null, "SS", null, 500.0,null,null);
		member.saveMInformation(member.getID(), m.getVo());
		assertEquals(member.getMInformation(member.getID()),m.getVo());
	}
	@Test
	public void testGetCreditList(){
		assertEquals(member.getCreditList(),member.getCreditList(member.getID()));
	}
	@Test
	public void testGetCredit(){
		assertEquals(""+member.getCredit(member.getID()),"500.0");
	}
	@Test
	public void testUpdateCredit(){
		member.updateCredit(member.getID(), 800);
        assertEquals(""+member.getCredit(member.getID()), ""+800.0);
	}
	@Test
	public void testCheckCredit(){
		assertEquals(member.checkCredit(member.getID()),true);
	}
	@Test
	public void testGetOrder(){
		member.ordermanager.addOrder(order1);
		member.ordermanager.addOrder(order2);
		assertEquals((MockOrder)member.getOrder("1100"),order1);
		assertEquals((MockOrder)member.getOrder("1101"),order2);
	}
	@Test
	public void testGetOrderList(){
		member.ordermanager.addOrder(order1);
		member.ordermanager.addOrder(order2);
		List<OrderVO> List = member.gerOrderList(member.getID());
		
		assertEquals(List.get(0),order1);
		assertEquals(List.get(1),order2);
	}
}
