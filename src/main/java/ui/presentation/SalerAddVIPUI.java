package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.PromotionController;

/**
 * Created by 婧婧 on 2016/11/30.
 */
public class SalerAddVIPUI extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SalerAddVIP.fxml"));
        PromotionController.setPrimaryStage(primaryStage);
        Scene myScene = new Scene(root,318,538);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
