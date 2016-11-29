package po;

import other.Date;
import other.District;
import other.Enterprise;
import other.PromotionType;

import java.util.ArrayList;

public class PromotionPO {
	
	private String promotionID;
	private String promotionName;
	private PromotionType promotionType;
	private Date startDate;
	private Date endDate;
	
	private Date birthday;
	private Enterprise enterprise;
	private double rankDiscount;
	private District district;
	
	private double discount;
	private ArrayList<Double> priceList;
	private ArrayList<Double> reduceList;
	
	public PromotionPO() {
		
	}
	
	public boolean checkAvailable(MemberPO memberPO) {
		return false;
	}
	
	public double calculatePrice(double originalPrice) {
		return 0;
	}
}
