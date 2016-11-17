package bl.mock;

import vo.DateVO;
import vo.PromotionVO;

/**
 * Promotion的Mock类
 * @author CROFF
 * @version 2016-11-05 11:45
 */
public class MockPromotion extends PromotionVO {
	
	DateVO birthday;
	int roomNumber;
	boolean isCoordinate;
	DateVO date;
	boolean isVIP;
	String district;
	double discount;
	
	/**
	 * 构造MockPromotion的方法
	 * @param birthday 生日
	 * @param roomNumber 客房号
	 * @param isCoordinate 是否是企业合作客户
	 * @param date 入住日期
	 * @param isVIP 是否是VIP会员
	 * @param district 目标酒店商圈
	 * @param discount 折扣
	 */
	public MockPromotion(DateVO birthday, int roomNumber, boolean isCoordinate, DateVO date, boolean isVIP, String district, double discount, String id) {
		super(birthday, roomNumber, isCoordinate, date, isVIP, district, discount, id);
	}
	
	/**
	 * 设置生日
	 * @param birthday 生日
	 */
	public void setBirthday(DateVO birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * 获取生日
	 * @return 生日
	 */
	public DateVO getBirday(){
		return birthday;
	}
	
	/**
	 * 设置客房号码
	 * @param roomNumber 客房号码
	 */
	public void setRoomNumber(int roomNumber){
		this.roomNumber = roomNumber;
	}
	
	/**
	 * 获取客房号码
	 * @return 客房号码
	 */
	public int getRoomNumber(){
		return roomNumber;
	}
	
	/**
	 * 设置是否有合作企业优惠
	 * @param coordinate 是否有合作企业优惠
	 */
	public void setCoodinate(boolean coordinate){
		this.isCoordinate = coordinate;
	}
	
	/**
	 * 获取是否有合作企业优惠
	 * @return 是否有合作企业优惠
	 */
	public boolean getCoordinate(){
		return isCoordinate;
	}
	
	/**
	 * 设置入住日期
	 * @param date 入住日期
	 */
	public void setDate(DateVO date){
		this.date = date;
	}
	
	/**
	 * 获取入住日期
	 * @return 入住日期
	 */
	public DateVO getDate(){
		return date;
	}
	
	/**
	 * 设置是否有VIP优惠
	 * @param VIP 是否有VIP优惠
	 */
	public void setVIP(boolean VIP){
		this.isVIP = VIP;
	}
	
	/**
	 * 获取是否有VIP优惠
	 * @return 是否有VIP优惠
	 */
	public boolean getVIP(){
		return isVIP;
	}
	
	/**
	 * 设置目标酒店的商圈
	 * @param district 目标酒店的商圈
	 */
	public void setDistrict(String district){
		this.district = district;
	}
	
	/**
	 * 获取目标酒店的商圈
	 * @return 目标酒店的商圈
	 */
	public String getDistrict(){
		return district;
	}
	
	/**
	 * 设置折扣
	 * @param 折扣
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	/**
	 * 获取折扣
	 * @return 折扣
	 */
	public double getDiscount() {
		return discount;
	}
	
}
