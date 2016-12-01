package ui.controller;

import bl.implementation.Member;
import bl.service.MemberBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import ui.controllerservice.MemberControllerService;
import ui.presentation.LoginUI;
import ui.presentation.MemberHisitoryHotelUI;
import ui.presentation.MemberInformationUI;
import ui.presentation.MemberSearchUI;
import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 97147 on 2016/11/26.
 */
public class MemberController{

   // private MemberBLService memberBL = new Member();
    private static Stage primaryStage;


    public static void setPrimaryStage(Stage in) {
        primaryStage = in;
    }


    @FXML
    private void onSearch(ActionEvent E)throws Exception {
        new MemberSearchUI().start(primaryStage);
    }
    @FXML
    private void onMenberInfor(ActionEvent E)throws Exception {
        new MemberInformationUI().start(primaryStage);
    }
    @FXML
    private void onOrderInfor(ActionEvent E)throws Exception {

    }
    @FXML
    private void onPastHotel(ActionEvent E)throws Exception {
        new MemberHisitoryHotelUI().start(primaryStage);
    }
    @FXML
    private void onLogOut(ActionEvent E)throws Exception {
        new LoginUI().start(primaryStage);
    }
    @FXML
    private void onLookingInfor(ActionEvent E)throws Exception {

    }
    @FXML
    private void onChangeInfor(ActionEvent E)throws Exception {

    }
    @FXML
    private void onSearchLimited(ActionEvent E)throws Exception {

    }
    @FXML
    private void onSearchAll(ActionEvent E)throws Exception {

    }
}
