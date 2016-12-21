package bl.implementation;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import data.service.PromotionDataService;
import bl.service.PromotionBLService;
import data.stub.PromotionDataStub;
import other.PromotionType;
import other.SaleType;
import po.PromotionPO;
import rmi.RemoteHelper;
import vo.PromotionVO;

/**
 * Promotion模块bl的实现类
 * @author CROFF
 * @version 2016-12-4
 */
public class Promotion implements PromotionBLService {
	
	private String hotelID; //酒店ID
	private ArrayList<PromotionVO> promotionList;   //促销策略列表
	
	private PromotionDataService promotionDataService;
	
	/**
	 * 酒店营销策略的构造方法，默认酒店存在
	 * @param hotelID
	 */
	public Promotion(String hotelID) {
		this.hotelID = hotelID;
//		promotionDataService = new PromotionDataStub();
		promotionDataService = RemoteHelper.getInstance().getPromotionDataService();
		promotionList = getHotelPromotionList(hotelID);
	}
	
	/**
	 * 网站营销策略的构造方法，获取所有营销策略
	 */
	public Promotion() {
		promotionDataService = RemoteHelper.getInstance().getPromotionDataService();
//		promotionDataService = new PromotionDataStub();
		promotionList = getWebPromotionList();
	}
	
	/**
	 * 根据营销策略ID获取营销策略信息，若营销策略不存在则返回null
	 * @param promotionID 营销策略ID
	 * @return 营销策略信息
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
	 * 添加营销策略
	 * @param promotionVO 营销策略信息
	 * @return 添加成功则返回true，否则返回false
	 */
	@Override
	public boolean addPromotion(PromotionVO promotionVO) {
		updateDataFromFile();
		try {
			promotionVO.setPromotionID(promotionDataService.getAvailablePromotionID());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		promotionList.add(promotionVO);
		PromotionPO promotionPO = promotionVOtoPO(promotionVO);
		try {
			return promotionDataService.addPromotion(promotionPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除营销策略
	 * @param promotionID 营销策略ID
	 * @return 删除成功则返回true，否则返回false
	 */
	@Override
	public boolean deletePromotion(String promotionID) {
		updateDataFromFile();
		int index = -1;
		PromotionVO promotionVO;
		for(int i=0; i<promotionList.size(); i++) {
			promotionVO = promotionList.get(i);
			if(promotionVO.getPromotionID().equals(promotionID)) {
				index = i;
				break;
			}
		}
		if(index==-1) {
			return false;
		} else {
			promotionList.remove(index);
			try {
				return promotionDataService.deletePromotion(promotionID);
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
	
	/**
	 * 更新营销策略信息
	 * @param promotionVO 营销策略信息
	 * @return 更新成功则返回true，否则返回false
	 */
	@Override
	public boolean updatePromotion(PromotionVO promotionVO) {
		String updatePromotionID = promotionVO.getPromotionID();
		int index = -1;
		for(int i=0; i<promotionList.size(); i++) {
			if(promotionList.get(i).getPromotionID().equals(updatePromotionID)) {
				index = i;
				break;
			}
		}
		if(index==-1) {
			return false;
		} else {
			promotionList.set(index, promotionVO);
			PromotionPO promotionPO = promotionVOtoPO(promotionVO);
			try {
				return promotionDataService.updatePromotion(promotionPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	
	/**
	 * 根据酒店ID获取酒店营销策略列表
	 * @param hotelID 酒店ID
	 * @return 酒店营销策略列表
	 */
	@Override
	public ArrayList<PromotionVO> getHotelPromotionList(String hotelID) {
		this.hotelID = hotelID;
		updateDataFromFile();
		return promotionList;
	}
	
	/**
	 * 获取网站营销策略列表
	 * @return 网站营销策略列表
	 */
	@Override
	public ArrayList<PromotionVO> getWebPromotionList() {
		this.hotelID = null;
		updateDataFromFile();
		return promotionList;
	}
	
	/**
	 * 获取商圈营销策略列表
	 * @return 商圈营销策略列表
	 */
	@Override
	public ArrayList<PromotionVO> getDistrictPromotionList() {
		ArrayList<PromotionVO> districtPromotionList = new ArrayList<>();
		for(int i=0; i<promotionList.size(); i++) {
			PromotionVO promotionVO = promotionList.get(i);
			if(promotionVO.getRelatedHotelID()==null && promotionVO.getSaleType()==SaleType.District) {
				districtPromotionList.add(promotionVO);
			}
		}
		return districtPromotionList;
	}
	
	/**
	 * 获取酒店的特定日期营销策略列表
	 * @return 酒店的特定日期营销策略列表
	 */
	@Override
	public ArrayList<PromotionVO> getHotelDatePromotionList() {
		ArrayList<PromotionVO> districtPromotionList = new ArrayList<>();
		for(int i=0; i<promotionList.size(); i++) {
			PromotionVO promotionVO = promotionList.get(i);
			if(promotionVO.getRelatedHotelID().equals(hotelID) && promotionVO.getSaleType()==SaleType.Date) {
				districtPromotionList.add(promotionVO);
			}
		}
		return districtPromotionList;
	}
	
	/**
	 * 获取网站的特定日期营销策略列表
	 * @return 网站的特定日期营销策略列表
	 */
	@Override
	public ArrayList<PromotionVO> getWebDatePromotionList() {
		ArrayList<PromotionVO> districtPromotionList = new ArrayList<>();
		for(int i=0; i<promotionList.size(); i++) {
			PromotionVO promotionVO = promotionList.get(i);
			if(promotionVO.getRelatedHotelID()==null && promotionVO.getSaleType()==SaleType.Date) {
				districtPromotionList.add(promotionVO);
			}
		}
		return districtPromotionList;
	}
	
	/**
	 * 获取合作企业促销列表
	 * @return 合作企业促销列表
	 */
	@Override
	public ArrayList<PromotionVO> getEnterprisePromotionList() {
		ArrayList<PromotionVO> districtPromotionList = new ArrayList<>();
		for(int i=0; i<promotionList.size(); i++) {
			PromotionVO promotionVO = promotionList.get(i);
			if(promotionVO.getRelatedHotelID().equals(hotelID) && promotionVO.getSaleType()==SaleType.Enterprise) {
				districtPromotionList.add(promotionVO);
			}
		}
		return districtPromotionList;
	}
	
	/**
	 * 从Data层更新数据，hotelID为null时更新网站营销策略列表，hotelID不为null时更新酒店营销策略列表
	 */
	public void updateDataFromFile() {
		promotionList = new ArrayList<>();
		ArrayList<PromotionPO> promotionPOList = null;
		try {
			promotionPOList = promotionDataService.getPromotionList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		PromotionPO promotionPO;
		PromotionVO promotionVO;
		for(int i=0; i<promotionPOList.size(); i++) {
			promotionPO = promotionPOList.get(i);
			promotionVO = promotionPOtoVO(promotionPO);
			if(hotelID==null) {
				if(promotionVO.getRelatedHotelID()==null) {
					promotionList.add(promotionVO);
				} else {
					continue;
				}
			} else {
				if(promotionPO.getRelatedHotelID()==null) {
					continue;
				}
				if(promotionPO.getRelatedHotelID().equals(hotelID)) {
					promotionList.add(promotionVO);
				}
			}
		}
	}
	
	/**
	 * 将promotion从VO转换成PO
	 * @param promotionVO VO
	 * @return PO
	 */
	public static PromotionPO promotionVOtoPO(PromotionVO promotionVO) {
		String promotionID = promotionVO.getPromotionID();
		String promotionName = promotionVO.getPromotionName();
		PromotionType promotionType = promotionVO.getPromotionType();
		String relatedHotelID = promotionVO.getRelatedHotelID();
		SaleType saleType = promotionVO.getSaleType();
		Date startDate = promotionVO.getStartDate();
		Date endDate = promotionVO.getEndDate();
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
			promotionPO.setDatePromotion(startDate, endDate, discount, neededPrice, reducePrice);
		} else if(saleType==SaleType.Birthday) {
			promotionPO.setBirthdayPromotion(discount, neededPrice, reducePrice);
		} else if(saleType==SaleType.RoomNumber) {
			promotionPO.setRoomNumberPromotion(numberOfRoom, discount, neededPrice, reducePrice);
		} else if(saleType==SaleType.Enterprise) {
			promotionPO.setEnterprisePromotion(enterprise, discount, neededPrice, reducePrice);
		} else if(saleType==SaleType.District) {
			promotionPO.setDistrictPromotion(district, discount, neededPrice, reducePrice);
		}
		return promotionPO;
	}
	
	/**
	 * 将promotion从PO转换成VO
	 * @param promotionPO PO
	 * @return VO
	 */
	public static PromotionVO promotionPOtoVO(PromotionPO promotionPO) {
		String promotionID = promotionPO.getPromotionID();
		String promotionName = promotionPO.getPromotionName();
		PromotionType promotionType = promotionPO.getPromotionType();
		String relatedHotelID = promotionPO.getRelatedHotelID();
		SaleType saleType = promotionPO.getSaleType();
		Date startDate = promotionPO.getStartDate();
		Date endDate = promotionPO.getEndDate();
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
			promotionVO.setDatePromotion(startDate, endDate, discount, neededPrice, reducePrice);
		} else if(saleType.equals(SaleType.Birthday)) {
			promotionVO.setBirthdayPromotion(discount, neededPrice, reducePrice);
		} else if(saleType.equals(SaleType.RoomNumber)) {
			promotionVO.setRoomNumberPromotion(numberOfRoom, discount, neededPrice, reducePrice);
		} else if(saleType.equals(SaleType.Enterprise)) {
			promotionVO.setEnterprisePromotion(enterprise, discount, neededPrice, reducePrice);
		} else if(saleType.equals(SaleType.District)) {
			promotionVO.setDistrictPromotion(district, discount, neededPrice, reducePrice);
		}
		return promotionVO;
	}
	
	/**
	 * 根据条件获取可用促销列表
	 * @param memberID 客户ID
	 * @param hotelID 酒店ID
	 * @param numberOfRoom 订房数量
	 * @return 可用促销列表
	 */
	public ArrayList<PromotionVO> getAvailablePromotionList(String memberID, String hotelID, int numberOfRoom) {
		Member member = new Member(memberID);
		Hotel hotel = new Hotel(hotelID);
		Date today = new Date();
		Rank rank = new Rank();
		ArrayList<PromotionVO> availablePromotionList = new ArrayList<>();
		
		PromotionVO promotionVO;
		for(int i=0; i<promotionList.size(); i++) {
			promotionVO = promotionList.get(i);
			if(promotionVO.getRelatedHotelID()==null || promotionVO.getRelatedHotelID().equals(hotelID)) {
				switch (promotionVO.getSaleType().getValue()) {
					case 0:
						promotionVO.setDiscount(rank.getDiscount(member.getCredit()));
						availablePromotionList.add(promotionVO);
						break;
					case 1:
						if(today.after(promotionVO.getStartDate()) && today.before(promotionVO.getEndDate())) {
							availablePromotionList.add(promotionVO);
						}
						break;
					case 2:
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(today);
						int year1 = calendar.get(Calendar.YEAR);
						int month1 = calendar.get(Calendar.MONTH);
						int day1 = calendar.get(Calendar.DATE);
						calendar.setTime(member.getBirthday());
						int year2 = calendar.get(Calendar.YEAR);
						int month2 = calendar.get(Calendar.MONTH);
						int day2 = calendar.get(Calendar.DATE);
						if(year1==year2 && month1==month2 && day1==day2) {
							availablePromotionList.add(promotionVO);
						}
						break;
					case 3:
						if(numberOfRoom>=promotionVO.getNumberOfRoom()) {
							availablePromotionList.add(promotionVO);
						}
						break;
					case 4:
						if(member.getEnterprise().equals(promotionVO.getEnterprise())) {
							availablePromotionList.add(promotionVO);
						}
						break;
					case 5:
						if(hotel.getDistrict().equals(promotionVO.getDistrict())) {
							availablePromotionList.add(promotionVO);
						}
						break;
				}
			}
		}
		return availablePromotionList;
	}
}
