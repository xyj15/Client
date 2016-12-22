package ui.controller;

import bl.implementation.Hotel;
import bl.implementation.Login;
import bl.implementation.Reserve;
import bl.implementation.Room;
import bl.service.*;
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

    private Date DateInTime;
    private Date DateOutTime;
    private String[] tem;


    private static Stage primaryStage;
    private static Stage promptPrimaryStage;
    private static Stage minPrimaryStage;
    private static Stage midPrimaryStage;
    private static Parent minRoot;
    private static Parent midRoot;
    private static Parent root;
    private static Parent promptRoot;
    private static SearchBLService search ;
    private static MemberBLService member ;
    private static CreditBLService credit ;
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

    public static void setSearch(SearchBLService in) {
        search = in;
    }

    public static void setMember(MemberBLService in) {
        member = in;
    }

    public static void setCredit(CreditBLService in) {
        credit = in;
    }

    public static void setOrder(OrderBLService in) {
        order = in;
    }

    private static ArrayList<OrderVO> OrderList;
    private static ArrayList<HotelVO> HotelList;
    private static ArrayList<RoomVO> RoomList;
    private static LocalDate LocalDateInTime =LocalDate.now(), LocalDateOutTime =LocalDate.now().plusDays(1);

    private static OrderVO temOrder;
    private static int count;
    private static RoomVO temRoom;
    public static void setMidRoot(Parent midRoot) {
        MemberController.midRoot = midRoot;
    }

    public static void setMinRoot(Parent minRoot) {
        MemberController.minRoot = minRoot;
    }

    public static void setRoot(Parent root) {
        MemberController.root = root;
    }

    public static void setPromptPrimaryStage(Stage PromptPrimaryStage) {
        promptPrimaryStage = PromptPrimaryStage;
    }

    public static void setPromptRoot(Parent promptRoot) {
        MemberController.promptRoot = promptRoot;
    }

    public static void setPrimaryStage(Stage in) {
        primaryStage = in;
    }

    public static void setMinPrimaryStage(Stage MinPrimaryStage) {
        MemberController.minPrimaryStage = MinPrimaryStage;
    }

    public static void setMidPrimaryStage(Stage MidPrimaryStage) {
        MemberController.midPrimaryStage = MidPrimaryStage;
    }

    /**
     * 关闭提示框的响应
     * */
    @FXML
    private void sure(ActionEvent E)throws Exception {
        promptPrimaryStage.close();
    }
    /**
     * 响应确认更改密码
     * */
    @FXML
    private void onSureChangePassword(ActionEvent E)throws Exception {
        PasswordField oldPassword = (PasswordField)minRoot.lookup("#oldP");
        PasswordField newPassword = (PasswordField)minRoot.lookup("#newP");
        PasswordField surePassword = (PasswordField)minRoot.lookup("#sureP");
        if(oldPassword.getText().toString().equals(member.getMemberInformation().getPassword())){
            if(newPassword.getText().toString().equals(surePassword.getText().toString())){
                if(login.validPassword(newPassword.getText().toString())){
                    member.getMemberInformation().setPassword(newPassword.getText().toString());
                    minPrimaryStage.close();
                    onMenberInfor(E);
                }
                else{
                    promptPrimaryStage = new Stage();
                    new MemberPromptUI().start(promptPrimaryStage);
                    Label message = (Label) promptRoot.lookup("#Message");
                    message.setText("新密码格式不符合要求");
                }
            }else{
                promptPrimaryStage = new Stage();
                new MemberPromptUI().start(promptPrimaryStage);
                Label message = (Label) promptRoot.lookup("#Message");
                message.setText("请再次确认新密码");
            }
        }
        else{
            promptPrimaryStage = new Stage();
            new MemberPromptUI().start(promptPrimaryStage);
            Label message = (Label) promptRoot.lookup("#Message");
            message.setText("旧密码输入不正确");
        }
    }
    /**
     * 创建更改密码界面
     * */
    @FXML
    private void onChangePass(ActionEvent E)throws Exception {
        minPrimaryStage = new Stage();
        new ChangePasswordUI().start(minPrimaryStage);
    }

    /**
     * 在选择城市后为商圈选择栏增添内容
     * @param E
     * @throws Exception
     */
    @FXML
    private void onDistrict(ActionEvent E)throws Exception {
        ComboBox<roomState> city = (ComboBox<roomState>)root.lookup("#city");
        ComboBox<roomState> district = (ComboBox<roomState>)root.lookup("#district");
        district.getItems().clear();
        ArrayList<String> d = search.getDistrictList(city.getSelectionModel().getSelectedItem().toString()) ;
        for(int i = 0; i<d.size();i++){
            district.getItems().add(new roomState(d.get(i)));
        }
    }

    /**
     * 进入搜索界面
     * @param E
     * @throws Exception
     */
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
        numOfRoom.getSelectionModel().select(0);
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

    /**
     * 响应查看用户信息
     * @param E
     * @throws Exception
     */
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

    /**
     * 完成客户订单管理界面的表格绘制
     * @param list
     */
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

    /**
     * 响应（查看）订单信息界面
     * 响应（查看）未执行订单界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onOrderInfor(ActionEvent E)throws Exception {
        new MemberUnprocessedOrderUI().start(primaryStage);
        this.OrderList = order.getUnexcutedOrders();
        orderManager(OrderList);
    }

    /**
     * 响应（查看）已执行订单界面
     * @param E
     * @throws Exception
     */
    @FXML
 private void onExecuteOrder(ActionEvent E)throws Exception {
     new MemberProcessedOrderUI().start(primaryStage);
        this.OrderList = order.getExcutedOrders();
        orderManager(OrderList);
 }

    /**
     * 响应（查看）撤销订单界面
     * @param E
     * @throws Exception
     */
    @FXML
 private void onCancelOrder(ActionEvent E)throws Exception {
     new MemberCancelOrder().start(primaryStage);
     this.OrderList = order.getCanceledOrders();
     orderManager(OrderList);
 }

    /**
     * 响应（查看）异常订单界面
     * @param E
     * @throws Exception
     */
     @FXML
 private void onAbnormalOrder(ActionEvent E)throws Exception {
     new MemberAbnormalOrder().start(primaryStage);
     this.OrderList = order.getAbnormalOrders();
     orderManager(OrderList);
 }

    /**
     * 响应撤销订单动作
     * 实现订单撤销
     * @param E
     * @throws Exception
     */
    @FXML
 private void onCancel(ActionEvent E)throws Exception {
     TableView table = (TableView) root.lookup("#table");
     order.cancelOrder(OrderList.get(table.getSelectionModel().getSelectedIndex()).getOrderID());
     onOrderInfor(E);
 }

    /**
     * 响应评价，判断订单是否已经被评价过，调用不同的评价界面
     * @param E
     * @throws Exception
     */
    @FXML//实现评价
 private void onComment(ActionEvent E)throws Exception {
     TableView table = (TableView) root.lookup("#table");
     temOrder = OrderList.get(table.getSelectionModel().getSelectedIndex());
     minPrimaryStage = new Stage();
     if(temOrder.getEvaluation()==null){
         new MemberCommentUI().start(minPrimaryStage);
         TextArea textArea = (TextArea)minRoot.lookup("#textArea");
         textArea.setWrapText(true);
     }else{
         new MemberCommentYUI().start(minPrimaryStage);
         TextArea textArea = (TextArea)minRoot.lookup("#textArea");
         TextField score = (TextField)minRoot.lookup("#score");
         textArea.setWrapText(true);
         textArea.setText(temOrder.getEvaluation());
         score.setText(""+temOrder.getScore());
     }
 }

    /**
     * 响应确认订单评价
     * 生成订单评价
     * @param E
     * @throws Exception
     */
    @FXML
    private void onBuildComment(ActionEvent E)throws Exception {
        TextArea textArea = (TextArea)minRoot.lookup("#textArea");
        TextField score = (TextField)minRoot.lookup("#score");
        if(textArea.getText().equals("")||score.getText().equals("")){
            promptPrimaryStage = new Stage();
            new MemberPromptUI().start(promptPrimaryStage);
            Label message = (Label) promptRoot.lookup("#Message");
            message.setText("请输入完整的评价信息后再确认");
        }
        else{
            order.evaluateOrder(temOrder.getOrderID(),Double.parseDouble(score.getText().toString()),textArea.getText().toString());
            minPrimaryStage.close();
        }
    }

    /**
     * 响应（查看）过去的预定的酒店界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onPastHotel(ActionEvent E)throws Exception {
        new MemberHisitoryHotelUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        HotelList = member.getReservedHotelList();
        for(int i = HotelList.size()-1; i>=0; i--){
            dataForMInfor.add(new TableData(HotelList.get(i).getName(),""+ HotelList.get(i).getLevel(),
                    HotelList.get(i).getAddress(), HotelList.get(i).getManagerTel()));
        }

        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        table.setItems(dataForMInfor);

    }

    /**
     * 响应注销按钮
     * @param E
     * @throws Exception
     */
    @FXML
    private void onLogOut(ActionEvent E)throws Exception {
        new LoginUI().start(primaryStage);
    }

    /**
     * 响应（查看）订单详情
     * @param E
     * @throws Exception
     */
    @FXML
    private void onOrderInformation(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        OrderVO tem = this.OrderList.get(table.getSelectionModel().getSelectedIndex());
        midPrimaryStage = new Stage();
        new MemberOrderInformationUI().start(midPrimaryStage);
        TextField name = (TextField)midRoot.lookup("#name");
        TextField tel = (TextField)midRoot.lookup("#tel");
        TextField hotelName = (TextField)midRoot.lookup("#hotelname");
        TextField hotelAddress = (TextField)midRoot.lookup("#hotelAddress");
        TextField nameOfRoom = (TextField)midRoot.lookup("#nameOfRoom");
        TextField numOfRoom = (TextField)midRoot.lookup("#numOfRoom");
        TextField state = (TextField)midRoot.lookup("#state");
        TextField price = (TextField)midRoot.lookup("#price");
        TextField expectInTime = (TextField)midRoot.lookup("#EinTime");
        TextField actualInTime = (TextField)midRoot.lookup("#AinTime");
        TextField expectOutTime = (TextField)midRoot.lookup("#EoutTime");
        TextField actualOutTime = (TextField)midRoot.lookup("#AoutTime");
        TextField createdTime = (TextField)midRoot.lookup("#CreatTime");
        TextField CancelTime = (TextField)midRoot.lookup("#CancelTime");
        TextField score = (TextField)midRoot.lookup("#score");
        TextArea area = (TextArea)midRoot.lookup("#area");
        area.setWrapText(true);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        actualInTime.setText("尚未入住");
        actualOutTime.setText("尚未退房");
        CancelTime.setText("订单没有被取消");

        name.setText(tem.getMemberVO().getName());
        tel.setText(tem.getMemberVO().getTel());
        hotelName.setText(tem.getHotelVO().getName());
        hotelAddress.setText(tem.getHotelVO().getAddress());
        nameOfRoom.setText(tem.getRoomName());
        numOfRoom.setText(""+tem.getNumberOfRoom());
        state.setText(tem.getOrderStatus().toString());
        price.setText(""+tem.getPrice());
        if(tem.getCheckinTime()!=null){
            expectInTime.setText(sdf.format(tem.getCheckinTime()));
        }
        if(tem.getActualCheckinTime()!=null){
            actualInTime.setText(sdf.format(tem.getActualCheckinTime()));
        }
        if(tem.getCheckoutTime()!=null){
            expectOutTime.setText(sdf.format(tem.getCheckoutTime()));
        }
        if(tem.getActualCheckoutTime()!=null){
            actualOutTime.setText(sdf.format(tem.getActualCheckoutTime()));
        }
        createdTime.setText(sdf.format(tem.getCreateTime()));
        if(tem.getCancelTime()!=null){
            CancelTime.setText(sdf.format(tem.getCancelTime()));
            actualInTime.setText("订单已经被取消");
            actualOutTime.setText("订单已经被取消");
        }
        if(tem.getOrderStatus()==OrderStatus.Abnormal){
            actualInTime.setText("订单异常");
            actualOutTime.setText("订单异常");
            CancelTime.setText("订单异常");
        }
        if(tem.getEvaluation()==null){
            score.setText("无");
            area.setText("尚未生成评价");
        }else{
            score.setText(""+tem.getScore());
            area.setText(tem.getEvaluation());
        }
    }

    /**
     * 响应在曾经预定过的酒店列表中选择查看酒店详细信息
     * @param E
     * @throws Exception
     */
    @FXML
    private void onLookingInforInHistory(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        hotel = new Hotel(HotelList.get(HotelList.size()-1-table.getSelectionModel().getSelectedIndex()).getUserID());
        room = new Room(hotel.getHotelInformation().getUserID());
        new MemberHotelInformationInHistoryUI().start(primaryStage);
        passOrderWithHotel();
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

    /**
     *
     * @param E
     * @throws Exception
     */
    @FXML
    private void onReserveRoom(ActionEvent E)throws Exception {
        Label totalPrice = (Label)midRoot.lookup("#totalPrice");
        if(totalPrice.getText().toString().equals("")){
            promptPrimaryStage = new Stage();
            new MemberPromptUI().start(promptPrimaryStage);
            Label message = (Label) promptRoot.lookup("#Message");
            message.setText("请先结算订单总价");
        }else{
            if(credit.checkCredit()){
                reserve.createOrder();
                midPrimaryStage.close();
                onOrderInfor(E);
            }
            else {
                promptPrimaryStage = new Stage();
                new MemberPromptUI().start(promptPrimaryStage);
                Label message = (Label) promptRoot.lookup("#Message");
                message.setText("您的信用值小于0，无法生成订单");
            }
        }
    }

    /**
     * 结算订单总价值
     * 下订单前必须先结算订单总价
     * @param E
     * @throws Exception
     */
    @FXML
    private void onTotalPrice(ActionEvent E)throws Exception {
        reserve = new Reserve(member.getMemberInformation().getUserID(),hotel.getHotelInformation().getUserID());
        DatePicker inTime = (DatePicker)midRoot.lookup("#inTime");
        DatePicker outTime = (DatePicker)midRoot.lookup("#outTime");
        RadioButton has = (RadioButton)midRoot.lookup("#has");
        TextField num = (TextField)midRoot.lookup("#num");
        TextField numP = (TextField)midRoot.lookup("#numP");
        Label totalPrice = (Label)midRoot.lookup("#totalPrice");
        tem = inTime.getEditor().getText().split("-");
        DateInTime = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        DateInTime.setHours(12);
        tem = outTime.getEditor().getText().split("-");
        DateOutTime = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        reserve.setCheckinTime(DateInTime);
        DateInTime.setHours(DateInTime.getHours()+8);
        reserve.setLatestArriveTime(DateInTime);
        reserve.setSelectedRoom(temRoom);
        reserve.setNumberOfRoom(Integer.parseInt(num.getText().toString()));
        reserve.setNumberOfClient(Integer.parseInt(numP.getText().toString()));
        reserve.setChekckoutTime(DateOutTime);
        reserve.setClientName(member.getName());
        reserve.setClientTel(member.getTel());
        reserve.setHaveKids(has.selectedProperty().getValue());
        totalPrice.setText(""+reserve.getPrice());
    }

    /**
     * 根据所选的房间生成订单预定界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onReserve(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#tablePass");
        temRoom = RoomList.get(table.getSelectionModel().getSelectedIndex());
        midPrimaryStage = new Stage();
        new MemberReserveUI().start(midPrimaryStage);
        TextField name = (TextField)midRoot.lookup("#name");
        TextField type = (TextField)midRoot.lookup("#type");
        TextField danjia = (TextField)midRoot.lookup("#danjia");
        TextField num = (TextField)midRoot.lookup("#num");
        DatePicker inTime = (DatePicker)midRoot.lookup("#inTime");
        DatePicker outTime = (DatePicker)midRoot.lookup("#outTime");
        name.setText(temRoom.getRoomName());
        type.setText(""+temRoom.getRoomType());
        inTime.setValue(LocalDateInTime);
        outTime.setValue(LocalDateOutTime);
        danjia.setText(""+temRoom.getPrice());
        num.setText("1");
    }

    /**
     * 在酒店详细信息界面绘制酒店房间列表表格
     * @param E
     */
    private void roomList(ActionEvent E){
        TableView table = (TableView) root.lookup("#tablePass");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        ArrayList<RoomVO> list = room.getDailyRoomList(new Date());
        RoomVO tem;
        RoomList = new ArrayList<RoomVO>();
        count=0;
        for(int i=0;!list.isEmpty();){
            tem = list.get(i);
            list=jian(list,tem);
            RoomList.add(tem);
            dataForMInfor.add(new TableData(tem.getRoomName(),""+tem.getRoomType(),""+tem.getPrice(),""+count));
            count=0;
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        table.setItems(dataForMInfor);
    }

    /**
     * 帮助roomList绘制房间列表的方法
     * roomList添加A名字房间后，去除名字为A的房间
     * @param list
     * @param room
     * @return  放回去除名字为A的房间的List
     *
     * tips：count用来计算名字为A的房间的数量
     */
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

    /**
     * 响应在搜索酒店的列表的查看酒店详细信息
     * @param E
     * @throws Exception
     */
    @FXML
    private void onLookingInforInSearch(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        hotel = new Hotel(HotelList.get(table.getSelectionModel().getSelectedIndex()).getUserID());
        room = new Room(hotel.getHotelInformation().getUserID());
        new MemberHotelInformationInSearchUI().start(primaryStage);
        passOrderWithHotel();
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

    /**
     * 绘制用户信息更改界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onChangeInfor(ActionEvent E)throws Exception {
        minPrimaryStage = new Stage();
        new MemberUpdateInformationUI().start(minPrimaryStage);
    }

    /**
     * 响应确认用户信息更改按钮
     * @param E
     * @throws Exception
     */
    @FXML
    private void onMakeChange(ActionEvent E)throws Exception {
        TextField name = (TextField)minRoot.lookup("#name");
        TextField tel = (TextField)minRoot.lookup("#tel");
        member.getMemberInformation().setName(name.getText().toString());
        member.getMemberInformation().setTel(tel.getText().toString());
        member.updateMemberInformation(member.getMemberInformation());
        minPrimaryStage.close();
        onMenberInfor(E);
    }

    /**
     * 设置只搜索曾经预定过的酒店
     * @param E
     * @throws Exception
     */
    @FXML
    private void onSearchLimited(ActionEvent E)throws Exception {
        ComboBox<roomState> city = ( ComboBox<roomState>)root.lookup("#city");
        ComboBox<roomState> district= ( ComboBox<roomState>)root.lookup("#district");
        if(city.getSelectionModel().getSelectedItem().toString().equals("")||district.getSelectionModel().getSelectedItem().toString().equals("")){
            promptPrimaryStage = new Stage();
            new MemberPromptUI().start(promptPrimaryStage);
            Label message = (Label) promptRoot.lookup("#Message");
            message.setText("请先输入商圈和城市信息");
        }else{
            search.setOnlyReservationBefore(true);
            searchSet(E);
        }
    }

    /**
     * 搜索所有此类型的酒店（包括没有预定过的酒店）
     * @param E
     * @throws Exception
     */
    @FXML
    private void onSearchAll(ActionEvent E)throws Exception {
        ComboBox<roomState> city = ( ComboBox<roomState>)root.lookup("#city");
        ComboBox<roomState> district= ( ComboBox<roomState>)root.lookup("#district");
        if(city.getSelectionModel().getSelectedItem().toString().equals("")||district.getSelectionModel().getSelectedItem().toString().equals("")){
            promptPrimaryStage = new Stage();
            new MemberPromptUI().start(promptPrimaryStage);
            Label message = (Label) promptRoot.lookup("#Message");
            message.setText("请先输入商圈和城市信息");
        }else{
            search.setOnlyReservationBefore(false);
            searchSet(E);
        }
    }

    /**
     * 帮助完成搜索酒店的条件设置
     * @param E
     * @throws Exception
     */
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
        if(roomTypeInsearch.getEditor().getText().toString().equals("")){
            search.setRoomType(null);
        }else{
            search.setRoomType(roomTypeInsearch.getSelectionModel().getSelectedItem().toRoomType());
        }
        search.setNumberOfRooms(Integer.parseInt(numOfRoom.getSelectionModel().getSelectedItem().toString()));
        search.setHotelName(hotelName.getText().toString());
        tem = inTime.getEditor().getText().split("-");
        DateInTime = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        tem = outTime.getEditor().getText().split("-");
        DateOutTime = new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2]));
        LocalDateInTime =inTime.getValue();
        LocalDateOutTime =outTime.getValue();
        search.setCheckinTime(DateInTime);
        search.setCheckoutTime(DateOutTime);
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
        if(level.getEditor().getText().toString().equals("")){
             search.setLevel(0);
        }else {
            search.setLevel(Integer.parseInt(level.getSelectionModel().getSelectedItem().toString()));
        }
        onSortWithLevel(E);
    }

    /**
     * 响应按星级排序的刺激
     * 将酒店列表按星级排序
     * @param E
     * @throws Exception
     */
    @FXML
    private void onSortWithLevel(ActionEvent E)throws Exception {
        HotelList = search.sortByLevelHighToLow();
        sort(HotelList);
    }

    /**
     * 响应按价格排序的刺激
     * 将酒店列表按价格排序
     * @param E
     * @throws Exception
     */
    @FXML
    private void onSortWithPrice(ActionEvent E)throws Exception {
        HotelList = search.sortByPriceLowToHigh();
        sort(HotelList);
    }

    /**
     * 在酒店详细信息列表中返回酒店搜索列表界面
     * 默认为按星级排序界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void returnSearch(ActionEvent E)throws Exception {
        onSortWithLevel(E);
    }

    /**
     * 在酒店详细信息列表中返回曾经预定过的酒店列表界面
     *
     * @param E
     * @throws Exception
     */
    @FXML
    private void returnHistory(ActionEvent E)throws Exception {
        onPastHotel(E);
    }

    /**
     * 响应按评分排序的刺激
     * 将酒店列表按评分排序
     * @param E
     * @throws Exception
     */
    @FXML
    private void onSortWithComment(ActionEvent E)throws Exception {
        HotelList = search.sortByScoreHighToLow();
        sort(HotelList);
    }

    /**
     * 完成搜索出的酒店列表的绘制
     * @param list      排序好的酒店列表
     * @throws Exception
     */
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

    /**
     * 帮助完成确认是否为曾经预定过的酒店的方法
     * @param past
     * @param now
     * @return
     */
    private boolean compare(ArrayList<HotelVO> past,HotelVO now){
        for(int i=0;i<past.size();i++){
            if(past.get(i).getUserID().equals(now.getUserID())){
                return true;
            }
        }
        return false;
    }

    /**
     * 绘制客户与特定酒店过去的订单信息表格
     * @throws Exception
     */
    private void passOrderWithHotel() throws  Exception{
        OrderList = member.getHotelOrderList(hotel.getHotelInformation().getUserID());
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i< OrderList.size(); i++){
            dataForMInfor.add(new TableData(OrderList.get(i).getOrderID(),sdf.format(OrderList.get(i).getCreateTime()),""+ OrderList.get(i).getOrderStatus(),""+ OrderList.get(i).getPrice()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        table.setItems(dataForMInfor);
    }
}
