package vo;

public class RoomVO {

	private boolean isValid;
	private String roomNUM;
	private int type;
	private double price;
	
	public RoomVO() {
		
	}
	
	public RoomVO(boolean valid, String number,int type,double price){
		this.isValid =valid;
		this.roomNUM=number;
		this.type=type;
		this.price =price;
	}
	
	/**
	 * 查看房间类型
	 * @return 以整数为代表的房间类型
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * 查看房间号
	 * @return 以字符串为代表的房间号
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public String getNumber() {
		return roomNUM;
	}
	
	/**
	 * 查看房间价格
	 * @return 以浮点数显示的房间价格
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 查看房间入住情况
	 * @return 以布尔值为代表的房间入住情况
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public boolean isValid() {
		return isValid;
	}
	
	/**
	 * 修改房间价格
	 * @param pri
	 *    要更改的新的房间价格
	 * @return 
	 * @author 张新悦
	 * @version 2016-11-04 09:50
	 */
	public void setPrice(double pri) {
		price = pri;
	}
	
	/**
	 * 登记入住
	 * @return 以布尔值为代表的更改房间入住情况成功与否
	 * @author 张新悦
	 * @version 2016-11-04 09:59
	 */
	public boolean checkIn() {
		if(!isValid) return false;
		isValid = false;
		return true;
	}
	
	/**
	 * 离开房间
	 * @return 以布尔值为代表的更改房间入住情况成功与否
	 * @author 张新悦
	 * @version 2016-11-04 10:04
	 */
	public boolean checkOut() {
		if(isValid) return false;
		isValid = true;
		return true;
	}
}
