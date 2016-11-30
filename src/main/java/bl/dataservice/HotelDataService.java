package bl.dataservice;

import po.HotelPO;
import po.OrderPO;
import po.RoomPO;

import java.util.ArrayList;

/**
 * Hotel模块bl层和data层之间的接口
 * @author CROFF
 * @version 2016-12-1
 */
public interface HotelDataService {

	public boolean updataHotelInformation(String hotelID, HotelPO hotelPO);	//更新酒店信息
	public boolean addHotel(HotelPO hotelPO);	//添加酒店
	public boolean deleteHotel(String hotelID);	//删除酒店
	public boolean updateHotelManagerInformation(String hotelID, String name, String tel);	//更新酒店工作人员信息，参数为酒店ID、工作人员的姓名和联系方式
	public ArrayList<HotelPO> getHotelList();	//获得酒店列表
	public HotelPO getHotelInformation(String hotelID);	//获得酒店信息
}