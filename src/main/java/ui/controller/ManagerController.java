package ui.controller;


import bl.implementation.Hotel;
import bl.implementation.Member;
import bl.implementation.Saler;
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
	private static Parent midRoot;
	private static Stage MidStage;

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


	public static void setMidRoot(Parent m) {
		ManagerController.midRoot = m;
	}
	public static void setMidStage(Stage m) {
		MidStage = m;
	}
	public static void setPrimaryStage(Stage in){
		primaryStage=in;
	}
	public static void setRoot(Parent root) {
		ManagerController.root = root;
	}

	/**
	 *
	 *搜索用户界面
	 */
	@FXML
	private void onSearchUser(ActionEvent E)throws Exception {
		new ManagerSearchUserUI().start(primaryStage);


	}
	@FXML
	private void onSearch(ActionEvent E)throws Exception {
		TextField searchID=(TextField)root.lookup("#searchID");//搜索时输入的ID
		UserType userType =manager.getUserType(searchID.getText());
		switch (userType) {
			case Member:
				MidStage=new Stage();
				new ManagerSearchMemberUI().start(MidStage);
				TextField memberName=(TextField)midRoot.lookup("#memberName");//客户名字
				TextField memberTel=(TextField)midRoot.lookup("#memberTel");//客户电话
				TextField credit=(TextField)midRoot.lookup("#credit");//客户信用
				DatePicker birthday=(DatePicker) midRoot.lookup("#birthday");//客户生日
				member=new Member(searchID.getText());
				memberName.setText(member.getName());
				memberTel.setText(member.getTel());
				credit.setText(String.valueOf(member.getCredit()));
				birthday.setValue(member.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				break;

				case Hotel:
				MidStage=new Stage();
				new ManagerSearchHotelUI().start(MidStage);
				TextField hotelNameSearch=(TextField)midRoot.lookup("#hotelNameSearch");//酒店名字
				TextField addressSearch=(TextField)midRoot.lookup("#addressSearch");//酒店地址
				TextField districtSearch=(TextField)midRoot.lookup("#districtSearch");//酒店商圈
				TextField levelSearch=(TextField)midRoot.lookup("#levelSearch");//酒店星级
				TextArea introductionSearch=(TextArea)midRoot.lookup("#introductionSearch");//酒店介绍
				TextArea serviceSearch=(TextArea)midRoot.lookup("#serviceSearch");//酒店服务设施
				TextField hotelManagerNameSearch=(TextField)midRoot.lookup("#hotelManagerNameSearch");//酒店工作人员名字
				TextField hotelManagerTelSearch=(TextField)midRoot.lookup("#hotelManagerTelSearch");//酒店工作人员电话
				hotel=new Hotel(searchID.getText());
				hotelNameSearch.setText(hotel.getHotelName());
				addressSearch.setText(hotel.getHotelAddress());
				districtSearch.setText(hotel.getDistrict());
				levelSearch.setText(String.valueOf(hotel.getHotelLevel()));
				introductionSearch.setText(hotel.getHotelIntroduction());
				serviceSearch.setText(hotel.getHotelService());
				hotelManagerNameSearch.setText(hotel.getHotelManagerName());
				hotelManagerTelSearch.setText(hotel.getHotelManagerTel());

				break;
			case Saler:
				MidStage=new Stage();
				new ManagerSearchSalerUI().start(MidStage);
				saler=new Saler(searchID.getText());
				TextField salerNameSearch=(TextField)midRoot.lookup("#salerNameSearch");//营销人员名字
				TextField salerTelSearch=(TextField)midRoot.lookup("#salerTelSearch");//营销人员电话
				salerNameSearch.setText(saler.getSalerInformation().getName());
				salerTelSearch.setText(saler.getSalerInformation().getPassword());
				break;
		}
	}
	/**
	 *
	 *修改客户
	 */
	@FXML
	private void confirmUpdateMemebr(ActionEvent E)throws Exception {
		TextField searchID=(TextField)root.lookup("#searchID");//搜索时输入的ID
		TextField memberName=(TextField)midRoot.lookup("#memberName");//客户名字
		TextField memberTel=(TextField)midRoot.lookup("#memberTel");//客户电话
		DatePicker birthday=(DatePicker) midRoot.lookup("#birthday");//客户生日
		MemberVO member=new MemberVO();
		member.setUserID(searchID.getText());
		member.setName(memberName.getText());
		member.setTel(memberTel.getText());
		member.setBirthday(new Date(birthday.getValue().getYear(),birthday.getValue().getMonthValue(),birthday.getValue().getDayOfMonth()));
		manager.updateMemberInformation(member);
	}
	/**
	 *
	 *修改营销人员
	 */
	@FXML
	private void confirmUpdateSaler(ActionEvent E)throws Exception {
		TextField searchID=(TextField)root.lookup("#searchID");//搜索时输入的ID
		TextField salerNameSearch=(TextField)midRoot.lookup("#salerNameSearch");//营销人员名字
		TextField salerTelSearch=(TextField)midRoot.lookup("#salerTelSearch");//营销人员电话
		SalerVO saler=new SalerVO();
		saler.setUserID(searchID.getText());
		saler.setName(salerNameSearch.getText());
		saler.setTel(salerTelSearch.getText());
		manager.updateSalerInformation(saler);
	}
	/**
	 *
	 *修改酒店管理人员
	 */
	@FXML
	private void confirmUpdateHotel(ActionEvent E)throws Exception {
		TextField searchID=(TextField)root.lookup("#searchID");//搜索时输入的用户ID
		TextField hotelManagerNameSearch=(TextField)root.lookup("#hotelManagerNameSearch");//酒店工作人员名字
		TextField hotelManagerTelSearch=(TextField)root.lookup("#hotelManagerTelSearch");//酒店工作人员电话
		manager.updateHotelManagerInformation(searchID.getText(),hotelManagerNameSearch.getText(),hotelManagerTelSearch.getText());
	}
	/**
	 *
	 *增加营销人员界面
	 */
	@FXML
	private void onAddUser(ActionEvent E)throws Exception {
		new ManagerAddSalerUI().start(primaryStage);
	}
	/**
	 *
	 *增加营销人员
	 */
	@FXML
	private void confirmAddSaler(ActionEvent E)throws Exception {
		TextField salerName=(TextField)root.lookup("#salerName");//营销人员名字
		PasswordField salerPassword=(PasswordField)root.lookup("#salerPassword");//营销人员电话
		SalerVO saler=new SalerVO();
		saler.setName(salerName.getText());
		saler.setPassword(salerPassword.getText());
		manager.addSaler(saler);
	}
	/**
	 *
	 *增加酒店界面
	 */
	@FXML
	private void onAddHotel(ActionEvent E)throws Exception {
		new ManagerAddHotelUI().start(primaryStage);
	}
	/**
	 *
	 *增加酒店
	 */
	@FXML
	private void confirmAddHotel(ActionEvent E)throws Exception {
		TextField hotelName=(TextField)root.lookup("#hotelName");
		TextField address=(TextField)root.lookup("#address");
		TextField district=(TextField)root.lookup("#district");
		TextField level=(TextField)root.lookup("#level");
		TextArea introduction=(TextArea)root.lookup("#introduction");
		TextArea service=(TextArea)root.lookup("#service");
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
	/**
	 *
	 *注销
	 */
	@FXML
	private void onLogOut(ActionEvent E)throws Exception {
		new LoginUI().start(primaryStage);
	}

}
