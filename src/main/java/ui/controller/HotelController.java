package ui.controller;

import bl.service.HotelBLService;
import bl.service.OrderBLService;
import bl.service.PromotionBLService;
import bl.service.RoomBLService;
import bl.stub.HotelBLStub;
import bl.stub.OrderBLStub;
import bl.stub.PromotionBLStub;
import bl.stub.RoomBLStub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import other.PromotionType;
import other.TableData;
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


    private HotelBLService hotel = new HotelBLStub();
    private OrderBLService order = new OrderBLStub();
    private PromotionBLService promotion = new PromotionBLStub();
    private RoomBLService room = new RoomBLStub();

    private static Stage primaryStage;
    private static Stage minprimaryStage;
    private static Stage midprimaryStage;
    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }
    private static Parent minroot;
    private static Parent root;
    private static Parent midroot;
    private static ArrayList<OrderVO> list;
    private static ArrayList<RoomVO> RoomList;
    private static OrderVO temOrder;
    private static int count=0;

    public static void setMidroot(Parent midroot) {
        HotelController.midroot = midroot;
    }

    public static void setMidprimaryStage(Stage midprimaryStage) {
        HotelController.midprimaryStage = midprimaryStage;
    }

    public static void setMinprimaryStage(Stage minprimaryStage) {
        HotelController.minprimaryStage = minprimaryStage;
    }

    public static void setRoot(Parent root) {
        HotelController.root = root;
    }

    public static void setMinroot(Parent minroot) {
        HotelController.minroot = minroot;
    }

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
    @FXML
    private void onInforChange(ActionEvent E)throws Exception {
        minprimaryStage = new Stage();
        new HotelUpdateInformationUI().start(minprimaryStage);
        TextField name = (TextField)minroot.lookup("#name");
        TextField address = (TextField)minroot.lookup("#address");
        TextField district = (TextField)minroot.lookup("#district");
        TextField level = (TextField)minroot.lookup("#level");
        TextArea service = (TextArea) minroot.lookup("#service");
        service.setWrapText(true);
        TextArea introduction = (TextArea) minroot.lookup("#introduction");
        introduction.setWrapText(true);

        name.setText(hotel.getHotelName());
        address.setText(hotel.getHotelAddress());
        district.setText(hotel.getDistrict());
        level.setText(""+hotel.getHotelLevel());
        service.setText(hotel.getHotelService());
        introduction.setText(hotel.getHotelIntroduction());
    }
    @FXML
    private void onMakeChange(ActionEvent E)throws Exception {          //酒店基本信息改变
        TextField name = (TextField)minroot.lookup("#name");
        TextField address = (TextField)minroot.lookup("#address");
        TextField district = (TextField)minroot.lookup("#district");
        TextField level = (TextField)minroot.lookup("#level");
        TextArea service = (TextArea) minroot.lookup("#service");
        service.setWrapText(true);
        TextArea introduction = (TextArea) minroot.lookup("#introduction");
        introduction.setWrapText(true);

        hotel.setHotelInformation(new HotelVO(hotel.getHotelInformation().getUserID(),hotel.getHotelInformation().getPassword(),name.getText().toString(),
                address.getText().toString(),district.getText().toString(),hotel.getHotelInformation().getCity(),Integer.parseInt(level.getText().toString()),
                hotel.getHotelInformation().getScore(), service.getText().toString(), introduction.getText().toString(),
                hotel.getHotelInformation().getManagerName(),hotel.getHotelManagerTel()));
        minprimaryStage.close();
        onInfor(E);
    }
    @FXML
    private void onOrderInforx(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        OrderVO tem = this.list.get(table.getSelectionModel().getSelectedIndex());

        midprimaryStage = new Stage();
        new HOrderInforUI().start(midprimaryStage);
        TextField name = (TextField)midroot.lookup("#name");
        TextField tel = (TextField)midroot.lookup("#tel");
        TextField score = (TextField)midroot.lookup("#score");
        TextField MType = (TextField)midroot.lookup("#MType");
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
        score.setText("订单尚未评价");

        name.setText(tem.getMemberVO().getName());
        tel.setText(tem.getMemberVO().getTel());
        if(tem.getEvaluation()!=null){
            score.setText(""+tem.getScore());
        }
        if(tem.getMemberVO().getBirthday()==null){
            MType.setText("企业");
        }else{
            MType.setText("普通");
        }

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
    private void OrderTable(){
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForH
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        for(int i=0;i<list.size();i++){
            dataForH.add(new TableData(list.get(i).getOrderID(),list.get(i).getRoomName(),
                    list.get(i).getMemberVO().getName(),list.get(i).getMemberVO().getTel()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));

        table.setItems(dataForH);
    }
    @FXML
    private void onOrderManager(ActionEvent E)throws Exception {
        new HotelUnprocessedOrderUI().start(primaryStage);
        list = order.getUnexcutedOrders();
        OrderTable();
    }
    @FXML
    private void onProcessedOrder(ActionEvent E)throws Exception {
        new HotelProcessedOrderUI().start(primaryStage);
        list = order.getExcutedOrders();
        OrderTable();
    }
    @FXML
    private void onCancelOrder(ActionEvent E)throws Exception {
        new HotelCancelOrderUI().start(primaryStage);
        list = order.getCanceledOrders();
        OrderTable();
    }
    @FXML
    private void onAbnormalOrder(ActionEvent E)throws Exception {
        new HotelAbnormalOrderUI().start(primaryStage);
        list = order.getAbnormalOrders();
        OrderTable();
    }
    @FXML
    private void onDelayOrder(ActionEvent E)throws Exception {
//        TableView table = (TableView) root.lookup("#table");
//        ArrayList<OrderVO> list = order.getUnexcutedOrders();
//        hotel.delay(list.get(table.getSelectionModel().getFocusedIndex()).getOrderID(),list.get(table.getSelectionModel().getFocusedIndex()));
        new HotelDelayOrderUI().start(primaryStage);
    }
    @FXML
    private void onCheckin() throws Exception {
        TableView table = (TableView) root.lookup("#table");
        temOrder = list.get(table.getSelectionModel().getSelectedIndex());
        midprimaryStage = new Stage();
        new HotelRoomChoiceUI().start(midprimaryStage);
        table = (TableView) midroot.lookup("#table");
        Label totalNum = (Label)midroot.lookup("#totalNum");
        Label unNum = (Label)midroot.lookup("#unNum");
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
                return new c();
            }
        });

        table.setItems(dataForH);
        count++;
    }
    class c extends TableCell<TableData,Boolean>{
        private Button button=new Button("入住");
        public c(){
//            button.setPrefSize();
            button.setOnAction((ActionEvent e)->{
                int seletedIndex=getTableRow().getIndex();
                RoomVO tem = RoomList.get(seletedIndex);
                hotel.checkin(temOrder.getOrderID(),tem.getRoomNumber());
                if(temOrder.getNumberOfRoom()!=count){
                    try{
                        onCheckin();
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
            }else{
                setGraphic(button);
                setText(null);
            }

        }
    }
    @FXML
    private void onPromotionManager(ActionEvent E)throws Exception {
        new HotelDatePromotionUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForH
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        ArrayList<PromotionVO> list = promotion.getHotelDatePromotionList();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<list.size();i++){
            dataForH.add(new TableData(sdf.format(list.get(i).getStartDate()),sdf.format(list.get(i).getEndDate()),
                    ""+list.get(i).getDiscount()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        table.setItems(dataForH);
    }
    @FXML
    private void onAddDatePromotion(ActionEvent E)throws Exception {
        minprimaryStage = new Stage();
        new HotelAddDatePromotionUI().start(minprimaryStage);
    }
    @FXML
    private void onChangeDatePromotion(ActionEvent E)throws Exception {
        minprimaryStage = new Stage();
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = promotion.getHotelDatePromotionList().get(table.getSelectionModel().getSelectedIndex());
        new HotelChangeDatePromotionUI().start(minprimaryStage);
        TextField DatePromotionName = (TextField)minroot.lookup("#DatePromotionName");
        TextField dateDiscount = (TextField)minroot.lookup("#dateDiscount");
        DatePicker checkInDate = (DatePicker)minroot.lookup("#checkInDate");
        DatePicker checkOutDate = (DatePicker)minroot.lookup("#checkOutDate");
        DatePromotionName.setText(tem.getPromotionName());
        dateDiscount.setText(""+tem.getDiscount());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String[] t1 = sdf.format(tem.getStartDate()).split("-");
        String[] t2 = sdf.format(tem.getEndDate()).split("-");
        checkInDate.setValue(LocalDate.of(tem.getStartDate().getYear()+1900,tem.getStartDate().getMonth()+1,Integer.parseInt(t1[2])));
        checkOutDate.setValue(LocalDate.of(tem.getEndDate().getYear()+1900,tem.getEndDate().getMonth()+1,Integer.parseInt(t2[2])));
    }
    @FXML
    private void onDeleteDateP(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = promotion.getHotelDatePromotionList().get(table.getSelectionModel().getSelectedIndex());
        promotion.deletePromotion(tem.getPromotionID());
        onPromotionManager(E);
    }
    @FXML
    private void confirmChangePromotion(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = promotion.getHotelDatePromotionList().get(table.getSelectionModel().getSelectedIndex());
        TextField DatePromotionName = (TextField)minroot.lookup("#DatePromotionName");
        TextField dateDiscount = (TextField)minroot.lookup("#dateDiscount");
        DatePicker checkInDate = (DatePicker)minroot.lookup("#checkInDate");
        DatePicker checkOutDate = (DatePicker)minroot.lookup("#checkOutDate");
        PromotionVO change = new PromotionVO(tem.getPromotionID(),DatePromotionName.toString(), tem.getPromotionType(),hotel.getHotelInformation().getUserID());
        change.setStartDate(new Date(checkInDate.getValue().getYear()-1900,checkInDate.getValue().getMonthValue()-1,checkInDate.getValue().getDayOfMonth()));
        change.setEndDate(new Date(checkOutDate.getValue().getYear()-1900,checkOutDate.getValue().getMonthValue()-1,checkOutDate.getValue().getDayOfMonth()));
        change.setDiscount(Double.parseDouble(dateDiscount.getText().toString()));
        promotion.updatePromotion(change);
        minprimaryStage.close();
        onPromotionManager(E);
    }
    @FXML
    private void confirmAddPromotion(ActionEvent E)throws Exception {
        TextField DatePromotionName = (TextField)minroot.lookup("#DatePromotionName");
        TextField dateDiscount = (TextField)minroot.lookup("#dateDiscount");
        DatePicker checkInDate = (DatePicker)minroot.lookup("#checkInDate");
        DatePicker checkOutDate = (DatePicker)minroot.lookup("#checkOutDate");
        PromotionVO add = new PromotionVO(null,DatePromotionName.toString(), PromotionType.Discount,hotel.getHotelInformation().getUserID());
        add.setStartDate(new Date(checkInDate.getValue().getYear()-1900,checkInDate.getValue().getMonthValue()-1,checkInDate.getValue().getDayOfMonth()));
        add.setEndDate(new Date(checkOutDate.getValue().getYear()-1900,checkOutDate.getValue().getMonthValue()-1,checkOutDate.getValue().getDayOfMonth()));
        add.setDiscount(Double.parseDouble(dateDiscount.getText().toString()));
        promotion.addPromotion(add);
        minprimaryStage.close();
        onPromotionManager(E);
    }
    @FXML
    private void onAddCompanyPromotion(ActionEvent E)throws Exception {
        minprimaryStage = new Stage();
        new HotelAddCompanyPromotionUI().start(minprimaryStage);
    }
    @FXML
    private void onChangeCompanyPromotion(ActionEvent E)throws Exception {
        minprimaryStage = new Stage();
        new HotelChangeCompanyPromotionUI().start(minprimaryStage);
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = promotion.getHotelDatePromotionList().get(table.getSelectionModel().getSelectedIndex());
        TextField Pname = (TextField)minroot.lookup("#Pname");
        TextField name = (TextField)minroot.lookup("#name");
        TextField discount = (TextField)minroot.lookup("#discount");
        Pname.setText(tem.getPromotionName());
        name.setText(tem.getEnterprise());
        discount.setText(""+tem.getDiscount());
    }
    @FXML
    private void onDeleteCompanyPromotion(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = promotion.getHotelDatePromotionList().get(table.getSelectionModel().getSelectedIndex());
        promotion.deletePromotion(tem.getPromotionID());
        onCompanyPromotion(E);
    }
    @FXML
    private void onCompanyPromotion(ActionEvent E)throws Exception {
        new HotelCompanyPromotionUI().start(primaryStage);
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableData> dataForMInfor
                = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        ArrayList<PromotionVO> list = promotion.getEnterprisePromotionList();
        for(int i=0;i<list.size();i++){
            dataForMInfor.add(new TableData(list.get(i).getPromotionName(),list.get(i).getEnterprise(),""+list.get(i).getDiscount()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        table.setItems(dataForMInfor);
    }
    @FXML
    private void onSureAddCp(ActionEvent E)throws Exception {
        TextField Pname = (TextField)minroot.lookup("#Pname");
        TextField name = (TextField)minroot.lookup("#name");
        TextField discount = (TextField)minroot.lookup("#discount");
        PromotionVO add = new PromotionVO(null,Pname.getText().toString(),PromotionType.Discount,hotel.getHotelInformation().getUserID());
        add.setPromotionName(Pname.getText().toString());
        add.setEnterprise(name.getText());
        add.setDiscount(Double.parseDouble(discount.getText().toString()));
        promotion.addPromotion(add);
        minprimaryStage.close();
        onCompanyPromotion(E);
    }
    @FXML
    private void onSureChangeCp(ActionEvent E)throws Exception {
        TableView table = (TableView) root.lookup("#table");
        PromotionVO tem = promotion.getEnterprisePromotionList().get(table.getSelectionModel().getSelectedIndex());
        TextField Pname = (TextField)minroot.lookup("#Pname");
        TextField name = (TextField)minroot.lookup("#name");
        TextField discount = (TextField)minroot.lookup("#discount");
        PromotionVO change = new PromotionVO(tem.getPromotionID(),Pname.getText().toString(),tem.getPromotionType(),hotel.getHotelInformation().getUserID());
        change.setPromotionName(Pname.getText().toString());
        change.setEnterprise(name.getText());
        change.setDiscount(Double.parseDouble(discount.getText().toString()));
        promotion.updatePromotion(change);
        minprimaryStage.close();
        onCompanyPromotion(E);
    }
    @FXML
    private void onRoomManager(ActionEvent E)throws Exception {
        new HotelRoomUI().start(primaryStage);
    }
    @FXML
    private void onAddRoom(ActionEvent E)throws Exception {
        new HotelAddRoomUI().start(primaryStage);
    }
    @FXML
    private void onLogOut(ActionEvent E)throws Exception {
        new LoginUI().start(primaryStage);
    }

}
