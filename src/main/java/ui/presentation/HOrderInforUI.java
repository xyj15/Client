package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.HotelController;

/**
 * Created by 97147 on 2016/12/11.
 */
public class HOrderInforUI extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HOrderInfor.fxml"));
        HotelController.setMidRoot(root);
        HotelController.setMidPrimaryStage(primaryStage);
        Scene myScene = new Scene(root,528,528);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
