package ui.controllerImpl;

import bl.implementation.Room;
import ui.controller.RoomController;
import ui.presentation.HotelUI;
import ui.presentation.RoomUI;
import vo.RoomVO;

/**
 * Created by apple on 2016/11/20.
 * @author 张新悦
 * @version 2016-11-22
 */
public class ExecuteRoomController implements RoomController {
    RoomUI window;
    Room roomManager;

    public ExecuteRoomController(RoomUI view){
        window=view;
    }

    @Override
    public boolean checkIn(RoomVO room) {
        boolean result = room.checkIn();
        if(result)result=updateRoom(room);
        return result;
    }

    @Override
    public boolean checkOut(RoomVO room) {
        boolean result = room.checkOut();
        if(result)result=updateRoom(room);
        return result;
    }

    @Override
    public RoomVO getRoom(String RoomNUM) {
        return roomManager.findRoom(RoomNUM);
    }

    @Override
    public boolean updateRoom(RoomVO room) {
        return roomManager.updateRoom(room);
    }

    @Override
    public boolean addRoom(RoomVO room) {
        return roomManager.addRoom(room);
    }

    @Override
    public boolean deleteRoom(String roomNUM) {
        return roomManager.deleteRoom(roomNUM);
    }

    @Override
    public void updateRoomButtonClicked() {
        window.updateRoomClicked();
    }

    @Override
    public void addRoomButtonClicked() {
        window.addRoomClicked();
    }

    @Override
    public void cancleOperationClicked() {
        window.cancleRoomClicked();
    }

    @Override
    public void getRoomClicked() {
        window.getRoomClicked();
    }
}
