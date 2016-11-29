package ui.controller;

import bl.service.ManagerBLService;
import ui.controllerservice.ManagerControllerService;
import ui.presentation.ManagerUI;
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
public class ManagerController implements ManagerControllerService {
    ManagerUI window ;
    ManagerBLService manager;

    public ManagerController(ManagerUI view){
        window = view;
    }
	
	
	@Override
	public HotelVO getHotel(String hotelID) {
		return null;
	}
	
	@Override
	public boolean addHotel(HotelVO hotel) {
		return false;
	}
	
	@Override
	public boolean updateHotel(HotelVO hotel) {
		return false;
	}
	
	@Override
	public boolean deleteHotel(HotelVO hotel) {
		return false;
	}
	
	@Override
	public MemberVO getMember(String hotelID) {
		return null;
	}
	
	@Override
	public boolean addMember(MemberVO member) {
		return false;
	}
	
	@Override
	public boolean updateMember(MemberVO member) {
		return false;
	}
	
	@Override
	public boolean deleteMember(MemberVO member) {
		return false;
	}
	
	@Override
	public SalerVO getSaler(String account) {
		return null;
	}
	
	@Override
	public boolean addSaler(SalerVO theSaler) {
		return false;
	}
	
	@Override
	public boolean updateSaler(SalerVO theSaler) {
		return false;
	}
	
	@Override
	public boolean deleteSaler(SalerVO theSaler) {
		return false;
	}
	
	@Override
    public void getHotelClicked() {
        window.getHotelClicked();
    }

    @Override
    public void getMemberClicked() {
        window.getMemberClicked();
    }

    @Override
    public void getSalerClicked() {
        window.getSalerClicked();
    }

    @Override
    public void addHotelClicked() {
        window.addHotelClicked();
    }

    @Override
    public void addMemberClicked() {
        window.addMemberClicked();
    }

    @Override
    public void addSalerClicked() {
        window.addSalerClicked();
    }
}
