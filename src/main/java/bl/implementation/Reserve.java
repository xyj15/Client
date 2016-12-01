package bl.implementation;

import bl.service.ReserveBLService;
import other.RoomType;
import vo.*;

import java.util.Date;

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
	
	public Reserve(String memberID) {
		
	}
	
	public Reserve() {
		
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
	public boolean setHasKids(boolean hasKids) {
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
