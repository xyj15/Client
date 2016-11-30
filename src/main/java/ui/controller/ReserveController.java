package ui.controller;

import bl.implementation.Reserve;
import bl.service.ReserveBLService;
import javafx.stage.Stage;
import other.Date;
import other.RoomType;
import ui.controllerservice.ReserveControllerService;
import vo.PromotionVO;

/**
 * Created by CROFF on 2016/11/26.
 * @author CROFF
 * @version 2016-11-26
 */
public class ReserveController{

    private ReserveBLService reserveBL;

    private Stage primaryStage;
    public void setPrimaryStage(Stage in){
        primaryStage=in;
    }
    }
