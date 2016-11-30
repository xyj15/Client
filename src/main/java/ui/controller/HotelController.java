package ui.controller;

import bl.implementation.Hotel;
import bl.service.HotelBLService;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controllerservice.HotelControllerService;
import ui.presentation.CompanyRegisterUI;
import ui.presentation.HotelFirstUI;
import ui.presentation.HotelInformationUI;
import ui.presentation.HotelUpdateInformationUI;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**     帮助Hotel模块完成界面转跳以及连接UI层与BL层
 *
 * Created by 庄刚轻 on 2016/11/26.
 */
public class HotelController{


    private HotelBLService hotelBL = new Hotel();

    private static Stage primaryStage;
    private Stage updateStage;
    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }

    @FXML
    private void onInfor(ActionEvent E) throws Exception{
//        try{
            new CompanyRegisterUI().start(primaryStage);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        new HotelInformationUI().start(primaryStage);
    }
    @FXML
    private void onInforChange(ActionEvent E)throws Exception {
        new HotelUpdateInformationUI().start(updateStage);                 //酒店基本信息改变
    }




    @FXML
    private void onOrderManager(ActionEvent E)throws Exception {
        new HotelFirstUI().start(primaryStage);
    }
    @FXML
    private void onUnExecuteOrder(ActionEvent E)throws Exception {
        new HotelFirstUI().start(primaryStage);
    }
    @FXML
    private void onExecuteOrder(ActionEvent E)throws Exception {
        new HotelFirstUI().start(primaryStage);
    }
    @FXML
    private void onCancelOrder(ActionEvent E)throws Exception {
        new HotelFirstUI().start(primaryStage);
    }
    @FXML
    private void onAbnormalOrder(ActionEvent E)throws Exception {
        new HotelFirstUI().start(primaryStage);
    }


    @FXML
    private void onPromotionManager(ActionEvent E)throws Exception {
        new HotelFirstUI().start(primaryStage);
    }
    @FXML
    private void onRoomManager(ActionEvent E)throws Exception {
        new HotelFirstUI().start(primaryStage);
    }
    @FXML
    private void onLogOut(ActionEvent E)throws Exception {
        new HotelFirstUI().start(primaryStage);
    }

}
