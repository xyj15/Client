package ui.presentation;

import bl.implementation.Member;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.HotelController;
import ui.controller.MemberController;

/**
 * Created by 97147 on 2016/12/21.
 */
public class changePassUI extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("changePass.fxml"));
        MemberController.setMinprimaryStage(primaryStage);
        MemberController.setMinroot(root);
        Scene myScene = new Scene(root,318,538);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}