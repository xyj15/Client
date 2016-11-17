package bl.mock;

import vo.OrderVO;

/**
 提供member的基本信息（包括姓名或名称，联系方式、信用）和修改服务
 * @author 婧婧
 * @version 2016-11-04 11:43
 * @param checkInTime 
 *   入住时间
 * @param days
 *   入住天数
 * @param roomType
 *   房间类型    
 * @param roomNumber
 *   房间数量
 * @param Promotion
 *   营销策略
 * @param price
 *   价格    
 * @param
 */
 
public class MockOrder extends OrderVO {
	
	private String checkInTime;
	private int days;
	private int roomType;
	private int roomNumber;
	private String promotion;
	private double price;
	private String orderID;
	private int state;//1，已经执行；2，未执行；3，异常；4，撤销
	
	public String getOrderID() {
		return orderID;
	}
	
	/**
	@param checkInTime 
	 *   入住时间
	 * @param days
	 *   入住天数
	 * @param roomType
	 *   房间类型    
	 * @param roomNumber
	 *   房间数量
	 * @param Promotion
	 *   营销策略
	 * @param price
	 *   价格    
	 */
	public MockOrder(String orID,int state,String ci, int da, int rt, int rn, String pro,double pri) {
		
		orderID = orID;
		this.setState(state);
		checkInTime = ci;
		days = da;
		roomType = rt;
		roomNumber = rn;
		promotion = pro;
		price = pri;

	}
	
	/**
	 * 查看入住时间
	 * @return 以String为表示入住时间
	 */
	public String getCheckInTime(){
		return checkInTime;
	}
	
	/**
	 * 查看入住天数
	 * @return 以整数为表示入住天数
	 */
	public int getDays(){
		return days;
	}
	
	/**
	 * 查看入住的房间类型
	 * @return 以整数为表示入住房间类型
	 */
	public int getRoomType(){
		return roomType;
	}
	
	/**
	 * 查看入住的房间数量
	 * @return 以整数为表示入住房间数量
	 */
	public int getRoomNumber(){
		return roomNumber;
	}
	
	/**
	 * 查看营销策略
	 * @return 以string为表示营销策略
	 */
	public String getPromotion(){
		return promotion;
	}
	
	/**
	 * 查看订单总价格
	 * @return 以整数为表示订单价格
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * 查看订单状态
	 * @return 以整数为表示订单状态（1，已经执行；2，未执行；3，异常；4，撤销）
	 */
	public int getState() {
		return state;
	}
	
	/**
	 * 设置订单状态
	 * @param 以整数为表示订单状态（1，已经执行；2，未执行；3，异常；4，撤销）
	 */
	public void setState(int state) {
		this.state = state;
	}
	
	/**
	 * 设置入住时间
	 * @param 入住时间
	 */
	public void setCheckInTime(String checkInTime){
		this.checkInTime=checkInTime;
	}
	
	/**
	 * 设置入住天数
	 * @param 入住天数
	 */
	public void setDays(int days){
		this.days=days;
	}
	
	/**
	 * 设置入住房间类型
	 * @param 入住房间类型
	 */
	public void setRoomType(int roomType){
		this.roomType=roomType;
	}
	
	/**
	 * 设置入住房间数量
	 * @param 入住房间数量
	 */
	public void setRoomNumber(int roomNumber){
		this.roomNumber=roomNumber;
	}
	
	/**
	 * 设置入住营销策略
	 * @param 入住营销策略
	 */
	public void setPromotion(String promotion){
		this.promotion=promotion;
	}
	
	/**
	 * 设置订单总价格
	 * @param 订单总价格
	 */
	public void setPrice(double price){
		this.price=price;
	}
	
	/**
	 * 设置订单ID
	 * @param 订单ID
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
}
