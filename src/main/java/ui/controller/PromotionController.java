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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.DateCell;

/**
 * Created by 97147 on 2016/11/30.
 */
public class PromotionController {

    private static Parent root;
    private static Parent minroot;
    private static Parent promptroot;
    private static Stage primaryStage;
    private static Stage minprimaryStage;
    private static Stage promptStage;

    public static void setPromptroot(Parent pr) {
        promptroot = pr;
    }
    public static void setPromptStage(Stage ps) {
        promptStage = ps;
    }
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


    /**
     * 关闭提示框的响应
     * */
    @FXML
    private void sure(ActionEvent E)throws Exception {
        promptStage.close();
    }
    /**
     *
     * 营销策略界面
     */
    @FXML
    private void onPromotion(ActionEvent E) throws Exception{
        new SalerPromotionUI().start(primaryStage);
        TableView promotionTable = (TableView)root.lookup("#promotionTable");//营销策略列表
        ObservableList<TableData> dataForSalerPromotion = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = promotionTable.getColumns();
        ArrayList<PromotionVO> list = promotion.getWebDatePromotionList();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       for(int i=0;i<list.size();i++){
            dataForSalerPromotion.add(new TableData(list.get(i).getPromotionName(),sdf.format(list.get(i).getStartDate()),
                    sdf.format(list.get(i).getEndDate()),""+list.get(i).getDiscount()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("fourth"));
        promotionTable.setItems(dataForSalerPromotion);

    }
    /**
     *
     * 异常订单界面
     */
    @FXML
    private void onAbnormal(ActionEvent E) throws Exception{
        new SalerAbnormalOrderUI().start(primaryStage);
        TableView rankTable = (TableView)root.lookup("#AbnormalOrderTable");//异常订单列表
        ObservableList<TableData> dataForSalerAbnormalOrder = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = rankTable.getColumns();
        ArrayList<OrderVO> list = saler.getDailyUnexcutedOrderList();
        for(int i=0;i<list.size();i++){
            Member member=new Member(list.get(i).getMemberID());
            dataForSalerAbnormalOrder.add(new TableData(list.get(i).getOrderID(),member.getName(),member.getTel()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        rankTable.setItems(dataForSalerAbnormalOrder);
    }
    /**
     *
     * 会员制度界面
     */
    @FXML
    private void onRank(ActionEvent E) throws Exception{
        new SalerVIPUI().start(primaryStage);
        TableView districtTable = (TableView)root.lookup("#districtTable");//商圈折扣列表
        ObservableList<TableData> dataForDistrict = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = districtTable.getColumns();
        ArrayList<PromotionVO> list = promotion.getDistrictPromotionList();
        for(int i=0;i<list.size();i++) {
            dataForDistrict.add(new TableData(list.get(i).getDistrict(), String.valueOf(list.get(i).getDiscount())));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        districtTable.setItems(dataForDistrict);


        TableView rankTable = (TableView)root.lookup("#rankTable");//VIP等级列表
        ObservableList<TableData> dataForVip = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList2 = rankTable.getColumns();
        ArrayList<Double> discountList = saler.getDiscountList();
        ArrayList<Double> creditList = saler.getCreditList();
        for(int i=0;i<creditList.size();i++) {
            dataForVip.add(new TableData("VIP"+(i+1), String.valueOf(discountList.get(i)),String.valueOf(creditList.get(i))));
        }
        tableList2.get(0).setCellValueFactory(new PropertyValueFactory("first"));
        tableList2.get(1).setCellValueFactory(new PropertyValueFactory("second"));
        tableList2.get(2).setCellValueFactory(new PropertyValueFactory("third"));
        rankTable.setItems(dataForVip);
    }
    /**
     *
     * 信用充值界面
     */
    @FXML
    private void onCredit(ActionEvent E) throws Exception{
        new SalerCreditRechargeUI().start(primaryStage);
    }
    /**
     *
     * 增加商圈折扣界面
     */
    @FXML
    private void onAddVIP(ActionEvent E) throws Exception{
        minprimaryStage = new Stage();
        new SalerAddVIPUI().start(minprimaryStage);
    }
    /**
     *
     * 增加商圈折扣
     */
    @FXML
    private void confirmAddVIP(ActionEvent E) throws Exception{
        TextField district=(TextField)minroot.lookup("#district");//商圈
        TextField VipDiscount=(TextField)minroot.lookup("#VipDiscount");//折扣
        if(district.getText().toString().equals("")||VipDiscount.getText().toString().equals("")){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("请输入完整的信息后再确认");
        }else{
            if(Double.parseDouble(VipDiscount.getText().toString())<=0||Double.parseDouble(VipDiscount.getText().toString())>1){
                promptStage = new Stage();
                new SalerPromptUI().start(promptStage);
                Label message = (Label) promptroot.lookup("#Message");
                message.setText("输入折扣信息不符合要求");
            }
            else{
                PromotionVO promotion=new PromotionVO(null,"", PromotionType.Discount);
                promotion.setDistrictPromotion(district.getText(),Double.parseDouble(VipDiscount.getText()),0,0);
                saler.createPromotion(promotion);
                minprimaryStage.close();
                onRank(E);
            }
        }
    }
    /**
     *
     * 更新商圈折扣界面
     */
    @FXML
    private void onUpdateVIP(ActionEvent E) throws Exception{
        TableView districtTable=(TableView)root.lookup("#districtTable");//商圈列表
        if(districtTable.getSelectionModel().getSelectedIndex()==-1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("请先选中表格内容");
        }
        else{
            minprimaryStage = new Stage();
            new SalerUpdateVipUI().start(minprimaryStage);

            TextField districtUpdate=(TextField)minroot.lookup("#districtUpdate");//商圈
            TextField VipDiscountUpdate=(TextField)minroot.lookup("#VipDiscountUpdate");//折扣
            int i = districtTable.getSelectionModel().getSelectedIndex();
            ArrayList<PromotionVO> list = promotion.getDistrictPromotionList();
            PromotionVO promotion=list.get(i);
            districtUpdate.setText(promotion.getDistrict());
            VipDiscountUpdate.setText(String.valueOf(promotion.getDiscount()));
        }
    }
    /**
     *
     * 更新商圈折扣
     */
    @FXML
    private void onconfirmUpdateVIP(ActionEvent E) throws Exception{
        TableView districtTable=(TableView)root.lookup("#districtTable");//商圈列表
        TextField districtUpdate=(TextField)minroot.lookup("#districtUpdate");//商圈
        TextField VipDiscountUpdate=(TextField)minroot.lookup("#VipDiscountUpdate");//折扣
        if(Double.parseDouble(VipDiscountUpdate.getText().toString())<=0||Double.parseDouble(VipDiscountUpdate.getText().toString())>1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("输入折扣信息不符合要求");
        }
        else{
            int i=districtTable.getSelectionModel().getSelectedIndex();
            ArrayList<PromotionVO> list = promotion.getDistrictPromotionList();
            PromotionVO promotion=list.get(i);
            promotion.setDistrict(districtUpdate.getText());
            promotion.setDiscount(Double.parseDouble(VipDiscountUpdate.getText()));
            minprimaryStage.close();
            onRank(E);
        }

    }
    /**
     *
     * 删除商圈折扣
     */
    @FXML
    private void onDelVIP(ActionEvent E) throws Exception {
        TableView districtTable = (TableView) root.lookup("#districtTable");//商圈列表
        if (districtTable.getSelectionModel().getSelectedIndex() == -1) {
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("请先选中表格内容");
        } else {
            int i = districtTable.getSelectionModel().getSelectedIndex();
            ArrayList<PromotionVO> list = promotion.getDistrictPromotionList();
            PromotionVO promotion = list.get(i);
            saler.deletePromotion(promotion.getPromotionID());
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("删除成功");
            onRank(E);
        }
    }

    /**
     *
     * 增加VIP等级以及升级所需经验界面
     */

    @FXML
    private void onAddRank(ActionEvent E) throws Exception{
        minprimaryStage = new Stage();
        new SalerAddRankUI().start(minprimaryStage);
    }
    /**
     *
     * 增加VIP等级以及升级所需经验
     */
    @FXML
    private void confirmAddRank(ActionEvent E) throws Exception{
        TextField rankDiscount=(TextField)minroot.lookup("#rankDiscount");//Vip折扣
        TextField creditUpgrate=(TextField)minroot.lookup("#creditUpgrate");//升级所需经验
        if(rankDiscount.getText().toString().equals("")||creditUpgrate.getText().toString().equals("")){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("请完善信息后再确认");
        }
        else{
            if(Double.parseDouble(rankDiscount.getText().toString())<=0||Double.parseDouble(rankDiscount.getText().toString())>1){
                promptStage = new Stage();
                new SalerPromptUI().start(promptStage);
                Label message = (Label) promptroot.lookup("#Message");
                message.setText("输入折扣信息不符合要求");
            }
            else{
                ArrayList<Double> discountList = saler.getDiscountList();
                ArrayList<Double> creditList = saler.getCreditList();
                discountList.add(Double.parseDouble(rankDiscount.getText()));
                creditList.add(Double.parseDouble(creditUpgrate.getText()));
                saler.setRankInformation(creditList,discountList);
                minprimaryStage.close();
                onRank(E);
            }
        }

    }
    /**
     *
     * 更新VIP等级以及升级所需经验界面
     */
    @FXML
    private void onUpdateRank(ActionEvent E) throws Exception{
        TableView rankTable=(TableView)root.lookup("#rankTable");
        if(rankTable.getSelectionModel().getSelectedIndex()==-1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("请先选中表格内容");
        }
        else{
            minprimaryStage = new Stage();
            new SalerUpdateRankUI().start(minprimaryStage);
            TextField VipDiscountUpdate=(TextField)minroot.lookup("#rankDiscountUpdate");//Vip折扣
            TextField creditUpgrateUpdate=(TextField)minroot.lookup("#creditUpgrateUpdate");//升级所需经验
            int i=rankTable.getSelectionModel().getSelectedIndex();
            ArrayList<Double> discountList = saler.getDiscountList();
            ArrayList<Double> creditList = saler.getCreditList();
            VipDiscountUpdate.setText(String.valueOf(discountList.get(i)));
            creditUpgrateUpdate.setText(String.valueOf(creditList.get(i)));
        }

    }
    /**
     *
     * 更新VIP等级以及升级所需经验
     */
    @FXML
    private void onconfirmUpdateRank(ActionEvent E) throws Exception{
        TableView rankTable=(TableView)root.lookup("#rankTable");//vip列表
        TextField rankDiscountUpdate=(TextField)minroot.lookup("#rankDiscountUpdate");//Vip折扣
        TextField creditUpgrateUpdate=(TextField)minroot.lookup("#creditUpgrateUpdate");//升级所需经验
        if(Double.parseDouble(rankDiscountUpdate.getText().toString())<=0||Double.parseDouble(rankDiscountUpdate.getText().toString())>1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("输入折扣信息不符合要求");
        }else{
            int i=rankTable.getSelectionModel().getSelectedIndex();
            ArrayList<Double> discountList = saler.getDiscountList();
            ArrayList<Double> creditList = saler.getCreditList();
            discountList.set(i,Double.parseDouble(rankDiscountUpdate.getText()));
            creditList.set(i,Double.parseDouble(creditUpgrateUpdate.getText()));
            saler.setRankInformation(creditList,discountList);
            minprimaryStage.close();
            onRank(E);
        }
    }
    /**
     *
     * 删除VIP等级以及升级所需经验界面
     */
    @FXML
    private void onDelRank(ActionEvent E) throws Exception{
        ArrayList<Double> discountList = saler.getDiscountList();
        ArrayList<Double> creditList = saler.getCreditList();
        discountList.remove(discountList.size()-1);
        creditList.remove(creditList.size()-1);
        saler.setRankInformation(creditList,discountList);
        promptStage = new Stage();
        new SalerPromptUI().start(promptStage);
        Label message = (Label) promptroot.lookup("#Message");
        message.setText("删除成功");
        onRank(E);
    }
    /**
     *
     * 增加营销策略界面
     */
    @FXML
    private void onAddPromotion(ActionEvent E) throws Exception{
        minprimaryStage = new Stage();
        new SalerAddPromotionUI().start(minprimaryStage);
        DatePicker checkInDate = (DatePicker)minroot.lookup("#checkInDate");//起始时间
        DatePicker checkOutDate = (DatePicker)minroot.lookup("#checkOutDate");//结束时间
         checkInDate.setValue(LocalDate.now());
        checkOutDate.setDayCellFactory(dateBefore(checkInDate));
        checkOutDate.setValue(checkInDate.getValue().plusDays(1));
    }
    /**
     *
     * 增加营销策略
     */
    @FXML
    private void confirmAddPromotion(ActionEvent E) throws Exception{
        TextField datePromotionName=(TextField)minroot.lookup("#DatePromotionName");//营销策略名称
        DatePicker checkInDate = (DatePicker)minroot.lookup("#checkInDate");//起始时间
        DatePicker checkOutDate = (DatePicker)minroot.lookup("#checkOutDate");//结束时间
        TextField dateDiscount=(TextField)minroot.lookup("#dateDiscount");//折扣
        if(Double.parseDouble(dateDiscount.getText().toString())<=0||Double.parseDouble(dateDiscount.getText().toString())>1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("输入折扣信息不符合要求");
        }else{
            PromotionVO promotion=new PromotionVO(null,datePromotionName.getText().toString(),PromotionType.Discount);
            Date start=new Date(checkInDate.getValue().getYear()-1900,checkInDate.getValue().getMonthValue()-1,checkInDate.getValue().getDayOfMonth());
            Date end=new Date(checkOutDate.getValue().getYear()-1900,checkOutDate.getValue().getMonthValue()-1,checkOutDate.getValue().getDayOfMonth());
            promotion.setDatePromotion(start,end,Double.parseDouble(dateDiscount.getText()),0,0);
            saler.createPromotion(promotion);
            minprimaryStage.close();
            onPromotion(E);
        }
    }
    /**
     *
     * 更新营销策略界面
     */
    @FXML
    private void onUpdatePromotion(ActionEvent E) throws Exception{
        TableView promotionTable=(TableView)root.lookup("#promotionTable") ;//营销策略名称
        minprimaryStage = new Stage();
        new SalerUpdatePromotionUI().start(minprimaryStage);
        TextField datePromotionNameUpdate=(TextField)minroot.lookup("#DatePromotionNameUpdate");//营销策略名称
        DatePicker checkInDateUpdate = (DatePicker)minroot.lookup("#checkInDateUpdate");//起始时间
        DatePicker checkOutDateUpdate = (DatePicker)minroot.lookup("#checkOutDateUpdate");//结束时间
        TextField dateDiscountUpdate=(TextField)minroot.lookup("#dateDiscountUpdate");//折扣
        if(promotionTable.getSelectionModel().getSelectedIndex()==-1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("请先选中表格内容");
        }else {
            int i = promotionTable.getSelectionModel().getSelectedIndex();
            ArrayList<PromotionVO> list = promotion.getWebDatePromotionList();
            PromotionVO promotion = list.get(i);
            datePromotionNameUpdate.setText(promotion.getPromotionName());
            checkInDateUpdate.setValue(promotion.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            dateDiscountUpdate.setText(String.valueOf(promotion.getDiscount()));
            checkOutDateUpdate.setValue(promotion.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            checkOutDateUpdate.setDayCellFactory(dateBefore(checkInDateUpdate));
         }
    }
    /**
     *
     * 开始日期不能迟于结束日期
     */
    private  Callback<DatePicker, DateCell> dateBefore (DatePicker d){
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item.isBefore(
                                        d.getValue().plusDays(1))
                                        ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        return dayCellFactory;
    }
    /**
     *
     * 更新营销策略
     */
    @FXML
    private void confirmUpdatePromotion(ActionEvent E) throws Exception{
        TableView promotionTable=(TableView)root.lookup("#promotionTable") ;//营销策略名称
        TextField datePromotionNameUpdate=(TextField)minroot.lookup("#DatePromotionNameUpdate");//营销策略名称
        DatePicker checkInDateUpdate = (DatePicker)minroot.lookup("#checkInDateUpdate");//起始时间
        DatePicker checkOutDateUpdate = (DatePicker)minroot.lookup("#checkOutDateUpdate");//结束时间
        TextField dateDiscountUpdate=(TextField)minroot.lookup("#dateDiscountUpdate");//折扣
        if(Double.parseDouble(dateDiscountUpdate.getText().toString())<=0||Double.parseDouble(dateDiscountUpdate.getText().toString())>1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("输入折扣信息不符合要求");
        }
        else{
            int i=promotionTable.getSelectionModel().getSelectedIndex();
            ArrayList<PromotionVO> list = promotion.getWebDatePromotionList();
            PromotionVO promotion=list.get(i);
            Date start=new Date(checkInDateUpdate.getValue().getYear()-1900,checkInDateUpdate.getValue().getMonthValue()-1,checkInDateUpdate.getValue().getDayOfMonth());
            Date end=new Date(checkOutDateUpdate.getValue().getYear()-1900,checkOutDateUpdate.getValue().getMonthValue()-1,checkOutDateUpdate.getValue().getDayOfMonth());
            promotion.setDatePromotion(start,end,Double.parseDouble(dateDiscountUpdate.getText()),0,0);
            saler.updatePromotion(promotion);
            minprimaryStage.close();
            onPromotion(E);
        }
    }
    /**
     *
     * 删除VIP等级以及升级所需经验界面
     */
    @FXML
    private void onDelPromotion(ActionEvent E) throws Exception{
        TableView promotionTable=(TableView)root.lookup("#promotionTable") ;//营销策略名称
        if(promotionTable.getSelectionModel().getSelectedIndex()==-1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("请先选中表格内容");
        }else {
            int i=promotionTable.getSelectionModel().getSelectedIndex();
            ArrayList<PromotionVO> list = promotion.getWebDatePromotionList();
            PromotionVO promotion=list.get(i);
            saler.deletePromotion(promotion.getPromotionID());
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("删除成功");

            onPromotion(E);
        }


    }
    /**
     *
     * 注销
     */
    @FXML
    private void onLogOut(ActionEvent E) throws Exception{
        new LoginUI().start(primaryStage);
    }
    /**
     *
     * 恢复异常订单一半信用
     */
    @FXML
    private void halfCredit(ActionEvent E) throws Exception{
        TableView AbnormalOrderTable=(TableView)root.lookup("#AbnormalOrderTable") ;//异常订单列表
        if(AbnormalOrderTable.getSelectionModel().getSelectedIndex()==-1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("请先选中表格内容");
        }
        else{
            int i=AbnormalOrderTable.getSelectionModel().getSelectedIndex();
            ArrayList<OrderVO> list = saler.getDailyUnexcutedOrderList();
            System.out.print(list.get(i).getOrderID());
            saler.cancelAbnormalOrder(list.get(i).getOrderID(),0.5);
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("恢复成功");
            onAbnormal(E);
        }
    }
    /**
     *
     * 恢复异常订单全部信用
     */
    @FXML
    private void fullCredit(ActionEvent E) throws Exception{
        TableView AbnormalOrderTable=(TableView)root.lookup("#AbnormalOrderTable") ;//异常订单列表
        if(AbnormalOrderTable.getSelectionModel().getSelectedIndex()==-1){
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("请先选中表格内容");
        }
        else{
            int i=AbnormalOrderTable.getSelectionModel().getSelectedIndex();
            ArrayList<OrderVO> list = saler.getDailyUnexcutedOrderList();
            saler.cancelAbnormalOrder(list.get(i).getOrderID(),1);
            promptStage = new Stage();
            new SalerPromptUI().start(promptStage);
            Label message = (Label) promptroot.lookup("#Message");
            message.setText("恢复成功");
            onAbnormal(E);
        }
    }
    @FXML
    private void queryCredit(ActionEvent E) throws Exception{
        TextField memberID=(TextField)root.lookup("#memberID");             //用户ID
        Label creditNow = (Label)root.lookup("#creditNow");                 //显示信用
        Member tem = new Member(memberID.getText().toString());
        creditNow.setText(""+tem.getCredit());
    }
    /**
     *
     * 增加充值的信用
     */
    @FXML
    private void confirmAddCredit(ActionEvent E) throws Exception{
        TextField memberID = (TextField)root.lookup("#memberID");             //用户ID
        TextField credit = (TextField)root.lookup("#credit");                 //充值信用
        saler.creditRecharge(memberID.getText(),Double.parseDouble(credit.getText()));
        promptStage = new Stage();
        new SalerPromptUI().start(promptStage);
        Label message = (Label) promptroot.lookup("#Message");
        message.setText("充值成功");
        credit.setText("");
        queryCredit(E);
    }
}
