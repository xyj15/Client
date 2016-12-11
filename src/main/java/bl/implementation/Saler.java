package bl.implementation;

import bl.service.SalerBLService;
import data.service.SalerDataService;
import data.stub.SalerDataStub;
import other.OrderAction;
import po.SalerPO;
import rmi.RemoteHelper;
import vo.CreditChangeVO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.SalerVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Saler模块bl的实现类
 * @author CROFF
 * @version 2016-12-5
 */
public class Saler implements SalerBLService {
    
	private String salerID;	//营销人员ID
    private SalerVO salerVO;	//营销人员信息
	private Promotion promotion;	//促销策略管理
	private Rank rank;	//会员等级制度管理
	private Order order;	//订单管理
	private Credit credit;	//信用管理
	
	private SalerDataService salerDataService;
	
	/**
	 * 增加新的营销人员调用这个构造方法
	 */
	public Saler(SalerVO salerVO) {
//		salerDataService = new SalerDataStub();
		salerDataService = RemoteHelper.getInstance().getSalerDataService();
		salerVO.setUserID(salerDataService.getAvailableSalerID());
		this.salerID = salerVO.getUserID();
		salerDataService.addSaler(salerVOtoPO(salerVO));
	}
	
	/**
	 * 构造方法，需要提供营销人员ID
	 * @param salerID 营销人员ID
	 */
	public Saler(String salerID) {
//		salerDataService = new SalerDataStub();
		salerDataService = RemoteHelper.getInstance().getSalerDataService();
		this.salerID = salerID;
		updateDataFromFile();
	}
	
	/**
	 * 获取营销人员信息
	 * @return 营销人员信息
	 */
	@Override
	public SalerVO getSalerInformation() {
		updateDataFromFile();
		return salerVO;
	}
	
	/**
	 * 设置营销人员的信息
	 * @param salerVO 营销人员信息
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setSalerInformation(SalerVO salerVO) {
		this.salerVO = salerVO;
		SalerPO salerPO = salerVOtoPO(salerVO);
		return salerDataService.updateSaler(salerPO);
	}
	
	/**
	 * 获取网站促销策略列表
	 * @return 获取成功则返回true，否则返回false
	 */
	@Override
	public ArrayList<PromotionVO> getPromotionList() {
		updateDataFromFile();
		return promotion.getWebPromotionList();
	}
	
	/**
	 * 根据ID获取促销策略信息
	 * @param promotionID 促销策略ID
	 * @return 获取成功则返回true，否则返回false
	 */
	@Override
	public PromotionVO getPromotion(String promotionID) {
		updateDataFromFile();
		return promotion.getPromotion(promotionID);
	}
	
	/**
	 * 创建新的促销策略
	 * @param promotionVO 促销策略信息
	 * @return 创建成功则返回true，否则返回false
	 */
	@Override
	public boolean createPromotion(PromotionVO promotionVO) {
		return promotion.addPromotion(promotionVO);
	}
	
	/**
	 * 删除促销策略
	 * @param promotionID 促销策略ID
	 * @return 删除成功则返回true，否则返回false
	 */
	@Override
	public boolean deletePromotion(String promotionID) {
		updateDataFromFile();
		return promotion.deletePromotion(promotionID);
	}
	
	/**
	 * 更新促销策略信息
	 * @param promotionVO 促销策略信息
	 * @return 更新成功则返回true，否则返回false
	 */
	@Override
	public boolean updatePromotion(PromotionVO promotionVO) {
		updateDataFromFile();
		return promotion.updatePromotion(promotionVO);
	}
	
	/**
	 * 设置会员等级制度和折扣信息
	 * @param creditList 会员升级所需信用表
	 * @param discountList 每级对应折扣表
	 * @return 设置成功则返回true，否则返回false
	 */
	@Override
	public boolean setRankInformation(ArrayList<Double> creditList, ArrayList<Double> discountList) {
		updateDataFromFile();
		return rank.setRankInformation(creditList, discountList);
	}
	
	/**
	 * 获取客户升级所需信用表
	 * @return 客户升级所需信用表
	 */
	@Override
	public ArrayList<Double> getCreditList() {
		return rank.getCreditList();
	}
	
	/**
	 * 获取客户每级享受的折扣表
	 * @return 客户每级享受的折扣表
	 */
	@Override
	public ArrayList<Double> getDiscountList() {
		return rank.getDiscountList();
	}
	
	/**
	 * 获取每天未执行订单列表
	 * @return 每天未执行订单列表
	 */
	@Override
	public ArrayList<OrderVO> getDailyUnexcutedOrderList() {
		updateDataFromFile();
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		ArrayList<OrderVO> dailyAbnormalOrderList = order.getAbnormalOrders();
		ArrayList<OrderVO> dailyUnexcutedOrderList = order.getUnexcutedOrders();
		orderList.addAll(dailyAbnormalOrderList);
		orderList.addAll(dailyUnexcutedOrderList);
		return orderList;
	}
	
	/**
	 * 取消异常订单
	 * @param orderID 订单ID
	 * @param recover 恢复信用的比例
	 * @return 取消成功则返回true，否则返回false
	 */
	@Override
	public boolean cancelAbnormalOrder(String orderID, double recover) {
		updateDataFromFile();
		return cancelAbnormalOrder(orderID, recover);
	}
	
	/**
	 * 信用充值
	 * @param memberID 充值的客户ID
	 * @param money 充值的金额
	 * @return 充值成功则返回true，否则返回false
	 */
	@Override
	public boolean creditRecharge(String memberID, double money) {
		updateDataFromFile();
		credit = new Credit(memberID);
		Date date = new Date();
		String orderID = null;
		OrderAction orderAction = OrderAction.RechargeCredit;
		double creditChange = money*100;
		double changeResult = credit.getCredit() - creditChange;
		CreditChangeVO creditChangeVO = new CreditChangeVO(date, orderID, orderAction,
				creditChange, changeResult);
		return credit.addCreditChange(creditChangeVO);
	}
	
	/**
	 * 从Data层更新数据
	 */
	public void updateDataFromFile() {
		promotion = new Promotion();
		order = new Order(salerID);
		SalerPO salerPO = salerDataService.getSaler(salerID);
		salerVO = salerPOtoVO(salerPO);
		rank = new Rank();
	}
	
	/**
	 * 删除当前营销人员
	 * @return 删除成功则返回true，否则返回false
	 */
	public boolean deleteSaler() {
		return salerDataService.deleteSaler(salerID);
	}
	
	/**
	 * saler的VO转换成PO
	 * @param salerVO VO
	 * @return PO
	 */
	public static SalerPO salerVOtoPO(SalerVO salerVO) {
		String salerID = salerVO.getUserID();
		String password = salerVO.getPassword();
		String name = salerVO.getName();
		String tel = salerVO.getTel();
		SalerPO salerPO = new SalerPO(salerID, password, name, tel);
		return salerPO;
	}
	
	/**
	 * saler的PO转换成VO
	 * @param salerPO PO
	 * @return VO
	 */
	public static SalerVO salerPOtoVO(SalerPO salerPO) {
		String salerID = salerPO.getUserID();
		String password = salerPO.getPassword();
		String name = salerPO.getName();
		String tel = salerPO.getTel();
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		ArrayList<OrderVO> dailyOrderList = new ArrayList<OrderVO>();
		SalerVO salerVO = new SalerVO(salerID, password, name, tel);
		return salerVO;
	}
}
