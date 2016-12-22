package data.stub;

import data.service.PromotionDataService;
import other.PromotionType;
import po.PromotionPO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CROFF on 2016/12/2.
 */
public class PromotionDataStub implements PromotionDataService {
	
	private ArrayList<PromotionPO> promotionList;
	
	public PromotionDataStub() {
		promotionList = new ArrayList<>();
		PromotionPO promotionPO1 = new PromotionPO("00000", "生日特惠", PromotionType.Discount);
		promotionPO1.setBirthdayPromotion(0.8, 0, 0);
		promotionList.add(promotionPO1);
		PromotionPO promotionPO2 = new PromotionPO("00001", "会员等级特惠", PromotionType.Discount);
		promotionPO2.setRankPromotion();
		promotionList.add(promotionPO2);
		PromotionPO promotionPO3 = new PromotionPO("00002", "商圈特惠", PromotionType.Discount);
		promotionPO3.setDistrictPromotion("南京大学商圈", 0.8, 0, 0);
		promotionList.add(promotionPO3);
		PromotionPO promotionPO4 = new PromotionPO("00003", "双十二特惠", PromotionType.Discount);
		promotionPO4.setDatePromotion(new Date(116, 12, 12), new Date(117, 1, 1), 0.9, 0, 0);
		promotionList.add(promotionPO4);

		PromotionPO promotionPO5 = new PromotionPO("00004", "合作企业特惠", PromotionType.Discount, "000000");
		promotionPO5.setEnterprisePromotion("企业1", 0.7, 0, 0);
		promotionList.add(promotionPO5);
		PromotionPO promotionPO6 = new PromotionPO("00005", "双十一特惠", PromotionType.Discount, "000000");
		promotionPO6.setDatePromotion(new Date(116, 11, 11), new Date(116, 11, 11), 0.9, 0, 0);
		promotionList.add(promotionPO6);
		PromotionPO promotionPO7 = new PromotionPO("00006", "预订3间以上优惠", PromotionType.Discount, "000000");
		promotionPO7.setRoomNumberPromotion(3, 0.8, 0, 0);
		promotionList.add(promotionPO7);
	}
	
	@Override
	public PromotionPO getPromotion(String promotionID) {
		System.out.println("获取促销策略信息成功");
		for(int i=0; i<promotionList.size(); i++) {
			PromotionPO promotionPO = promotionList.get(i);
			if(promotionPO.getPromotionID().equals(promotionID)) {
				return promotionPO;
			}
		}
		return null;
	}
	
	@Override
	public boolean addPromotion(PromotionPO promotion) {
		System.out.println("添加促销策略成功");
		for(int i=0; i<promotionList.size(); i++) {
			String promotionID = promotionList.get(i).getPromotionID();
			if(promotionID.equals(promotion.getPromotionID())) {
				return false;
			}
		}
		promotionList.add(promotion);
		return true;
	}
	
	@Override
	public boolean deletePromotion(String promotionID) {
		System.out.println("删除促销策略成功");
		for(int i=0; i<promotionList.size(); i++) {
			if(promotionList.get(i).getPromotionID().equals(promotionID)) {
				promotionList.remove(i);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean updatePromotion(PromotionPO promotion) {
		System.out.println("更新促销策略信息成功");
		String promotionID = promotion.getPromotionID();
		for(int i=0; i<promotionList.size(); i++) {
			if(promotionList.get(i).getPromotionID().equals(promotionID)) {
				promotionList.set(i, promotion);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public ArrayList<PromotionPO> getPromotionList() {
		System.out.println("获取促销策略列表成功");
		return promotionList;
	}
	
	@Override
	public String getAvailablePromotionID() {
		System.out.println("获取可用ID成功");
		int size = promotionList.size();
		String availableID = String.valueOf(size);
		switch (availableID.length()) {
			case 1:
				availableID = "0" + availableID;
			case 2:
				availableID = "0" + availableID;
			case 3:
				availableID = "0" + availableID;
			case 4:
				availableID = "0" + availableID;
			case 5:
				break;
		}
		return availableID;
	}
}
