package test;

import org.junit.Before;
import org.junit.Test;
import other.HotelQuickSort;
import other.SortValueOrder;
import vo.HotelVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by CROFF on 2016/12/4.
 * 酒店快速排序算法的测试类
 * @author CROFF
 * @version 2016-12-4
 */
public class HotelQuickSortTest {
	
	private ArrayList<HotelVO> hotelArrayList;
	int[] level = {2, 3, 1, 5};
	double[] lowsetPrice = {200, 100, 700, 300};
	double[] score = {2, 4, 3, 5};
	
	@Before
	public void setup() {
		hotelArrayList = new ArrayList<HotelVO>();
		for(int i=0; i<4; i++) {
			hotelArrayList.add(new HotelVO());
			hotelArrayList.get(i).setLevel(level[i]);
			hotelArrayList.get(i).setScore(score[i]);
			hotelArrayList.get(i).setLowestPrice(lowsetPrice[i]);
		}
	}
	
	@Test
	public void testHotelQuickSort1() {
		HotelQuickSort.quickSort(hotelArrayList, SortValueOrder.priceHtoL);
		assertEquals(700, (int)hotelArrayList.get(0).getLowestPrice());
		assertEquals(100, (int)hotelArrayList.get(3).getLowestPrice());
	}
	
	@Test
	public void testHotelQuickSort2() {
		HotelQuickSort.quickSort(hotelArrayList, SortValueOrder.priceLtoH);
		assertEquals(100, (int)hotelArrayList.get(0).getLowestPrice());
		assertEquals(700, (int)hotelArrayList.get(3).getLowestPrice());
	}
	
	@Test
	public void testHotelQuickSort3() {
		HotelQuickSort.quickSort(hotelArrayList, SortValueOrder.levelHtoL);
		assertEquals(5, hotelArrayList.get(0).getLevel());
		assertEquals(1, hotelArrayList.get(3).getLevel());
	}
	
	@Test
	public void testHotelQuickSort4() {
		HotelQuickSort.quickSort(hotelArrayList, SortValueOrder.levelLtoH);
		assertEquals(1, hotelArrayList.get(0).getLevel());
		assertEquals(5, hotelArrayList.get(3).getLevel());
	}
	
	@Test
	public void testHotelQuickSort5() {
		HotelQuickSort.quickSort(hotelArrayList, SortValueOrder.scoreHtoL);
		assertEquals(5, (int)hotelArrayList.get(0).getScore());
		assertEquals(2, (int)hotelArrayList.get(3).getScore());
	}
	
	@Test
	public void testHotelQuickSort6() {
		HotelQuickSort.quickSort(hotelArrayList, SortValueOrder.scoreLtoH);
		assertEquals(2, (int)hotelArrayList.get(0).getScore());
		assertEquals(5, (int)hotelArrayList.get(3).getScore());
	}
}
