package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.MemberController;

/**
 * Created by 97147 on 2016/12/1.
 */
public class MemberHotelInformationInhisUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MemberHotelInformationInhis.fxml"));
        MemberController.setMidprimaryStage(primaryStage);
        MemberController.setMidroot(root);
        Scene myScene = new Scene(root,740,528);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
