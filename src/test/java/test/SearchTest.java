package test;

import bl.implementation.Search;
import org.junit.Before;
import org.junit.Test;
import other.RoomType;
import sun.util.calendar.CalendarDate;
import vo.HotelVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class SearchTest {
	
	private Search search;
	
	@Before
	public void setUp() throws Exception {
		search = new Search("00000000");
	}
	
	@Test
	public void getCityList() throws Exception {
		ArrayList<String> cityList = search.getCityList();
		assertEquals(cityList.size(), 1);
		assertEquals(cityList.get(0), "南京市");
	}
	
	@Test
	public void getDistrictList() throws Exception {
		ArrayList<String> districtList = search.getDistrictList("南京市");
		assertEquals(districtList.size(), 3);
		assertEquals(districtList.get(0), "南京大学商圈");
		assertEquals(districtList.get(1), "马群商圈");
		assertEquals(districtList.get(2), "新街口商圈");
	}
	
	@Test
	public void setCity() throws Exception {
		assertEquals(search.setCity("city"), true);
	}
	
	@Test
	public void setDistrict() throws Exception {
		assertEquals(search.setDistrict("district"), true);
	}
	
	@Test
	public void setHotelName() throws Exception {
		assertEquals(search.setHotelName("hotel name"), true);
	}
	
	@Test
	public void setLevel() throws Exception {
		assertEquals(search.setLevel(5), true);
	}
	
	@Test
	public void setRoomType() throws Exception {
		assertEquals(search.setRoomType(RoomType.BigBed), true);
	}
	
	@Test
	public void setNumberOfRooms() throws Exception {
		assertEquals(search.setNumberOfRooms(4), true);
	}
	
	@Test
	public void setLowerPrice() throws Exception {
		assertEquals(search.setLowerPrice(500), true);
	}
	
	@Test
	public void setUpperPrice() throws Exception {
		assertEquals(search.setUpperPrice(500), true);
	}
	
	@Test
	public void setLowerScore() throws Exception {
		assertEquals(search.setLowerScore(3), true);
	}
	
	@Test
	public void setUpperScore() throws Exception {
		assertEquals(search.setUpperScore(5), true);
	}
	
	@Test
	public void setCheckinTime() throws Exception {
		assertEquals(search.setCheckinTime(new Date()), true);
	}
	
	@Test
	public void setCheckoutTime() throws Exception {
		assertEquals(search.setCheckoutTime(new Date()), true);
	}
	
	@Test
	public void setOnlyReservationBefore() throws Exception {
		assertEquals(search.setOnlyReservationBefore(true), true);
	}
	
	@Test
	public void search() throws Exception {
		assertEquals(search.search(), null);
		search.setCheckinTime(new Date());
		search.setCheckoutTime(new Date());
		search.setCity("南京市");
		search.setDistrict("南京大学商圈");
		assertEquals(search.search().size(), 2);
	}
	
	@Test
	public void filterExceptDate() throws Exception {
		assertEquals(search.filterExceptDate(new Date()).size(), 0);
		search.setCheckinTime(new Date());
		search.setCheckoutTime(new Date());
		search.setCity("南京市");
		search.setDistrict("南京大学商圈");
		assertEquals(search.filterExceptDate(new Date()).size(), 2);
	}
	
	@Test
	public void filterByhotelName() throws Exception {
		search.setCity("南京市");
		search.setDistrict("南京大学商圈");
		ArrayList<HotelVO> list = search.search();
		assertEquals(list.size(), 2);
		
		search.setHotelName("新悦大酒店");
		list = search.filterByhotelName(list);
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void filterByLevel() throws Exception {
		search.setCity("南京市");
		search.setDistrict("南京大学商圈");
		ArrayList<HotelVO> list = search.search();
		assertEquals(list.size(), 2);
		
		search.setLevel(5);
		list = search.filterByLevel(list);
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void filterByNumberOfRooms() throws Exception {
		search.setCity("南京市");
		search.setDistrict("南京大学商圈");
		ArrayList<HotelVO> list = search.search();
		assertEquals(list.size(), 2);
		
		search.setNumberOfRooms(5);
		ArrayList<HotelVO> list1 = search.filterByNumberOfRooms(list);
		assertEquals(list1.size(), 2);
		
		search.setNumberOfRooms(8);
		ArrayList<HotelVO> list2 = search.filterByNumberOfRooms(list);
		assertEquals(list2.size(), 2);
		
//		search.setNumberOfRooms(10);
//		ArrayList<HotelVO> list3 = search.filterByNumberOfRooms(list);
//		assertEquals(list3.size(), 0);
		
		search.setNumberOfRooms(14);
		ArrayList<HotelVO> list4 = search.filterByNumberOfRooms(list);
		assertEquals(list4.size(), 0);
		
		search.setNumberOfRooms(2);
		search.setRoomType(RoomType.BigBed);
		ArrayList<HotelVO> list5 = search.filterByNumberOfRooms(list);
		assertEquals(list5.size(), 2);
		
		search.setNumberOfRooms(5);
		ArrayList<HotelVO> list6 = search.filterByNumberOfRooms(list);
		assertEquals(list6.size(), 0);
	}
	
	@Test
	public void filterByPrice() throws Exception {
		search.setCity("南京市");
		search.setDistrict("南京大学商圈");
		ArrayList<HotelVO> list = search.search();
		assertEquals(list.size(), 2);
		
		search.setLowerPrice(1000);
		list = search.filterByPrice(list);
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void filterByScore() throws Exception {
		search.setCity("南京市");
		search.setDistrict("南京大学商圈");
		ArrayList<HotelVO> list = search.search();
		assertEquals(list.size(), 2);
		
		search.setLowerScore(4);
		list = search.filterByScore(list);
		assertEquals(list.size(), 1);
		
		search.setUpperScore(4);
		list = search.filterByScore(list);
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void filterByReservedBefore() throws Exception {
		search.setCity("南京市");
		search.setDistrict("南京大学商圈");
		ArrayList<HotelVO> list = search.search();
		assertEquals(list.size(), 2);
		
		search.setOnlyReservationBefore(true);
		ArrayList<HotelVO> hotelList = search.filterByReservedBefore(list);
		assertEquals(hotelList.size(), 1);
	}
	
	@Test
	public void filterByDate() throws Exception {
		search.setCheckinTime(new Date());
		search.setCheckoutTime(new Date());
		search.setCity("南京市");
		search.setDistrict("马群商圈");
		ArrayList<HotelVO> list = search.filterByDate();
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void nextDay() throws Exception {
		Date d1 = new Date();
		Date d2 = Search.nextDay(d1);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d1);
		int day = calendar.get(Calendar.DATE);
		calendar.setTime(d2);
		assertEquals(day+1, calendar.get(Calendar.DATE));
	}
}