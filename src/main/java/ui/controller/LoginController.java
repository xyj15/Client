package ui.controller;

import bl.implementation.*;
import bl.service.LoginBLService;
import bl.stub.LoginBLStub;
import bl.stub.PromotionBLStub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    private static Parent Troot;
    private static Stage primaryStage;
    private static Stage TprimaryStage;
    private  static  boolean zhuce =false;
    public static void setTprimaryStage(Stage tprimaryStage) {
        TprimaryStage = tprimaryStage;
    }

    public static void setTroot(Parent troot) {
        Troot = troot;
    }

    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }
    public static void setRoot(Parent root) {
        LoginController.root = root;
    }

    @FXML
    private void onLogIn(ActionEvent E)throws Exception {
        TprimaryStage = new Stage();
        TextField usernameForLog = (TextField)root.lookup("#usernameForLog");
        PasswordField passwordForLog = (PasswordField)root.lookup("#passwordForLog");
<<<<<<< HEAD
        if(!loginBL.checkNetwork()){
            new LtUI().start(TprimaryStage);
            Label messager = (Label)Troot.lookup("#Message");
            messager.setText("网络连接失败");
        }
        else {
            if(loginBL.existUserID(usernameForLog.getText().toString())){
                if(loginBL.login(usernameForLog.getText().toString(),passwordForLog.getText().toString())){
=======
//        if(!loginBL.checkNetwork()){
//            System.out.println("Link failed");
//        }
//        else {
//         System.out.print(usernameForLog.getText().toString());
            if(loginBL.existUserID(usernameForLog.getText())){
                if(loginBL.login(usernameForLog.getText(), passwordForLog.getText())) {
>>>>>>> refs/remotes/xin541322049/master
                    UserType userType = loginBL.getUserType(usernameForLog.getText().toString());
                    switch (userType){
                        case Member:
                            new MemberFirstUI().start(primaryStage);
                            MemberController.setSearch(new Search(usernameForLog.getText().toString()));
                            MemberController.setMember(new Member(usernameForLog.getText().toString()));
                            MemberController.setCreidt(new Credit(usernameForLog.getText().toString()));
                            MemberController.setOrder(new Order(usernameForLog.getText().toString()));
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
                            PromotionController.setPromotion(new Promotion(usernameForLog.getText().toString()));
                            break;
                        case Manager:
                            new ManagerFirstUI().start(primaryStage);
                            ManagerController.setSaler(new Saler(usernameForLog.getText().toString()));
                            ManagerController.setHotel(new Hotel(usernameForLog.getText().toString()));
                            ManagerController.setMember(new Member(usernameForLog.getText().toString()));
                            ManagerController.setManager(new Manager());
                            break;
                    }
                }else{
                    new LtUI().start(TprimaryStage);
                    Label messager = (Label)Troot.lookup("#Message");
                    messager.setText("账号密码不匹配");
                }
            }else{
                new LtUI().start(TprimaryStage);
                Label messager = (Label)Troot.lookup("#Message");
                messager.setText("账户不存在");
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
        TprimaryStage = new Stage();
        if(loginBL.validPassword(passwordForCR.getText().toString())){
            MemberVO tem = new MemberVO("", passwordForCR.getText().toString(), usernameForCR.getText().toString(),
                    "", 1, 1, MemberType.Bussiness, null, companyName.getText().toString());
            loginBL.register(tem);
            zhuce = true;
            new logintUI().start(TprimaryStage);
            Label messager = (Label)Troot.lookup("#Message");
            Label m = (Label)Troot.lookup("#m");
            messager.setText("您的ID为：");
            m.setText(tem.getUserID());
        }
    }
    @FXML
    private void sure(ActionEvent E)throws Exception {
        TprimaryStage.close();
        if(zhuce){
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
            MemberVO t = new MemberVO("", password.getText().toString(), username.getText().toString(), "", 1, 1,
                    MemberType.Orinary, new Date(Integer.parseInt(tem[0])-1900,Integer.parseInt(tem[1])-1,Integer.parseInt(tem[2])),"" );
            loginBL.register(t);
            zhuce = true;
            new logintUI().start(TprimaryStage);
            Label messager = (Label)Troot.lookup("#Message");
            Label m = (Label)Troot.lookup("#m");
            messager.setText("您的ID为：");
            m.setText(t.getUserID());
        }
    }
}

