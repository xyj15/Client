package data.stub;

import bl.implementation.Rank;
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
		System.out.println("获取客房信息成功");
		for(int i=0; i<roomList.size(); i++) {
			RoomPO roomPO = roomList.get(i);
			if(roomPO.getRoomNumber().equals(roomNum)) {
				return roomPO;
			}
		}
		return null;
	}
	
	@Override
	public boolean addSingleRoom(RoomPO room, String hotelID) {
		System.out.println("添加客房成功");
		for(int i=0; i<roomList.size(); i++) {
			String roomNumber = roomList.get(i).getRoomNumber();
			if(roomNumber.equals(room.getRoomNumber())) {
				return false;
			}
		}
		roomList.add(room);
		return true;
	}
	
	@Override
	public boolean updateSingleRoom(Date date, RoomPO room, String hotelID) {
		System.out.println("更新客房信息成功");
		String roomNumber = room.getRoomNumber();
		for(int i=0; i<roomList.size(); i++) {
			RoomPO roomPO = roomList.get(i);
			if(roomPO.getRoomNumber().equals(roomNumber)) {
				roomList.set(i, room);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean deleteSingleRoom(String roomNum, String hotelID) {
		System.out.println("删除客房成功");
		for(int i=0; i<roomList.size(); i++) {
			RoomPO roomPO = roomList.get(i);
			if(roomPO.getRoomNumber().equals(roomNum)) {
				roomList.remove(i);
				return true;
			}
		}
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
		System.out.println("获取客房列表成功");
		return roomList;
	}
	
	@Override
	public boolean reserveSingleRoom(Date day, String roomNUM, String hotelID) {
		System.out.println("预定客房成功");
		for(int i=0; i<roomList.size(); i++) {
			RoomPO roomPO = roomList.get(i);
			if(roomPO.getRoomNumber().equals(roomNUM) && roomPO.isReserved()==false) {
				roomPO.setReserved(true);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean checkIn(Date day, String roomNUM, String hotelID) {
		System.out.println("入住成功");
		for(int i=0; i<roomList.size(); i++) {
			RoomPO roomPO = roomList.get(i);
			if(roomPO.getRoomNumber().equals(roomNUM) && roomPO.isAvailable()) {
				roomPO.setAvailable(false);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean checkOut(Date day, String roomNUM, String hotelID) {
		System.out.println("离店成功");
		for(int i=0; i<roomList.size(); i++) {
			RoomPO roomPO = roomList.get(i);
			if(!roomPO.isAvailable() && roomPO.getRoomNumber().equals(roomNUM)) {
				roomPO.setAvailable(true);
				return true;
			}
		}
		return false;
	}
}
