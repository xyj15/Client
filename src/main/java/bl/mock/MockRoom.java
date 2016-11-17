/**
 * 
 */
package bl.mock;

import vo.RoomVO;

/**
 * 提供房间的基本信息（包括房间类型、单价和入住情况）,提供更改房间入住状态和单价的方法。
 * @author 张新悦
 * @version 2016-11-04 08:56
 * @param type
 *    房间类型
 * @param roomNUM 
 *    房间号
 * @param price
 *    房间单价
 * @param isValid
 *    房间入住状态       
 *
 */
public class MockRoom extends RoomVO {
	private int type;
	private String roomNUM;
	private double price;
	private boolean isValid;
	
	/**
	 *  构造MockRoom的方法，确定房间的类型、房间号和单价
	 *  @param t 
	 *    房间的类型
	 *  @param number
	 *    房间号
	 *  @param pr
	 *    房间单价      
	 */
	public MockRoom(int t, String number, double pr) {
		type=t;
		roomNUM=number;
		price=pr;
		isValid=true;
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
