package data.stub;

import data.service.RankDataService;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/12/2.
 */
public class RankDataStub implements RankDataService {
	
	private ArrayList<Double> creditList;
	private ArrayList<Double> discountList;
	
	public RankDataStub() {
		creditList = new ArrayList<Double>();
		discountList = new ArrayList<Double>();
		
		double credit = 100.0;
		double discount = 0.95;
		for(int i=0; i<5; i++) {
			creditList.add(credit);
			discountList.add(discount);
			credit += 100;
			discount -= 0.05;
		}
	}
	
	@Override
	public ArrayList<Double> getCreditList() {
		return creditList;
	}
	
	@Override
	public ArrayList<Double> getDiscountList() {
		return discountList;
	}
	
	@Override
	public boolean updateCreditList(ArrayList<Double> creditList) {
		this.creditList = creditList;
		return true;
	}
	
	@Override
	public boolean updateDiscountList(ArrayList<Double> discountList) {
		this.discountList = discountList;
		return true;
	}
}
