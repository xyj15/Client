package ui.controller;

import bl.service.HotelBLService;
import bl.service.MemberBLService;
import bl.service.ReserveBLService;
import bl.service.SearchBLService;
import bl.stub.HotelBLStub;
import bl.stub.MemberBLStub;
import bl.stub.ReserveBLStub;
import bl.stub.SearchBLStub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ui.presentation.*;

import java.util.Date;

/**
 * Created by 97147 on 2016/11/26.
 */
public class MemberController{

    private Date in;
    private Date out;
    private String[] tem;


    private static Stage primaryStage;
    private static Stage midprimaryStage;
    private static Parent midroot;
    private static Parent root;
    private SearchBLService search = new SearchBLStub();
    private MemberBLService member = new MemberBLStub();
    private HotelBLService hotel = new HotelBLStub();
    private ReserveBLService reserve = new ReserveBLStub();

    public static void setMidroot(Parent midroot) {
        MemberController.midroot = midroot;
    }

    public static void setRoot(Parent root) {
        MemberController.root = root;
    }

    public static void setPrimaryStage(Stage in) {
        primaryStage = in;
    }

    public static void setMidprimaryStage(Stage midprimaryStage) {
        MemberController.midprimaryStage = midprimaryStage;
    }

    @FXML
    private void onSearch(ActionEvent E)throws Exception {
        new MemberSearchUI().start(primaryStage);
    }
    @FXML
    private void onMenberInfor(ActionEvent E)throws Exception {
        new MemberInformationUI().start(primaryStage);
        Label userName=(Label)root.lookup("#userNameLable");
        Label tel=(Label)root.lookup("#telLable");
        Label credit=(Label)root.lookup("#creditLable");
        userName.setText(member.getName());
        tel.setText(member.getTel());
        credit.setText(""+member.getCredit());
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
    private void onLookingInforInHistory(ActionEvent E)throws Exception {
        midprimaryStage = new Stage();
        new MemberHotelInformationInhisUI().start(midprimaryStage);
        TextField hotelAddress = (TextField)midroot.lookup("#hotelAddress");
        TextArea serviceStub = (TextArea)midroot.lookup("#serviceStub");
        serviceStub.setWrapText(true);
        TextArea introduction = (TextArea)midroot.lookup("#introduct");
        introduction.setWrapText(true);
        TextField hotelName = (TextField)midroot.lookup("#hotelName");
        TextField hotelLevel = (TextField)midroot.lookup("#hotelLevel");
        TextField hotelScore = (TextField)midroot.lookup("#hotelScore");
        hotelName.setText(hotel.getHotelName());
        hotelLevel.setText(""+hotel.getHotelLevel());
        hotelScore.setText(""+hotel.getHotelScore());
        hotelAddress.setText(hotel.getHotelAddress());
        serviceStub.setText(hotel.getHotelService());
        introduction.setText(hotel.getHotelIntroduction());
    }
    @FXML
    private void onReserveInHis(ActionEvent E)throws Exception {
        new MemberReserveInHisUI().start(midprimaryStage);
    }
    @FXML
    private void onReserveRoomInhis(ActionEvent E)throws Exception {
        DatePicker inTime = (DatePicker)midroot.lookup("#inTime");
        DatePicker outTime = (DatePicker)root.lookup("#outTime");
        TextField expectNum = (TextField)root.lookup("#expectNum");
        RadioButton has = (RadioButton)root.lookup("#has");
        RadioButton hasnot = (RadioButton)root.lookup("#hasnot");
        Label totalPrice = (Label)root.lookup("#totalPrice");
        tem = inTime.getEditor().getText().split("-");
        in = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        tem = outTime.getEditor().getText().split("-");
        out = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        reserve.setCheckinTime(in);
        reserve.setChekckoutTime(out);

    }




    @FXML
    private void onReserveRoomInsear(ActionEvent E)throws Exception {
//        DatePicker inTime = (DatePicker)root.lookup("#inTime");
//        System.out.print(inTime.getEditor().getText());
        new MemberReserveInHisUI().start(midprimaryStage);
    }
    @FXML
    private void onTotalPrice(ActionEvent E)throws Exception {
            Label totalPrice = (Label)root.lookup("#totalPrice");
            totalPrice.setText(""+reserve.getPrice());
    }
    @FXML
    private void onReserveInSear(ActionEvent E)throws Exception {
        midprimaryStage.close();
        new MemberHisitoryHotelUI().start(primaryStage);
    }
    @FXML
    private void onLookingInforInSearch(ActionEvent E)throws Exception {
        midprimaryStage.close();
        new MemberHisitoryHotelUI().start(primaryStage);
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
