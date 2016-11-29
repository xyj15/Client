package vo;

import other.Date;
import other.District;
import other.Enterprise;
import other.PromotionType;

import java.util.ArrayList;

public class PromotionVO {
	
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
	
	public PromotionVO() {
		
	}
	
	public boolean checkAvailable(MemberVO memberVO) {
		return false;
	}
	
	public double calculatePrice(double originalPrice) {
		return 0;
	}
}
