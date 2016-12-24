package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.ManagerController;

/**
 * Created by 97147 on 2016/12/24.
 */
public class ManagerPromptUI extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {
        primaryStage.setTitle("请皇上过目");
        Parent root = FXMLLoader.load(getClass().getResource("ManagerPrompt.fxml"));
        ManagerController.setPromptRoot(root);
        ManagerController.setPromptStage(primaryStage);
        Scene myScene = new Scene(root,410,193);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}