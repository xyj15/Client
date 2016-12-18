package data.driver;

import data.service.RoomDataService;
import data.stub.RoomDataStub;
import other.RoomType;
import po.RoomPO;

import java.rmi.RemoteException;

/**
 * Created by CROFF on 2016/12/9.
 */
public class RoomDataDriver {
	
	private RoomDataService roomDataService = new RoomDataStub();
	
	public void drive() throws RemoteException {
		System.out.println(roomDataService.checkIn(null, "3001", null));
		System.out.println(roomDataService.checkOut(null, "3001", null));
		System.out.println(roomDataService.getRoomsByDate(null, null));
		System.out.println(roomDataService.getSingleRoom(null, null, null));
		System.out.println(roomDataService.reserveSingleRoom(null, null, null));
		System.out.println(roomDataService.updateSingleRoom(null, new RoomPO(false, false, "", "", RoomType.BigBed, 0, ""), null));
		System.out.println(roomDataService.deleteSingleRoom(null, null));
		System.out.println(roomDataService.addSingleRoom(new RoomPO(false, false, "", "", RoomType.BigBed, 0, ""), ""));
	}
	
	public static void main(String[] args) throws RemoteException {
		RoomDataDriver roomDataDriver = new RoomDataDriver();
		roomDataDriver.drive();
	}
}
