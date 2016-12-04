package data.service;

import po.OrderPO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by apple on 2016/12/1.
 */
public interface OrderDataServiceForSaler extends OrderDataService {
	public ArrayList<OrderPO> getAbnormalOrders(Date day);  //查看当天所有异常订单列表
	public ArrayList<OrderPO> getUnfinishedOrders(Date day);  //查看当天所有未执行订单
}
