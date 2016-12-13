package test;
import bl.implementation.Manager;
import org.junit.Before;
import org.junit.Test;
import other.UserType;
import vo.ManagerVO;

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
		
	}
	
	@Test
	public void deleteMember() throws Exception {
		
	}
	
	@Test
	public void updateMemberInformation() throws Exception {
		
	}
	
	@Test
	public void getMemberInfomation() throws Exception {
		
	}
	
	@Test
	public void addHotel() throws Exception {
		
	}
	
	@Test
	public void deleteHotel() throws Exception {
		
	}
	
	@Test
	public void updateHotelManagerInformation() throws Exception {
		
	}
	
	@Test
	public void getHotelInformation() throws Exception {
		
	}
	
	@Test
	public void addSaler() throws Exception {
		
	}
	
	@Test
	public void deleteSaler() throws Exception {
		
	}
	
	@Test
	public void updateSalerInformation() throws Exception {
		
	}
	
	@Test
	public void getSalerInformation() throws Exception {
		
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