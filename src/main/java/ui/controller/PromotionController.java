package ui.controller;

import bl.service.ReserveBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import ui.presentation.SalerFirstUI;
import ui.presentation.SalerAbnormalOrderUI;
import ui.presentation.SalerAddVIPUI;
import ui.presentation.SalerDatePromotionUI;
import ui.presentation.SalerCompanyPromotionUI;
import ui.presentation.SalerVIPUI;
import ui.presentation.LoginUI;

/**
 * Created by 97147 on 2016/11/30.
 */
public class PromotionController {
    private ReserveBLService reserveBL;

    private static Stage primaryStage;
    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }

    @FXML
    private void onPromotion(ActionEvent E) throws Exception{
        new SalerDatePromotionUI().start(primaryStage);
    }
    @FXML
    private void onDatePromotion(ActionEvent E) throws Exception{
        new SalerDatePromotionUI().start(primaryStage);
    }
    @FXML
    private void onCompanyPromotion(ActionEvent E) throws Exception{
        new SalerCompanyPromotionUI().start(primaryStage);
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
    private void onAddVIP(ActionEvent E) throws Exception{
        new SalerAddVIPUI().start(primaryStage);
    }
    @FXML
    private void onLogOut(ActionEvent E) throws Exception{
        new LoginUI().start(primaryStage);
    }
}
