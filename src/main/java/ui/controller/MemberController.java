package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import ui.presentation.*;

/**
 * Created by 97147 on 2016/11/26.
 */
public class MemberController{

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
        new MemberUnprocessedOrderUI().start(primaryStage);
    }
    @FXML
 private void onExecuteOrder(ActionEvent E)throws Exception {
     new MemberProcessedOrderUI().start(primaryStage);
 }
 @FXML
 private void onCancelOrder(ActionEvent E)throws Exception {
     new MemberCancelOrder().start(primaryStage);
 }
 @FXML
 private void onAbnormalOrder(ActionEvent E)throws Exception {
     new MemberAbnormalOrder().start(primaryStage);
 }
 @FXML//实现撤销
 private void onCancel(ActionEvent E)throws Exception {
 }
 @FXML//实现评价
 private void onComment(ActionEvent E)throws Exception {
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
      new MemberHotelInformationUI().start(primaryStage);
    }
    @FXML
    private void onChangeInfor(ActionEvent E)throws Exception {

    }
    @FXML
    private void onSearchLimited(ActionEvent E)throws Exception {
     new MemberSearchListUI().start(primaryStage);
    }
    @FXML
    private void onSearchAll(ActionEvent E)throws Exception {
     new MemberSearchListUI().start(primaryStage);
    }

    //排序，暂时为空
    @FXML
    private void onSortWithLevel(ActionEvent E)throws Exception {

    }
    @FXML
    private void onSortWithPrice(ActionEvent E)throws Exception {

    }
    @FXML
    private void onSortWithComment(ActionEvent E)throws Exception {

    }
}
