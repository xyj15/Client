package ui.controllerImpl;

import bl.implementation.Login;
import bl.implementation.Manager;
import bl.service.LoginBLService;
import bl.service.ManagerBLService;
import ui.presentation.ManagerUI;
import vo.HotelVO;


/**
 *
 * 这个类是帮助网站管理人员界面实现具体操作的controller类
 * @author 张新悦
 * @version 2016-11-18 17：18
 * @param
 */
public class ManageUsersControllerImpl {
    ManagerUI window ;
    LoginBLService logger;
    ManagerBLService manager;

    public ManageUsersControllerImpl(ManagerUI view){
        window = view;
        logger = new Login();
        manager = new Manager();
    }

    public HotelVO getHotel(String hotelID){
        return manager.getHotel(hotelID);
    }

    public boolean addHotel(HotelVO hotel){
        return manager.addHotel(hotel);
    }

    public boolean deleteHotel(HotelVO hotel){
        return manager.deleteHotel(hotel);
    }

    public boolean updateHotel(HotelVO hotel){
        return manager.updateHotel(hotel);
    }
}
