package bl.implementation;

import data.service.OrderDataService;
import data.service.PromotionDataService;
import data.service.SalerDataService;
import bl.service.SalerBLService;
import other.Rank;
import po.SalerPO;
import vo.OrderVO;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * Saler模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Saler implements SalerBLService {
    
    private SalerPO salerPO;
	private Promotion promotion;
	private Order order;
	private Rank rank;
	
	private SalerDataService salerDataService;
	private PromotionDataService promotionDataService;
	private OrderDataService orderDataService;
	
	public Saler(String salerID) {
		salerPO = salerDataService.getSaler(salerID);
		
	}
	
	public Saler() {
		
	}
	
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
