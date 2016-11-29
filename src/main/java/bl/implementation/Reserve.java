package bl.implementation;

import bl.service.ReserveBLService;
import other.*;
import other.RoomType;
import vo.*;

public class Reserve implements ReserveBLService {

	private MemberVO member;
	private HotelVO hotel;

	private PromotionVO promotion;
	private double singlePrice;
	
	private String hotelName;
	private String hotelAddress;
	private String hotelLevel;
	private String hotelTel;
	private RoomType roomType;
	private Date checkinTime;
	private Date checkoutTime;
	private String clientName;
	private String clientTel;
	private String otherReq;
	
	public Reserve(MemberVO member) {
		this.member = member;
	}
	
	@Override
	public void setPromotion(PromotionVO promotion) {
		this.promotion = promotion;
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
	public String getHotelLevel() {
		return hotelLevel;
	}
	
	@Override
	public String getHotelTel() {
		return hotelTel;
	}
	
	@Override
	public RoomType getRoomType() {
		return roomType;
	}
	
	@Override
	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}
	
	@Override
	public void setChekckoutTime(Date chekckoutTime) {
		this.checkoutTime = chekckoutTime;
	}
	
	@Override
	public void setLatestArriveTime(Time time) {
		
	}
	
	@Override
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	@Override
	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
	}
	
	@Override
	public void setNumberOfClient(int numberOfClient) {
		
	}
	
	@Override
	public void setHasKids(boolean hasKids) {
		
	}
	
	@Override
	public void setNumberOfRoom(int numberOfRoom) {
		
	}
	
	@Override
	public void setOtherReq(String otherReq) {
		this.otherReq = otherReq;
	}
	
	@Override
	public void createOrder() {
		
	}
	
	public MemberVO getMember() {
		return member;
	}
	
	public void setMember(MemberVO member) {
		this.member = member;
	}
	
	public HotelVO getHotel() {
		return hotel;
	}
	
	public void setHotel(HotelVO hotel) {
		this.hotel = hotel;
	}
	
	public PromotionVO getPromotion() {
		return promotion;
	}
}
