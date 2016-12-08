package ui.controller;

import bl.service.SalerBLService;
import bl.stub.SalerBLStub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import other.TableDataForSalerPromotion;
import ui.presentation.*;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/30.
 */
public class PromotionController {

    private static Parent root;
    private static Stage primaryStage;


    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }
    public static void setRoot(Parent root) {
        PromotionController.root = root;
    }

    private SalerBLService saler = new SalerBLStub();

    @FXML
    private TextField district=new TextField();
    @FXML
    private TextField discount=new TextField();
    @FXML
    private TextField memberID=new TextField();
    @FXML
    private TextField credit=new TextField();
    @FXML
    private TextField datePromotionName=new TextField();
    @FXML
    private DatePicker checkInDate=new DatePicker();
    @FXML
    private TextField dateDiscount=new TextField();
    @FXML
    private DatePicker checkOutDate=new DatePicker();

    @FXML
    private void onPromotion(ActionEvent E) throws Exception{
        new SalerPromotionUI().start(primaryStage);
        System.out.print("he");
        TableView table = (TableView) root.lookup("#table");
        ObservableList<TableDataForSalerPromotion> dataForSalerPromotion = FXCollections.observableArrayList();
        ObservableList<TableColumn> tableList = table.getColumns();
        ArrayList<PromotionVO> list = saler.getPromotionList();
        for(int i=0;i<list.size();i++){
            dataForSalerPromotion.add(new TableDataForSalerPromotion(list.get(i).getPromotionName(),list.get(i).getStartDate().toString(),
                    list.get(i).getEndDate().toString(),""+list.get(i).getDiscount()));
        }
        tableList.get(0).setCellValueFactory(new PropertyValueFactory("name"));
        tableList.get(1).setCellValueFactory(new PropertyValueFactory("startDate"));
        tableList.get(2).setCellValueFactory(new PropertyValueFactory("endDate"));
        tableList.get(3).setCellValueFactory(new PropertyValueFactory("discount"));
        table.setItems(dataForSalerPromotion);
        
    }
    @FXML
    private void onAbnormal(ActionEvent E) throws Exception{
        new SalerAbnormalOrderUI().start(primaryStage);
    }
    @FXML
    private void onRank(ActionEvent E) throws Exception{
        new SalerVIPUI().start(primaryStage);
    }
    @FXML
    private void onCredit(ActionEvent E) throws Exception{
        new SalerCreditRechargeUI().start(primaryStage);
    }
    @FXML
    private void onAddVIP(ActionEvent E) throws Exception{
        new SalerAddVIPUI().start(primaryStage);
    }
    @FXML
    private void confirmAddVIP(ActionEvent E) throws Exception{
        //saler.setRankInformation()
    }
    @FXML
    private void onAddPromotion(ActionEvent E) throws Exception{
        new SalerAddPromotionUI().start(primaryStage);
    }
    @FXML
    private void onLogOut(ActionEvent E) throws Exception{
        new LoginUI().start(primaryStage);
    }
    @FXML
    private void halfCredit(ActionEvent E) throws Exception{
        //saler.cancelAbnormalOrder(,0.5);
    }
    @FXML
    private void fullCredit(ActionEvent E) throws Exception{
        //saler.cancelAbnormalOrder(,1);
    }
    @FXML
    private void confirmAddCredit(ActionEvent E) throws Exception{
        saler.creditRecharge(memberID.getText(),Double.parseDouble(credit.getText()));
    }
    @FXML
    private void confirmAddCpromotion(ActionEvent E) throws Exception{
        //PromotionVO promotion=new PromotionVO(datePromotionName.getText(),);

        //saler.createPromotion()
    }
}
