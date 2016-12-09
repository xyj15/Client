package test;

import bl.implementation.Promotion;
import org.junit.Before;
import org.junit.Test;
import vo.PromotionVO;

import static org.junit.Assert.*;

/**
 * Created by CROFF on 2016/12/7.
 */
public class PromotionTestForSaler {
	
	private Promotion promotion;
	
	@Before
	public void setUp() throws Exception {
		promotion = new Promotion();
	}
	
	@Test
	public void getPromotion() throws Exception {
		PromotionVO promotionVO;
		promotionVO = promotion.getPromotion("00000");
		assertEquals(promotionVO.getPromotionName(), "生日特惠");
		promotionVO = promotion.getPromotion("00002");
		assertEquals(promotionVO.getPromotionName(), "商圈特惠");
		promotionVO = promotion.getPromotion("00003");
		assertEquals(promotionVO.getPromotionName(), "双十二特惠");
	}
	
	@Test
	public void addPromotion() throws Exception {
		
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