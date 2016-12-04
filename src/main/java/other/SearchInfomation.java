package other;

import java.util.Date;

/**
 * Created by 97147 on 2016/11/19.
 * 设置搜索酒店的限制条件的类
 * @author CROFF
 * @version 2016-11-25
 */
public class SearchInfomation {

    private String city;	//城市，若未设置则为null
	private String district;	//商圈，若未设置则为null
    private String hotelName;	//酒店名称，若未设置则为null
    private int level;	//星级，若未设置则为0
    private RoomType roomType;	//房间类型，若未设置则为null
    private double lowerPrice;	//价格区间下限，若未设置则为0
    private double upperPrice;	//价格区间上限，若未设置则为0
	private double lowerScore;	//评分区间下限，若未设置则为0
	private double upperScore;	//评分区间上限，若未设置则为0
    private Date checkinTime;	//入住日期，若未设置则为当天
    private Date checkoutTime;	//退房日期，若未设置则为一天后
    private boolean onlyReservationBefore;	//是否只搜索自己预定过的酒店
	
	/**
	 * 无参数的构造方法
	 */
	public SearchInfomation() {
		
	}
	
	/**
	 * 带参数的构造方法
	 * @param city 城市，若未设置则为null
	 * @param district 商圈，若未设置则为null
	 * @param hotelName 酒店名称，若未设置则为null
	 * @param level 星级，若未设置则为0
	 * @param roomType 房间类型，若未设置则为null
	 * @param lowerPrice 价格区间下限，若未设置则为0
	 * @param upperPrice 价格区间上限，若未设置则为0
	 * @param lowerScore 评分区间下限，若未设置则为0
	 * @param upperScore 评分区间上限，若未设置则为0
	 * @param checkinTime 入住日期，若未设置则为当天
	 * @param checkoutTime 退房日期，若未设置则为一天后
	 * @param onlyReservationBefore 是否只搜索自己预定过的酒店
	 */
	public SearchInfomation(String city, String district, String hotelName, int level,
							RoomType roomType, double lowerPrice, double upperPrice, double lowerScore,
							double upperScore, Date checkinTime, Date checkoutTime, boolean onlyReservationBefore) {
		this.city = city;
		this.district = district;
		this.hotelName = hotelName;
		this.level = level;
		this.roomType = roomType;
		this.lowerPrice = lowerPrice;
		this.upperPrice = upperPrice;
		this.lowerScore = lowerScore;
		this.upperScore = upperScore;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
		this.onlyReservationBefore = onlyReservationBefore;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(double lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public double getUpperPrice() {
        return upperPrice;
    }

    public void setUpperPrice(double upperPrice) {
        this.upperPrice = upperPrice;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public boolean isOnlyReservationBefore() {
        return onlyReservationBefore;
    }

    public void setOnlyReservationBefore(boolean onlyReservationBefore) {
        this.onlyReservationBefore = onlyReservationBefore;
    }
	
	public double getLowerScore() {
		return lowerScore;
	}
	
	public void setLowerScore(double lowerScore) {
		this.lowerScore = lowerScore;
	}
	
	public double getUpperScore() {
		return upperScore;
	}
	
	public void setUpperScore(double upperScore) {
		this.upperScore = upperScore;
	}
}
