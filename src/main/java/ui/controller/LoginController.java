package ui.controller;

import bl.implementation.*;
import bl.service.LoginBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import other.MemberType;
import other.UserType;
import other.roomState;
import ui.presentation.*;
import vo.MemberVO;

import java.time.LocalDate;
import java.util.Date;


/**
 * Created by 婧婧 on 2016/11/27.
 */
public class LoginController{
    private LoginBLService loginBL =new Login();
    private static Parent root;
    private static Parent promptRoot;
    private static Stage primaryStage;
    private static Stage promptPrimaryStage;
    private  static  boolean register =false;
    public static void setPromptPrimaryStage(Stage promptPrimaryStage) {
        LoginController.promptPrimaryStage = promptPrimaryStage;
    }

    public static void setPromptRoot(Parent promptRoot) {
        LoginController.promptRoot = promptRoot;
    }

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
            promptPrimaryStage = new Stage();
            new LoginPromptUI().start(promptPrimaryStage);
            Label message = (Label) promptRoot.lookup("#Message");
            message.setText("网络连接失败");
        }
        else {
            if(loginBL.existUserID(usernameForLog.getText().toString())){
                if(loginBL.login(usernameForLog.getText().toString(),passwordForLog.getText().toString())){
                    UserType userType = loginBL.getUserType(usernameForLog.getText().toString());
                    switch (userType){
                        case Member:
                            new MemberFirstUI().start(primaryStage);
                            MemberController.setSearch(new Search(usernameForLog.getText().toString()));
                            MemberController.setMember(new Member(usernameForLog.getText().toString()));
                            MemberController.setCredit(new Credit(usernameForLog.getText().toString()));
                            MemberController.setOrder(new Order(usernameForLog.getText().toString()));
                            MemberController.setLogin(loginBL);
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
                            PromotionController.setSaler(new Saler(usernameForLog.getText().toString()));
                            PromotionController.setPromotion(new Promotion());
                            break;
                        case Manager:
                            new ManagerFirstUI().start(primaryStage);
                            ManagerController.setManager(new Manager());
                            break;
                    }
                }else{
                    promptPrimaryStage = new Stage();
                    new LoginPromptUI().start(promptPrimaryStage);
                    Label message = (Label) promptRoot.lookup("#Message");
                    message.setText("账号密码不匹配");
                }
            }else{
                promptPrimaryStage = new Stage();
                new LoginPromptUI().start(promptPrimaryStage);
                Label message = (Label) promptRoot.lookup("#Message");
                message.setText("账户不存在");
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
    private void CompanyRegister(ActionEvent E)throws Exception {
        TextField usernameForCR = (TextField)root.lookup("#usernameForCR");
        PasswordField passwordForCR = (PasswordField)root.lookup("#passwordForCR");
        TextField companyName = (TextField)root.lookup("#companyName");
        promptPrimaryStage = new Stage();
        if(loginBL.validPassword(passwordForCR.getText().toString())){
            MemberVO tem = new MemberVO("", passwordForCR.getText().toString(), usernameForCR.getText().toString(),
                    "", 1, 1, MemberType.Bussiness, null, companyName.getText().toString());
            loginBL.register(tem);
            register = true;
            new LoginPrompt2UI().start(promptPrimaryStage);
            Label message = (Label) promptRoot.lookup("#Message");
            Label m = (Label) promptRoot.lookup("#m");
            message.setText("您的ID为：");
            m.setText(tem.getUserID());
        }
    }
    @FXML
    private void sure(ActionEvent E)throws Exception {
        promptPrimaryStage.close();
        if(register){
            new LoginUI().start(primaryStage);
        }
    }
    @FXML
    private void NormalRegister(ActionEvent E)throws Exception {
        TextField username = (TextField)root.lookup("#username");
        PasswordField password = (PasswordField)root.lookup("#password");
        DatePicker birth = (DatePicker)root.lookup("#birth");
        String[] tem = birth.getEditor().getText().split("-");
        promptPrimaryStage = new Stage();
        if(loginBL.validPassword(password.getText().toString())){
            MemberVO t = new MemberVO("", password.getText().toString(), username.getText().toString(), "", 1, 1,
                    MemberType.Orinary, new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2])),"" );
            loginBL.register(t);
            register = true;
            new LoginPrompt2UI().start(promptPrimaryStage);
            Label message = (Label) promptRoot.lookup("#Message");
            Label m = (Label) promptRoot.lookup("#m");
            message.setText("您的ID为：");
            m.setText(t.getUserID());
        }
    }
}

