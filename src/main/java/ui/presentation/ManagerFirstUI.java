package ui.presentation;

import bl.implementation.Manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.LoginController;
import ui.controller.ManagerController;

/**
 * Created by 97147 on 2016/11/30.
 */
public class ManagerFirstUI extends Application {
    private ManagerController controller ;
    @Override
    public void start (Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ManagerFirstUI.fxml"));
        Parent root =loader.load();
        controller=loader.getController();
        controller.setPrimaryStage(primaryStage);
        Scene myScene = new Scene(root);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
