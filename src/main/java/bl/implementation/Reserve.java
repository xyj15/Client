package bl.implementation;

import bl.service.ReserveBLService;
import vo.*;

import java.util.Date;

/**
 * Reserve模块bl的实现类
 * @author CROFF
 * @version 2016-12-2
 */
public class Reserve implements ReserveBLService {

	private String memberID;	//
	private String hotelID;	//

	private PromotionVO promotion;	//
	private double singlePrice;	//
	
	private String hotelName;	//
	private String hotelAddress;	//
	private int hotelLevel;	//
	private String hotelTel;	//
	private String roomName;	//
	private Date checkinTime;	//
	private Date checkoutTime;	//
	private String clientName;	//
	private String clientTel;	//
	private String otherReq;	//
	
	public Reserve(String memberID, String hotelID) {
		
	}
	
	@Override
	public PromotionVO getPromotion() {
		return null;
	}
	
	@Override
	public boolean setPromotion(PromotionVO promotion) {
		this.promotion = promotion;
		return false;
	}
	
	@Override
	public double getPrice() {
		return 0;
	}
	
	@Override
	public String getHotelName() {
		return hotelName;
	}
	
	@Override
	public String getHotelAddress() {
		return hotelAddress;
	}
	
	@Override
	public int getHotelLevel() {
		return hotelLevel;
	}
	
	@Override
	public String getHotelTel() {
		return hotelTel;
	}
	
	@Override
	public String getRoomName() {
		return roomName;
	}
	
	@Override
	public boolean setCheckinTime(java.util.Date checkinTime) {
		return false;
	}
	
	@Override
	public boolean setChekckoutTime(java.util.Date chekckoutTime) {
		return false;
	}
	
	@Override
	public boolean setLatestArriveTime(java.util.Date date) {
		return false;
	}
	
	@Override
	public boolean setClientName(String clientName) {
		this.clientName = clientName;
		return false;
	}
	
	@Override
	public boolean setClientTel(String clientTel) {
		this.clientTel = clientTel;
		return false;
	}
	
	@Override
	public boolean setNumberOfClient(int numberOfClient) {
		return false;
	}
	
	@Override
	public boolean setHaveKids(boolean haveKids) {
		return false;
	}
	
	@Override
	public boolean setNumberOfRoom(int numberOfRoom) {
		return false;
	}
	
	@Override
	public boolean setOtherReq(String otherReq) {
		this.otherReq = otherReq;
		return false;
	}
	
	@Override
	public boolean createOrder() {
		return false;
	}
}
