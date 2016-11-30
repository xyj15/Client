package bl.implementation;

import bl.dataservice.SalerDataService;
import bl.service.SalerBLService;
import po.SalerPO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.SalerVO;

import java.util.ArrayList;

/**
 * Created by 97147 on 2016/11/19.
 */
public class Saler implements SalerBLService {
    
    private SalerVO salerVO;
    private SalerPO salerPO;
	private SalerDataService salerDataService;
	private Promotion promotion;
    
    private Rank rank = Rank.getInstance();
	
	@Override
	public ArrayList<PromotionVO> getPromotionList() {
		return null;
	}
	
	@Override
	public PromotionVO getPromotion(String promotionID) {
		return null;
	}
	
	@Override
	public boolean createPromotion(PromotionVO promotionVO) {
		return false;
	}
	
	@Override
	public boolean deletePromotion(String promotionID) {
		return false;
	}
	
	@Override
	public boolean updatePromotion(String promotionID, PromotionVO promotionVO) {
		return false;
	}
	
	@Override
	public boolean setRankInformation(ArrayList<Double> creditList, ArrayList<Double> discountList) {
		return false;
	}
	
	@Override
	public ArrayList<OrderVO> getDailyUnexcutedOrderList() {
		return null;
	}
	
	@Override
	public boolean cancelAbnormalOrder(String orderId, double recover) {
		return false;
	}
	
	@Override
	public boolean creditRecharge(String username, double money) {
		return false;
	}
}
