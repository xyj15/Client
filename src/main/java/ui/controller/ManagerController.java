package ui.controller;

import bl.implementation.Member;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import other.UserType;
import ui.presentation.*;
import vo.HotelVO;
import vo.SalerVO;

import java.time.LocalDate;
import java.util.Date;


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
				TextField memberName=(TextField)root.lookup("#memberName");
				TextField memberTel=(TextField)root.lookup("#memberTel");
				TextField credit=(TextField)root.lookup("#credit");
				DatePicker birthday=(DatePicker)root.lookup("#birthday");
				memberName.setText(member.getName());
				memberTel.setText(member.getTel());
				credit.setText(String.valueOf(member.getCredit()));
				birthday.setText(member.getBirthday().toString());
				break;
			case Hotel:new ManagerSearchHotelUI().start(primaryStage);
				break;
			case Saler:new ManagerSearchSalerUI().start(primaryStage);
				break;
		}
	}
	@FXML
	private void onAddUser(ActionEvent E)throws Exception {
		new ManagerAddSalerUI().start(primaryStage);

		TextField username=(TextField)root.lookup("#username");
		TextField password=(TextField)root.lookup("#password");
		SalerVO saler=new SalerVO();
		saler.setName(username.getText());
		saler.setPassword(password.getText());
		manager.addSaler(saler);

	}
	@FXML
	private void onAddHotel(ActionEvent E)throws Exception {
		new ManagerAddHotelUI().start(primaryStage);
		TextField hotelName=(TextField)root.lookup("#hotelName");
		TextField password=(TextField)root.lookup("#password");
		TextField address=(TextField)root.lookup("#address");
		TextField district=(TextField)root.lookup("#district");
		TextField level=(TextField)root.lookup("#level");
		TextField service=(TextField)root.lookup("#service");
		TextField introduction=(TextField)root.lookup("#introduction");
		TextField hotelManagerName=(TextField)root.lookup("#hotelManagerName");

		HotelVO hotel=new HotelVO();
		hotel.setPassword(password.getText());
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
