package test;
import bl.implementation.Manager;
import org.junit.Before;
import org.junit.Test;
import other.MemberType;
import other.UserType;
import vo.HotelVO;
import vo.ManagerVO;
import vo.MemberVO;
import vo.SalerVO;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/10.
 */
public class ManagerTest {
	
	private Manager manager;
	
	@Before
	public void setUp() {
		manager = new Manager();
	}
	
	@Test
	public void addMember() throws Exception {
		MemberVO memberVO = new MemberVO("00000004", "12345678910", "name",
				"1234567890", 2, 0.95, MemberType.Orinary, new Date(), null);
		assertEquals(manager.addMember(memberVO), true);
	}
	
	@Test
	public void deleteMember() throws Exception {
		assertEquals(manager.deleteMember("00000004"), false);
		assertEquals(manager.deleteMember("00000000"), true);
	}
	
	@Test
	public void updateMemberInformation() throws Exception {
		MemberVO memberVO = manager.getMemberInfomation("00000000");
		memberVO.setName("name");
		memberVO.setTel("tel");
		assertEquals(manager.updateMemberInformation(memberVO), true);
	}
	
	@Test
	public void getMemberInfomation() throws Exception {
		assertEquals(manager.getMemberInfomation("00000000").getName(), "客户1");
		assertEquals(manager.getMemberInfomation("00000000").getLevel(), 1);
		assertEquals(manager.getMemberInfomation("00000001").getTel(), "12345678910");
	}
	
	@Test
	public void addHotel() throws Exception {
		HotelVO hotelVO = new HotelVO("000004", "12345678910", "hotel", "address",
				"district", "city", 4, 4, "service", "introduction", "manager", "tel");
		assertEquals(manager.addHotel(hotelVO), true);
	}
	
	@Test
	public void deleteHotel() throws Exception {
		assertEquals(manager.deleteHotel("000004"), false);
		assertEquals(manager.deleteHotel("000000"), true);
	}
	
	@Test
	public void updateHotelManagerInformation() throws Exception {
		String name = "manager name";
		String tel = "manager tel";
		assertEquals(manager.updateHotelManagerInformation("000000", name, tel), true);
	}
	
	@Test
	public void getHotelInformation() throws Exception {
		HotelVO hotelVO = manager.getHotelInformation("000000");
		assertEquals(hotelVO.getName(), "新悦大酒店");
	}
	
	@Test
	public void addSaler() throws Exception {
		SalerVO salerVO = new SalerVO("0004", "12345678910", "saler", "tel");
		assertEquals(manager.addSaler(salerVO), true);
	}
	
	@Test
	public void deleteSaler() throws Exception {
		assertEquals(manager.deleteSaler("0004"), false);
		assertEquals(manager.deleteSaler("0000"), true);
	}
	
	@Test
	public void updateSalerInformation() throws Exception {
		SalerVO salerVO = manager.getSalerInformation("0000");
		salerVO.setName("name");
		assertEquals(manager.updateSalerInformation(salerVO), true);
	}
	
	@Test
	public void getSalerInformation() throws Exception {
		SalerVO salerVO = manager.getSalerInformation("0000");
		assertEquals(salerVO.getName(), "传销人员01");
		assertEquals(salerVO.getTel(), "tel01");
	}
	
	@Test
	public void updateManagerInformation() throws Exception {
		ManagerVO managerVO = manager.getManagerInformation();
		managerVO.setUserID("01");
		managerVO.setName("m");
		manager.updateManagerInformation(managerVO);
		managerVO = manager.getManagerInformation();
		assertEquals(managerVO.getName(), "m");
		assertEquals(managerVO.getUserID(), "01");
	}
	
	@Test
	public void getManagerInformation() throws Exception {
		ManagerVO managerVO = manager.getManagerInformation();
		assertEquals(managerVO.getName(), "manager");
		assertEquals(managerVO.getTel(), "12345678910");
		assertEquals(managerVO.checkIdentity("00", "12345678910"), true);
		assertEquals(managerVO.getUserType(), UserType.Manager);
	}
	
	@Test
	public void getUserType() throws Exception {
		assertEquals(manager.getUserType("00"), UserType.Manager);
		assertEquals(manager.getUserType("0000"), UserType.Saler);
		assertEquals(manager.getUserType("000000"), UserType.Hotel);
		assertEquals(manager.getUserType("00000000"), UserType.Member);
	}
}