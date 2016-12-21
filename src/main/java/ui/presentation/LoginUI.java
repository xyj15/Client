package ui.presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import rmi.RemoteHelper;
import ui.controller.LoginController;

import java.io.IOException;
import java.util.Date;


public class LoginUI extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {
           primaryStage.setTitle("食宿");
           Parent root =FXMLLoader.load(getClass().getResource("login.fxml"));
           LoginController.setRoot(root);
           LoginController.setPrimaryStage(primaryStage);
           Scene myScene = new Scene(root,318,538);
           primaryStage.setResizable(false);
           primaryStage.setScene(myScene);
           primaryStage.show();
    }
    public static void main(String[] args) {
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		remoteHelper.connect();
        launch(args);
    }

}
