package other;

import vo.HotelVO;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/12/4.
 * 对HotelVO列表实现快速排序算法的类
 * @author CROFF
 * @version 2016-12-4
 */
public class HotelQuickSort {
	
	public static void exchangeElements(ArrayList<HotelVO> hotelList, int index1, int index2) {
		HotelVO hotelVO = hotelList.get(index1);
		hotelList.set(index1, hotelList.get(index2));
		hotelList.set(index2, hotelVO);
	}
	
	public static void quickSort(ArrayList<HotelVO> hotelList, SortValueOrder sortValueOrder) {
		subQuickSort(hotelList, 0, hotelList.size()-1, sortValueOrder);
	}
	
	private static void subQuickSort(ArrayList<HotelVO> hotelList, int start, int end, SortValueOrder sortValueOrder) {
		if(hotelList==null || (end-start+1)<2) {
			return ;
		}
		
		int part = partition(hotelList, start, end, sortValueOrder);
		
		if(part==start) {
			subQuickSort(hotelList, part+1, end, sortValueOrder);
		} else if(part==end) {
			subQuickSort(hotelList, start, part-1, sortValueOrder);
		} else {
			subQuickSort(hotelList, start, part-1, sortValueOrder);
			subQuickSort(hotelList, part+1, end, sortValueOrder);
		}
	}
	
	private static int partition(ArrayList<HotelVO> hotelList, int start, int end, SortValueOrder sortValueOrder) {
		HotelVO hotelVO = hotelList.get(end);
		int index = start - 1;
		
		for(int i=start; i<end; i++) {
			if(compare(hotelList.get(i), hotelVO, sortValueOrder)) {
				index++;
				if(index!=i) {
					exchangeElements(hotelList, index, i);
				}
			}
		}
		
		if((index+1) != end) {
			exchangeElements(hotelList, index+1, end);
		}
		
		return index+1;
	}
	
	private static boolean compare(HotelVO hotelVO1, HotelVO hotelVO2, SortValueOrder sortValueOrder) {
		if(sortValueOrder==SortValueOrder.levelHtoL) {
			if(hotelVO1.getLevel()>=hotelVO2.getLevel()) {
				return true;
			} else {
				return false;
			}
		} else if(sortValueOrder==SortValueOrder.levelLtoH) {
			if(hotelVO1.getLevel()>=hotelVO2.getLevel()) {
				return false;
			} else {
				return true;
			}
		} else if(sortValueOrder==SortValueOrder.scoreHtoL) {
			if(hotelVO1.getScore()>=hotelVO2.getScore()) {
				return true;
			} else {
				return false;
			}
		} else if(sortValueOrder==SortValueOrder.scoreLtoH) {
			if(hotelVO1.getScore()>=hotelVO2.getScore()) {
				return false;
			} else {
				return true;
			}
		} else if(sortValueOrder==SortValueOrder.priceHtoL) {
			if(hotelVO1.getLowestPrice()>=hotelVO2.getLowestPrice()) {
				return true;
			} else {
				return false;
			}
		} else if(sortValueOrder==SortValueOrder.priceLtoH) {
			if(hotelVO1.getLowestPrice()>=hotelVO2.getLowestPrice()) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}
}
