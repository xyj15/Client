package bl.dataservice;

import po.OrderPO;
import po.PromotionPO;
import po.SalerPO;

import java.util.ArrayList;

/**
 * Created by apple on 2016/11/22.
 */
public interface SalerDataService {
	
	public ArrayList<PromotionPO> getPromotionList();
	public PromotionPO getPromotion(String promotionID);
	public void createPromotion(PromotionPO promotionPO);
	public boolean deletePromotion(String promotionID);
	public boolean updatePromotion(String promotionID, PromotionPO promotionPO);
	
	public void setRankInformation(ArrayList<Double> creditList, ArrayList<Double> discountList);	//设置客户升级所需信用表和每个等级的折扣表
	public ArrayList<OrderPO> getOrderList();	//返回所有订单列表
	public void cancelAbnormalOrder(String orderId, double recover);	//撤销异常订单，recover为恢复的信用比例
	public void creditRecharge(String memberID, double credit);	//信用充值，参数为充值的账户名和充值增加的信用
}
