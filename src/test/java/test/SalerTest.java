package test;

import bl.implementation.Saler;
import org.junit.Before;
import org.junit.Test;
import other.SaleType;
import other.UserType;
import vo.PromotionVO;
import vo.SalerVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by CROFF on 2016/12/7.
 */
public class SalerTest {
	
	private Saler saler;
	
	@Before
	public void setUp() throws Exception {
		saler = new Saler("0002");
	}
	
	@Test
	public void getSalerInformation() throws Exception {
		SalerVO salerVO = saler.getSalerInformation();
		assertEquals(salerVO.getName(), "传销人员03");
		assertEquals(salerVO.getTel(), "tel03");
		assertEquals(salerVO.getUserType(), UserType.Saler);
	}
	
	@Test
	public void setSalerInformation() throws Exception {
		SalerVO salerVO = saler.getSalerInformation();
		salerVO.setName("cx");
		salerVO.setTel("8888");
		saler.setSalerInformation(salerVO);
		salerVO = saler.getSalerInformation();
		assertEquals(salerVO.getTel(), "8888");
		assertEquals(salerVO.getName(), "cx");
	}
	
	@Test
	public void getPromotionList() throws Exception {
		ArrayList<PromotionVO> promotionList = saler.getPromotionList();
		assertEquals(promotionList.size(), 4);
		assertEquals(promotionList.get(0).getPromotionName(), "生日特惠");
	}
	
	@Test
	public void getPromotion() throws Exception {
		PromotionVO promotionVO = saler.getPromotion("00000");
		assertEquals(promotionVO.getEnterprise(), null);
		assertEquals(promotionVO.getPromotionName(), "生日特惠");
		promotionVO = saler.getPromotion("00002");
		assertEquals(promotionVO.getPromotionName(), "商圈特惠");
		assertEquals(promotionVO.getSaleType(), SaleType.District);
	}
	
	@Test
	public void getDailyUnexcutedOrderList() throws Exception {
		
	}
	
	@Test
	public void cancelAbnormalOrder() throws Exception {
		
	}
	
	@Test
	public void creditRecharge() throws Exception {
		
	}
	
	@Test
	public void getCreditList() throws Exception {
		ArrayList<Double> creditList = saler.getCreditList();
		for(int i=0; i<creditList.size(); i++) {
			assertEquals(creditList.get(i), 100*i+100, 0.001);
		}
	}
	
	@Test
	public void getDiscountList() throws Exception {
		ArrayList<Double> discountList = saler.getDiscountList();
		for(int i=0; i<discountList.size(); i++) {
			assertEquals(discountList.get(i), 0.95-0.05*i, 0.0001);
		}
	}
	
	@Test
	public void deleteSaler() throws Exception {
		assertEquals(saler.deleteSaler(), true);
	}
}