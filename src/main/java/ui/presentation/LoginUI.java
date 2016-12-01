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
import ui.controller.LoginController;
import ui.controllerservice.LoginControllerService;

import java.io.IOException;


public class LoginUI extends Application {/*
            @FXML
            private Button signInButton;
            @FXML
            private Button normalRegiserButton;
            @FXML
            private Button companyRegiserButton;
            @FXML
            private TextField username;
            @FXML
            private PasswordField password;
        */
    @Override
    public void start (Stage primaryStage) throws Exception {
           primaryStage.setTitle("食宿");
           Parent root =FXMLLoader.load(getClass().getResource("login.fxml"));
           LoginController.setPrimaryStage(primaryStage);
           Scene myScene = new Scene(root,318,538);
           primaryStage.setResizable(false);
           primaryStage.setScene(myScene);
           primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
