package data.stub;

import bl.implementation.Room;
import data.service.RoomDataService;
import other.RoomType;
import po.RoomPO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CROFF on 2016/12/2.
 */
public class RoomDataStub implements RoomDataService {
	
	private ArrayList<RoomPO> roomList;
	
	public RoomDataStub() {
		String hotelID = "123456";
		String bigbed = "大床房";
		String doublebed = "双床房";
		String single = "单人房";
		roomList = new ArrayList<RoomPO>();
		RoomPO room1 = new RoomPO(true, false, "3001", bigbed, RoomType.BigBed, 500, hotelID);
		roomList.add(room1);
		RoomPO room2 = new RoomPO(false, true, "3002", bigbed, RoomType.BigBed, 500, hotelID);
		roomList.add(room2);
		RoomPO room3 = new RoomPO(false, true, "3003", bigbed, RoomType.BigBed, 500, hotelID);
		roomList.add(room3);
		RoomPO room4 = new RoomPO(false, true, "2001", single, RoomType.Single, 300, hotelID);
		roomList.add(room4);
		RoomPO room5 = new RoomPO(false, true, "2002", single, RoomType.Single, 300, hotelID);
		roomList.add(room5);
		RoomPO room6 = new RoomPO(true, false, "4001", doublebed, RoomType.TwinBed, 600, hotelID);
		roomList.add(room6);
		RoomPO room7 = new RoomPO(false, true, "4002", doublebed, RoomType.TwinBed, 600, hotelID);
		roomList.add(room7);
		RoomPO room8 = new RoomPO(true, true, "5001", "总统套房", RoomType.Suite, 900, hotelID);
		roomList.add(room8);
	}
	
	@Override
	public RoomPO getSingleRoom(Date date, String roomNum, String hotelID) {
		return null;
	}
	
	@Override
	public boolean addSingleRoom(RoomPO room, String hotelID) {
		return false;
	}
	
	@Override
	public boolean updateSingleRoom(Date date, RoomPO room, String hotelID) {
		return false;
	}
	
	@Override
	public boolean deleteSingleRoom(String roomNum, String hotelID) {
		return false;
	}
	
	@Override
	public ArrayList<RoomPO> getRoomsByTypeDate(Date day, RoomType roomType, String hotelID) {
		return null;
	}
	
	@Override
	public ArrayList<RoomPO> getRoomsByNameDate(Date day, String roomName, String hotelID) {
		return null;
	}
	
	@Override
	public ArrayList<RoomPO> getRoomsByDate(Date day, String hotelID) {
		return null;
	}
	
	@Override
	public boolean reserveSingleRoom(Date day, String roomNUM, String hotelID) {
		return false;
	}
	
	@Override
	public boolean checkIn(Date day, String roomNUM, String hotelID) {
		return false;
	}
	
	@Override
	public boolean checkOut(Date day, String roomNUM, String hotelID) {
		return false;
	}
}
