package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.LoginController;
import ui.controller.MemberController;

/**
 * Created by 97147 on 2016/11/30.
 */
public class MemberFirstUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root =FXMLLoader.load(getClass().getResource("MemberFirst.fxml"));
        MemberController.setPrimaryStage(primaryStage);
        Scene myScene = new Scene(root,960,540);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
