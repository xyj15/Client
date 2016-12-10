package ui.controller;

import bl.service.*;
import bl.stub.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import other.*;
import ui.presentation.*;
import vo.CreditChangeVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 97147 on 2016/11/26.
 */
public class MemberController{

    private Date in;
    private Date out;
    private String[] tem;


    private static Stage primaryStage;
    private static Stage minprimaryStage;
    private static Stage midprimaryStage;
    private static Parent minroot;
    private static Parent midroot;
    private static Parent root;
    private SearchBLService search = new SearchBLStub();
    private MemberBLService member = new MemberBLStub();
    private HotelBLService hotel = new HotelBLStub();
    private ReserveBLService reserve = new ReserveBLStub();
    private OrderBLService order = new OrderBLStub();


    public static void setMidroot(Parent midroot) {
        MemberController.midroot = midroot;
    }

    public static void setMinroot(Parent minroot) {
        MemberController.minroot = minroot;
    }

    public static void setRoot(Parent root) {
        MemberController.root = root;
    }

    public static void setPrimaryStage(Stage in) {
        primaryStage = in;
    }

    public static void setMinprimaryStage(Stage minprimaryStage) {
        MemberController.minprimaryStage = minprimaryStage;
    }

    public static void setMidprimaryStage(Stage midprimaryStage) {
        MemberController.midprimaryStage = midprimaryStage;
    }
//    @FXML
//    private ComboBox<roomTypeChoice> roomTypeInsearch;
    @FXML
    private void onSearch(ActionEvent E)throws Exception {
        new MemberSearchUI().start(primaryStage);
//        ComboBox<roomTypeChoice> roomTypeInsearch =(ComboBox<roomTypeChoice>)root.lookup("roomTypeInsearch");
//        roomTypeInsearch.getItems().clear();
//        roomTypeInsearch.getItems().add(new roomTypeChoice(RoomType.Single.toString()));
        TextField city = (TextField)root.lookup("#city");
        TextField district = (TextField)root.lookup("#district");
        ChoiceBox roomType = (ChoiceBox)root.lookup("#roomType");
        TextField numOfRoom = (TextField)root.lookup("#numOfRoom");
        TextField lowPrice = (TextField)root.lookup("#lowPrice");
        TextField highPrice = (TextField)root.lookup("#highPrice");
        TextField lowScore = (TextField)root.lookup("#lowScore");
        TextField highScore = (TextField)root.lookup("#highScore");
        TextField level = (TextField)root.lookup("#level");
        TextField hotelName = (TextField)root.lookup("#hotelName");
        DatePicker inTime = (DatePicker)root.lookup("#inTime");
        DatePicker outTime = (DatePicker)root.lookup("#outTime");
        city.setText("");
        district.setText("");
        numOfRoom.setText("1");
        lowPrice.setText("");
        highPrice.setText("");
        lowScore.setText("");
        highScore.setText("");
        level.setText("");
        hotelName.setText("");
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

        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        String dateTem;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<CreditChangeVO> list = member.getCreditChangeList();
        for(int i=list.size()-1;i>=0;i--){
            dateTem = sdf.format(list.get(i).getDate());
            dataForMInfor.add(new TableData(list.get(i).getOrderID(),dateTem,
                    list.get(i).getOrderAction().toString(),""+list.get(i).getChange(),""+list.get(i).getResult()));
        }

        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        tableList.get(4).setCellValueFactory(new PropertyValueFactory("fifth"));
        table.setItems(dataForMInfor);

    }
    private void orderManager(ArrayList<OrderVO> list){
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        String dateTem;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<list.size();i++){
            dateTem = sdf.format(list.get(i).getCreateTime());
            dataForMInfor.add(new TableData(list.get(i).getOrderID(),dateTem,
                    list.get(i).getHotelVO().getName(),list.get(i).getHotelVO().getManagerTel()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        table.setItems(dataForMInfor);
    }
    @FXML
    private void onOrderInfor(ActionEvent E)throws Exception {
        new MemberUnprocessedOrderUI().start(primaryStage);
        ArrayList<OrderVO> list = order.getUnexcutedOrders();
        orderManager(list);
    }
    @FXML
 private void onExecuteOrder(ActionEvent E)throws Exception {
     new MemberProcessedOrderUI().start(primaryStage);
        ArrayList<OrderVO> list = order.getExcutedOrders();
        orderManager(list);
 }
 @FXML
 private void onCancelOrder(ActionEvent E)throws Exception {
     new MemberCancelOrder().start(primaryStage);
     ArrayList<OrderVO> list = order.getCanceledOrders();
     orderManager(list);
 }
 @FXML
 private void onAbnormalOrder(ActionEvent E)throws Exception {
     new MemberAbnormalOrder().start(primaryStage);
     ArrayList<OrderVO> list = order.getAbnormalOrders();
     orderManager(list);
 }
 @FXML//实现撤销
 private void onCancel(ActionEvent E)throws Exception {
     TableView table = (TableView) root.lookup("#table");
     ArrayList<OrderVO> list = order.getUnexcutedOrders();
     order.cancelOrder(list.get(table.getSelectionModel().getSelectedIndex()).getOrderID());
     onOrderInfor(E);
 }
 @FXML//实现评价
 private void onComment(ActionEvent E)throws Exception {
        minprimaryStage = new Stage();
        new MemberCommentUI().start(minprimaryStage);
     TextArea textArea = (TextArea)minroot.lookup("#textArea");
     textArea.setWrapText(true);
 }
    @FXML//实现评价
    private void onBuildComment(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        TextArea textArea = (TextArea)minroot.lookup("#textArea");
        TextField score = (TextField)minroot.lookup("#score");
        textArea.setWrapText(true);
        ArrayList<OrderVO> list = order.getExcutedOrders();
        order.evaluateOrder(list.get(table.getSelectionModel().getSelectedIndex()).getOrderID(),
                Double.parseDouble(score.getText().toString()),textArea.getText().toString());
        minprimaryStage.close();
    }
    @FXML
    private void onPastHotel(ActionEvent E)throws Exception {
        new MemberHisitoryHotelUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");

    }
    @FXML
    private void onLogOut(ActionEvent E)throws Exception {
        new LoginUI().start(primaryStage);
    }
    @FXML
    private void onLookingInforInHistory(ActionEvent E)throws Exception {
//        table.getSelectionModel().getFocusedIndex();
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



//        TableView table = (TableView) root.lookup("#table");
//        table.getSelectionModel().getFocusedIndex();
//        ArrayList<RoomVO> list = reserve.getRoomList()
//        ObservableList<TableDataForSearchList> dataForMInfor
//                = FXCollections.observableArrayList();
//        ObservableList<TableColumn> tableList = table.getColumns();
//        for(int i=0;i<list.size();i++){
//            dataForMInfor.add(new TableDataForSearchList(list.get(i).getName(),""+list.get(i).getLevel(),
//                    ""+list.get(i).getLowestPrice(),""+list.get(i).getScore()));
//        }
//        tableList.get(0).setCellValueFactory(new PropertyValueFactory("name"));
//        tableList.get(1).setCellValueFactory(new PropertyValueFactory("level"));
//        tableList.get(2).setCellValueFactory(new PropertyValueFactory("price"));
//        tableList.get(3).setCellValueFactory(new PropertyValueFactory("score"));
//        table.setItems(dataForMInfor);
    }
    @FXML
    private void onReserveRoomInhis(ActionEvent E)throws Exception {
        DatePicker inTime = (DatePicker)midroot.lookup("#inTime");
        DatePicker outTime = (DatePicker)midroot.lookup("#outTime");
        TextField expectNum = (TextField)midroot.lookup("#expectNum");
        RadioButton has = (RadioButton)midroot.lookup("#has");
        RadioButton hasnot = (RadioButton)midroot.lookup("#hasnot");
        Label totalPrice = (Label)midroot.lookup("#totalPrice");
        tem = inTime.getEditor().getText().split("-");
        in = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        tem = outTime.getEditor().getText().split("-");
        out = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        reserve.setCheckinTime(in);
        reserve.setChekckoutTime(out);
        reserve.setClientName(member.getName());
        reserve.setClientTel(member.getTel());
        reserve.setHaveKids(has.selectedProperty().getValue());
        //生成订单
        midprimaryStage.close();
        new MemberHisitoryHotelUI().start(primaryStage);
    }
     @FXML
    private void onReserveRoomInsear(ActionEvent E)throws Exception {
        DatePicker inTime = (DatePicker)midroot.lookup("#inTime");
        DatePicker outTime = (DatePicker)midroot.lookup("#outTime");
        TextField expectNum = (TextField)midroot.lookup("#expectNum");
        RadioButton has = (RadioButton)midroot.lookup("#has");
        RadioButton hasnot = (RadioButton)midroot.lookup("#hasnot");
        Label totalPrice = (Label)midroot.lookup("#totalPrice");
        tem = inTime.getEditor().getText().split("-");
        in = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        tem = outTime.getEditor().getText().split("-");
        out = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        reserve.setCheckinTime(in);
        reserve.setChekckoutTime(out);
        reserve.setClientName(member.getName());
        reserve.setClientTel(member.getTel());
        reserve.setHaveKids(has.selectedProperty().getValue());
        //生成订单

         midprimaryStage.close();
        new MemberSearchListUI().start(primaryStage);
    }
    @FXML
    private void onTotalPrice(ActionEvent E)throws Exception {
            Label totalPrice = (Label)root.lookup("#totalPrice");
            totalPrice.setText(""+reserve.getPrice());
    }
    @FXML
    private void onReserveInHis(ActionEvent E)throws Exception {
        new MemberReserveInHisUI().start(midprimaryStage);
    }
    @FXML
    private void onReserveInSear(ActionEvent E)throws Exception {
        new MemberReserveInSearUI().start(midprimaryStage);
    }
    @FXML
    private void onLookingInforInSearch(ActionEvent E)throws Exception {
        midprimaryStage = new Stage();
        new MemberHotelInformationInSearUI().start(midprimaryStage);
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
    private void onChangeInfor(ActionEvent E)throws Exception {
        minprimaryStage = new Stage();
        new MemberUpdateInformationUI().start(minprimaryStage);
    }
    @FXML
    private void onMakeChange(ActionEvent E)throws Exception {
        TextField name = (TextField)minroot.lookup("#name");
        TextField tel = (TextField)minroot.lookup("#tel");
        member.getMemberInformation().setName(name.getText().toString());
        member.getMemberInformation().setTel(tel.getText().toString());
        member.updateMemberInformation(member.getMemberInformation());
        minprimaryStage.close();
        onMenberInfor(null);
    }
    @FXML
    private void onSearchLimited(ActionEvent E)throws Exception {
        search.setOnlyReservationBefore(true);
        searchSet();
     new MemberSearchListUI().start(primaryStage);
    }
    @FXML
    private void onSearchAll(ActionEvent E)throws Exception {
        search.setOnlyReservationBefore(false);
        searchSet();
     new MemberSearchListUI().start(primaryStage);
    }
    private void searchSet(){
        TextField city = (TextField)root.lookup("#city");
        TextField district = (TextField)root.lookup("#district");
        ComboBox<RoomType> roomTypeInsearch = (ComboBox<RoomType>)root.lookup("#roomTypeInsearch");
        TextField numOfRoom = (TextField)root.lookup("#numOfRoom");
        TextField lowPrice = (TextField)root.lookup("#lowPrice");
        TextField highPrice = (TextField)root.lookup("#highPrice");
        TextField lowScore = (TextField)root.lookup("#lowScore");
        TextField highScore = (TextField)root.lookup("#highScore");
        TextField level = (TextField)root.lookup("#level");
        TextField hotelName = (TextField)root.lookup("#hotelName");
        DatePicker inTime = (DatePicker)root.lookup("#inTime");
        DatePicker outTime = (DatePicker)root.lookup("#outTime");
        search.setCity(city.getText().toString());
        search.setDistrict(district.getText().toString());
        search.setRoomType(roomTypeInsearch.getSelectionModel().getSelectedItem());
        search.setNumberOfRooms(Integer.parseInt(numOfRoom.getText().toString()));
        search.setHotelName(hotelName.getText().toString());

        if(lowPrice.getText().toString().equals("")){
            search.setLowerPrice(-1);
        }else {
            search.setLowerPrice(Double.parseDouble(lowPrice.getText().toString()));
        }
        if(highPrice.getText().toString().equals("")){
            search.setUpperPrice(-1);
        }else{
            search.setUpperPrice(Double.parseDouble(highPrice.getText().toString()));
        }
        if(lowScore.getText().toString().equals("")){
            search.setLowerScore(-1);
        }else {
            search.setLowerScore(Double.parseDouble(lowScore.getText().toString()));
        }
        if(highScore.getText().toString().equals("")){
            search.setUpperScore(-1);
        }else {
            search.setUpperScore(Double.parseDouble(highScore.getText().toString()));
        }
        if(level.getText().toString().equals("")){
            search.setLevel(-1);
        }else {
            search.setLevel(Integer.parseInt(level.getText().toString()));
        }
    }

    //排序
    @FXML
    private void onSortWithLevel(ActionEvent E)throws Exception {
        ArrayList<HotelVO> list = search.sortByLevelHighToLow();
        sort(list);
    }
    @FXML
    private void onSortWithPrice(ActionEvent E)throws Exception {
        ArrayList<HotelVO> list = search.sortByPriceLowToHigh();
        sort(list);
    }
    @FXML
    private void onSortWithComment(ActionEvent E)throws Exception {
        ArrayList<HotelVO> list = search.sortByScoreHighToLow();
        sort(list);
    }
    private void sort(ArrayList<HotelVO> list)throws Exception {
        new MemberSearchListUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableDataForSearchList> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        for(int i=0;i<list.size();i++){
            dataForMInfor.add(new TableDataForSearchList(list.get(i).getName(),""+list.get(i).getLevel(),
                    ""+list.get(i).getLowestPrice(),""+list.get(i).getScore()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("name"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("level"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("price"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("score"));
        table.setItems(dataForMInfor);
    }
}
