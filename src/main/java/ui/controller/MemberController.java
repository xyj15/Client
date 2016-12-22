package ui.controller;

import bl.implementation.Hotel;
import bl.implementation.Login;
import bl.implementation.Reserve;
import bl.implementation.Room;
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
import java.time.LocalDate;
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
    private static Stage TprimaryStage;
    private static Stage minprimaryStage;
    private static Stage midprimaryStage;
    private static Parent minroot;
    private static Parent midroot;
    private static Parent root;
    private static Parent Troot;
    private static SearchBLService search ;
    private static MemberBLService member ;
    private static CreditBLService creidt ;
    private static HotelBLService hotel ;
    private static ReserveBLService reserve ;
    private static OrderBLService order;
    private static RoomBLService room ;
    private static  LoginBLService login = new Login();
//    private SearchBLService search = new SearchBLStub();
//    private MemberBLService member = new MemberBLStub();
//    private CreditBLService creidt = new CreditBLStub();
//    private HotelBLService hotel = new HotelBLStub();
//    private ReserveBLService reserve = new ReserveBLStub();
//    private OrderBLService order = new OrderBLStub();
//    private RoomBLService room = new RoomBLStub();

    public static void setSearch(SearchBLService searc) {
        search = searc;
    }

    public static void setMember(MemberBLService membe) {
        member = membe;
    }

    public static void setCreidt(CreditBLService creid) {
        creidt = creid;
    }

    public static void setOrder(OrderBLService orde) {
        order = orde;
    }

    private static ArrayList<OrderVO> list;
    private static ArrayList<HotelVO> HList;
    private static ArrayList<RoomVO> RList;
    private static LocalDate i=LocalDate.now(),o=LocalDate.now().plusDays(1);

    private static OrderVO temOrder;
    private static int count;
    private static RoomVO temR;
    public static void setMidroot(Parent midroot) {
        MemberController.midroot = midroot;
    }

    public static void setMinroot(Parent minroot) {
        MemberController.minroot = minroot;
    }

    public static void setRoot(Parent root) {
        MemberController.root = root;
    }

    public static void setTprimaryStage(Stage tprimaryStage) {
        TprimaryStage = tprimaryStage;
    }

    public static void setTroot(Parent troot) {
        Troot = troot;
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


    @FXML
    private void sure(ActionEvent E)throws Exception {
        TprimaryStage.close();
    }
    @FXML
    private void sureChangeP(ActionEvent E)throws Exception {
        PasswordField oldP = (PasswordField)minroot.lookup("#oldP");
        PasswordField newP = (PasswordField)minroot.lookup("#newP");
        PasswordField sureP = (PasswordField)minroot.lookup("#sureP");
        TprimaryStage = new Stage();
        if(oldP.getText().toString().equals(member.getMemberInformation().getPassword())){
            if(newP.getText().toString().equals(sureP.getText().toString())){
                if(login.validPassword(newP.getText().toString())){
                    member.getMemberInformation().setPassword(newP.getText().toString());
                    minprimaryStage.close();
                    onMenberInfor(E);
                }
                else{
                    new MtUI().start(TprimaryStage);
                    Label messager = (Label)Troot.lookup("#Message");
                    messager.setText("新密码格式不符合要求");
                }
            }else{
                new MtUI().start(TprimaryStage);
                Label messager = (Label)Troot.lookup("#Message");
                messager.setText("请再次确认新密码");
            }
        }
        else{
            new MtUI().start(TprimaryStage);
            Label messager = (Label)Troot.lookup("#Message");
            messager.setText("旧密码输入不正确");
        }
    }
    @FXML
    private void onChangePass(ActionEvent E)throws Exception {
        minprimaryStage = new Stage();
        new changePassUI().start(minprimaryStage);
    }
    @FXML
    private void onD(ActionEvent E)throws Exception {
        ComboBox<roomState> city = (ComboBox<roomState>)root.lookup("#city");
        ComboBox<roomState> district = (ComboBox<roomState>)root.lookup("#district");
        ArrayList<String> d = search.getDistrictList(city.getSelectionModel().getSelectedItem().toString()) ;
        for(int i = 0; i<d.size();i++){
            district.getItems().add(new roomState(d.get(i)));
        }
    }
    @FXML
    private void onSearch(ActionEvent E)throws Exception {
        ArrayList<String> c = search.getCityList() ;

        new MemberSearchUI().start(primaryStage);
        ComboBox<roomTypeChoice> roomTypeInsearch =(ComboBox<roomTypeChoice>)root.lookup("#roomTypeInsearch");
        roomTypeInsearch.getItems().clear();
        roomTypeInsearch.getItems().add(new roomTypeChoice(RoomType.Single.toString()));
        roomTypeInsearch.getItems().add(new roomTypeChoice(RoomType.BigBed.toString()));
        roomTypeInsearch.getItems().add(new roomTypeChoice(RoomType.TwinBed.toString()));
        roomTypeInsearch.getItems().add(new roomTypeChoice(RoomType.Suite.toString()));
        roomTypeInsearch.getSelectionModel().select(0);
        ComboBox<roomState> city = (ComboBox<roomState>)root.lookup("#city");
        for(int i = 0; i<c.size();i++){
            city.getItems().add(new roomState(c.get(i)));
        }

        ComboBox<roomState> numOfRoom = (ComboBox<roomState>)root.lookup("#numOfRoom");
        numOfRoom.getItems().clear();
        numOfRoom.getItems().add(new roomState("1"));
        numOfRoom.getItems().add(new roomState("2"));
        numOfRoom.getItems().add(new roomState("3"));
        numOfRoom.getItems().add(new roomState("4"));
        numOfRoom.getItems().add(new roomState("5"));
        numOfRoom.getItems().add(new roomState("6"));
        numOfRoom.getItems().add(new roomState("7"));
        numOfRoom.getItems().add(new roomState("8"));
        TextField lowPrice = (TextField)root.lookup("#lowPrice");
        TextField highPrice = (TextField)root.lookup("#highPrice");
        TextField lowScore = (TextField)root.lookup("#lowScore");
        TextField highScore = (TextField)root.lookup("#highScore");
        ComboBox<roomState> level = (ComboBox<roomState>)root.lookup("#level");
        level.getItems().add(new roomState("1"));
        level.getItems().add(new roomState("2"));
        level.getItems().add(new roomState("3"));
        level.getItems().add(new roomState("4"));
        level.getItems().add(new roomState("5"));
        TextField hotelName = (TextField)root.lookup("#hotelName");
        DatePicker inTime = (DatePicker)root.lookup("#inTime");
        DatePicker outTime = (DatePicker)root.lookup("#outTime");
        lowPrice.setText("");
        highPrice.setText("");
        lowScore.setText("");
        highScore.setText("");
        hotelName.setText("");
        inTime.setValue(LocalDate.now());
        outTime.setValue(LocalDate.now().plusDays(1));
    }

    @FXML
    private void onMenberInfor(ActionEvent E)throws Exception {
        new MemberInformationUI().start(primaryStage);
        Label userName=(Label)root.lookup("#userNameLable");
        Label tel=(Label)root.lookup("#telLable");
        Label credit=(Label)root.lookup("#creditLable");
        System.out.print(root.toString());
        System.out.print(userName);
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
        this.list = order.getUnexcutedOrders();
        orderManager(list);
    }
    @FXML
 private void onExecuteOrder(ActionEvent E)throws Exception {
     new MemberProcessedOrderUI().start(primaryStage);
        this.list = order.getExcutedOrders();
        orderManager(list);
 }
 @FXML
 private void onCancelOrder(ActionEvent E)throws Exception {
     new MemberCancelOrder().start(primaryStage);
     this.list = order.getCanceledOrders();
     orderManager(list);
 }
 @FXML
 private void onAbnormalOrder(ActionEvent E)throws Exception {
     new MemberAbnormalOrder().start(primaryStage);
     this.list = order.getAbnormalOrders();
     orderManager(list);
 }
 @FXML//实现撤销
 private void onCancel(ActionEvent E)throws Exception {
     TableView table = (TableView) root.lookup("#table");
     order.cancelOrder(list.get(table.getSelectionModel().getSelectedIndex()).getOrderID());
     onOrderInfor(E);
 }
 @FXML//实现评价
 private void onComment(ActionEvent E)throws Exception {
     TableView table = (TableView) root.lookup("#table");
     temOrder = list.get(table.getSelectionModel().getSelectedIndex());
     minprimaryStage = new Stage();
     if(temOrder.getEvaluation()==null){
         new MemberCommentUI().start(minprimaryStage);
         TextArea textArea = (TextArea)minroot.lookup("#textArea");
         textArea.setWrapText(true);
     }else{
         new MemberCommentYUI().start(minprimaryStage);
         TextArea textArea = (TextArea)minroot.lookup("#textArea");
         TextField score = (TextField)minroot.lookup("#score");
         textArea.setWrapText(true);
         textArea.setText(temOrder.getEvaluation());
         score.setText(""+temOrder.getScore());
     }

 }
    @FXML//实现评价
    private void onBuildComment(ActionEvent E)throws Exception {
        TextArea textArea = (TextArea)minroot.lookup("#textArea");
        TextField score = (TextField)minroot.lookup("#score");
        textArea.setWrapText(true);
        order.evaluateOrder(temOrder.getOrderID(),Double.parseDouble(score.getText().toString()),textArea.getText().toString());
        minprimaryStage.close();
    }
    @FXML
    private void onPastHotel(ActionEvent E)throws Exception {
        new MemberHisitoryHotelUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        HList = member.getReservedHotelList();
        for(int i=HList.size()-1;i>=0;i--){
            dataForMInfor.add(new TableData(HList.get(i).getName(),""+HList.get(i).getLevel(),
                    HList.get(i).getAddress(),HList.get(i).getManagerTel()));
        }

        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        table.setItems(dataForMInfor);

    }
    @FXML
    private void onLogOut(ActionEvent E)throws Exception {
        new LoginUI().start(primaryStage);
    }
    @FXML
    private void onOrderInforx(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        OrderVO tem = this.list.get(table.getSelectionModel().getSelectedIndex());

        midprimaryStage = new Stage();
        new MOrderInforUI().start(midprimaryStage);
        TextField name = (TextField)midroot.lookup("#name");
        TextField tel = (TextField)midroot.lookup("#tel");
        TextField hotelname = (TextField)midroot.lookup("#hotelname");
        TextField hotelAddress = (TextField)midroot.lookup("#hotelAddress");
        TextField nameOfRoom = (TextField)midroot.lookup("#nameOfRoom");
        TextField numOfRoom = (TextField)midroot.lookup("#numOfRoom");
        TextField state = (TextField)midroot.lookup("#state");
        TextField price = (TextField)midroot.lookup("#price");
        TextField EinTime = (TextField)midroot.lookup("#EinTime");
        TextField AinTime = (TextField)midroot.lookup("#AinTime");
        TextField EoutTime = (TextField)midroot.lookup("#EoutTime");
        TextField AoutTime = (TextField)midroot.lookup("#AoutTime");
        TextField CreatTime = (TextField)midroot.lookup("#CreatTime");
        TextField CancelTime = (TextField)midroot.lookup("#CancelTime");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        AinTime.setText("尚未入住");
        AoutTime.setText("尚未退房");
        CancelTime.setText("订单没有取消");

        name.setText(tem.getMemberVO().getName());
        tel.setText(tem.getMemberVO().getTel());
        hotelname.setText(tem.getHotelVO().getName());
        hotelAddress.setText(tem.getHotelVO().getAddress());
        nameOfRoom.setText(tem.getRoomName());
        numOfRoom.setText(""+tem.getNumberOfRoom());
        state.setText(tem.getOrderStatus().toString());
        price.setText(""+tem.getPrice());
        if(tem.getCheckinTime()!=null){
            EinTime.setText(sdf.format(tem.getCheckinTime()));
        }
        if(tem.getActualCheckinTime()!=null){
            AinTime.setText(sdf.format(tem.getActualCheckinTime()));
        }
        if(tem.getCheckoutTime()!=null){
            EoutTime.setText(sdf.format(tem.getCheckoutTime()));
        }
        if(tem.getActualCheckoutTime()!=null){
            AoutTime.setText(sdf.format(tem.getActualCheckoutTime()));
        }

        CreatTime.setText(sdf.format(tem.getCreateTime()));

        if(tem.getCancelTime()!=null){
            CancelTime.setText(sdf.format(tem.getCancelTime()));
        }
    }

    @FXML
    private void onLookingInforInHistory(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        hotel = new Hotel(HList.get(table.getSelectionModel().getSelectedIndex()).getUserID());
        room = new Room(hotel.getHotelInformation().getUserID());
        new MemberHotelInformationInhisUI().start(primaryStage);
        Mlo();
        TextField hotelAddress = (TextField)root.lookup("#hotelAddress");
        TextArea serviceStub = (TextArea)root.lookup("#serviceStub");
        serviceStub.setWrapText(true);
        TextArea introduction = (TextArea)root.lookup("#introduct");
        introduction.setWrapText(true);
        TextField hotelName = (TextField)root.lookup("#hotelName");
        TextField hotelLevel = (TextField)root.lookup("#hotelLevel");
        TextField hotelScore = (TextField)root.lookup("#hotelScore");
        TextField city = (TextField)root.lookup("#city");
        TextField district = (TextField)root.lookup("#district");
        city.setText(hotel.getCity());
        district.setText(hotel.getDistrict());
        hotelName.setText(hotel.getHotelName());
        hotelLevel.setText(""+hotel.getHotelLevel());
        hotelScore.setText(""+hotel.getHotelScore());
        hotelAddress.setText(hotel.getHotelAddress());
        serviceStub.setText(hotel.getHotelService());
        introduction.setText(hotel.getHotelIntroduction());
        roomList(E);
     }
    @FXML
    private void onReserveRoomInhis(ActionEvent E)throws Exception {
        Label totalPrice = (Label)midroot.lookup("#totalPrice");
        TprimaryStage = new Stage();
        if(totalPrice.getText().toString().equals("")){
            new MtUI().start(TprimaryStage);
            Label messager = (Label)Troot.lookup("#Message");
            messager.setText("请先结算订单总价");
        }else{
            if(creidt.checkCredit()){
                reserve.createOrder();
                midprimaryStage.close();
                onPastHotel(E);
            }
            else {
                new MtUI().start(TprimaryStage);
                Label messager = (Label)Troot.lookup("#Message");
                messager.setText("您的信用值小于0，无法生成订单");
            }
        }
    }
     @FXML
    private void onReserveRoomInsear(ActionEvent E)throws Exception {
         Label totalPrice = (Label)midroot.lookup("#totalPrice");
         TprimaryStage = new Stage();
         if(totalPrice.getText().toString().equals("")){
             new MtUI().start(TprimaryStage);
             Label messager = (Label)Troot.lookup("#Message");
             messager.setText("");
             messager.setText("请先结算订单总价");
         }else{
             if(creidt.checkCredit()){
                 reserve.createOrder();
                 midprimaryStage.close();
                 onOrderInfor(E);
             }
             else {
                 new MtUI().start(TprimaryStage);
                 Label messager = (Label)Troot.lookup("#Message");
                 messager.setText("您的信用值小于0，无法生成订单");
             }
         }
    }
    @FXML
    private void onTotalPrice(ActionEvent E)throws Exception {
        reserve = new Reserve(member.getMemberInformation().getUserID(),hotel.getHotelInformation().getUserID());
        DatePicker inTime = (DatePicker)midroot.lookup("#inTime");
        DatePicker outTime = (DatePicker)midroot.lookup("#outTime");
        RadioButton has = (RadioButton)midroot.lookup("#has");
        TextField num = (TextField)midroot.lookup("#num");
        TextField numP = (TextField)midroot.lookup("#numP");
        Label totalPrice = (Label)midroot.lookup("#totalPrice");
        tem = inTime.getEditor().getText().split("-");
        in = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        in.setHours(12);
        tem = outTime.getEditor().getText().split("-");
        out = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        reserve.setCheckinTime(in);
        in.setHours(in.getHours()+8);
        reserve.setLatestArriveTime(in);
        reserve.setSelectedRoom(temR);
        reserve.setNumberOfRoom(Integer.parseInt(num.getText().toString()));
        reserve.setNumberOfClient(Integer.parseInt(numP.getText().toString()));
        reserve.setChekckoutTime(out);
        reserve.setClientName(member.getName());
        reserve.setClientTel(member.getTel());
        reserve.setHaveKids(has.selectedProperty().getValue());
        totalPrice.setText(""+reserve.getPrice());
    }
    @FXML
    private void onReserveInHis(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#tablePass");
        temR =RList.get(table.getSelectionModel().getSelectedIndex());
        midprimaryStage = new Stage();
        new MemberReserveInHisUI().start(midprimaryStage);
        TextField name = (TextField)midroot.lookup("#name");
        TextField type = (TextField)midroot.lookup("#type");
        TextField danjia = (TextField)midroot.lookup("#danjia");
        TextField num = (TextField)midroot.lookup("#num");
        DatePicker inTime = (DatePicker)midroot.lookup("#inTime");
        DatePicker outTime = (DatePicker)midroot.lookup("#outTime");
        name.setText(temR.getRoomName());
        type.setText(""+temR.getRoomType());
        inTime.setValue(i);
        outTime.setValue(o);
        danjia.setText(""+temR.getPrice());
        num.setText("1");
    }
    @FXML
    private void onReserveInSear(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#tablePass");
        temR =RList.get(table.getSelectionModel().getSelectedIndex());
        midprimaryStage = new Stage();
        new MemberReserveInSearUI().start(midprimaryStage);
        TextField name = (TextField)midroot.lookup("#name");
        TextField type = (TextField)midroot.lookup("#type");
        TextField danjia = (TextField)midroot.lookup("#danjia");
        TextField num = (TextField)midroot.lookup("#num");
        DatePicker inTime = (DatePicker)midroot.lookup("#inTime");
        DatePicker outTime = (DatePicker)midroot.lookup("#outTime");
        name.setText(temR.getRoomName());
        type.setText(""+temR.getRoomType());
        inTime.setValue(i);
        outTime.setValue(o);
        danjia.setText(""+temR.getPrice());
        num.setText("1");
    }
    private void roomList(ActionEvent E){
        TableView table = (TableView) root.lookup("#tablePass");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        ArrayList<RoomVO> list = room.getDailyRoomList(new Date());
        RoomVO tem;
        RList = new ArrayList<RoomVO>();
        count=0;
        for(int i=0;!list.isEmpty();){
            tem = list.get(i);
            list=jian(list,tem);
            RList.add(tem);
            dataForMInfor.add(new TableData(tem.getRoomName(),""+tem.getRoomType(),""+tem.getPrice(),""+count));
            count=0;
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        table.setItems(dataForMInfor);
    }
    private ArrayList<RoomVO> jian(ArrayList<RoomVO> list, RoomVO room){
        ArrayList<RoomVO> re = new ArrayList<RoomVO>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getRoomName().equals(room.getRoomName())){
                if(!list.get(i).isReserved()){
                    count++;
                }
            }else{
                re.add(list.get(i));
            }
        }
        return re;
    }
    @FXML
    private void onLookingInforInSearch(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        hotel = new Hotel(HList.get(table.getSelectionModel().getSelectedIndex()).getUserID());
        room = new Room(hotel.getHotelInformation().getUserID());
        new MemberHotelInformationInSearUI().start(primaryStage);
        Mlo();
        TextField hotelAddress = (TextField)root.lookup("#hotelAddress");
        TextArea serviceStub = (TextArea)root.lookup("#serviceStub");
        serviceStub.setWrapText(true);
        TextArea introduction = (TextArea)root.lookup("#introduct");
        introduction.setWrapText(true);
        TextField hotelName = (TextField)root.lookup("#hotelName");
        TextField hotelLevel = (TextField)root.lookup("#hotelLevel");
        TextField hotelScore = (TextField)root.lookup("#hotelScore");
        TextField city = (TextField)root.lookup("#city");
        TextField district = (TextField)root.lookup("#district");
        city.setText(hotel.getCity());
        district.setText(hotel.getDistrict());
        hotelName.setText(hotel.getHotelName());
        hotelLevel.setText(""+hotel.getHotelLevel());
        hotelScore.setText(""+hotel.getHotelScore());
        hotelAddress.setText(hotel.getHotelAddress());
        serviceStub.setText(hotel.getHotelService());
        introduction.setText(hotel.getHotelIntroduction());
        roomList(E);
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
        ComboBox<roomState> city = ( ComboBox<roomState>)root.lookup("#city");
        ComboBox<roomState> district= ( ComboBox<roomState>)root.lookup("#district");
        if(city.getSelectionModel().getSelectedItem().toString().equals("")||district.getSelectionModel().getSelectedItem().toString().equals("")){
            TprimaryStage = new Stage();
            new MtUI().start(TprimaryStage);
            Label messager = (Label)Troot.lookup("#Message");
            messager.setText("请先输入商圈和城市信息");
        }else{
            search.setOnlyReservationBefore(true);
            searchSet(E);
        }
    }
    @FXML
    private void onSearchAll(ActionEvent E)throws Exception {
        ComboBox<roomState> city = ( ComboBox<roomState>)root.lookup("#city");
        ComboBox<roomState> district= ( ComboBox<roomState>)root.lookup("#district");
        if(city.getSelectionModel().getSelectedItem().toString().equals("")||district.getSelectionModel().getSelectedItem().toString().equals("")){
            TprimaryStage = new Stage();
            new MtUI().start(TprimaryStage);
            Label messager = (Label)Troot.lookup("#Message");
            messager.setText("请先输入商圈和城市信息");
        }else{
            search.setOnlyReservationBefore(false);
            searchSet(E);
        }
    }
    private void searchSet(ActionEvent E)throws Exception{
        ComboBox<roomState> city = (ComboBox<roomState>)root.lookup("#city");
        ComboBox<roomState> district = (ComboBox<roomState>)root.lookup("#district");
        ComboBox<roomTypeChoice> roomTypeInsearch = (ComboBox<roomTypeChoice>)root.lookup("#roomTypeInsearch");
        ComboBox<roomState> numOfRoom = (ComboBox<roomState>)root.lookup("#numOfRoom");
        TextField lowPrice = (TextField)root.lookup("#lowPrice");
        TextField highPrice = (TextField)root.lookup("#highPrice");
        TextField lowScore = (TextField)root.lookup("#lowScore");
        TextField highScore = (TextField)root.lookup("#highScore");
        ComboBox<roomState> level = (ComboBox<roomState>)root.lookup("#level");
        TextField hotelName = (TextField)root.lookup("#hotelName");
        DatePicker inTime = (DatePicker)root.lookup("#inTime");
        DatePicker outTime = (DatePicker)root.lookup("#outTime");
        search.setCity(city.getSelectionModel().getSelectedItem().toString());
        search.setDistrict(district.getSelectionModel().getSelectedItem().toString());
        search.setRoomType(roomTypeInsearch.getSelectionModel().getSelectedItem().toRoomType());
        search.setNumberOfRooms(Integer.parseInt(numOfRoom.getSelectionModel().getSelectedItem().toString()));
        search.setHotelName(hotelName.getText().toString());
        tem = inTime.getEditor().getText().split("-");
        in = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        tem = outTime.getEditor().getText().split("-");
        out = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        i=inTime.getValue();
        o=outTime.getValue();
        search.setCheckinTime(in);
        search.setCheckoutTime(out);
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
        System.out.print(level.getSelectionModel().getSelectedItem().toString());
        if(level.getSelectionModel().getSelectedItem().toString().equals("")){

            search.setLevel(-1);
        }else {
            search.setLevel(Integer.parseInt(level.getSelectionModel().getSelectedItem().toString()));
        }
        onSortWithLevel(E);
    }

    //排序
    @FXML
    private void onSortWithLevel(ActionEvent E)throws Exception {
        HList= search.sortByLevelHighToLow();
        sort(HList);
    }
    @FXML
    private void onSortWithPrice(ActionEvent E)throws Exception {
        HList = search.sortByPriceLowToHigh();
        sort(HList);
    }
    @FXML
    private void onFHTsear(ActionEvent E)throws Exception {
        onSortWithLevel(E);
    }
    @FXML
    private void onFHThis(ActionEvent E)throws Exception {
        onPastHotel(E);
    }
    @FXML
    private void onSortWithComment(ActionEvent E)throws Exception {
        HList = search.sortByScoreHighToLow();
        sort(HList);
    }
    private void sort(ArrayList<HotelVO> list)throws Exception {
        new MemberSearchListUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        ArrayList<HotelVO> past = member.getReservedHotelList();
        String  tem ;
        for(int i=0;i<list.size();i++){
            if(compare(past,list.get(i))){
                tem="是";
            }else{
                tem="否";
            }
            dataForMInfor.add(new TableData(list.get(i).getName(),""+list.get(i).getLevel(),
                    ""+list.get(i).getLowestPrice(),""+list.get(i).getScore(),
                    tem,list.get(i).getManagerTel()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        tableList.get(4).setCellValueFactory(new PropertyValueFactory("fifth"));
        tableList.get(5).setCellValueFactory(new PropertyValueFactory("sixth"));

        table.setItems(dataForMInfor);
    }
    private boolean compare(ArrayList<HotelVO> past,HotelVO now){
        for(int i=0;i<past.size();i++){
            if(past.get(i).getUserID().equals(now.getUserID())){
                return true;
            }
        }
        return false;
    }
    private void Mlo() throws  Exception{
        list = member.getHotelOrderList(hotel.getHotelInformation().getUserID());
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(int i =0 ;i<list.size();i++){
            dataForMInfor.add(new TableData(list.get(i).getOrderID(),sdf.format(list.get(i).getCreateTime()),""+list.get(i).getOrderStatus(),""+list.get(i).getPrice()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        table.setItems(dataForMInfor);
    }
}
