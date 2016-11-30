package ui.controller;

import bl.implementation.Search;
import bl.service.SearchBLService;
import javafx.stage.Stage;
import other.Date;
import other.RoomType;
import ui.controllerservice.SearchControllerService;
import vo.HotelVO;
import vo.RoomVO;

import java.util.ArrayList;

/**
 * Search的controller类
 * Created by CROFF on 2016/11/26.
 * @author CROFF
 * @version 2016-11-27
 */
public class SearchController{

    private SearchBLService searchBL;
    private Stage primaryStage;
    public void setPrimaryStage(Stage in){
        primaryStage=in;
    }
}
