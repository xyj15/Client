package po;

import java.util.ArrayList;

/**
 * Created by apple on 2016/11/22.
 */
public class SalerPO {
    
    private String salerID;
    private String name;
    private String tel;
    private ArrayList<PromotionPO> promotionList;	//网站促销策略列表
    private ArrayList<OrderPO> abnormalOrderList;	//异常订单列表

    public SalerPO() {
        
    }
}
