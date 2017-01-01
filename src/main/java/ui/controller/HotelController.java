package ui.controller;

import bl.implementation.Order;
import bl.service.HotelBLService;
import bl.service.OrderBLService;
import bl.service.PromotionBLService;
import bl.service.RoomBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import other.*;
import ui.presentation.*;
import vo.HotelVO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomVO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**     帮助Hotel模块完成界面转跳以及连接UI层与BL层
 *
 * Created by 庄刚轻 on 2016/11/26.
 */
public class HotelController {


    private static HotelBLService hotel;            //hotel模块，连接BL层
    private static OrderBLService order ;           //order模块，连接BL层
    private static PromotionBLService promotion;            //Promotion模块，连接BL层
    private static RoomBLService room ;             //room模块，连接BL层

    public static void setHotel(HotelBLService hote) {
        hotel = hote;
    }

    public static void setOrder(OrderBLService orde) {
        order = orde;
    }

    public static void setPromotion(PromotionBLService promotio) {
        promotion = promotio;
    }

    public static  void setRoom(RoomBLService roo) {
        room = roo;
    }

    private static Stage primaryStage;              //主界面舞台
    private static Stage minPrimaryStage;           //小界面舞台
    private static Stage midPrimaryStage;           //中界面舞台
    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }
    private static Parent minRoot;
    private static Parent root;
    private static Parent midRoot;
    private static ArrayList<OrderVO> OrderList;
    private static ArrayList<RoomVO> RoomList;
    private static ArrayList<PromotionVO> PromotionList;
    private static OrderVO temOrder;
    private static int count;
    private static LocalDate tem;

    public static void setMidRoot(Parent midRoot) {
        HotelController.midRoot = midRoot;
    }

    public static void setMidPrimaryStage(Stage midPrimaryStage) {
        HotelController.midPrimaryStage = midPrimaryStage;
    }

    public static void setMinPrimaryStage(Stage minPrimaryStage) {
        HotelController.minPrimaryStage = minPrimaryStage;
    }

    public static void setRoot(Parent root) {
        HotelController.root = root;
    }

    public static void setMinRoot(Parent minRoot) {
        HotelController.minRoot = minRoot;
    }

    /**
     * 响应（查看）酒店基本信息
     * @param E
     * @throws Exception
     */
    @FXML
    private void onInfor(ActionEvent E) throws Exception {
        new HotelInformationUI().start(primaryStage);
        TextField name = (TextField)root.lookup("#name");
        TextField address = (TextField)root.lookup("#address");
        TextField district = (TextField)root.lookup("#district");
        TextField level = (TextField)root.lookup("#level");
        TextArea service = (TextArea) root.lookup("#service");
        service.setWrapText(true);
        TextArea introduction = (TextArea) root.lookup("#introduction");
        introduction.setWrapText(true);
        name.setText(hotel.getHotelName());
        address.setText(hotel.getHotelAddress());
        district.setText(hotel.getDistrict());
        level.setText(""+hotel.getHotelLevel());
        service.setText(hotel.getHotelService());
        introduction.setText(hotel.getHotelIntroduction());
    }

    /**
     * 生成酒店基本信息更改界面
     *
     * 将酒店的基本信息传入作为默认值
     * @param E
     * @throws Exception
     */
    @FXML
    private void onInforChange(ActionEvent E)throws Exception {
        minPrimaryStage = new Stage();
        new HotelUpdateInformationUI().start(minPrimaryStage);
        TextField name = (TextField) minRoot.lookup("#name");
        TextField address = (TextField) minRoot.lookup("#address");
        TextField district = (TextField) minRoot.lookup("#district");
        TextField level = (TextField) minRoot.lookup("#level");
        TextArea service = (TextArea) minRoot.lookup("#service");
        service.setWrapText(true);
        TextArea introduction = (TextArea) minRoot.lookup("#introduction");
        introduction.setWrapText(true);

        name.setText(hotel.getHotelName());
        address.setText(hotel.getHotelAddress());
        district.setText(hotel.getDistrict());
        level.setText(""+hotel.getHotelLevel());
        service.setText(hotel.getHotelService());
        introduction.setText(hotel.getHotelIntroduction());
    }

    /**
     * 响应确认酒店基本信息变更
     * @param E
     * @throws Exception
     */
    @FXML
    private void onMakeChange(ActionEvent E)throws Exception {          //酒店基本信息改变
        TextField name = (TextField) minRoot.lookup("#name");
        TextField address = (TextField) minRoot.lookup("#address");
        TextField district = (TextField) minRoot.lookup("#district");
        TextField level = (TextField) minRoot.lookup("#level");
        TextArea service = (TextArea) minRoot.lookup("#service");
        service.setWrapText(true);
        TextArea introduction = (TextArea) minRoot.lookup("#introduction");
        introduction.setWrapText(true);

        hotel.setHotelInformation(new HotelVO(hotel.getHotelInformation().getUserID(),hotel.getHotelInformation().getPassword(),name.getText().toString(),
                address.getText().toString(),district.getText().toString(),hotel.getHotelInformation().getCity(),Integer.parseInt(level.getText().toString()),
                hotel.getHotelInformation().getScore(), service.getText().toString(), introduction.getText().toString(),
                hotel.getHotelInformation().getManagerName(),hotel.getHotelManagerTel()));
        minPrimaryStage.close();
        onInfor(E);
    }

    /**
     * 响应（查看）订单详细信息
     * @param E
     * @throws Exception
     */
    @FXML
    private void onOrderInformation(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        OrderVO tem = this.OrderList.get(table.getSelectionModel().getSelectedIndex());

        midPrimaryStage = new Stage();
        new HotelOrderInformationUI().start(midPrimaryStage);
        TextField name = (TextField) midRoot.lookup("#name");
        TextField tel = (TextField) midRoot.lookup("#tel");
        TextField level = (TextField) midRoot.lookup("#l");
        TextField MemberType = (TextField) midRoot.lookup("#MType");
        TextField nameOfRoom = (TextField) midRoot.lookup("#nameOfRoom");
        TextField numOfRoom = (TextField) midRoot.lookup("#numOfRoom");
        TextField state = (TextField) midRoot.lookup("#state");
        TextField price = (TextField) midRoot.lookup("#price");
        TextField expectInTime = (TextField) midRoot.lookup("#EinTime");
        TextField actualInTime = (TextField) midRoot.lookup("#AinTime");
        TextField expectOutTime = (TextField) midRoot.lookup("#EoutTime");
        TextField actualOutTime = (TextField) midRoot.lookup("#AoutTime");
        TextField createdTime = (TextField) midRoot.lookup("#CreatTime");
        TextField CancelTime = (TextField) midRoot.lookup("#CancelTime");
        TextField score = (TextField)midRoot.lookup("#score");
        TextArea area = (TextArea)midRoot.lookup("#area");
        area.setWrapText(true);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        actualInTime.setText("尚未入住");
        actualOutTime.setText("尚未退房");
        CancelTime.setText("订单没有被取消");

        name.setText(tem.getMemberVO().getName());
        tel.setText(tem.getMemberVO().getTel());
        level.setText(""+tem.getMemberVO().getLevel());

        if(tem.getMemberVO().getBirthday()==null){
            MemberType.setText("企业");
        }else{
            MemberType.setText("普通");
        }

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
            score.setText("");
            score.setText(""+tem.getScore());
            area.setText(tem.getEvaluation());
        }
    }

    /**
     * 帮助完成订单管理界面的表格绘制和信息填充
     */
    private void OrderTable(){
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForH
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        for(int i = 0; i< OrderList.size(); i++){
            dataForH.add(new TableData(OrderList.get(i).getOrderID(), OrderList.get(i).getRoomName(),
                    OrderList.get(i).getMemberVO().getName(), OrderList.get(i).getMemberVO().getTel()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));

        table.setItems(dataForH);
    }

    /**
     * 响应订单管理
     * 响应（查看）未执行订单列表
     * @param E
     * @throws Exception
     */
    @FXML
    private void onOrderManager(ActionEvent E)throws Exception {
        new HotelUnprocessedOrderUI().start(primaryStage);
        OrderList = order.getUnexcutedOrders();
        OrderTable();
        //count=0;
    }

    /**
     * 响应（查看）已执行订单列表
     * @param E
     * @throws Exception
     */
    @FXML
    private void onProcessedOrder(ActionEvent E)throws Exception {
        new HotelProcessedOrderUI().start(primaryStage);
        OrderList = order.getExcutedOrders();
        OrderTable();
    }

    /**
     * 响应（查看）已撤销的订单列表
     * @param E
     * @throws Exception
     */
    @FXML
    private void onCancelOrder(ActionEvent E)throws Exception {
        new HotelCancelOrderUI().start(primaryStage);
        OrderList = order.getCanceledOrders();
        OrderTable();
    }

    /**
     * 响应（查看）异常订单列表
     * @param E
     * @throws Exception
     */
    @FXML
    private void onAbnormalOrder(ActionEvent E)throws Exception {
        new HotelAbnormalOrderUI().start(primaryStage);
        OrderList = order.getAbnormalOrders();
        OrderTable();
        //count=0;
    }

    /**
     * 响应延迟入住操作，生成房间选择界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onDelayOrder(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        OrderList = order.getAbnormalOrders();
        temOrder = OrderList.get(table.getSelectionModel().getSelectedIndex());
        midPrimaryStage = new Stage();
        new HotelRoomChoiceUI().start(midPrimaryStage);
        count = temOrder.getRoomList().size();
        table = (TableView) midRoot.lookup("#table");
        Label totalNum = (Label) midRoot.lookup("#totalNum");
        Label unNum = (Label) midRoot.lookup("#unNum");
        totalNum.setText(""+temOrder.getNumberOfRoom());
        unNum.setText(""+(temOrder.getNumberOfRoom()-count));
        RoomList = room.getAvailableRoomByName(temOrder.getCheckinTime(),temOrder.getRoomName());
        ObservableList<TableData> dataForH
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        for(int i=0;i<RoomList.size();i++){
            dataForH.add(new TableData(RoomList.get(i).getRoomNumber(),RoomList.get(i).getRoomName()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellFactory(new Callback<TableColumn<TableData,Boolean>, TableCell<TableData,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new delayCheckIn();
            }
        });
        table.setItems(dataForH);
    }

    /**
     * 响应客户入住操作，生成房间选择界面
     * @throws Exception
     */
    @FXML
    private void onCheckIn() throws Exception {
        TableView table = (TableView) root.lookup("#table");
        OrderList = order.getUnexcutedOrders();
        temOrder = OrderList.get(table.getSelectionModel().getSelectedIndex());
        midPrimaryStage = new Stage();
        new HotelRoomChoiceUI().start(midPrimaryStage);
        count = temOrder.getRoomList().size();
        table = (TableView) midRoot.lookup("#table");
        Label totalNum = (Label) midRoot.lookup("#totalNum");
        Label unNum = (Label) midRoot.lookup("#unNum");
        totalNum.setText(""+temOrder.getNumberOfRoom());
        unNum.setText(""+(temOrder.getNumberOfRoom()-count));
        RoomList = room.getAvailableRoomByName(new Date(),temOrder.getRoomName());
        ObservableList<TableData> dataForH
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        for(int i=0;i<RoomList.size();i++){
            dataForH.add(new TableData(RoomList.get(i).getRoomNumber(),RoomList.get(i).getRoomName()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellFactory(new Callback<TableColumn<TableData,Boolean>, TableCell<TableData,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new checkIn();
            }
        });
        table.setItems(dataForH);
    }

    /**
     * 帮助完成入住操作界面的绘制，添加入住按钮动作并响应动作监听
     */
    class checkIn extends TableCell<TableData,Boolean>{
        private Button button=new Button("入住");
        public checkIn(){
//            button.setPrefSize();
            button.setOnAction((ActionEvent e)->{
                int seletedIndex=getTableRow().getIndex();
                RoomVO tem = RoomList.get(seletedIndex);
                hotel.checkin(temOrder.getOrderID(),tem.getRoomNumber());
                count++;
                if(temOrder.getNumberOfRoom()!=count){
                    try{
                        midPrimaryStage.close();
                        onCheckIn();
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                }else {
                    try{
                        midPrimaryStage.close();
                        order.checkin(temOrder.getOrderID());
                        onOrderManager(e);
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                }
            });
        }
        @Override
        protected void updateItem(Boolean t,boolean empty){
            super.updateItem(t,empty);
            if(empty){
                setGraphic(null);
                setText(null);
                setText(null);
            }else{
                setGraphic(button);
                setText(null);
            }

        }
    }

    /**
     *
     * 帮助完成延迟入住操作界面的绘制，添加入住按钮动作并响应动作监听
     */
    class delayCheckIn extends TableCell<TableData,Boolean> {
        private Button button = new Button("入住");

        public delayCheckIn() {
//            button.setPrefSize();
            button.setOnAction((ActionEvent e) -> {
                int seletedIndex = getTableRow().getIndex();
                RoomVO tem = RoomList.get(seletedIndex);
                hotel.delay(temOrder.getOrderID(), tem.getRoomNumber());
                count++;
                if ( count != temOrder.getNumberOfRoom()) {
                    try {
                        midPrimaryStage.close();
                        onDelayOrder(e);
                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                } else {
                    try {
                        midPrimaryStage.close();
                        order.checkin(temOrder.getOrderID());
                        onAbnormalOrder(e);
                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                }
            });
        }
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(button);
                setText(null);
            }

        }
    }

    /**
     * 响应客户离开操作，生成退房界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onCheckOut(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        OrderList = order.getExcutedOrders();
        temOrder = OrderList.get(table.getSelectionModel().getSelectedIndex());
        midPrimaryStage = new Stage();
        new HotelRoomChoiceUI().start(midPrimaryStage);
        RoomList = temOrder.getRoomList();
        count = RoomList.size();
        table = (TableView) midRoot.lookup("#table");
        Label totalNum = (Label) midRoot.lookup("#totalNum");
        Label unNum = (Label) midRoot.lookup("#unNum");
        totalNum.setText(""+temOrder.getNumberOfRoom());
        unNum.setText(""+count);
        ObservableList<TableData> dataForH
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        for(int i=0;i<RoomList.size();i++){
            dataForH.add(new TableData(RoomList.get(i).getRoomNumber(),RoomList.get(i).getRoomName()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellFactory(new Callback<TableColumn<TableData,Boolean>, TableCell<TableData,Boolean>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new checkout();
            }
        });

        table.setItems(dataForH);

    }

    /**
     * 帮助完成客户离开操作界面的绘制，添加退房按钮动作并响应动作监听
     */
    class checkout extends TableCell<TableData,Boolean> {
        private Button button = new Button("退房");

        public checkout() {
//            button.setPrefSize();
            button.setOnAction((ActionEvent e) -> {
                int seletedIndex = getTableRow().getIndex();
                RoomVO tem = RoomList.get(seletedIndex);
                hotel.checkout(temOrder.getOrderID(), tem.getRoomNumber());
                count--;
                if (0 != count) {
                    try {
                        midPrimaryStage.close();
                        onCheckOut(e);
                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                } else {
                    try {
                        midPrimaryStage.close();
                        order.checkout(temOrder.getOrderID());
                        onProcessedOrder(e);
                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                }
            });
        }
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (empty) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(button);
                setText(null);
                setText(null);
            }

        }
    }

    /**
     * 响应策略管理，生成策略管理界面
     * 响应日期策略
     * @param E
     * @throws Exception
     */
    @FXML
    private void onPromotionManager(ActionEvent E)throws Exception {
        new HotelDatePromotionUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForH
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        PromotionList = promotion.getHotelDatePromotionList();
        System.out.print(PromotionList.size());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<PromotionList.size();i++){
            dataForH.add(new TableData(sdf.format(PromotionList.get(i).getStartDate()),sdf.format(PromotionList.get(i).getEndDate()),
                    ""+PromotionList.get(i).getDiscount()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        table.setItems(dataForH);
    }

    /**
     * 响应添加日期促销策略
     * 生成添加界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onAddDatePromotion(ActionEvent E)throws Exception {
        minPrimaryStage = new Stage();
        new HotelAddDatePromotionUI().start(minPrimaryStage);
    }

    /**
     * 响应更改日期促销策略
     * 生成更改界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onChangeDatePromotion(ActionEvent E)throws Exception {
        minPrimaryStage = new Stage();
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = promotion.getHotelDatePromotionList().get(table.getSelectionModel().getSelectedIndex());
        new HotelChangeDatePromotionUI().start(minPrimaryStage);
        TextField DatePromotionName = (TextField) minRoot.lookup("#DatePromotionName");
        TextField dateDiscount = (TextField) minRoot.lookup("#dateDiscount");
        DatePicker checkInDate = (DatePicker) minRoot.lookup("#checkInDate");
        DatePicker checkOutDate = (DatePicker) minRoot.lookup("#checkOutDate");
        DatePromotionName.setText(tem.getPromotionName());
        dateDiscount.setText(""+tem.getDiscount());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String[] t1 = sdf.format(tem.getStartDate()).split("-");
        String[] t2 = sdf.format(tem.getEndDate()).split("-");
        checkInDate.setValue(LocalDate.of(tem.getStartDate().getYear()+1900,tem.getStartDate().getMonth()+1,Integer.parseInt(t1[2])));
        checkOutDate.setValue(LocalDate.of(tem.getEndDate().getYear()+1900,tem.getEndDate().getMonth()+1,Integer.parseInt(t2[2])));
    }

    /**
     * 响应删除日期促销策略
     * @param E
     * @throws Exception
     */
    @FXML
    private void onDeleteDateP(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = PromotionList.get(table.getSelectionModel().getSelectedIndex());
        promotion.deletePromotion(tem.getPromotionID());
        onPromotionManager(E);
    }

    /**
     * 响应确认更改日期促销策略
     * @param E
     * @throws Exception
     */
    @FXML
    private void confirmChangePromotion(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = PromotionList.get(table.getSelectionModel().getSelectedIndex());
        TextField DatePromotionName = (TextField) minRoot.lookup("#DatePromotionName");
        TextField dateDiscount = (TextField) minRoot.lookup("#dateDiscount");
        DatePicker checkInDate = (DatePicker) minRoot.lookup("#checkInDate");
        DatePicker checkOutDate = (DatePicker) minRoot.lookup("#checkOutDate");
        PromotionVO change = new PromotionVO(tem.getPromotionID(),DatePromotionName.toString(), tem.getPromotionType(),hotel.getHotelInformation().getUserID());
        change.setStartDate(new Date(checkInDate.getValue().getYear()-1900,checkInDate.getValue().getMonthValue()-1,checkInDate.getValue().getDayOfMonth()));
        change.setEndDate(new Date(checkOutDate.getValue().getYear()-1900,checkOutDate.getValue().getMonthValue()-1,checkOutDate.getValue().getDayOfMonth()));
        change.setDiscount(Double.parseDouble(dateDiscount.getText().toString()));
        promotion.updatePromotion(change);
        minPrimaryStage.close();
        onPromotionManager(E);
    }

    /**
     * 响应确认添加日期促销策略
     * @param E
     * @throws Exception
     */
    @FXML
    private void confirmAddPromotion(ActionEvent E)throws Exception {
        TextField DatePromotionName = (TextField) minRoot.lookup("#DatePromotionName");
        TextField dateDiscount = (TextField) minRoot.lookup("#dateDiscount");
        DatePicker checkInDate = (DatePicker) minRoot.lookup("#checkInDate");
        DatePicker checkOutDate = (DatePicker) minRoot.lookup("#checkOutDate");
        PromotionVO add = new PromotionVO(null,DatePromotionName.getText().toString(), PromotionType.Discount,hotel.getHotelInformation().getUserID());
        add.setStartDate(new Date(checkInDate.getValue().getYear()-1900,checkInDate.getValue().getMonthValue()-1,checkInDate.getValue().getDayOfMonth()));
        add.setEndDate(new Date(checkOutDate.getValue().getYear()-1900,checkOutDate.getValue().getMonthValue()-1,checkOutDate.getValue().getDayOfMonth()));
        add.setSaleType(SaleType.Date);
        add.setDiscount(Double.parseDouble(dateDiscount.getText().toString()));
        promotion.addPromotion(add);
        minPrimaryStage.close();
        onPromotionManager(E);
    }

    /**
     * 响应添加企业促销策略
     * 生成添加界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onAddCompanyPromotion(ActionEvent E)throws Exception {
        minPrimaryStage = new Stage();
        new HotelAddCompanyPromotionUI().start(minPrimaryStage);
    }

    /**
     * 响应更改企业促销策略
     * 生成更改界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onChangeCompanyPromotion(ActionEvent E)throws Exception {
        minPrimaryStage = new Stage();
        new HotelChangeCompanyPromotionUI().start(minPrimaryStage);
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = PromotionList.get(table.getSelectionModel().getSelectedIndex());
        TextField Pname = (TextField) minRoot.lookup("#Pname");
        TextField name = (TextField) minRoot.lookup("#name");
        TextField discount = (TextField) minRoot.lookup("#discount");
        Pname.setText(tem.getPromotionName());
        name.setText(tem.getEnterprise());
        discount.setText(""+tem.getDiscount());
    }

    /**
     * 响应删除企业促销策略操作
     * @param E
     * @throws Exception
     */
    @FXML
    private void onDeleteCompanyPromotion(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = PromotionList.get(table.getSelectionModel().getSelectedIndex());
        promotion.deletePromotion(tem.getPromotionID());
        onCompanyPromotion(E);
    }

    /**
     * 响应企业策略策略界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onCompanyPromotion(ActionEvent E)throws Exception {
        new HotelCompanyPromotionUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        PromotionList = promotion.getEnterprisePromotionList();
        for(int i=0;i<PromotionList.size();i++){
            dataForMInfor.add(new TableData(PromotionList.get(i).getPromotionName(),PromotionList.get(i).getEnterprise(),""+PromotionList.get(i).getDiscount()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        table.setItems(dataForMInfor);
    }

    /**
     * 确认新增企业促销策略
     * @param E
     * @throws Exception
     */
    @FXML
    private void onSureAddCompanyPromotion(ActionEvent E)throws Exception {
        TextField Pname = (TextField) minRoot.lookup("#Pname");
        TextField name = (TextField) minRoot.lookup("#name");
        TextField discount = (TextField) minRoot.lookup("#discount");
        PromotionVO add = new PromotionVO(null,Pname.getText().toString(),PromotionType.Discount,hotel.getHotelInformation().getUserID());
        add.setPromotionName(Pname.getText().toString());
        add.setEnterprise(name.getText());
        add.setDiscount(Double.parseDouble(discount.getText().toString()));
        add.setSaleType(SaleType.Enterprise);
        promotion.addPromotion(add);
        minPrimaryStage.close();
        onCompanyPromotion(E);
    }

    /**
     * 确认更改企业促销策略
     * @param E
     * @throws Exception
     */
    @FXML
    private void onSureChangeCompanyPromotion(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = PromotionList.get(table.getSelectionModel().getSelectedIndex());
        TextField Pname = (TextField) minRoot.lookup("#Pname");
        TextField name = (TextField) minRoot.lookup("#name");
        TextField discount = (TextField) minRoot.lookup("#discount");
        PromotionVO change = new PromotionVO(tem.getPromotionID(),Pname.getText().toString(),tem.getPromotionType(),hotel.getHotelInformation().getUserID());
        change.setPromotionName(Pname.getText().toString());
        change.setEnterprise(name.getText());
        change.setDiscount(Double.parseDouble(discount.getText().toString()));
        promotion.updatePromotion(change);
        minPrimaryStage.close();
        onCompanyPromotion(E);
    }
    /**
     * 进入酒店房间管理界面的响应
     * */
    @FXML
    private void onRoomManager(ActionEvent E)throws Exception {
        new HotelRoomUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");
        DatePicker date = (DatePicker)root.lookup("#date");
        date.setValue(LocalDate.now());
        tem=date.getValue();
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        RoomList = room.getDailyRoomList(new Date());
        for(int i=0;i<RoomList.size();i++){
            dataForMInfor.add(new TableData(RoomList.get(i).getRoomNumber(),RoomList.get(i).getRoomName(),
                    ""+RoomList.get(i).getRoomType(),""+RoomList.get(i).getPrice(),RoomList.get(i).isAvailable()?"空置":"已入住"));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        tableList.get(4).setCellValueFactory(new PropertyValueFactory("fifth"));
        table.setItems(dataForMInfor);
    }

    /**
     * 按日期查询房间的动作响应
     * */
    @FXML
    private void onQuery(ActionEvent E)throws Exception {
        DatePicker date = (DatePicker)root.lookup("#date");
        tem = date.getValue();
        TableView table = (TableView) root.lookup("#table");
        table.getItems().clear();
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        RoomList = room.getDailyRoomList(new Date(tem.getYear()-1900,tem.getMonthValue()-1,tem.getDayOfMonth()));
        for(int i=0;i<RoomList.size();i++){
            dataForMInfor.add(new TableData(RoomList.get(i).getRoomNumber(),RoomList.get(i).getRoomName(),
                    ""+RoomList.get(i).getRoomType(),""+RoomList.get(i).getPrice(),RoomList.get(i).isAvailable()?"空置":"已入住"));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        tableList.get(4).setCellValueFactory(new PropertyValueFactory("fifth"));
        table.setItems(dataForMInfor);
    }

    /**
     * 响应新增房间操作
     * 生成新增界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onAddRoom(ActionEvent E)throws Exception {
        minPrimaryStage = new Stage();
        new HotelAddRoomUI().start(minPrimaryStage);
        ComboBox<roomTypeChoice> type =(ComboBox<roomTypeChoice>) minRoot.lookup("#type");
        type.getItems().clear();
        type.getItems().add(new roomTypeChoice(RoomType.Single.toString()));
        type.getItems().add(new roomTypeChoice(RoomType.BigBed.toString()));
        type.getItems().add(new roomTypeChoice(RoomType.TwinBed.toString()));
        type.getItems().add(new roomTypeChoice(RoomType.Suite.toString()));
    }

    /**
     * 确认新增房间的操作
     * @param E
     * @throws Exception
     */
    @FXML
    private void onSureAddRoom(ActionEvent E)throws Exception {
        TextField id = (TextField) minRoot.lookup("#id");
        TextField name = (TextField) minRoot.lookup("#name");
        TextField price = (TextField) minRoot.lookup("#price");
        ComboBox<roomTypeChoice> type =(ComboBox<roomTypeChoice>) minRoot.lookup("#type");
        room.addRoom(new RoomVO(false,true,id.getText().toString(),name.getText().toString(),
                type.getSelectionModel().getSelectedItem().toRoomType(),
                Double.parseDouble(price.getText().toString()),hotel.getHotelInformation().getUserID()));
        minPrimaryStage.close();
        onRoomManager(E);
    }

    /**
     * 响应更改房间信息操作
     * 生成更改房间信息界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onChangeRoom(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
//        ArrayList<RoomVO> OrderList = room.getDailyRoomList(new Date());
        RoomVO tem =RoomList.get(table.getSelectionModel().getSelectedIndex());
        minPrimaryStage = new Stage();
        new HotelChangeRoomUI().start(minPrimaryStage);
        TextField id = (TextField) minRoot.lookup("#id");
        TextField name = (TextField) minRoot.lookup("#name");
        TextField price = (TextField) minRoot.lookup("#price");
        ComboBox<roomTypeChoice> type =(ComboBox<roomTypeChoice>) minRoot.lookup("#type");
        type.getItems().clear();
        type.getItems().add(new roomTypeChoice(RoomType.Single.toString()));
        type.getItems().add(new roomTypeChoice(RoomType.BigBed.toString()));
        type.getItems().add(new roomTypeChoice(RoomType.TwinBed.toString()));
        type.getItems().add(new roomTypeChoice(RoomType.Suite.toString()));
        type.setValue(new roomTypeChoice(""+tem.getRoomType()));
        ComboBox<roomState> state =(ComboBox<roomState>) minRoot.lookup("#state");
        state.getItems().clear();
        state.getItems().add(new roomState("已入住"));
        state.getItems().add(new roomState("空置"));
        state.setValue(tem.isAvailable()?new roomState("空置"):new roomState("已入住"));
        id.setText(tem.getRoomNumber());
        name.setText(tem.getRoomName());
        price.setText(""+tem.getPrice());
    }

    /**
     * 响应确认房间信息变化
     * @param E
     * @throws Exception
     */
    @FXML
    private void onSureChangeRoom(ActionEvent E)throws Exception {
        TextField name = (TextField) minRoot.lookup("#name");
        TextField price = (TextField) minRoot.lookup("#price");
        ComboBox<roomTypeChoice> type =(ComboBox<roomTypeChoice>) minRoot.lookup("#type");
        ComboBox<roomState> state =(ComboBox<roomState>) minRoot.lookup("#state");
        TableView table = (TableView) root.lookup("#table");
//        ArrayList<RoomVO> OrderList = room.getDailyRoomList(new Date());
        RoomVO tem =RoomList.get(table.getSelectionModel().getSelectedIndex());
        tem.setRoomName(name.getText().toString());
        tem.setPrice(Double.parseDouble(price.getText().toString()));
        tem.setRoomType(type.getSelectionModel().getSelectedItem().toRoomType());
        tem.setAvailable(state.getSelectionModel().getSelectedItem().toString().equals("空置")?true:false);
        room.updateRoom(new Date(this.tem.getYear()-1900,this.tem.getMonthValue()-1,this.tem.getDayOfMonth()),tem);
        minPrimaryStage.close();
        onRoomManager(E);
    }

    /**
     * 响应删除房间操作
     * @param E
     * @throws Exception
     */
    @FXML
    private void onDeleteRoom(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
//        ArrayList<RoomVO> OrderList = room.getDailyRoomList(new Date());
        RoomVO tem =RoomList.get(table.getSelectionModel().getSelectedIndex());
        room.deleteRoom(tem.getRoomNumber());
        onRoomManager(E);
    }

    /**
     * 实现登出，返回登录界面
     * @param E
     * @throws Exception
     */
    @FXML
    private void onLogOut(ActionEvent E)throws Exception {
        new LoginUI().start(primaryStage);
    }
}
