package bl.dataservice;

import po.HotelPO;
import po.OrderPO;
import po.RoomPO;

import java.util.ArrayList;

/**
 * Hotel模块bl层和data层之间的接口
 * @author CROFF
 * @version 2016-11-29
 */
public interface HotelDataService {

	public HotelPO getHotelInformation(String hotelID);	//获得酒店信息
	public boolean updataHotelInformation(String hotelID, HotelPO hotelPO);	//更新酒店信息
	public ArrayList<OrderPO> getOrderList(String hotelID);	//获得酒店的订单列表
	public boolean updataOrder(String orderID, OrderPO orderPO);	//更新订单状态
	public ArrayList<RoomPO> getRoomList(String hotelID);	//获得酒店的客房列表
	public RoomPO getRoomInformation(String roomID);	//获得客房信息
	public boolean updateRoom(String roomID, RoomPO roomPO);	//更新客房状态
	public boolean addRoom(RoomPO roomPO);	//添加客房
	public boolean deleteRoom(String roomID, RoomPO roomPO);	//删除客房
}