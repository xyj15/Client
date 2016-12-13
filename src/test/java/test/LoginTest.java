package test;

import bl.implementation.Login;
import org.junit.Before;
import org.junit.Test;
import other.UserType;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class LoginTest {
	
	private Login login;
	
	@Before
	public void setUp() throws Exception {
		login = new Login();
	}
	
	@Test
	public void checkNetwork() throws Exception {
		boolean connected = login.checkNetwork();
		assertEquals(connected, false);	//RMI未连接
//		assertEquals(connected, true);	//RMI已连接
	}
	
	@Test
	public void existUserID() throws Exception {
		
	}
	
	@Test
	public void validPassword() throws Exception {
		String[] password1 = {"123456789", "12345678", "%%$$#gfgfgf"};
		for(int i=0; i<password1.length; i++) {
			assertEquals(login.validPassword(password1[i]), false);
		}
		
		String[] password2 = {"1234567890", "12345678910", "aassddffgg"};
		for(int i=0; i<password2.length; i++) {
			assertEquals(login.validPassword(password2[i]), true);
		}
	}
	
	@Test
	public void login() throws Exception {
		
	}
	
	@Test
	public void register() throws Exception {
		
	}
	
	@Test
	public void getUserType() throws Exception {
		assertEquals(login.getUserType("00"), UserType.Manager);
		assertEquals(login.getUserType("0000"), UserType.Saler);
		assertEquals(login.getUserType("000000"), UserType.Hotel);
		assertEquals(login.getUserType("00000000"), UserType.Member);
	}
}