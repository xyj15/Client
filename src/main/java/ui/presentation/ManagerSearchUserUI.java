package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.ManagerController;

/**
 * Created by 97147 on 2016/11/30.
 */
public class ManagerSearchUserUI extends Application {
    @Override
    public void start (Stage primaryStage) throws Exception {
        Parent root =FXMLLoader.load(getClass().getResource("ManagerSearchUser.fxml"));
        ManagerController.setPrimaryStage(primaryStage);
        ManagerController.setRoot(root);
        Scene myScene = new Scene(root,1180,660);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
