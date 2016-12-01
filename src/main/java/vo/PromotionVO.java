package vo;

import other.District;
import other.Enterprise;
import other.PromotionType;
import other.SaleType;

import java.util.ArrayList;
import java.util.Date;

public class PromotionVO {
	
	private String promotionID;
	private String promotionName;
	private PromotionType promotionType;
	private SaleType saleType;
	
	private Date startDate;
	private Date endDate;
	
	private Date birthday;
	
	private int numberOfRoom;
	
	private Enterprise enterprise;
	
	private int level;
	
	private District district;
	
	private double discount;
	private double neededPrice;
	private double reducePrice;
	
	
	/**
	 * 会员等级折扣（一般营销策略的构造方法）
	 * @param promotionID
	 * @param promotionName
	 * @param promotionType
	 * @param discount
	 * @param neededPrice
	 * @param reducePrice
	 */
	public PromotionVO(String promotionID, String promotionName, PromotionType promotionType,
					   double discount, double neededPrice, double reducePrice) {
		this.promotionID = promotionID;
		this.promotionName = promotionName;
		this.promotionType = promotionType;
		this.discount = discount;
		this.neededPrice = neededPrice;
		this.reducePrice = reducePrice;
	}
	
	/**
	 * 特定日期营销策略
	 * @param promotionID
	 * @param promotionName
	 * @param promotionType
	 * @param startDate
	 * @param endDate
	 * @param discount
	 * @param neededPrice
	 * @param reducePrice
	 */
	public PromotionVO(String promotionID, String promotionName, PromotionType promotionType,
					   Date startDate, Date endDate, double discount, double neededPrice, double reducePrice) {
		this(promotionID, promotionName, promotionType, discount, neededPrice, reducePrice);
	}
	
	/**
	 * 生日特惠
	 * @param promotionID
	 * @param promotionName
	 * @param promotionType
	 * @param birthday
	 * @param discount
	 * @param neededPrice
	 * @param reducePrice
	 */
	public PromotionVO(String promotionID, String promotionName, PromotionType promotionType,
					   Date birthday, double discount, double neededPrice, double reducePrice) {
		this(promotionID, promotionName, promotionType, discount, neededPrice, reducePrice);
	}
	
	/**
	 * 预订房间数营销策略
	 * @param promotionID
	 * @param promotionName
	 * @param promotionType
	 * @param numberOfRoom
	 * @param discount
	 * @param neededPrice
	 * @param reducePrice
	 */
	public PromotionVO(String promotionID, String promotionName, PromotionType promotionType,
					   int numberOfRoom, double discount, double neededPrice, double reducePrice) {
		this(promotionID, promotionName, promotionType, discount, neededPrice, reducePrice);
	}
	
	/**
	 * 合作企业客户折扣
	 * @param promotionID
	 * @param promotionName
	 * @param promotionType
	 * @param enterprise
	 * @param discount
	 * @param neededPrice
	 * @param reducePrice
	 */
	public PromotionVO(String promotionID, String promotionName, PromotionType promotionType,
					   Enterprise enterprise, double discount, double neededPrice, double reducePrice) {
		this(promotionID, promotionName, promotionType, discount, neededPrice, reducePrice);
	}
	
	/**
	 * 特定商圈折扣
	 * @param promotionID
	 * @param promotionName
	 * @param promotionType
	 * @param district
	 * @param discount
	 * @param neededPrice
	 * @param reducePrice
	 */
	public PromotionVO(String promotionID, String promotionName, PromotionType promotionType,
					   String district, double discount, double neededPrice, double reducePrice) {
		this(promotionID, promotionName, promotionType, discount, neededPrice, reducePrice);
	}
	
	public boolean checkAvailable(MemberVO memberVO) {
		return false;
	}
	
	public double calculatePrice(double originalPrice) {
		return 0;
	}
}
