package ui.controller;

import bl.implementation.Login;
import bl.service.LoginBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import other.UserType;
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
    private TextField usernameForLog;
    @FXML
    private PasswordField passwordForLog;
    @FXML
    private void onLogIn(ActionEvent E)throws Exception {
        if(!loginBL.checkNetwork()){
            System.out.println("Link failed");
        }
        else {
            if(loginBL.existUserID(usernameForLog.toString())){
                if(loginBL.login(usernameForLog.toString(),passwordForLog.toString())){
                    UserType userType = loginBL.getUserType(usernameForLog.toString());
                    switch (userType){
                        case Member:
                            new MemberFirstUI().start(primaryStage);
                            break;
                        case Hotel:
                            new HotelFirstUI().start(primaryStage);
                        case Saler:
                            new SalerFirstUI().start(primaryStage);
                    }
                }
            }
        }
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

