package test;

import bl.implementation.Room;
import org.junit.Before;
import org.junit.Test;
import other.RoomType;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class RoomTest {
	
	private Room room;
	
	@Before
	public void setUp() throws Exception {
		room = new Room("123456");
	}
	
	@Test
	public void getRoomInformation() throws Exception {
		RoomVO room1 = room.getRoomInformation(new Date(), "3001");
		assertEquals(room1.getRoomName(), "大床房");
		assertEquals((int)room1.getPrice(), 500);
		assertEquals(room1.getRoomType(), RoomType.BigBed);
		RoomVO room2 = room.getRoomInformation(new Date(), "2001");
		assertEquals(room2.getRoomName(), "单人房");
		assertEquals((int)room2.getPrice(), 300);
		assertEquals(room2.getRoomType(), RoomType.Single);
		RoomVO room3 = room.getRoomInformation(new Date(), "4001");
		assertEquals(room3.getRoomName(), "双床房");
		assertEquals((int)room3.getPrice(), 600);
		assertEquals(room3.getRoomType(), RoomType.TwinBed);
		RoomVO room4 = room.getRoomInformation(new Date(), "5001");
		assertEquals(room4.getRoomName(), "总统套房");
		assertEquals((int)room4.getPrice(), 900);
		assertEquals(room4.getRoomType(), RoomType.Suite);
	}
	
	@Test
	public void addRoom() throws Exception {
		RoomVO roomVO = new RoomVO(false, false, "6001", "hahahaha", RoomType.Suite, 1000, "123456");
		int size = room.getDailyRoomList(new Date()).size();
		room.addRoom(roomVO);
		ArrayList<RoomVO> newRoomList = room.getDailyRoomList(new Date());
		assertEquals(newRoomList.get(size).getRoomType(), RoomType.Suite);
		assertEquals(newRoomList.get(size).getRoomName(), "hahahaha");
	}
	
	@Test
	public void deleteRoom() throws Exception {
		int size = room.getDailyRoomList(new Date()).size();
		room.deleteRoom("2001");
		assertEquals(room.getDailyRoomList(new Date()).size(), size-1);
	}
	
	@Test
	public void updateRoom() throws Exception {
		RoomVO roomVO = new RoomVO(false, false, "5001", "hahahaha", RoomType.Suite, 1000, "123456");
		room.updateRoom(new Date(), roomVO);
		RoomVO newRoomVOinRoomList = room.getRoomInformation(new Date(), "5001");
		assertEquals(newRoomVOinRoomList.getRoomName(), "hahahaha");
		assertEquals((int)newRoomVOinRoomList.getPrice(), 1000);
	}
	
	@Test
	public void getDailyRoomList() throws Exception {
		ArrayList<RoomVO> roomList = room.getDailyRoomList(new Date());
		for(int i=0; i<roomList.size(); i++) {
			RoomVO roomVO = roomList.get(i);
			if(roomVO.getRoomNumber().equals("2001")) {
				assertEquals(roomVO.getRoomName(), "单人房");
			} else if(roomVO.getRoomNumber().equals("3001")) {
				assertEquals(roomVO.getRoomType(), RoomType.BigBed);
			} else if(roomVO.getRoomNumber().equals("4001")) {
				assertEquals((int)roomVO.getPrice(), 600);
			} else if(roomVO.getRoomNumber().equals("5001")) {
				assertEquals(roomVO.getRoomName(), "总统套房");
			}
		}
	}
	
}