package other;

/**
 * Created by 97147 on 2016/11/19.
 * @author CROFF
 * @version 2016-11-25
 */
public class SearchInfomation {

    private String address;  // 地址，若未设置则为null
    private String district;  // 商圈，若未设置则为null
    private String hotelName;  // 酒店名称，若未设置则为null
    private int level;  // 星级
    private double score;  // 评分，若未设置则为0
    private RoomType roomType;  // 房间类型，若未设置则为null
    private double lowerPrice;  // 价格区间下限，若未设置则为0
    private double upperPrice;  // 价格区间上限，若未设置则为0
    private Date checkinTime;  // 入住日期，若未设置则为null
    private Date checkoutTime;  // 退房日期，若未设置则为null
    private boolean onlyReservationBefore;  // 是否只搜索自己预定过的酒店，若未设置则为false

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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
}
