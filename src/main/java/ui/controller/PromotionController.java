package ui.controller;

import bl.service.ReserveBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import ui.presentation.SalerFirstUI;

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
        new SalerFirstUI().start(primaryStage);
    }
    @FXML
    private void onAbnormal(ActionEvent E) throws Exception{
        new SalerFirstUI().start(primaryStage);
    }
    @FXML
    private void onRank(ActionEvent E) throws Exception{
        new SalerFirstUI().start(primaryStage);
    }
    @FXML
    private void onLogOut(ActionEvent E) throws Exception{
        new SalerFirstUI().start(primaryStage);
    }
}
