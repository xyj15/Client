package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.MemberController;

/**
 * Created by 97147 on 2016/12/4.
 */
public class MemberUpdateInformationUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root =FXMLLoader.load(getClass().getResource("MemberUpdateInformation.fxml"));
        MemberController.setMinRoot(root);
        MemberController.setMinPrimaryStage(primaryStage);
        Scene myScene = new Scene(root,318,538);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
