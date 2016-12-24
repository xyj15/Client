package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.ManagerController;

/**
 * Created by 婧婧 on 2016/12/4.
 */
public class ManagerSearchSalerUI extends Application {
    @Override
    public void start (Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ManagerSearchSaler.fxml"));
        ManagerController.setMidStage(primaryStage);
        ManagerController.setMidRoot(root);
        Scene myScene = new Scene(root,528,528);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
