package ui.controller;


import bl.service.PromotionBLService;
import bl.service.SalerBLService;
import bl.stub.PromotionBLStub;
import bl.stub.SalerBLStub;
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
import vo.OrderVO;
import vo.PromotionVO;
import bl.implementation.Member;
import bl.implementation.Promotion;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.DateCell;
import static other.UserType.Member;

/**
 * Created by 97147 on 2016/11/30.
 */
public class PromotionController {

    private static Parent root;
    private static Parent minroot;
    private static Stage primaryStage;
    private static Stage minprimaryStage;


    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }
    public static void setRoot(Parent root) {
        PromotionController.root = root;
    }
    public static void setMinroot(Parent minroot) {
        PromotionController.minroot = minroot;
    }
    public static void setMinprimaryStage(Stage minprimaryStage) {
        PromotionController.minprimaryStage = minprimaryStage;
    }

    private static SalerBLService saler;
    private static PromotionBLService promotion;

    public static void setSaler(SalerBLService s) {
        saler = s;
    }

    public static void setPromotion(PromotionBLService p) {
        promotion = p;
    }
//  增加商圈折扣
    @FXML
    private TextField district=new TextField();
    @FXML
    private TextField VipDiscount=new TextField();
//  修改商圈折扣
    @FXML
    private TextField districtUpdate=new TextField();
    @FXML
    private TextField VipDiscountUpdate=new TextField();
//  信用充值
    @FXML
    private TextField memberID=new TextField();
    @FXML
    private TextField credit=new TextField();
//   增加日期营销策略
    @FXML
    private TextField datePromotionName=new TextField();
    @FXML
    private DatePicker checkInDate=new DatePicker();
    @FXML
    private TextField dateDiscount=new TextField();
    @FXML
    private DatePicker checkOutDate=new DatePicker();

    @FXML
    private TableView AbnormalOrderTable=new TableView();
    @FXML
    private TableView promotionTable=new TableView();
    @FXML
    private TableView rankTable=new TableView();
    @FXML
    private TableView districtTable=new TableView();


//   更新日期营销策略
    @FXML
    private TextField datePromotionNameUpdate=new TextField();
    @FXML
    private DatePicker checkInDateUpdate=new DatePicker();
    @FXML
    private TextField dateDiscountUpdate=new TextField();
    @FXML
    private DatePicker checkOutDateUpdate=new DatePicker();
//   增加会员等级
    @FXML
    private TextField vip=new TextField();
    @FXML
    private TextField rankDiscount=new TextField();
    @FXML
    private TextField creditUpgrate=new TextField();
//   更改会员等级
    @FXML
    private TextField vipUpdate=new TextField();
    @FXML
    private TextField rankDiscountUpdate=new TextField();
    @FXML
    private TextField creditUpgrateUpdate=new TextField();







    @FXML
    private void onPromotion() throws Exception{
        new SalerPromotionUI().start(primaryStage);
        TableView promotionTable = (TableView)root.lookup("#promotionTable");
        ObservableList<TableDataForSalerPromotion> dataForSalerPromotion = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = promotionTable.getColumns();
        ArrayList<PromotionVO> list = promotion.getWebDatePromotionList();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       for(int i=0;i<list.size();i++){
            dataForSalerPromotion.add(new TableDataForSalerPromotion(list.get(i).getPromotionName(),sdf.format(list.get(i).getStartDate()),
                    sdf.format(list.get(i).getEndDate()),""+list.get(i).getDiscount()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("name"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("startDate"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("endDate"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("discount"));
        promotionTable.setItems(dataForSalerPromotion);

    }

    @FXML
    private void onAbnormal(ActionEvent E) throws Exception{
        new SalerAbnormalOrderUI().start(primaryStage);
        TableView rankTable = (TableView)root.lookup("#AbnormalOrderTable");
        ObservableList<TableDataForSalerAbnormalOrder> dataForSalerAbnormalOrder = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = AbnormalOrderTable.getColumns();
        ArrayList<OrderVO> list = saler.getDailyUnexcutedOrderList();
        for(int i=0;i<list.size();i++){
            Member member=new Member(list.get(i).getMemberID());
            dataForSalerAbnormalOrder.add(new TableDataForSalerAbnormalOrder(list.get(i).getOrderID(),member.getName(),member.getTel()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("orderID"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("memberName"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("memberTel"));
        AbnormalOrderTable.setItems(dataForSalerAbnormalOrder);
    }
    @FXML
    private void onRank(ActionEvent E) throws Exception{
        new SalerVIPUI().start(primaryStage);
        TableView districtTable = (TableView)root.lookup("#districtTable");

        ObservableList<TableData> dataForDistrict = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = districtTable.getColumns();
        ArrayList<PromotionVO> list = promotion.getDistrictPromotionList();
        for(int i=0;i<list.size();i++) {
            dataForDistrict.add(new TableData(list.get(i).getDistrict(), String.valueOf(list.get(i).getDiscount())));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        districtTable.setItems(dataForDistrict);

        TableView rankTable = (TableView)root.lookup("#rankTable");
        ObservableList<TableData> dataForVip = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList2 = rankTable.getColumns();
        ArrayList<Double> discountList = saler.getDiscountList();
        ArrayList<Double> creditList = saler.getCreditList();
        for(int i=0;i<list.size();i++) {
            dataForVip.add(new TableData("VIP"+(i+1), String.valueOf(discountList.get(i)),String.valueOf(creditList.get(i))));
        }
        tableList2.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList2.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList2.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        rankTable.setItems(dataForVip);
    }
    @FXML
    private void onCredit(ActionEvent E) throws Exception{
        new SalerCreditRechargeUI().start(primaryStage);
    }
    @FXML
    private void onAddVIP(ActionEvent E) throws Exception{
        minprimaryStage = new Stage();
        new SalerAddVIPUI().start(minprimaryStage);
    }
    @FXML
    private void confirmAddVIP(ActionEvent E) throws Exception{
        TextField datePromotionName=(TextField)minroot.lookup("#DatePromotionName");
        TextField district=(TextField)minroot.lookup("#district");
        TextField VipDiscount=(TextField)minroot.lookup("#VipDiscount");
        PromotionVO promotion=new PromotionVO(null,datePromotionName.getText(), PromotionType.Discount);
        promotion.setDistrictPromotion(district.getText(),Double.parseDouble(VipDiscount.getText()),0,0);
        saler.createPromotion(promotion);
    }
    @FXML
    private void onUpdateVIP(ActionEvent E) throws Exception{
        minprimaryStage = new Stage();
        new SalerUpdateVipUI().start(minprimaryStage);

        int i=districtTable.getSelectionModel().getFocusedIndex();
        ArrayList<PromotionVO> list = promotion.getDistrictPromotionList();
        PromotionVO promotion=list.get(i);
        districtUpdate.setText(promotion.getDistrict());
        VipDiscountUpdate.setText(String.valueOf(promotion.getDiscount()));
    }
    @FXML
    private void onDelVIP(ActionEvent E) throws Exception{
        int i=districtTable.getSelectionModel().getFocusedIndex();
        ArrayList<PromotionVO> list = promotion.getDistrictPromotionList();
        PromotionVO promotion=list.get(i);
        saler.deletePromotion(promotion.getPromotionID());
    }
    @FXML
    private void onconfirmUpdateVIP(ActionEvent E) throws Exception{
        int i=districtTable.getSelectionModel().getFocusedIndex();
        ArrayList<PromotionVO> list = promotion.getDistrictPromotionList();
        PromotionVO promotion=list.get(i);
        promotion.setDistrict(districtUpdate.getText());
        promotion.setDiscount(Double.parseDouble(VipDiscountUpdate.getText()));
    }


    @FXML
    private void onAddRank(ActionEvent E) throws Exception{
        minprimaryStage = new Stage();
        new SalerAddRankUI().start(minprimaryStage);
    }
    @FXML
    private void confirmAddRank(ActionEvent E) throws Exception{
        ArrayList<Double> discountList = saler.getDiscountList();
        ArrayList<Double> creditList = saler.getCreditList();
        int level=Integer.parseInt(vip.getText());
        discountList.add(Double.parseDouble(rankDiscount.getText()));
        creditList.add(Double.parseDouble(creditUpgrate.getText()));
    }
    @FXML
    private void onUpdateRank(ActionEvent E) throws Exception{
        minprimaryStage = new Stage();
        new SalerUpdateRankUI().start(minprimaryStage);

        int i=rankTable.getSelectionModel().getFocusedIndex();
        ArrayList<Double> discountList = saler.getDiscountList();
        ArrayList<Double> creditList = saler.getCreditList();
        rankDiscountUpdate.setText(String.valueOf(discountList.get(i)));
        creditUpgrateUpdate.setText(String.valueOf(creditList.get(i)));
    }
    @FXML
    private void onDelRank(ActionEvent E) throws Exception{
        ArrayList<Double> discountList = saler.getDiscountList();
        ArrayList<Double> creditList = saler.getCreditList();
        discountList.remove(discountList.size()-1);
        creditList.remove(creditList.size()-1);
    }
    @FXML
    private void onconfirmUpdateRank(ActionEvent E) throws Exception{
        int i=districtTable.getSelectionModel().getFocusedIndex();
        ArrayList<Double> discountList = saler.getDiscountList();
        ArrayList<Double> creditList = saler.getCreditList();
        discountList.set(i,Double.parseDouble(rankDiscountUpdate.getText()));
        creditList.set(i,Double.parseDouble(creditUpgrateUpdate.getText()));
    }
    @FXML
    private void onAddPromotion(ActionEvent E) throws Exception{
        minprimaryStage = new Stage();
        new SalerAddPromotionUI().start(minprimaryStage);
        TextField datePromotionName=(TextField)minroot.lookup("#DatePromotionName");
        DatePicker checkInDate = (DatePicker)minroot.lookup("#checkInDate");
        DatePicker checkOutDate = (DatePicker)minroot.lookup("#checkOutDate");
        TextField dateDiscount=(TextField)minroot.lookup("#dateDiscount");
        checkInDate.setValue(LocalDate.now());

       final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item.isBefore(
                                        checkInDate.getValue().plusDays(1))
                                        ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        checkOutDate.setDayCellFactory(dayCellFactory);
        checkOutDate.setValue(checkInDate.getValue().plusDays(1));
    }

    @FXML
    private void onUpdatePromotion(ActionEvent E) throws Exception{
        minprimaryStage = new Stage();
        new SalerUpdatePromotionUI().start(minprimaryStage);
        int i=promotionTable.getSelectionModel().getFocusedIndex();
        ArrayList<PromotionVO> list = promotion.getWebDatePromotionList();
        PromotionVO promotion=list.get(i);
        datePromotionNameUpdate.setText(promotion.getPromotionName());
        checkInDateUpdate.setValue(promotion.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        dateDiscountUpdate.setText(String.valueOf(promotion.getDiscount()));
        checkOutDateUpdate.setValue(promotion.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

    }
    @FXML
    private void confirmUpdatePromotion(ActionEvent E) throws Exception{
        int i=promotionTable.getSelectionModel().getFocusedIndex();
        ArrayList<PromotionVO> list = promotion.getWebDatePromotionList();
        PromotionVO promotion=list.get(i);
        Date start=new Date(checkInDate.getValue().getYear(),checkInDate.getValue().getMonthValue(),checkInDate.getValue().getDayOfMonth());
        Date end=new Date(checkOutDate.getValue().getYear(),checkOutDate.getValue().getMonthValue(),checkOutDate.getValue().getDayOfMonth());
        promotion.setDatePromotion(start,end,Double.parseDouble(dateDiscount.getText()),0,0);
        saler.updatePromotion(promotion);
    }
    @FXML
    private void onLogOut(ActionEvent E) throws Exception{
        new LoginUI().start(primaryStage);
    }
    @FXML
    private void halfCredit(ActionEvent E) throws Exception{
        int i=AbnormalOrderTable.getSelectionModel().getFocusedIndex();
        ArrayList<OrderVO> list = saler.getDailyUnexcutedOrderList();
        saler.cancelAbnormalOrder(list.get(i).getOrderID(),0.5);
    }
    @FXML
    private void fullCredit(ActionEvent E) throws Exception{
        int i=AbnormalOrderTable.getSelectionModel().getFocusedIndex();
        ArrayList<OrderVO> list = saler.getDailyUnexcutedOrderList();
        saler.cancelAbnormalOrder(list.get(i).getOrderID(),1);
    }
    @FXML
    private void confirmAddCredit(ActionEvent E) throws Exception{
            saler.creditRecharge(memberID.getText(),Double.parseDouble(credit.getText()));
    }
    @FXML
    private void confirmAddPromotion(ActionEvent E) throws Exception{
        TextField datePromotionName=(TextField)minroot.lookup("#DatePromotionName");
        DatePicker checkInDate = (DatePicker)minroot.lookup("#checkInDate");
        DatePicker checkOutDate = (DatePicker)minroot.lookup("#checkOutDate");
        TextField dateDiscount=(TextField)minroot.lookup("#dateDiscount");
        PromotionVO promotion=new PromotionVO(null,datePromotionName.getText(),PromotionType.Discount);
        Date start=new Date(checkInDate.getValue().getYear(),checkInDate.getValue().getMonthValue(),checkInDate.getValue().getDayOfMonth());
        Date end=new Date(checkOutDate.getValue().getYear(),checkOutDate.getValue().getMonthValue(),checkOutDate.getValue().getDayOfMonth());
        promotion.setDatePromotion(start,end,Double.parseDouble(dateDiscount.getText()),0,0);
        saler.createPromotion(promotion);
    }
}
