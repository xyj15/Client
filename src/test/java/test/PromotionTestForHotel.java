package test;

import bl.implementation.Promotion;
import org.junit.Before;
import org.junit.Test;
import other.PromotionType;
import other.SaleType;
import vo.PromotionVO;

import java.util.ArrayList;
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
		ArrayList<PromotionVO> promotionList = promotion.getHotelPromotionList("000000");
		assertEquals(promotionList.size(), 3);
		for(int i=0; i< promotionList.size(); i++) {
			PromotionVO promotionVO = promotionList.get(i);
			assertEquals(promotionVO.getRelatedHotelID(), "000000");
			if(promotionVO.getPromotionID().equals("00004")) {
				assertEquals(promotionVO.getPromotionName(), "合作企业特惠");
			} else if(promotionVO.getPromotionID().equals("00005")) {
				assertEquals(promotionVO.getDiscount(), 0.9, 0.000001);
			} else if(promotionVO.getPromotionID().equals("00006")) {
				assertEquals(promotionVO.getSaleType(), SaleType.RoomNumber);
			}
		}
	}
	
	@Test
	public void getAvailablePromotionList() throws Exception {
		
	}
	
	@Test
	public void getHotelDatePromotionList() throws Exception {
		ArrayList<PromotionVO> promotionList = promotion.getHotelDatePromotionList();
		assertEquals(promotionList.size(), 1);
		PromotionVO promotionVO = promotionList.get(0);
		assertEquals(promotionVO.getSaleType(), SaleType.Date);
	}
	
	@Test
	public void getEnterprisePromotionList() throws Exception {
		ArrayList<PromotionVO> promotionList = promotion.getEnterprisePromotionList();
		assertEquals(promotionList.size(), 1);
		PromotionVO promotionVO = promotionList.get(0);
		assertEquals(promotionVO.getSaleType(), SaleType.Enterprise);
		assertEquals(promotionVO.getEnterprise(), "");
	}
}