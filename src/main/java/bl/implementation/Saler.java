package bl.implementation;

import bl.service.SalerBLService;
import other.User;
import vo.OrderVO;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/19.
 */
public class Saler extends User implements SalerBLService {
    private Promotion promotion = new Promotion();

    private Rank rank=Rank.getInstance();

    private ArrayList<OrderVO> dailyUndoneOrderList = new ArrayList<OrderVO>();
    private double returnCredit;
}
