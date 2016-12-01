package po;

import other.User;

import java.util.ArrayList;

/**
 * Created by apple on 2016/11/22.
 */
public class SalerPO extends User {
    
    private String name;
    private String tel;
    private ArrayList<OrderPO> dailyOrderList;	//当天所有订单列表

    public SalerPO(String name, String tel, ArrayList<OrderPO> dailyOrderList) {
        this.name = name;
        this.tel = tel;
        this.dailyOrderList = dailyOrderList;
    }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public ArrayList<OrderPO> getDailyOrderList() {
		return dailyOrderList;
	}
	
	public void setDailyOrderList(ArrayList<OrderPO> dailyOrderList) {
		this.dailyOrderList = dailyOrderList;
	}
}
