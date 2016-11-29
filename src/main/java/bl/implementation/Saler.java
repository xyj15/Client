package bl.implementation;

import bl.service.SalerBLService;
import other.User;
import po.SalerPO;
import vo.OrderVO;
import vo.SalerVO;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/19.
 */
public class Saler implements SalerBLService {
    
    private SalerVO salerVO;
    private SalerPO salerPO;
    
    private Rank rank = Rank.getInstance();
//
//    private ArrayList<OrderVO> dailyUndoneOrderList = new ArrayList<OrderVO>();
//    private double returnCredit;
}
