//package bl.stub;
//
//import java.util.ArrayList;
//
//import bl.service.PromotionBLService;
//import other.Date;
//import vo.PromotionVO;
//
//
//public class PromotionBLStub implements PromotionBLService {
//
//	public PromotionVO getPromotion(String promotionID) {
//		return new PromotionVO(new Date(1997, 3, 4), 1, false, new Date(2016, 2, 11), false, promotionID, 0.8, "0011");
//	}
//
//    public boolean addPromotion(PromotionVO promotion) {
//		System.out.println("增加成功");
//		return true;
//	}
//
//    public boolean delPromotion(PromotionVO promotion) {
//		System.out.println("删除成功");
//		return true;
//	}
//
//    public boolean changePromotion(PromotionVO promotion) {
//		System.out.println("更新成功");
//		return true;
//	}
//
//    public ArrayList<PromotionVO> getPromotionList() {
//		return null;
//    }
//
//}
