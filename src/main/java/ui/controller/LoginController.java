package ui.controller;

import bl.implementation.*;
import bl.service.LoginBLService;
import bl.stub.LoginBLStub;
import bl.stub.PromotionBLStub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import other.MemberType;
import other.UserType;
import ui.presentation.*;
import vo.MemberVO;

import java.time.LocalDate;
import java.util.Date;


/**
 * Created by 婧婧 on 2016/11/27.
 */
public class LoginController{
    private LoginUI loginUI;
    private LoginBLService loginBL =new Login();
    private static Parent root;
    private static Stage primaryStage;
    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }
    public static void setRoot(Parent root) {
        LoginController.root = root;
    }

    @FXML
    private void onLogIn(ActionEvent E)throws Exception {
        TextField usernameForLog = (TextField)root.lookup("#usernameForLog");
        PasswordField passwordForLog = (PasswordField)root.lookup("#passwordForLog");
        if(!loginBL.checkNetwork()){
            System.out.println("Link failed");
        }
        else {
            if(loginBL.existUserID(usernameForLog.toString())){
                if(loginBL.login(usernameForLog.toString(),passwordForLog.toString())){
                    UserType userType = loginBL.getUserType(usernameForLog.toString());
                System.out.print(""+userType );
                    switch (userType){
                        case Member:
                            new MemberFirstUI().start(primaryStage);
                            break;
                        case Hotel:
                            new HotelFirstUI().start(primaryStage);
                            HotelController.setHotel(new Hotel(usernameForLog.getText().toString()));
                            HotelController.setOrder(new Order(usernameForLog.getText().toString()));
                            HotelController.setPromotion(new Promotion(usernameForLog.getText().toString()));
                            HotelController.setRoom(new Room(usernameForLog.getText().toString()));
                            break;
                        case Saler:
                            new SalerFirstUI().start(primaryStage);
                            break;
                        case Manager:
                            new ManagerFirstUI().start(primaryStage);
                            break;
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
        DatePicker birth = (DatePicker)root.lookup("#birth");
        birth.setValue(LocalDate.of(1997,1,1));
    }
    @FXML
    private void onCancel(ActionEvent E)throws Exception {
        new LoginUI().start(primaryStage);
    }

    @FXML
    private void oncRegister(ActionEvent E)throws Exception {
        TextField usernameForCR = (TextField)root.lookup("#usernameForCR");
        PasswordField passwordForCR = (PasswordField)root.lookup("passwordForCR");
        TextField companyName = (TextField)root.lookup("#companyName");
        if(loginBL.validPassword(passwordForCR.getText().toString())){
            loginBL.register(new MemberVO("", passwordForCR.getText().toString(), usernameForCR.getText().toString(),
                    "", 1, 1, MemberType.Bussiness, null, companyName.getText().toString()));
            new LoginUI().start(primaryStage);
        }
    }
    @FXML
    private void onnRegister(ActionEvent E)throws Exception {
        TextField username = (TextField)root.lookup("#username");
        PasswordField password = (PasswordField)root.lookup("password");
        DatePicker birth = (DatePicker)root.lookup("#birth");
        String[] tem = birth.getEditor().getText().split("-");
        if(loginBL.validPassword(password.getText().toString())){
            loginBL.register(new MemberVO("", password.getText().toString(), username.getText().toString(), "", 1, 1,
                    MemberType.Orinary, new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2])),"" ));
            new LoginUI().start(primaryStage);
        }
    }
}

