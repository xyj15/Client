package ui.controller;


import bl.service.HotelBLService;
import bl.service.ManagerBLService;
import bl.service.MemberBLService;
import bl.service.SalerBLService;
import bl.stub.HotelBLStub;
import bl.stub.ManagerBLStub;
import bl.stub.MemberBLStub;
import bl.stub.SalerBLStub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import other.UserType;
import ui.presentation.*;
import vo.HotelVO;
import vo.SalerVO;

import java.time.ZoneId;


/**
 *
 * 这个类是帮助网站管理人员界面实现具体操作的controller类
 * @author 张新悦
 * @version 2016-11-18 17：18
 * @param
 */
public class ManagerController{
	private static Parent root;
	private static Stage primaryStage;

	private ManagerBLService manager = new ManagerBLStub();
	private HotelBLService hotel = new HotelBLStub();
	private SalerBLService saler = new SalerBLStub();
	private MemberBLService member = new MemberBLStub();
	@FXML
	private TextField salerName;
	@FXML
	private TextField salerPassword;
	@FXML
	private TextField hotelName;
	@FXML
	private TextField hotelPassword;
	@FXML
	private TextField address;
	@FXML
	private TextField district;
	@FXML
	private TextField level;
	@FXML
	private TextField service;
	@FXML
	private TextField introduction;
	@FXML
	private TextField hotelManagerName;
//搜索客户结果
	@FXML
	private TextField memberName;
	@FXML
	private TextField memberTel;
	@FXML
	private TextField credit;
	@FXML
	private  DatePicker birthday;


	public static void setPrimaryStage(Stage in){
		primaryStage=in;
	}
	public static void setRoot(Parent root) {
		ManagerController.root = root;
	}

	@FXML
	private void onSearchUser(ActionEvent E)throws Exception {
		new ManagerSearchUserUI().start(primaryStage);
		Label searchID=(Label)root.lookup("#searchID");
		UserType userType =manager.getUserType(searchID.toString());
		switch (userType){
			case Member:new ManagerSearchMemberUI().start(primaryStage);
				memberName.setText(member.getName());
				memberTel.setText(member.getTel());
				credit.setText(String.valueOf(member.getCredit()));
				birthday.setValue(member.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				break;
			case Hotel:new ManagerSearchHotelUI().start(primaryStage);
				TextField hotelName=(TextField)root.lookup("#hotelName");
				TextField address=(TextField)root.lookup("#address");
				TextField district=(TextField)root.lookup("#district");
				TextField level=(TextField)root.lookup("#level");
				TextField introduction=(TextField)root.lookup("#introduction");
				TextField service=(TextField)root.lookup("#service");
				TextField hotelManagerName=(TextField)root.lookup("#hotelManagerName");
				TextField hotelPassword=(TextField)root.lookup("#hotelPassword");
				hotelName.setText(hotel.getHotelName());
				address.setText(hotel.getHotelAddress());
				district.setText(hotel.getDistrict());
				level.setText(String.valueOf(hotel.getHotelLevel()));
				introduction.setText(hotel.getHotelIntroduction());
				service.setText(hotel.getHotelService());
				hotelManagerName.setText(hotel.getHotelManagerName());
				//hotelPassword.setText(hotel.password);
				break;
			case Saler:new ManagerSearchSalerUI().start(primaryStage);
				TextField salerName=(TextField)root.lookup("#salerName");
				PasswordField password=(PasswordField)root.lookup("#password");
				salerName.setText(saler.getSalerInformation().getName());
				password.setText(saler.getSalerInformation().getPassword());
				break;
		}
	}
	@FXML
	private void confirm(ActionEvent E)throws Exception {
		new ManagerAddSalerUI().start(primaryStage);
	}
	@FXML
	private void onAddUser(ActionEvent E)throws Exception {
		new ManagerAddSalerUI().start(primaryStage);
	}
	@FXML
	private void confirmAddSaler(ActionEvent E)throws Exception {
		SalerVO saler=new SalerVO();
		saler.setName(salerName.getText());
		saler.setPassword(salerPassword.getText());
		manager.addSaler(saler);
	}
	@FXML
	private void onAddHotel(ActionEvent E)throws Exception {
		new ManagerAddHotelUI().start(primaryStage);

	}
	@FXML
	private void confirmAddHotel(ActionEvent E)throws Exception {
		HotelVO hotel=new HotelVO();
		hotel.setPassword(hotelPassword.getText());
		hotel.setName(hotelName.getText());
		hotel.setAddress(address.getText());
		hotel.setDistrict(district.getText());
		hotel.setLevel(Integer.parseInt(level.getText()));
		hotel.setIntroduction(introduction.getText());
		hotel.setService(service.getText());
		hotel.setManagerName(hotelManagerName.getText());
		manager.addHotel(hotel);
	}
	@FXML
	private void onLogOut(ActionEvent E)throws Exception {
		new LoginUI().start(primaryStage);
	}

}
