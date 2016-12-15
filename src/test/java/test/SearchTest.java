package test;

import bl.implementation.Search;
import org.junit.Before;
import org.junit.Test;
import other.RoomType;
import sun.util.calendar.CalendarDate;

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
		
	}
	
	@Test
	public void filterExceptDate() throws Exception {
		
	}
	
	@Test
	public void sortByPriceHighToLow() throws Exception {
		
	}
	
	@Test
	public void sortByPriceLowToHigh() throws Exception {
		
	}
	
	@Test
	public void sortByScoreHighToLow() throws Exception {
		
	}
	
	@Test
	public void sortByScoreLowToHigh() throws Exception {
		
	}
	
	@Test
	public void sortByLevelHighToLow() throws Exception {
		
	}
	
	@Test
	public void sortByLevelLowToHigh() throws Exception {
		
	}
	
	@Test
	public void filterByhotelName() throws Exception {
		
	}
	
	@Test
	public void filterByLevel() throws Exception {
		
	}
	
	@Test
	public void filterByNumberOfRooms() throws Exception {
		
	}
	
	@Test
	public void filterByPrice() throws Exception {
		
	}
	
	@Test
	public void filterByScore() throws Exception {
		
	}
	
	@Test
	public void filterByReservedBefore() throws Exception {
		
	}
	
	@Test
	public void filterByDate() throws Exception {
		
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
	
	@Test
	public void updateHotelInfomationByDate() throws Exception {
		
	}
}