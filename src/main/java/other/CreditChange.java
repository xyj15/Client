package other;

import bl.service.CreditChangeBLService;
import bl.stub.OrderAction;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 97147 on 2016/11/19.
 */
public class CreditChange implements CreditChangeBLService {

    private ArrayList<Double> creditList=new ArrayList<Double>();

    private Date date;                           // 信用变化日期和时间
    private String orderID;                     // 订单号
    private OrderAction action;                 // 导致信用变化的行为
    private double change;                      // 信用度变化
    private double result;                      // 信用度变化后的结果



    @Override
    public ArrayList<Double> getCreditList() {
        return creditList;
    }

}
