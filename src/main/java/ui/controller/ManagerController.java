package ui.controller;


import bl.implementation.Hotel;
import bl.implementation.Member;
import bl.implementation.Saler;
import bl.implementation.Search;
import bl.service.*;
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
import other.roomState;
import sun.security.util.Password;
import ui.presentation.*;
import vo.HotelVO;
import vo.MemberVO;
import vo.SalerVO;

import java.time.ZoneId;
import java.util.ArrayList;
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
	private static Parent PromptRoot;
	private static Stage primaryStage;
	private static Parent midRoot;
	private static Stage MidStage;
	private static Stage PromptStage;

	private static ManagerBLService manager;
	private static HotelBLService hotel ;
	private static SalerBLService saler ;
	private static MemberBLService member;
	private static SearchBLService search = new Search("000000");

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

	public static void setPromptRoot(Parent promptRoot) {
		PromptRoot = promptRoot;
	}

	public static void setPromptStage(Stage promptStage) {
		PromptStage = promptStage;
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
				Label credit=(Label) midRoot.lookup("#credit");//客户信用
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
					introductionSearch.setWrapText(true);
					serviceSearch.setWrapText(true);
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
				TextField salerTelSearch=(TextField)midRoot.lookup("#tel");//营销人员电话
				salerNameSearch.setText(saler.getSalerInformation().getName());
				salerTelSearch.setText(saler.getSalerInformation().getTel());
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
		if(manager.updateSalerInformation(saler)){
			MidStage.close();
			PromptStage = new Stage();
			new ManagerPromptUI().start(PromptStage);
			Label message = (Label)PromptRoot.lookup("#Message");
			message.setText("营销人员信息更新成功");
		}
		else{
			PromptStage = new Stage();
			new ManagerPromptUI().start(PromptStage);
			Label message = (Label)PromptRoot.lookup("#Message");
			message.setText("营销人员信息更新失败");
		}
	}
	/**
	 *
	 *修改酒店管理人员
	 */
	@FXML
	private void confirmUpdateHotel(ActionEvent E)throws Exception {
		TextField searchID=(TextField)root.lookup("#searchID");//搜索时输入的用户ID
		TextField hotelManagerNameSearch=(TextField)midRoot.lookup("#hotelManagerNameSearch");//酒店工作人员名字
		TextField hotelManagerTelSearch=(TextField)midRoot.lookup("#hotelManagerTelSearch");//酒店工作人员电话
		if(manager.updateHotelManagerInformation(searchID.getText(),hotelManagerNameSearch.getText(),hotelManagerTelSearch.getText())){
			MidStage.close();
			PromptStage = new Stage();
			new ManagerPromptUI().start(PromptStage);
			Label message = (Label)PromptRoot.lookup("#Message");
			message.setText("酒店工作人员信息更新成功");
		}
		else{
			PromptStage = new Stage();
			new ManagerPromptUI().start(PromptStage);
			Label message = (Label)PromptRoot.lookup("#Message");
			message.setText("酒店工作人员信息更新失败");
		}
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
		TextField tel=(TextField)root.lookup("#tel");//营销人员电话
		PasswordField password=(PasswordField)root.lookup("#password");
		if(salerName.getText().toString().equals("")||tel.getText().toString().equals("")
				||password.getText().toString().equals("")){
			PromptStage = new Stage();
			new ManagerPromptUI().start(PromptStage);
			Label message = (Label)PromptRoot.lookup("#Message");
			message.setText("请完善营销人员信息");
		}else{
			SalerVO saler=new SalerVO();
			saler.setName(salerName.getText().toString());
			saler.setPassword(password.getText().toString());
			saler.setTel(tel.getText().toString());
			manager.addSaler(saler);
			PromptStage = new Stage();
			new ManagerPrompt2UI().start(PromptStage);
			Label message = (Label) PromptRoot.lookup("#Message");
			Label m = (Label) PromptRoot.lookup("#m");
			message.setText("您的ID为：");
			m.setText(saler.getUserID());
		}

	}
	/**
	 *
	 *增加酒店界面
	 */
	@FXML
	private void onAddHotel(ActionEvent E)throws Exception {
		new ManagerAddHotelUI().start(primaryStage);
		TextArea introduction=(TextArea)root.lookup("#introduction");
		TextArea service=(TextArea)root.lookup("#service");
		ComboBox<roomState> city = (ComboBox<roomState>)root.lookup("#city") ;
		introduction.setWrapText(true);
		service.setWrapText(true);
		ArrayList<String> cityList = search.getCityList();
		for(int i = 0 ; i < cityList.size() ; i++){
			city.getItems().add(new roomState(cityList.get(i)));
		}
	}

	/**
	 * 关闭提示面板
	 * @param E
	 * @throws Exception
	 */
	@FXML
	private void sure(ActionEvent E)throws Exception {
		PromptStage.close();
	}

	/**
	 * 帮助商圈信息初始化
	 * @param E
	 * @throws Exception
	 */
	@FXML
	private void onDistrict(ActionEvent E)throws Exception {
		ComboBox<roomState> city = (ComboBox<roomState>)root.lookup("#city") ;
		ComboBox<roomState> district = (ComboBox<roomState>)root.lookup("#district") ;
		if(city.getSelectionModel().getSelectedItem()==null){
			PromptStage = new Stage();
			new ManagerPromptUI().start(PromptStage);
			Label message = (Label)PromptRoot.lookup("#Message");
			message.setText("请先选择城市");
		}
		else{
			ArrayList<String> districtList = search.getDistrictList(city.getSelectionModel().getSelectedItem().toString());
			district.getItems().clear();
			for( int i = 0 ; i<districtList.size();i++){
				district.getItems().add(new roomState(districtList.get(i)));
			}
		}
	}
	/**
	 *
	 *增加酒店
	 */
	@FXML
	private void confirmAddHotel(ActionEvent E)throws Exception {
		TextField hotelName=(TextField)root.lookup("#hotelName");
		TextField address=(TextField)root.lookup("#address");
		ComboBox<roomState> district=(ComboBox<roomState>)root.lookup("#district");
		ComboBox<roomState> city=(ComboBox<roomState>)root.lookup("#city");
		TextField level=(TextField)root.lookup("#level");
		TextArea introduction=(TextArea)root.lookup("#introduction");
		TextArea service=(TextArea)root.lookup("#service");
		TextField hotelManagerName=(TextField)root.lookup("#hotelManagerName");
		TextField tel=(TextField)root.lookup("#tel");
		PasswordField password=(PasswordField) root.lookup("#password");
		HotelVO hotel=new HotelVO();
		hotel.setName(hotelName.getText());
		hotel.setAddress(address.getText());
		hotel.setCity(city.getSelectionModel().getSelectedItem().toString());
		hotel.setDistrict(district.getSelectionModel().getSelectedItem().toString());
		hotel.setLevel(Integer.parseInt(level.getText()));
		hotel.setIntroduction(introduction.getText());
		hotel.setService(service.getText());
		hotel.setManagerName(hotelManagerName.getText());
		hotel.setManagerTel(tel.getText());
		hotel.setPassword(password.getText());
		manager.addHotel(hotel);
		PromptStage = new Stage();
		new ManagerPrompt2UI().start(PromptStage);
		Label message = (Label) PromptRoot.lookup("#Message");
		Label m = (Label) PromptRoot.lookup("#m");
		message.setText("您的ID为：");
		m.setText(hotel.getUserID());
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
