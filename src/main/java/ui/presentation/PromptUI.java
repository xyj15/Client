package ui.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.PromotionController;

/**
 * Created by 婧婧 on 2016/12/20.
 */
public class PromptUI extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("prompt.fxml"));
        PromotionController.setPromptStage(primaryStage);
        PromotionController.setPromptroot(root);
        Scene myScene = new Scene(root,318,538);
        primaryStage.setResizable(false);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
}
