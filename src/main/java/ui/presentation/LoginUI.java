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
import ui.controllerservice.LoginControllerService;

import java.io.IOException;


public class LoginUI extends Application {

    private LoginControllerService controller;

    private Stage primaryStage;
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

    @Override
    public void start (Stage primaryStage) throws IOException {
        primaryStage.setTitle("食宿酒店管理系统");
        Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("view/login.fxml"));
        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
    private void initButtons(){
        signInButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                //controller.signInButtonClicked();
            }
        });
        normalRegiserButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                //controller.normalRegiserClicked();
            }
        });
        normalRegiserButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                //controller.companyRegiserClicked();
            }
        });
    }
    private boolean signIn(String username,String password) {
        return true;
    }
    private boolean normalRegister(){
        try {
            Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("view/normalRegister.fxml"));
            Scene myScene = new Scene(myPane);

            Stage registerStage = new Stage();
            registerStage.setScene(myScene);
            registerStage.setTitle("食宿酒店管理系统");
            registerStage.initModality(Modality.WINDOW_MODAL);
            registerStage.initOwner(primaryStage);
            registerStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean companyRegister(){
        try {
            Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("view/companyRegister.fxml"));
            Scene myScene = new Scene(myPane);
            Stage registerStage = new Stage();
            registerStage.setScene(myScene);
            registerStage.setTitle("食宿酒店管理系统");
            registerStage.initModality(Modality.WINDOW_MODAL);
            registerStage.initOwner(primaryStage);
            registerStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
