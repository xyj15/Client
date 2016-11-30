package ui.controller;

import bl.implementation.Room;
import javafx.stage.Stage;
import ui.controllerservice.RoomControllerService;
import vo.RoomVO;

/**
 * Created by apple on 2016/11/20.
 * @author 张新悦
 * @version 2016-11-22
 */
public class RoomController {
    Room roomManager;

    private Stage primaryStage;

    public void setPrimaryStage(Stage in) {
        primaryStage = in;
    }

}