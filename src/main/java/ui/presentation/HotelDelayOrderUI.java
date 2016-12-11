package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.HotelController;
import ui.controller.LoginController;

/**
 * Created by 婧婧 on 2016/12/1.
 */
public class HotelDelayOrderUI extends Application {
    @Override
    public void start (Stage primaryStage) throws Exception {
        primaryStage.setTitle("食宿");
        Parent root = FXMLLoader.load(getClass().getResource("HotelDelayOrder.fxml"));
        HotelController.setMinprimaryStage(primaryStage);
        HotelController.setMinroot(root);
        Scene myScene = new Scene(root,318,538);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
