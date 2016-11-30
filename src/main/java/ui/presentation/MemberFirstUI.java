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
    private MemberController controller ;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("MemberFirst.fxml"));
        Parent root =loader.load();
        controller=loader.getController();
        controller.setPrimaryStage(primaryStage);
        Scene myScene = new Scene(root);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
