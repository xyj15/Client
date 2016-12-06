package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.ManagerController;

/**
 * Created by 婧婧 on 2016/12/2.
 */
public class ManagerAddHotelUI extends Application {
    @Override
    public void start (Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ManagerAddHotel.fxml"));
        ManagerController.setPrimaryStage(primaryStage);
        Scene myScene = new Scene(root,960,540);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

}
