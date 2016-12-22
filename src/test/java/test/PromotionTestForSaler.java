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
		PromotionVO promotionVO = new PromotionVO("", "国庆特惠", PromotionType.Discount);
		promotionVO.setDatePromotion(new Date(), new Date(), 0.8, 0, 0);
		promotion.addPromotion(promotionVO);
		assertEquals(promotion.getPromotion("00007").getPromotionName(), "国庆特惠");
	}
	
	@Test
	public void deletePromotion() throws Exception {
		promotion.deletePromotion("00000");
		PromotionVO promotionVO = promotion.getPromotion("00000");
		assertEquals(promotionVO, null);
	}
	
	@Test
	public void updatePromotion() throws Exception {
		assertEquals(promotion.getPromotion("00000").getPromotionName(), "生日特惠");
		PromotionVO promotionVO = promotion.getPromotion("00000");
		promotionVO.setPromotionName("清明特惠");
		promotion.updatePromotion(promotionVO);
		assertEquals(promotion.getPromotion("00000").getPromotionName(), "清明特惠");
	}
	
	@Test
	public void getWebPromotionList() throws Exception {
		ArrayList<PromotionVO> promotionList = promotion.getWebPromotionList();
		for(int i=0; i<promotionList.size(); i++) {
			PromotionVO promotionVO = promotionList.get(i);
			assertEquals(promotionVO.getRelatedHotelID(), null);
			if(promotionVO.getPromotionID().equals("00000")) {
				assertEquals(promotionVO.getPromotionName(), "生日特惠");
			} else if(promotionVO.getPromotionID().equals("00001")) {
				assertEquals(promotionVO.getSaleType(), SaleType.Rank);
			} else if(promotionVO.getPromotionID().equals("00002")) {
				assertEquals(promotionVO.getDiscount(), 0.8, 0.0001);
			}
		}
	}
	
	@Test
	public void getAvailablePromotionList() throws Exception {
		ArrayList<PromotionVO> availablePromotionList = promotion.getAvailablePromotionList("00000002", "000000", 3);
		for(int i=0; i<availablePromotionList.size(); i++) {
			PromotionVO promotionVO = availablePromotionList.get(i);
			System.out.println(promotionVO.getSaleType());
		}
	}
	
	@Test
	public void getDistrictPromotionList() throws Exception {
		ArrayList<PromotionVO> promotionList = promotion.getDistrictPromotionList();
		assertEquals(promotionList.size(), 1);
		PromotionVO promotionVO = promotionList.get(0);
		assertEquals(promotionVO.getSaleType(), SaleType.District);
		assertEquals(promotionVO.getDistrict(), "南京大学商圈");
	}
	
	@Test
	public void getWebDatePromotionList() throws Exception {
		ArrayList<PromotionVO> promotionList = promotion.getWebDatePromotionList();
		assertEquals(promotionList.size(), 1);
		PromotionVO promotionVO = promotionList.get(0);
		assertEquals(promotionVO.getSaleType(), SaleType.Date);
	}
}