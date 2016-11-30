package ui.controller;

import bl.implementation.Member;
import bl.service.MemberBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import ui.controllerservice.MemberControllerService;
import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 97147 on 2016/11/26.
 */
public class MemberController{

    private MemberBLService memberBL = new Member();
    private Stage primaryStage;

    @FXML
    private void onReserve(ActionEvent E)throws Exception {

    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
