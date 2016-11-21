package ui.controller;

import vo.RoomVO;

/**
 * Created by apple on 2016/11/20.
 */
public interface RoomController {
    public boolean checkIn(RoomVO room);
    public boolean checkOut(RoomVO room);
    public RoomVO getRoom(String RoomNUM);
}
