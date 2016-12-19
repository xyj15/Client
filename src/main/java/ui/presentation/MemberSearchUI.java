package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import other.RoomType;
import other.roomTypeChoice;
import ui.controller.MemberController;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by 97147 on 2016/12/1.
 */
public class MemberSearchUI  extends Application{


    Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("MemberSearchU.fxml"));
        MemberController.setPrimaryStage(primaryStage);
        MemberController.setRoot(root);
        Scene myScene = new Scene(root,1180,660);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
