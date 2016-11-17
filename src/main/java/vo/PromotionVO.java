package vo;

public class PromotionVO {
	
	DateVO birthday;
	int roomNumber;
	boolean coordinate;
	DateVO date;
	boolean VIP;
	String district;
	double discount;
	String ID;
	
	public PromotionVO(DateVO b, int rn, boolean c, DateVO da, boolean v, String di, double dis, String id) {
		birthday = b;
		roomNumber = rn;
		coordinate = c;
		date = da;
		VIP = v;
		district = di;
		discount = dis;
		ID=id;
	}
	
	public DateVO getBirthday() {
		return birthday;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public boolean getCoordinate() {
		return coordinate;
	}
	
	public DateVO getDate() {
		return date;
	}
	
	public boolean getVIP() {
		return VIP;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setBirthday(DateVO birthday) {
		this.birthday = birthday;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public void setCoodinate(boolean coordinate) {
		this.coordinate = coordinate;
	}
	
	public void setDate(DateVO date) {
		this.date = date;
	}
	
	public void setVIP(boolean VIP) {
		this.VIP = VIP;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public String getID() {
		return ID;
	}
	
}
