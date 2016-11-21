package ui.controllerImpl;

import bl.implementation.Room;
import ui.controller.RoomController;
import ui.presentation.HotelUI;
import vo.RoomVO;

/**
 * Created by apple on 2016/11/20.
 */
public class ExecuteRoomController implements RoomController {
    HotelUI window;
    Room roomManager;
    RoomVO room;

    public ExecuteRoomController(HotelUI view){
        window=view;
    }

    @Override
    public boolean checkIn(RoomVO room) {
        return false;
    }

    @Override
    public boolean checkOut(RoomVO room) {
        return false;
    }

    @Override
    public RoomVO getRoom(String RoomNUM) {
        return null;
    }
}
