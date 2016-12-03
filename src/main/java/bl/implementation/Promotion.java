package bl.implementation;

import java.util.ArrayList;
import java.util.Date;

import data.service.PromotionDataService;
import bl.service.PromotionBLService;
import other.PromotionType;
import other.SaleType;
import po.PromotionPO;
import vo.PromotionVO;

/**
 * Promotion模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Promotion implements PromotionBLService {
	
	private String hotelID; //
	private ArrayList<PromotionVO> promotionList;   //
	
	private PromotionDataService promotionDataService;
	
	/**
	 * 酒店营销策略的构造方法
	 * @param hotelID
	 */
	public Promotion(String hotelID) {
		this.hotelID = hotelID;
		updateDataFromFile();
		ArrayList<PromotionVO> promotionVOs = new ArrayList<PromotionVO>();
		PromotionVO promotionVO;
		for(int i=0; i<promotionList.size(); i++) {
			promotionVO = promotionList.get(i);
			if(promotionVO.getRelatedHotelID().equals(hotelID)) {
				promotionVOs.add(promotionVO);
			}
		}
		promotionList = promotionVOs;
	}
	
	/**
	 * 网站营销策略的构造方法
	 */
	public Promotion() {
		updateDataFromFile();
	}
	
	/**
	 *
	 * @param promotionID
	 * @return
	 */
	@Override
	public PromotionVO getPromotion(String promotionID) {
		updateDataFromFile();
		PromotionVO promotionVO;
		for(int i=0; i<promotionList.size(); i++) {
			promotionVO = promotionList.get(i);
			if(promotionVO.getPromotionID().equals(promotionID)) {
				return promotionVO;
			}
		}
		return null;
	}
	
	/**
	 *
	 * @param promotion
	 * @return
	 */
	@Override
	public boolean addPromotion(PromotionVO promotion) {
		return false;
	}
	
	/**
	 *
	 * @param promotionID
	 * @return
	 */
	@Override
	public boolean deletePromotion(String promotionID) {
		return false;
	}
	
	/**
	 *
	 * @param promotionID
	 * @param promotion
	 * @return
	 */
	@Override
	public boolean updatePromotion(String promotionID, PromotionVO promotion) {
		return false;
	}
	
	/**
	 *
	 * @param hotelID
	 * @return
	 */
	@Override
	public ArrayList<PromotionVO> getHotelPromotionList(String hotelID) {
		return null;
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public ArrayList<PromotionVO> getWebPromotionList() {
		return null;
	}
	
	/**
	 *
	 */
	public void updateDataFromFile() {
		promotionList = new ArrayList<PromotionVO>();
		ArrayList<PromotionPO> promotionPOList = promotionDataService.getPromotionList();
		PromotionPO promotionPO;
		PromotionVO promotionVO;
		for(int i=0; i<promotionPOList.size(); i++) {
			promotionPO = promotionPOList.get(i);
			promotionVO = promotionPOtoVO(promotionPO);
			promotionList.add(promotionVO);
		}
	}
	
	/**
	 *
	 * @param promotionVO
	 * @return
	 */
	public PromotionPO promotionVOtoPO(PromotionVO promotionVO) {
		String promotionID = promotionVO.getPromotionID();
		String promotionName = promotionVO.getPromotionName();
		PromotionType promotionType = promotionVO.getPromotionType();
		String relatedHotelID = promotionVO.getRelatedHotelID();
		SaleType saleType = promotionVO.getSaleType();
		Date startDate = promotionVO.getStartDate();
		Date endDate = promotionVO.getEndDate();
		Date birthday = promotionVO.getBirthday();
		int numberOfRoom = promotionVO.getNumberOfRoom();
		String enterprise = promotionVO.getEnterprise();
		String district = promotionVO.getDistrict();
		double discount = promotionVO.getDiscount();
		double neededPrice = promotionVO.getNeededPrice();
		double reducePrice = promotionVO.getReducePrice();
		PromotionPO promotionPO = new PromotionPO(promotionID, promotionName, promotionType, relatedHotelID);
		promotionPO.setDiscount(discount);
		promotionPO.setNeededPrice(neededPrice);
		promotionPO.setReducePrice(reducePrice);
		if(saleType==SaleType.Rank) {
			promotionPO.setRankPromotion();
		} else if(saleType==SaleType.Date) {
			promotionPO.setDatePromotion(startDate, endDate);
		} else if(saleType==SaleType.Birthday) {
			promotionPO.setBirthday(birthday);
		} else if(saleType==SaleType.RoomNumber) {
			promotionPO.setRoomNumberPromotion(numberOfRoom);
		} else if(saleType==SaleType.Enterprise) {
			promotionPO.setEnterprisePromotion(enterprise);
		} else if(saleType==SaleType.District) {
			promotionPO.setDistrictPromotion(district);
		}
		return promotionPO;
	}
	
	/**
	 *
	 * @param promotionPO
	 * @return
	 */
	public PromotionVO promotionPOtoVO(PromotionPO promotionPO) {
		String promotionID = promotionPO.getPromotionID();
		String promotionName = promotionPO.getPromotionName();
		PromotionType promotionType = promotionPO.getPromotionType();
		String relatedHotelID = promotionPO.getRelatedHotelID();
		SaleType saleType = promotionPO.getSaleType();
		Date startDate = promotionPO.getStartDate();
		Date endDate = promotionPO.getEndDate();
		Date birthday = promotionPO.getBirthday();
		int numberOfRoom = promotionPO.getNumberOfRoom();
		String enterprise = promotionPO.getEnterprise();
		String district = promotionPO.getDistrict();
		double discount = promotionPO.getDiscount();
		double neededPrice = promotionPO.getNeededPrice();
		double reducePrice = promotionPO.getReducePrice();
		PromotionVO promotionVO = new PromotionVO(promotionID, promotionName, promotionType, relatedHotelID);
		promotionVO.setDiscount(discount);
		promotionVO.setNeededPrice(neededPrice);
		promotionVO.setReducePrice(reducePrice);
		if(saleType.equals(SaleType.Rank)) {
			promotionVO.setRankPromotion();
		} else if(saleType.equals(SaleType.Date)) {
			promotionVO.setDatePromotion(startDate, endDate);
		} else if(saleType.equals(SaleType.Birthday)) {
			promotionVO.setBirthday(birthday);
		} else if(saleType.equals(SaleType.RoomNumber)) {
			promotionVO.setRoomNumberPromotion(numberOfRoom);
		} else if(saleType.equals(SaleType.Enterprise)) {
			promotionVO.setEnterprisePromotion(enterprise);
		} else if(saleType.equals(SaleType.District)) {
			promotionVO.setDistrictPromotion(district);
		}
		return promotionVO;
	}
}
