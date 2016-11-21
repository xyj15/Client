package ui.controllerImpl;

import bl.implementation.Login;
import bl.implementation.Manager;
import bl.service.LoginBLService;
import bl.service.ManagerBLService;
import ui.controller.ManagerController;
import ui.presentation.ManagerUI;
import vo.HotelVO;
import vo.MemberVO;


/**
 *
 * 这个类是帮助网站管理人员界面实现具体操作的controller类
 * @author 张新悦
 * @version 2016-11-18 17：18
 * @param
 */
public class ManageUsersControllerImpl implements ManagerController{
    ManagerUI window ;
    ManagerBLService manager;

    public ManageUsersControllerImpl(ManagerUI view){
        window = view;
    }

    @Override
    public HotelVO getHotel(String hotelID){

        return manager.getHotel(hotelID);
    }

    @Override
    public boolean addHotel(HotelVO hotel){

        return manager.addHotel(hotel);
    }

    @Override
    public boolean deleteHotel(HotelVO hotel){
        return manager.deleteHotel(hotel);
    }

    @Override
    public boolean updateHotel(HotelVO hotel){
        return manager.updateHotel(hotel);
    }

    @Override
    public MemberVO getMember(String memberID) {
        return manager.getMember(memberID);
    }

    @Override
    public boolean addMember(MemberVO member) {
        return addMember(member);
    }

    @Override
    public boolean updateMember(MemberVO member) {
        return manager.updateMember(member);
    }

    @Override
    public boolean deleteMember(MemberVO member) {
        return deleteMember(member);
    }
}
