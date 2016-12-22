package bl.stub;

import java.util.ArrayList;
import java.util.Date;
import bl.service.PromotionBLService;
import other.PromotionType;
import vo.PromotionVO;


public class PromotionBLStub implements PromotionBLService {
	
	private PromotionVO promotionVO;
	
	public PromotionBLStub() {
		String promotionID = "00000";
		String promotionName = "1111";
		PromotionType promotionType = PromotionType.Discount;
		promotionVO = new PromotionVO(promotionID, promotionName, promotionType);
		promotionVO.setRankPromotion();
		promotionVO.setStartDate(new Date());
		promotionVO.setEndDate(new Date());
	}
	
	@Override
	public PromotionVO getPromotion(String promotionID) {
		System.out.println("获取促销策略成功");
		return promotionVO;
	}
	
	@Override
	public boolean addPromotion(PromotionVO promotionVO) {
		System.out.println("添加促销策略成功");
		return true;
	}
	
	@Override
	public boolean deletePromotion(String promotionID) {
		System.out.println("删除促销策略成功");
		return true;
	}
	
	@Override
	public boolean updatePromotion(PromotionVO promotionVO) {
		System.out.println("更新促销策略成功");
		return true;
	}
	
	@Override
	public ArrayList<PromotionVO> getHotelPromotionList(String hotelID) {
		System.out.println("获取酒店促销策略列表成功");
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		promotionList.add(promotionVO);
		return promotionList;
	}
	
	@Override
	public ArrayList<PromotionVO> getWebPromotionList() {
		System.out.println("获取网站促销策略列表成功");

		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		promotionList.add(promotionVO);
		return promotionList;
	}
	
	@Override
	public ArrayList<PromotionVO> getDistrictPromotionList() {
		System.out.println("获取商圈营销策略列表成功");
		PromotionVO districtPromotion1=new PromotionVO();
		districtPromotion1.setDistrict("新街口");
		districtPromotion1.setDiscount(8.8);
		PromotionVO districtPromotion2=new PromotionVO();
		districtPromotion2.setDistrict("仙林");
		districtPromotion2.setDiscount(9);
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		promotionList.add(districtPromotion1);
		promotionList.add(districtPromotion2);
		return promotionList;
	}
	
	@Override
	public ArrayList<PromotionVO> getHotelDatePromotionList() {
		System.out.println("获取酒店的特定日期营销策略列表成功");
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		promotionList.add(promotionVO);
		return promotionList;
	}
	
	@Override
	public ArrayList<PromotionVO> getWebDatePromotionList() {
		System.out.println("获取网站的特定日期营销策略列表成功");
		PromotionVO promotion1=new PromotionVO();
		promotion1.setPromotionName("庆祝我出生");
		promotion1.setStartDate(new Date(1992-1996,2,2));
		promotion1.setEndDate(new Date(1996-1996,3,3));
		promotion1.setDiscount(8.8);
		PromotionVO promotion2=new PromotionVO();
		promotion2.setPromotionName("双三二");
		promotion2.setStartDate(new Date(2005-1996,2,2));
		promotion2.setEndDate(new Date(2005-1996,2,3));
		promotion2.setDiscount(9);
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		promotionList.add(promotion1);
		promotionList.add(promotion2);
		return promotionList;
	}
	
	@Override
	public ArrayList<PromotionVO> getEnterprisePromotionList() {
		System.out.println("获取合作企业促销列表成功");
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		promotionVO.setEnterprise("2");
		promotionList.add(promotionVO);
		return promotionList;
	}
	
	@Override
	public ArrayList<PromotionVO> getAvailablePromotionList(String memberID, String hotelID, int numberOfRoom) {
		System.out.println("获取可用促销列表成功");
		return new ArrayList<>();
	}
}
