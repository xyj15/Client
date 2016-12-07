package ui.controller;

import bl.service.HotelBLService;
import bl.stub.HotelBLStub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ui.presentation.*;
import vo.HotelVO;

/**     帮助Hotel模块完成界面转跳以及连接UI层与BL层
 *
 * Created by 庄刚轻 on 2016/11/26.
 */
public class HotelController {


    private HotelBLService hotel = new HotelBLStub();

    private static Stage primaryStage;
    private static Stage minprimaryStage;
    public static void setPrimaryStage(Stage in){
        primaryStage=in;
    }
    private static Parent minroot;
    private static Parent root;

    public static void setMinprimaryStage(Stage minprimaryStage) {
        HotelController.minprimaryStage = minprimaryStage;
    }

    public static void setRoot(Parent root) {
        HotelController.root = root;
    }

    public static void setMinroot(Parent minroot) {
        HotelController.minroot = minroot;
    }

    @FXML
    private void onInfor(ActionEvent E) throws Exception {
        new HotelInformationUI().start(primaryStage);
        TextField name = (TextField)root.lookup("#name");
        TextField address = (TextField)root.lookup("#address");
        TextField district = (TextField)root.lookup("#district");
        TextField level = (TextField)root.lookup("#level");
        TextArea service = (TextArea) root.lookup("#service");
        service.setWrapText(true);
        TextArea introduction = (TextArea) root.lookup("#introduction");
        introduction.setWrapText(true);

        name.setText(hotel.getHotelName());
        address.setText(hotel.getHotelAddress());
        district.setText(hotel.getDistrict());
        level.setText(""+hotel.getHotelLevel());
        service.setText(hotel.getHotelService());
        introduction.setText(hotel.getHotelIntroduction());
    }
    @FXML
    private void onInforChange(ActionEvent E)throws Exception {
        minprimaryStage = new Stage();
        new HotelUpdateInformationUI().start(minprimaryStage);
        TextField name = (TextField)minroot.lookup("#name");
        TextField address = (TextField)minroot.lookup("#address");
        TextField district = (TextField)minroot.lookup("#district");
        TextField level = (TextField)minroot.lookup("#level");
        TextArea service = (TextArea) minroot.lookup("#service");
        service.setWrapText(true);
        TextArea introduction = (TextArea) minroot.lookup("#introduction");
        introduction.setWrapText(true);

        name.setText(hotel.getHotelName());
        address.setText(hotel.getHotelAddress());
        district.setText(hotel.getDistrict());
        level.setText(""+hotel.getHotelLevel());
        service.setText(hotel.getHotelService());
        introduction.setText(hotel.getHotelIntroduction());
    }
    @FXML
    private void onMakeChange(ActionEvent E)throws Exception {          //酒店基本信息改变
        TextField name = (TextField)minroot.lookup("#name");
        TextField address = (TextField)minroot.lookup("#address");
        TextField district = (TextField)minroot.lookup("#district");
        TextField level = (TextField)minroot.lookup("#level");
        TextArea service = (TextArea) minroot.lookup("#service");
        service.setWrapText(true);
        TextArea introduction = (TextArea) minroot.lookup("#introduction");
        introduction.setWrapText(true);

        hotel.setHotelInformation(new HotelVO(hotel.getHotelInformation().getUserID(),hotel.getHotelInformation().getPassword(),name.getText().toString(),
                address.getText().toString(),district.getText().toString(),hotel.getHotelInformation().getCity(),Integer.parseInt(level.getText().toString()),
                hotel.getHotelInformation().getScore(), service.getText().toString(), introduction.getText().toString(),
                hotel.getHotelInformation().getManagerName(),hotel.getHotelManagerTel()));
        minprimaryStage.close();
        onInfor(E);
    }
    @FXML
    private void onOrderManager(ActionEvent E)throws Exception {
        new HotelUnprocessedOrderUI().start(primaryStage);
    }
    @FXML
    private void onProcessedOrder(ActionEvent E)throws Exception {
        new HotelProcessedOrderUI().start(primaryStage);
    }
    @FXML
    private void onCancelOrder(ActionEvent E)throws Exception {
        new HotelOrderUI().start(primaryStage);
    }
    @FXML
    private void onAbnormalOrder(ActionEvent E)throws Exception {
        new HotelAbnormalOrderUI().start(primaryStage);
    }
    @FXML
    private void onDelayOrder(ActionEvent E)throws Exception {
        new HotelDelayOrderUI().start(primaryStage);
    }
    @FXML
    private void onPromotionManager(ActionEvent E)throws Exception {
        new HotelDatePromotionUI().start(primaryStage);
    }
    @FXML
    private void onAddDatePromotion(ActionEvent E)throws Exception {
        new SalerAddPromotionUI().start(primaryStage);
    }
    @FXML
    private void onAddCompanyPromotion(ActionEvent E)throws Exception {
        new SalerAddPromotionUI().start(primaryStage);
    }
    @FXML
    private void onCompanyPromotion(ActionEvent E)throws Exception {
        new HotelCompanyPromotionUI().start(primaryStage);
    }
    @FXML
    private void onRoomManager(ActionEvent E)throws Exception {
        new HotelRoomUI().start(primaryStage);
    }
    @FXML
    private void onAddRoom(ActionEvent E)throws Exception {
        new HotelAddRoomUI().start(primaryStage);
    }
    @FXML
    private void onLogOut(ActionEvent E)throws Exception {
        new LoginUI().start(primaryStage);
    }

}
