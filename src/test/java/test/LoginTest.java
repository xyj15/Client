package test;

import bl.implementation.Login;
import org.junit.Before;
import org.junit.Test;
import other.MemberType;
import other.UserType;
import vo.MemberVO;

import java.util.Date;

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
		assertEquals(login.existUserID("00000000"), true);
		assertEquals(login.existUserID("000000"), true);
		assertEquals(login.existUserID("0000"), true);
		assertEquals(login.existUserID("00"), true);
		assertEquals(login.existUserID("12345678"), false);
		assertEquals(login.existUserID("123456"), false);
		assertEquals(login.existUserID("1234"), false);
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
		assertEquals(login.login("000000", "12345678910"), true);
		assertEquals(login.login("00000000", "12345678910"), true);
		assertEquals(login.login("0000", "12345678910"), true);
		assertEquals(login.login("00", "12345678910"), true);
		
		assertEquals(login.login("00000000", "123"), false);
		assertEquals(login.login("000000", "123"), false);
		assertEquals(login.login("0000", "123"), false);
		assertEquals(login.login("00", "123"), false);
		
		assertEquals(login.login("12345678", "123"), false);
		assertEquals(login.login("123456", "123"), false);
		assertEquals(login.login("1234", "123"), false);
		assertEquals(login.login("12", "123"), false);
	}
	
	@Test
	public void register() throws Exception {
		MemberVO memberVO = new MemberVO(null, "123456", "new client",
				"13800000000", 1, 1, MemberType.Orinary, new Date(), null);
		assertEquals(login.register(memberVO), true);
	}
	
	@Test
	public void getUserType() throws Exception {
		assertEquals(login.getUserType("00"), UserType.Manager);
		assertEquals(login.getUserType("0000"), UserType.Saler);
		assertEquals(login.getUserType("000000"), UserType.Hotel);
		assertEquals(login.getUserType("00000000"), UserType.Member);
	}
}