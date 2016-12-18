package ui.presentation;

import bl.implementation.Hotel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.HotelController;

/**
 * Created by 97147 on 2016/11/30.
 */
public class HotelFirstUI extends Application {

    @Override
    public void start(Stage primaryStage)throws Exception{
            Parent root =FXMLLoader.load(getClass().getResource("HotelFirst.fxml"));
            HotelController.setPrimaryStage(primaryStage);
            Scene myScene = new Scene(root,1180,660);
            primaryStage.setResizable(false);
            primaryStage.setScene(myScene);
            primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
