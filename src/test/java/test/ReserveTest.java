package test;

import bl.implementation.Reserve;
import org.junit.Before;
import org.junit.Test;
import other.PromotionType;
import other.RoomType;
import vo.PromotionVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class ReserveTest {
	
	private Reserve reserve;
	
	@Before
	public void setUp() throws Exception {
		reserve = new Reserve("00000000", "000000");
	}
	
	@Test
	public void getPromotionList() throws Exception {
		ArrayList<PromotionVO> promotionList = reserve.getPromotionList();
		assertEquals(promotionList.size(), 3);
	}
	
	@Test
	public void getPromotion() throws Exception {
		assertEquals(reserve.getPromotion().getPromotionID(), "00000");
	}
	
	@Test
	public void setPromotion() throws Exception {
		PromotionVO promotionVO = new PromotionVO("", "", PromotionType.Discount);
		reserve.setPromotion(promotionVO);
		assertEquals(reserve.getPromotion(), promotionVO);
	}
	
	@Test
	public void getPrice() throws Exception {
		double price = reserve.getPrice();
		assertEquals(price, 400, 0.001);
	}
	
	@Test
	public void getHotelName() throws Exception {
		String name = reserve.getHotelName();
		assertEquals(name, "新悦大酒店");
	}
	
	@Test
	public void getHotelAddress() throws Exception {
		String address = reserve.getHotelAddress();
		assertEquals(address, "仙林大道163号");
	}
	
	@Test
	public void getHotelLevel() throws Exception {
		int level = reserve.getHotelLevel();
		assertEquals(level, 5);
	}
	
	@Test
	public void getRoomList() throws Exception {
		ArrayList<RoomVO> roomList = reserve.getRoomList(new Date());
		assertEquals(roomList.size(), 8);
		RoomVO roomVO = roomList.get(0);
		assertEquals(roomVO.getPrice(), 500, 0.001);
		assertEquals(roomVO.getRoomType(), RoomType.BigBed);
	}
	
	@Test
	public void getSelectedRoom() throws Exception {
		RoomVO roomVO = reserve.getSelectedRoom();
		assertEquals(roomVO.getRoomType(), RoomType.BigBed);
		assertEquals(roomVO.getRoomName(), "大床房");
	}
	
	@Test
	public void setSelectedRoom() throws Exception {
		RoomVO roomVO = reserve.getSelectedRoom();
		roomVO.setAvailable(false);
		roomVO.setRoomName("name");
		assertEquals(reserve.setSelectedRoom(roomVO), true);
		roomVO = reserve.getSelectedRoom();
		assertEquals(roomVO.getRoomName(), "name");
		assertEquals(roomVO.isAvailable(), false);
	}
	
	@Test
	public void setCheckinTime() throws Exception {
		assertEquals(reserve.setCheckinTime(new Date()), true);
	}
	
	@Test
	public void setChekckoutTime() throws Exception {
		assertEquals(reserve.setCheckinTime(new Date()), true);
	}
	
	@Test
	public void setLatestArriveTime() throws Exception {
		assertEquals(reserve.setLatestArriveTime(new Date()), true);
	}
	
	@Test
	public void setClientName() throws Exception {
		String name = "client name";
		assertEquals(reserve.setClientName(name), true);
	}
	
	@Test
	public void setClientTel() throws Exception {
		String tel = "client tel";
		assertEquals(reserve.setClientTel(tel), true);
	}
	
	@Test
	public void setNumberOfClient() throws Exception {
		int num = 5;
		assertEquals(reserve.setNumberOfClient(num), true);
	}
	
	@Test
	public void setHaveKids() throws Exception {
		assertEquals(reserve.setHaveKids(true), true);
	}
	
	@Test
	public void setNumberOfRoom() throws Exception {
		assertEquals(reserve.setNumberOfRoom(5), true);
	}
	
	@Test
	public void setOtherReq() throws Exception {
		assertEquals(reserve.setOtherReq("req"), true);
	}
	
	@Test
	public void createOrder() throws Exception {
		assertEquals(reserve.createOrder(), true);
	}
}