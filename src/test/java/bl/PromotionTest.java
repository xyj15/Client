package bl;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import bl.implementation.Promotion;
import bl.mock.MockPromotion;
import vo.PromotionVO;

public class PromotionTest {
	private Promotion promotion;
	MockPromotion promotion1;

	@Before
	public void setUp() {
		promotion = new Promotion();
		promotion1=new MockPromotion(null, 0, false, null, false, null, 0, "123");
	}
	
	@Test
	public void testGetPromotionList(){
		promotion.addPromotion(promotion1);
		List<PromotionVO> List = promotion.getPromotionList();
		assertEquals(List.get(0),promotion1);
	}
	@Test
	public void testGetPromotion(){
		promotion.addPromotion(promotion1);
		assertEquals((MockPromotion)promotion.getPromotion("123"),promotion1);
	}
	@Test
	public void testChangePromotion(){
		promotion.addPromotion(promotion1);
		MockPromotion promotion2=new MockPromotion(null, 0, false, null, false, null, 0, "123");
		promotion.changePromotion(promotion2);
		assertEquals(promotion.getPromotion(promotion1.getID()),promotion2);
	}
}
