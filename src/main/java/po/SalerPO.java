package po;

import other.User;

import java.util.ArrayList;

/**
 * Created by apple on 2016/11/22.
 */
public class SalerPO extends User {
    
    private String name;
    private String tel;
    private ArrayList<PromotionPO> promotionList;	//网站促销策略列表
    private ArrayList<OrderPO> dailyOrderList;	//当天所有订单列表

    public SalerPO() {
        
    }
}
