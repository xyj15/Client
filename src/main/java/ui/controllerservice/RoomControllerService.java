package ui.controllerservice;

import vo.RoomVO;

/**
 * Created by apple on 2016/11/20.
 */
public interface RoomControllerService {
    public boolean checkIn(RoomVO room);
    public boolean checkOut(RoomVO room);
    public RoomVO getRoom(String RoomNUM);
    public boolean updateRoom(RoomVO room);
    public boolean addRoom(RoomVO room);
    public boolean deleteRoom(String roomNUM);
    public void updateRoomButtonClicked();
    public void addRoomButtonClicked();
    public void cancleOperationClicked();
    public void getRoomClicked();
}
