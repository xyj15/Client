package bl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.*;

import bl.implementation.Search;
import bl.mock.MockHotel;
import vo.HotelVO;

/**
 * Search的测试类
 * @author CROFF
 * @version 2016-11-09
 */
public class SearchTest {

	private Search s;
	
	MockHotel h1 = new MockHotel("001", "新悦大酒店",
			"南京市仙林大道163号", "五星级", "南京大学商圈", null);
	MockHotel h2 = new MockHotel("002", "一家黑店",
			"南京市仙林大道162号", "二星级", "南京大学商圈", null);
	MockHotel h3 = new MockHotel("003", "南大宿舍",
			"南京市汉口路22号", "一星级", "南京大学商圈", null);
	
	String address1 = "南京市仙林大道163号";
	String address2 = "南京市仙林大道162号";
	String address3 = "南京市汉口路22号";
	
	String district = "南京大学商圈";
	
	@Before
	public void setUp() {
		s = new Search();
		ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
		hotelList.add(h1);
		hotelList.add(h2);
		hotelList.add(h3);
		s.setHotelList(hotelList);
	}
	
	@Test
	public void testSetAddress() {
		s.setAddress(address1);
		assertEquals(s.getAddress(), address1);
		s.setAddress(address2);
		assertEquals(s.getAddress(), address2);
		s.setAddress(address3);
		assertEquals(s.getAddress(), address3);
	}
	
	@Test
	public void testSetDistrict() {
		s.setDistrict(district);
		assertEquals(s.getDistrict(), district);
	}
	
	@Test
	public void testGetHotelList() {
		ArrayList<HotelVO> list;
		
		s.setDistrict(district);
		s.setAddress(null);
		list = s.getHotelList();
		assertEquals(list.get(0), h1);
		assertEquals(list.get(1), h2);
		assertEquals(list.get(2), h3);
		
		s.setDistrict(null);
		s.setAddress(address1);
		list = s.getHotelList();
		assertEquals(list.get(0), h1);
		
		s.setDistrict(null);
		s.setAddress(address2);
		list = s.getHotelList();
		assertEquals(list.get(0), h2);
		
		s.setDistrict(null);
		s.setAddress(address3);
		list = s.getHotelList();
		assertEquals(list.get(0), h3);
	}

}
