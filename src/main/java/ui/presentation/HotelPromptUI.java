package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.HotelController;
import ui.controller.LoginController;

/**
 * Created by 97147 on 2017/1/1.
 */
public class HotelPromptUI extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {
        primaryStage.setTitle("请皇上过目");
        Parent root = FXMLLoader.load(getClass().getResource("HotelPrompt.fxml"));
        HotelController.setPromptRoot(root);
        HotelController.setPromptPrimaryStage(primaryStage);
        Scene myScene = new Scene(root,410,193);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}