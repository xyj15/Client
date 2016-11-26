package ui.controllerservice;

import vo.MemberVO;
import vo.OrderVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 97147 on 2016/11/26.
 */
public interface MemberControllerService {

    public MemberVO getMInformation(String memberID);
    public boolean changeMInformation();
    public boolean saveMInformation(String memberID,MemberVO M);
    public boolean show ();
    public OrderVO getOrder(String orderID);
    public List<OrderVO> gerOrderList(String userID);
    public boolean cancelOrder(String orderID);
    public ArrayList<OrderVO> getUnOrder(String orderID);
    public  ArrayList<OrderVO> getAlOrder(String orderID);
    public ArrayList<OrderVO> getAandCOrder(String orderID);
}
