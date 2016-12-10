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
public class MemberSearchUI  extends Application implements Initializable {

//    @FXML
//    private ComboBox<roomTypeChoice> roomTypeInsearch;
    Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("MemberSearchU.fxml"));
        MemberController.setPrimaryStage(primaryStage);
        MemberController.setRoot(root);
        Scene myScene = new Scene(root,960,540);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        ComboBox<roomTypeChoice> roomTypeInsearch =(ComboBox<roomTypeChoice>)root.lookup("roomTypeInsearch");
        roomTypeInsearch.getItems().add(new roomTypeChoice(RoomType.Single.toString()));
        roomTypeInsearch.getItems().add(new roomTypeChoice(RoomType.Single.toString()));
        roomTypeInsearch.getItems().add(new roomTypeChoice(RoomType.Single.toString()));
        roomTypeInsearch.getSelectionModel().select(1);
    }
}
