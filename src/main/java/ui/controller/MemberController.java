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
public class MemberController implements MemberControllerService{

    private MemberUI memberUI;
//    private static MemberController memberController ;
    private MemberBLService memberBL = new Member();

    public   MemberController(MemberUI memberUI){
        this.memberUI=memberUI;
    }

    @Override
    public MemberVO getMInformation(String memberID) {
        return memberBL.getMInformation(memberID);
    }

    @Override
    public boolean changeMInformation() {
        memberUI.changeMInformation();
        return true;
    }

    @Override
    public boolean saveMInformation(String memberID, MemberVO M) {
        memberBL.saveMInformation(memberID,M);
        return true;
    }

    @Override
    public boolean show() {
        memberUI.show();
        return true;
    }

    @Override
    public OrderVO getOrder(String orderID) {
        return memberBL.getOrder(orderID);
    }

    @Override
    public List<OrderVO> gerOrderList(String userID) {
        return memberBL.gerOrderList(userID);
    }

    @Override
    public boolean cancelOrder(String orderID) {
        memberBL.cancelOrder(orderID);
        return true;
    }

    @Override
    public ArrayList<OrderVO> getUnOrder(String orderID) {
        return null;
    }

    @Override
    public ArrayList<OrderVO> getAlOrder(String orderID) {
        return null;
    }

    @Override
    public ArrayList<OrderVO> getAandCOrder(String orderID) {
        return null;
    }
//    public static MemberController getInstance(){
//        return  memberController;
//    }

}
