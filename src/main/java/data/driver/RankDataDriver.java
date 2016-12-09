package data.driver;

import data.service.RankDataService;
import data.stub.RankDataStub;

import java.util.ArrayList;

/**
 * Created by CROFF on 2016/12/9.
 */
public class RankDataDriver {
	
	private RankDataService rankDataService = new RankDataStub();
	
	public void drive() {
		System.out.println(rankDataService.getCreditList());
		System.out.println(rankDataService.getDiscountList());
		System.out.println(rankDataService.updateCreditList(new ArrayList<Double>()));
		System.out.println(rankDataService.updateDiscountList(new ArrayList<Double>()));
	}
	
	public static void main(String[] args) {
		RankDataDriver rankDataDriver = new RankDataDriver();
		rankDataDriver.drive();
	}
}
