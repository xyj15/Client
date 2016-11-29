package vo;

import po.PromotionPO;

import java.util.ArrayList;

/**
 * Created by apple on 2016/11/22.
 */
public class SalerVO {
	
	private String salerID;
	private String name;
	private String tel;
	private ArrayList<PromotionVO> promotionList;	//网站促销策略列表
	private ArrayList<OrderVO> abnormalOrderList;	//异常订单列表

    public SalerVO() {
		
	}
}
