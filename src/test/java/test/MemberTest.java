package test;

import bl.implementation.Member;
import bl.implementation.Order;
import org.junit.Before;
import org.junit.Test;
import other.MemberType;
import other.OrderAction;
import vo.CreditChangeVO;
import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class MemberTest {
	
	private Member member;
	
	@Before
	public void setUp() throws Exception {
		member = new Member("00000000");
	}
	
	@Test
	public void getName() throws Exception {
		String name = member.getName();
		assertEquals(name, "客户1");
	}
	
	@Test
	public void getTel() throws Exception {
		String tel = member.getTel();
		assertEquals(tel, "12345678910");
	}
	
	@Test
	public void getCredit() throws Exception {
		double credit = member.getCredit();
		assertEquals(credit, 0, 0.01);
	}
	
	@Test
	public void getCreditChangeList() throws Exception {
		ArrayList<CreditChangeVO> creditChangeList = member.getCreditChangeList();
		assertEquals(creditChangeList.size(), 4);
		CreditChangeVO creditChangeVO1 = creditChangeList.get(0);
		assertEquals(creditChangeVO1.getOrderAction(), OrderAction.CancelOrder);
	}
	
	@Test
	public void getLevel() throws Exception {
		int level = member.getLevel();
		assertEquals(level, 1);
	}
	
	@Test
	public void getDiscount() throws Exception {
		double discount = member.getDiscount();
		assertEquals(discount, 1, 0.001);
	}
	
	@Test
	public void getMemberType() throws Exception {
		MemberType memberType = member.getMemberType();
		assertEquals(memberType, MemberType.Orinary);
	}
	
	@Test
	public void getBirthday() throws Exception {
		Date birthday = member.getBirthday();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		
		calendar.setTime(new Date());
		assertEquals(calendar.get(Calendar.YEAR), year);
		assertEquals(calendar.get(Calendar.MONTH), month);
		assertEquals(calendar.get(Calendar.DATE), day);
	}
	
	@Test
	public void getEnterprise() throws Exception {
		String enterprise = member.getEnterprise();
		assertEquals(enterprise, null);
	}
	
	@Test
	public void getHotelOrderList() {
		String hotelID = "000000";
		ArrayList<OrderVO> list = member.getHotelOrderList(hotelID);
		assertEquals(list.size(), 3);
	}
	
	@Test
	public void getMemberInformation() throws Exception {
		MemberVO memberVO = member.getMemberInformation();
		assertEquals(memberVO.getName(), "客户1");
	}
	
	@Test
	public void updateMemberInformation() throws Exception {
		MemberVO memberVO = member.getMemberInformation();
		memberVO.setName("client");
		assertEquals(member.updateMemberInformation(memberVO), true);
		memberVO = member.getMemberInformation();
		assertEquals(memberVO.getName(), "client");
	}
	
	@Test
	public void deleteMember() throws Exception {
		member.deleteMember();
		assertEquals(member.getMemberInformation(), null);
	}
}