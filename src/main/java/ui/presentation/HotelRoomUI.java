package ui.presentation;

import bl.implementation.Hotel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.HotelController;
import ui.controller.PromotionController;

/**
 * Created by 婧婧 on 2016/12/1.
 */
public class HotelRoomUI extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("HotelRoom.fxml"));
        HotelController.setPrimaryStage(primaryStage);
        HotelController.setRoot(root);
        Scene myScene = new Scene(root,1180,660);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
