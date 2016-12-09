package test;

import bl.implementation.Promotion;
import org.junit.Before;
import org.junit.Test;
import other.PromotionType;
import vo.PromotionVO;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class PromotionTestForHotel {
	
	private Promotion promotion;
	
	@Before
	public void setUp() throws Exception {
		promotion = new Promotion("000000");
	}
	
	@Test
	public void getPromotion() throws Exception {
		assertEquals(promotion.getPromotion("00000"), null);
		assertEquals(promotion.getPromotion("00005").getPromotionName(), "双十一特惠");
	}
	
	@Test
	public void addPromotion() throws Exception {
		PromotionVO promotionVO = new PromotionVO("", "国庆特惠", PromotionType.Discount, "000000");
		promotionVO.setDatePromotion(new Date(), new Date(), 0.8, 0, 0);
		promotion.addPromotion(promotionVO);
		assertEquals(promotion.getPromotion("00007").getPromotionName(), "国庆特惠");
	}
	
	@Test
	public void deletePromotion() throws Exception {
		
	}
	
	@Test
	public void updatePromotion() throws Exception {
		
	}
	
	@Test
	public void getHotelPromotionList() throws Exception {
		
	}
	
	@Test
	public void getWebPromotionList() throws Exception {
		
	}
	
	@Test
	public void updateDataFromFile() throws Exception {
		
	}
	
	@Test
	public void promotionVOtoPO() throws Exception {
		
	}
	
	@Test
	public void promotionPOtoVO() throws Exception {
		
	}
	
	@Test
	public void getAvailablePromotionList() throws Exception {
		
	}
	
	@Test
	public void getDistrictPromotionList() throws Exception {
		
	}
	
	@Test
	public void getHotelDatePromotionList() throws Exception {
		
	}
	
	@Test
	public void getWebDatePromotionList() throws Exception {
		
	}
	
	@Test
	public void getEnterprisePromotionList() throws Exception {
		
	}
}