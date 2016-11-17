package bl.stub;

import java.util.ArrayList;

import bl.service.PromotionBLService;
import vo.DateVO;
import vo.PromotionVO;


public class PromotionBLStub implements PromotionBLService {
	
	public PromotionVO getPromotion(String promotionID) {
		return new PromotionVO(new DateVO(1997, 3, 4), 1, false, new DateVO(2016, 2, 11), false, promotionID, 0.8, "0011");
	}
	
    public boolean addPromotion(PromotionVO promotion) {
		System.out.println("增加成功");
		return true;
	}
    
    public boolean delPromotion(PromotionVO promotion) {
		System.out.println("删除成功");
		return true;
	}
    
    public boolean changePromotion(PromotionVO promotion) {
		System.out.println("更新成功");
		return true;
	}
    
    public ArrayList<PromotionVO> getPromotionList() {
		return null;
    }
    
}
