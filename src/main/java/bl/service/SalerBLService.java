package bl.service;

import vo.OrderVO;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/19.
 * Saler模块bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-30
 */
public interface SalerBLService {
	
	public ArrayList<PromotionVO> getPromotionList();	//获得营销策略列表
	public PromotionVO getPromotion(String promotionID);	//获得营销策略信息
	public boolean createPromotion(PromotionVO promotionVO);	//创建营销策略
	public boolean deletePromotion(String promotionID);	//删除营销策略
	public boolean updatePromotion(String promotionID, PromotionVO promotionVO);	//更新营销策略信息
	
	public boolean setRankInformation(ArrayList<Double> creditList, ArrayList<Double> discountList);	//设置客户升级所需信用表和每个等级的折扣表
	public ArrayList<OrderVO> getDailyUnexcutedOrderList();	//返回每天的未执行订单列表
	public boolean cancelAbnormalOrder(String orderId, double recover);	//撤销异常订单，recover为恢复的信用比例
	public boolean creditRecharge(String memberID, double money);	//信用充值，参数为充值的账户名和充值额度（不用乘100）
}
