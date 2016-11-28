package ui.controller;

import bl.implementation.Member;
import bl.service.MemberBLService;
import ui.controllerservice.MemberControllerService;
import ui.presentation.MemberUI;
import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 97147 on 2016/11/26.
 */
public class MemberController implements MemberControllerService {

    private MemberUI memberUI;
    private MemberBLService memberBL = new Member();

    public   MemberController(MemberUI memberUI){
        this.memberUI=memberUI;
    }

    @Override
    public MemberVO getMInformation(String memberID) {
        return null;
    }
    
    @Override
    public boolean changeMInformation() {
        memberUI.changeMInformation();
        return true;
    }

    @Override
    public boolean saveMInformation(String memberID, MemberVO M) {
        memberBL.setMemberInformation(M);
        return true;
    }

    @Override
    public boolean show() {
        memberUI.show();
        return true;
    }

    @Override
    public OrderVO getOrder(String orderID) {
        return null;
    }

    @Override
    public List<OrderVO> gerOrderList(String userID) {
        return null;
    }

    @Override
    public boolean cancelOrder(String orderID) {
        memberBL.cancelOrder(orderID);
        return true;
    }

    @Override
    public ArrayList<OrderVO> getUnOrder(String userID) {
        return null;
    }

    @Override
    public ArrayList<OrderVO> getAlOrder(String userID) {
        return null;
    }

    @Override
    public ArrayList<OrderVO> getAandCOrder(String userID) {
        return null;
    }


    public void getMInformationButtonClicked(){
        memberUI.getMInformationButtonClicked();
    }

    public void saveMInformationButtonClicked(){
        memberUI.saveMInformationButtonClicked();
    }
    public void getCreditInforButtonClicked(){
        memberUI.getCreditInforButtonClicked();
    }
    public void getPastHotelButtonClicked(){
        memberUI.getPastHotelButtonClicked();
    }public void searchButtonClicked(){
        memberUI.searchButtonClicked();
    }public void searchPastButtonClicked(){
        memberUI.searchPastButtonClicked();
    }public void reserveButtonClicked(){
        memberUI.reserveButtonClicked();
    }
}
