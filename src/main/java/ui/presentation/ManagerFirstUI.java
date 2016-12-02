package ui.presentation;

import bl.implementation.Manager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.LoginController;
import ui.controller.ManagerController;
import ui.controller.MemberController;

/**
 * Created by 97147 on 2016/11/30.
 */
public class ManagerFirstUI extends Application {
    private ManagerController controller ;
    @Override
    public void start (Stage primaryStage) throws Exception {
        Parent root =FXMLLoader.load(getClass().getResource("ManagerFirst.fxml"));
        ManagerController.setPrimaryStage(primaryStage);
        Scene myScene = new Scene(root,960,540);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
