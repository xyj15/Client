package bl.service;

import vo.OrderVO;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/19.
 */
public interface SalerBLService {
	
	public void createPromotion(PromotionVO promotionVO);
	
	public void setRankInformation(ArrayList<Double> creditList, ArrayList<Double> discountList);	//设置客户升级所需信用表和每个等级的折扣表
	
	public ArrayList<OrderVO> getDailyUnexcutedOrderList();	//返回每天的未执行订单列表
	public void cancelAbnormalOrder(String orderId, double recover);	//撤销异常订单，recover为恢复的信用比例
	public void creditRecharge(String username, double money);	//信用充值，参数为充值的账户名和充值额度（不用乘100）
}
