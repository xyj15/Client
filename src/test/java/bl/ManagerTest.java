package bl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bl.implementation.*;
import bl.mock.*;

/**
 * 
 * @author 张新悦
 * @version 2016-11-06
 *
 */
public class ManagerTest {

	private Manager user;
	MockHotel hotel1;
	MockHotel hotel2;
	MockMember member1;
	MockMember member2;

	@Before
	public void setUp() {
		user = new Manager();
		hotel1 = new MockHotel("123", "kunkun", null, null, null, null);
		hotel2 = new MockHotel("123", "zhuangzhuang", null, null, null, null);
		member1 = new MockMember("541", null, null, null, null, 0);
		member2 = new MockMember("541", null, null, null, null, 5.0);
	}

	@Test
	public void testAddUser() {
		user.addHotel(hotel1);
		user.addMember(member1);
		assertEquals(hotel1.getHotelID(), user.getHotel(hotel1.getHotelID()).getHotelID());
		assertEquals(member1.getMemberID(), user.getMember("541").getMemberID());
	}
	
	//@SuppressWarnings("deprecation")
	@Test
	public void testUpdateUser(){
		user.updateHotel(hotel2);
		user.updateMember(member2);
		assertEquals(hotel2.getName(), user.getHotel(hotel2.getHotelID()).getName());
		assertEquals((int)member2.getCredit(), (int)user.getMember(member2.getMemberID()).getCredit());
	}
	
	/*@Test
	public void testDeleteUser(){
		user.deleteHotel(hotel2);
		user.deleteMember(member2);
		assertEquals(null, user.getHotel(hotel2.getHotelID()));
		assertEquals(null, user.getMember(member2.getMemberID()));
	}*/

}
