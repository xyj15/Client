package test;

import bl.implementation.Hotel;
import org.junit.Before;
import org.junit.Test;
import other.RoomType;
import vo.HotelVO;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class HotelTest {
	
	private Hotel hotel;
	
	@Before
	public void setUp() throws Exception {
		hotel = new Hotel("000000");
	}
	
	@Test
	public void getHotelName() throws Exception {
		String hotelName = hotel.getHotelName();
		assertEquals(hotelName, "新悦大酒店");
	}
	
	@Test
	public void getHotelAddress() throws Exception {
		String hotelAddress = hotel.getHotelAddress();
		assertEquals(hotelAddress, "仙林大道163号");
	}
	
	@Test
	public void getCity() throws Exception {
		String city = hotel.getCity();
		assertEquals(city, "南京市");
	}
	
	@Test
	public void getHotelLevel() throws Exception {
		int level = hotel.getHotelLevel();
		assertEquals(level, 5);
	}
	
	@Test
	public void getDistrict() throws Exception {
		String district = hotel.getDistrict();
		assertEquals(district, "南京大学商圈");
	}
	
	@Test
	public void getHotelScore() throws Exception {
		double score = hotel.getHotelScore();
		assertEquals(score, 5, 0.001);
	}
	
	@Test
	public void getHotelService() throws Exception {
		String service = hotel.getHotelService();
		assertEquals(service, "24小时Wi-Fi");
	}
	
	@Test
	public void getHotelIntroduction() throws Exception {
		String introduction = hotel.getHotelIntroduction();
		assertEquals(introduction, "这个酒店是全世界坠吼的");
	}
	
	@Test
	public void getHotelManagerName() throws Exception {
		String name = hotel.getHotelManagerName();
		assertEquals(name, "张新悦");
	}
	
	@Test
	public void getHotelManagerTel() throws Exception {
		String tel = hotel.getHotelManagerTel();
		assertEquals(tel, "12345678910");
	}
	
	@Test
	public void setHotelInformation() throws Exception {
		HotelVO hotelVO = hotel.getHotelInformation();
		hotelVO.setName("新悦小酒店");
		hotel.setHotelInformation(hotelVO);
		hotelVO = hotel.getHotelInformation();
		assertEquals(hotelVO.getName(), "新悦小酒店");
	}
	
	@Test
	public void getHotelInformation() throws Exception {
		HotelVO hotelVO = hotel.getHotelInformation();
		assertEquals(hotelVO.getName(), "新悦大酒店");
	}
	
	@Test
	public void checkin() throws Exception {
		assertEquals(hotel.checkin("003", "3003"), false);
		assertEquals(hotel.checkin("003", "3001"), true);
		assertEquals(hotel.checkin("003", "3001"), false);
	}
	
	@Test
	public void checkout() throws Exception {
		assertEquals(hotel.checkout("000", "3001"), false);
		assertEquals(hotel.checkout("000", "3003"), true);
		assertEquals(hotel.checkout("000", "3003"), false);
	}
	
	@Test
	public void delay() throws Exception {
		assertEquals(hotel.delay("001", "3003"), false);
		assertEquals(hotel.delay("001", "3001"), true);
		assertEquals(hotel.delay("001", "3001"), false);
	}
	
	@Test
	public void reserveSingleRoom() throws Exception {
		assertEquals(hotel.reserveSingleRoom(new Date(), "大床房"), true);
		assertEquals(hotel.reserveSingleRoom(new Date(), "大床房"), false);
		assertEquals(hotel.reserveSingleRoom(new Date(), "双床房"), true);
		assertEquals(hotel.reserveSingleRoom(new Date(), "双床房"), false);
	}
	
	@Test
	public void updateDailyInformation() throws Exception {
		hotel.updateDailyInformation(new Date());
		assertEquals(hotel.getHotelInformation().getLowestPrice(), 300, 0.01);
		assertEquals(hotel.getHotelInformation().getRoomTypeList().get(0), RoomType.BigBed);
		assertEquals(hotel.getHotelInformation().getRoomNumberList().size(), hotel.getHotelInformation().getRoomTypeList().size());
		assertEquals((int)hotel.getHotelInformation().getRoomNumberList().get(0), 3);
	}
	
	@Test
	public void deleteHotel() throws Exception {
		assertEquals(hotel.deleteHotel(), true);
		assertEquals(hotel.getHotelInformation(), null);
	}
	
	@Test
	public void updateHotelManagerInformation() throws Exception {
		String name = "name", tel = "tel";
		assertEquals(hotel.updateHotelManagerInformation(name, tel), true);
		assertEquals(hotel.getHotelInformation().getManagerName(), name);
		assertEquals(hotel.getHotelInformation().getManagerTel(), tel);
	}
}