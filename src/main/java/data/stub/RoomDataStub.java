package data.stub;

import data.service.RoomDataService;
import other.RoomType;
import po.RoomPO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CROFF on 2016/12/2.
 */
public class RoomDataStub implements RoomDataService {
	
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
