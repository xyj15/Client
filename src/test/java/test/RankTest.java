package test;

import org.junit.Before;
import org.junit.Test;
import other.Rank;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/9.
 */
public class RankTest {
	
	private Rank rank;
	
	@Before
	public void setUp() throws Exception {
		rank = new Rank();
	}
	
	@Test
	public void getLevel() throws Exception {
		int[] level = {1, 2, 3, 4, 5, 6};
		double[] credit = {50, 150, 250, 350, 450, 550};
		for(int i=0; i<6; i++) {
			assertEquals(rank.getLevel(credit[i]), level[i]);
		}
	}
	
	@Test
	public void getDiscount() throws Exception {
		double[] discount = {1, 0.95, 0.9, 0.85, 0.8, 0.75};
		double[] credit = {50, 150, 250, 350, 450, 550};
		for(int i=0; i<6; i++) {
			assertEquals(discount[i], rank.getDiscount(credit[i]), 0.0001);
		}
	}
	
	@Test
	public void setRankInformation() throws Exception {
		ArrayList<Double> creditList = new ArrayList<Double>();
		ArrayList<Double> discountList = new ArrayList<Double>();
		double credit = 200.0;
		double discount = 0.99;
		for(int i=0; i<5; i++) {
			creditList.add(credit);
			discountList.add(discount);
			credit += 200;
			discount -= 0.01;
		}
		rank.setRankInformation(creditList, discountList);
		
		double[] discounts = {1, 0.99, 0.98, 0.97, 0.96, 0.95};
		double[] credits = {100, 300, 500, 700, 900, 1100};
		for(int i=0; i<6; i++) {
			assertEquals(discounts[i], rank.getDiscount(credits[i]), 0.0001);
		}
	}
}