package bl.service;

import java.util.ArrayList;
import java.util.Date;

import other.RoomType;
import vo.HotelVO;
import vo.RoomVO;

public interface SearchBLService {
	
	public boolean setCity(String city);	//设置搜索酒店城市
	public boolean setDistrict(String district);	//设置搜索酒店商圈
	public boolean setHotelName(String hotelName);	//设置搜索酒店名称
	public boolean setLevel(int level);	//设置搜索酒店星级
	public boolean setRoomType(RoomType roomType);	//设置搜索房型
	public boolean setLowerPrice(double lowerPrice);	//设置搜索价格下限
	public boolean setUpperPrice(double upperPrice);	//设置搜索价格上限
	public boolean setLowerScore(double lowerScore);	//设置搜索评分下限
	public boolean setUpperScore(double upperScore);	//设置搜索评分上限
	public boolean setCheckinTime(Date checkinTime);	//设置入住时间
	public boolean setCheckoutTime(Date checkoutTime);	//设置离店时间
	public boolean setOnlyReservationBefore(boolean onlyReservationBefore);	//设置是否只搜索预定过的酒店
	
	public ArrayList<HotelVO> search();	//根据设置过的条件返回一个酒店列表
	public ArrayList<RoomVO> getRoomList(String hotelID);	//根据酒店ID返回该酒店的客房列表
	
	public ArrayList<HotelVO> sortByPriceHighToLow();	//按价格从高到低排序
	public ArrayList<HotelVO> sortByPriceLowToHigh();	//按价格从低到高排序
	public ArrayList<HotelVO> sortByScoreHighToLow();	//按评分从高到低排序
	public ArrayList<HotelVO> sortByScoreLowToHigh();	//按评分从低到高排序
	public ArrayList<HotelVO> sortByLevelHighToLow();	//按星级从高到低排序
	public ArrayList<HotelVO> sortByLevelLowToHigh();	//按星级从低到高排序
}
