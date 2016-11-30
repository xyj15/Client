package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import other.UserType;
import ui.controllerservice.LoginControllerService;
import bl.implementation.Login;
import bl.service.LoginBLService;
import ui.presentation.*;


/**
 * Created by 婧婧 on 2016/11/27.
 */
public class LoginController{
    private LoginUI loginUI;
    private LoginBLService loginBL = new Login();

    private static Stage primaryStage;
    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }


    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    /*@FXML
    private void onLogIn(ActionEvent E)throws Exception {
        UserType userType = loginBL.getUserType(username.toString());
        switch (userType){
            case Member:
                new MemberFirstUI().start(primaryStage);
                break;
            case Hotel:
HotelFirstUI()   SalerFirstUI()
            case Manager:

        }
    }*/
    @FXML
    private void onLogIn(ActionEvent E) throws Exception{
        new SalerFirstUI().start(primaryStage);
    }
    @FXML
    private void onCompanyRegister(ActionEvent E)throws Exception {
        new CompanyRegisterUI().start(primaryStage);
    }
    @FXML
    private void onNormalRegiser(ActionEvent E)throws Exception {
        new NormalRegiserUI().start(primaryStage);
    }
    @FXML
    private void onCancel(ActionEvent E)throws Exception {
        new LoginUI().start(primaryStage);
    }
}

