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
		promotion.deletePromotion("00005");
		assertEquals(promotion.getPromotion("00005"), null);
	}
	
	@Test
	public void updatePromotion() throws Exception {
		assertEquals(promotion.getPromotion("00005").getPromotionName(), "双十一特惠");
		PromotionVO promotionVO = promotion.getPromotion("00005");
		promotionVO.setPromotionName("清明特惠");
		promotion.updatePromotion(promotionVO);
		assertEquals(promotion.getPromotion("00005").getPromotionName(), "清明特惠");
	}
	
	@Test
	public void getHotelPromotionList() throws Exception {
		
	}
	
	@Test
	public void getAvailablePromotionList() throws Exception {
		
	}
	
	@Test
	public void getHotelDatePromotionList() throws Exception {
		
	}
	
	@Test
	public void getEnterprisePromotionList() throws Exception {
		
	}
}