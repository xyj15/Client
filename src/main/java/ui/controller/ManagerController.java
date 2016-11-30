package ui.controller;

import bl.service.ManagerBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import ui.controllerservice.ManagerControllerService;
import ui.presentation.ManagerSearchUserUI;
import vo.HotelVO;
import vo.MemberVO;
import vo.SalerVO;


/**
 *
 * 这个类是帮助网站管理人员界面实现具体操作的controller类
 * @author 张新悦
 * @version 2016-11-18 17：18
 * @param
 */
public class ManagerController{
    ManagerBLService manager;


	private Stage primaryStage;
	public void setPrimaryStage(Stage in){
		primaryStage=in;
	}

	@FXML
	private void onSearchUser(ActionEvent E)throws Exception {
		new ManagerSearchUserUI().start(primaryStage);
	}

}
