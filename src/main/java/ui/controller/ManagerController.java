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
import javafx.scene.control.*;
import javafx.stage.Stage;
import other.UserType;
import sun.security.util.Password;
import ui.presentation.*;
import vo.HotelVO;
import vo.MemberVO;
import vo.SalerVO;

import java.time.ZoneId;
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

	private static ManagerBLService manager;
	private static HotelBLService hotel ;
	private static SalerBLService saler ;
	private static MemberBLService member;

	public static void setSaler(SalerBLService s) {
		saler = s;
	}

	public static void setHotel(HotelBLService h) {
		hotel = h;
	}

	public static void setMember(MemberBLService m) {
		member = m;
	}

	public static void setManager(ManagerBLService m) {
		manager = m;
	}

	@FXML
	private TextField searchID;
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
	private TextArea service;
	@FXML
	private TextArea introduction;
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
//搜索酒店结果
	@FXML
	private TextField hotelNameSearch;
	@FXML
	private TextField hotelManagerTelSearch;
	@FXML
	private TextField addressSearch;
	@FXML
	private TextField districtSearch;
	@FXML
	private TextField levelSearch;
	@FXML
	private TextArea serviceSearch;
	@FXML
	private TextArea introductionSearch;
	@FXML
	private TextField hotelManagerNameSearch;
//搜索营销人员
	@FXML
	private TextField salerNameSearch;
	@FXML
	private TextField salerTelSearch;

	public static void setPrimaryStage(Stage in){
		primaryStage=in;
	}
	public static void setRoot(Parent root) {
		ManagerController.root = root;
	}

	@FXML
	private void onSearchUser(ActionEvent E)throws Exception {
		new ManagerSearchUserUI().start(primaryStage);
		TextField searchID=(TextField)root.lookup("#searchID");
		TextField memberName=(TextField)root.lookup("#memberName");
		TextField memberTel=(TextField)root.lookup("#memberTel");
		TextField credit=(TextField)root.lookup("#credit");
		DatePicker birthday=(DatePicker) root.lookup("#birthday");
		TextField hotelNameSearch=(TextField)root.lookup("#hotelNameSearch");
		TextField addressSearch=(TextField)root.lookup("#addressSearch");
		TextField districtSearch=(TextField)root.lookup("#districtSearch");
		TextField levelSearch=(TextField)root.lookup("#levelSearch");
		TextField introductionSearch=(TextField)root.lookup("#introductionSearch");
		TextField serviceSearch=(TextField)root.lookup("#serviceSearch");
		TextField hotelManagerNameSearch=(TextField)root.lookup("#hotelManagerNameSearch");
		TextField hotelManagerTelSearch=(TextField)root.lookup("#hotelManagerTelSearch");
		TextField salerNameSearch=(TextField)root.lookup("#salerNameSearch");
		TextField salerTelSearch=(TextField)root.lookup("#salerTelSearch");


		UserType userType =manager.getUserType(searchID.getText());
		switch (userType){
			case Member:new ManagerSearchMemberUI().start(primaryStage);
				memberName.setText(member.getName());
				memberTel.setText(member.getTel());
				credit.setText(String.valueOf(member.getCredit()));
				birthday.setValue(member.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				break;
			case Hotel:new ManagerSearchHotelUI().start(primaryStage);
				hotelNameSearch.setText(hotel.getHotelName());
				addressSearch.setText(hotel.getHotelAddress());
				districtSearch.setText(hotel.getDistrict());
				levelSearch.setText(String.valueOf(hotel.getHotelLevel()));
				introductionSearch.setText(hotel.getHotelIntroduction());
				serviceSearch.setText(hotel.getHotelService());
				hotelManagerNameSearch.setText(hotel.getHotelManagerName());
				hotelManagerTelSearch.setText(hotel.getHotelManagerTel());

				break;
			case Saler:new ManagerSearchSalerUI().start(primaryStage);
				salerNameSearch.setText(saler.getSalerInformation().getName());
				salerTelSearch.setText(saler.getSalerInformation().getPassword());
				break;
		}
	}
	@FXML
	private void confirmUpdateMemebr(ActionEvent E)throws Exception {
		TextField memberName=(TextField)root.lookup("#memberName");
		TextField memberTel=(TextField)root.lookup("#memberTel");
		DatePicker birthday=(DatePicker) root.lookup("#birthday");
		MemberVO member=new MemberVO();
		member.setName(memberName.getText());
		member.setTel(memberTel.getText());
		member.setBirthday(new Date(birthday.getValue().getYear(),birthday.getValue().getMonthValue(),birthday.getValue().getDayOfMonth()));
		manager.updateMemberInformation(member);
	}
	@FXML
	private void confirmUpdateSaler(ActionEvent E)throws Exception {
		TextField salerNameSearch=(TextField)root.lookup("#salerNameSearch");
		TextField salerTelSearch=(TextField)root.lookup("#salerTelSearch");
		SalerVO saler=new SalerVO();
		saler.setName(salerNameSearch.getText());
		saler.setTel(salerTelSearch.getText());
		manager.updateSalerInformation(saler);
	}
	@FXML
	private void confirmUpdateHotel(ActionEvent E)throws Exception {
		TextField searchID=(TextField)root.lookup("#searchID");
		TextField hotelManagerNameSearch=(TextField)root.lookup("#hotelManagerNameSearch");
		TextField hotelManagerTelSearch=(TextField)root.lookup("#hotelManagerTelSearch");
		manager.updateHotelManagerInformation(searchID.getText(),hotelManagerNameSearch.getText(),hotelManagerTelSearch.getText());
	}
	@FXML
	private void onAddUser(ActionEvent E)throws Exception {
		new ManagerAddSalerUI().start(primaryStage);
	}
	@FXML
	private void confirmAddSaler(ActionEvent E)throws Exception {
		TextField salerName=(TextField)root.lookup("#salerName");
		PasswordField salerPassword=(PasswordField)root.lookup("#salerPassword");
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
		TextField hotelName=(TextField)root.lookup("#hotelName");
		TextField address=(TextField)root.lookup("#address");
		TextField district=(TextField)root.lookup("#district");
		TextField level=(TextField)root.lookup("#level");
		TextField introduction=(TextField)root.lookup("#introduction");
		TextField service=(TextField)root.lookup("#service");
		TextField hotelManagerName=(TextField)root.lookup("#hotelManagerName");
		TextField hotelManagerTel=(TextField)root.lookup("#hotelManagerTel");
		PasswordField hotelPassword=(PasswordField)root.lookup("#hotelPassword");
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
