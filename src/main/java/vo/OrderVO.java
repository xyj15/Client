package vo;

public class OrderVO {
	private String orderID;
	String checkInTime;
	String checkOutTime;
	int roomType;
	int roomNumber;
	String promotion;
	double discount;
	double price;
	private int state;
	//1，已经执行；2，未执行；3，异常；4，已经取消
	public OrderVO(){}
	public OrderVO(int state,String ci,String co,int rt,int rn,String pro,double d,double pri,String orID){
		checkInTime=ci;
		checkOutTime=co;
		roomType=rt;
		roomNumber=rn;
		promotion=pro;
		discount=d;
		price=pri;
		setOrderID(orID);
		this.setState(state);
	}
	
	public String getCheckInTime(){
		return checkInTime;
	}
	public String getCheckOutTime(){
		return checkOutTime;
	}
	public int getRoomType(){
		return roomType;
	}
	public int getRoomNumber(){
		return roomNumber;
	}
	public String getPromotion(){
		return promotion;
	}
	public double getDiscount(){
		return discount;
	}
	public double getPrice(){
		return price;
	}
	
	
	public void setCheckInTime(String checkInTime){
		this.checkInTime=checkInTime;
	}
	public void setCheckOutTime(String checkOutTime){
		this.checkOutTime=checkOutTime;
	}
	public void setRoomType(int roomType){
		this.roomType=roomType;
	}
	public void setRoomNumber(int roomNumber){
		this.roomNumber=roomNumber;
	}
	public void setPromotion(String promotion){
		this.promotion=promotion;
	}
	public void setDiscount(double discount){
		this.discount=discount;
	}
	public void setPrice(double price){
		this.price=price;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
//	public boolean isCancel() {
//		return isCancel;
//	}
//	public void setCancel(boolean isCancel) {
//		this.isCancel = isCancel;
//	}
//	public boolean isAbnormal() {
//		return isAbnormal;
//	}
//	public void setAbnormal(boolean isAbnormal) {
//		this.isAbnormal = isAbnormal;
//	}
//	public boolean isExcute() {
//		return isExcute;
//	}
//	public void setExcute(boolean isExcute) {
//		this.isExcute = isExcute;
//	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
