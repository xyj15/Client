package bl.stub;

import bl.service.SalerBLService;
import other.OrderStatus;
import other.PromotionType;
import vo.OrderVO;
import vo.PromotionVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CROFF on 2016/12/2.
 *
 */
public class SalerBLStub implements SalerBLService {
	
	private PromotionVO promotionVO;
	private OrderVO orderVO;
	
	public SalerBLStub() {
		String promotionID = "00000";
		String promotionName = "";
		PromotionType promotionType = PromotionType.Discount;
		promotionVO = new PromotionVO(promotionID, promotionName, promotionType);
		promotionVO.setRankPromotion();
		
		String memberID = "12345678";
		String hotelID = "123456";
		String orderID = "00000";
		OrderStatus orderStatus = OrderStatus.Executed;
		Date createTime = new Date();
		Date checkinTime = new Date();
		Date actualCheckinTime = new Date();
		Date latestCheckinTime = new Date();
		Date checkoutTime = new Date();
		Date actualCheckoutTime = new Date();
		int numberOfRoom = 4;
		String roomName = "商务大床房";
		int numberOfClient = 4;
		boolean haveKids = false;
		double score = 5;
		String evaluation = "床太硬了不酥服555555";
		double recover = 0.5;
		promotionID = "00000";
		double price = 99999;
		Date cancelTime = new Date();
		orderVO = new OrderVO(memberID, hotelID, orderID, orderStatus, createTime,
				checkinTime, actualCheckinTime, latestCheckinTime, checkoutTime, actualCheckoutTime,
				numberOfRoom, roomName, numberOfClient, haveKids, score, evaluation, recover,
				promotionID, price, cancelTime);
	}
	
	@Override
	public ArrayList<PromotionVO> getPromotionList() {
		System.out.println("获取促销策略列表成功");
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		promotionList.add(promotionVO);
		return promotionList;
	}
	
	@Override
	public PromotionVO getPromotion(String promotionID) {
		System.out.println("获取促销策略成功");
		return promotionVO;
	}
	
	@Override
	public boolean createPromotion(PromotionVO promotionVO) {
		System.out.println("创建促销策略成功");
		return true;
	}
	
	@Override
	public boolean deletePromotion(String promotionID) {
		System.out.println("删除促销策略成功");
		return true;
	}
	
	@Override
	public boolean updatePromotion(String promotionID, PromotionVO promotionVO) {
		System.out.println("更新促销策略信息成功");
		return true;
	}
	
	@Override
	public boolean setRankInformation(ArrayList<Double> creditList, ArrayList<Double> discountList) {
		System.out.println("设置会员等级制度信息成功");
		return true;
	}
	
	@Override
	public ArrayList<OrderVO> getDailyUnexcutedOrderList() {
		System.out.println("获取每天未执行订单列表成功");
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		orderList.add(orderVO);
		return orderList;
	}
	
	@Override
	public boolean cancelAbnormalOrder(String orderId, double recover) {
		System.out.println("取消异常订单成功");
		return true;
	}
	
	@Override
	public boolean creditRecharge(String memberID, double money) {
		System.out.println("信用充值成功");
		return true;
	}
}
