package ui.presentation;

import bl.implementation.Member;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.LoginController;
import ui.controller.MemberController;

/**
 * Created by 97147 on 2016/12/21.
 */
public class MtUI extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {
        primaryStage.setTitle("请皇上过目");
        Parent root = FXMLLoader.load(getClass().getResource("Mt.fxml"));
        MemberController.setTroot(root);
        MemberController.setTprimaryStage(primaryStage);
        Scene myScene = new Scene(root,410,193);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}