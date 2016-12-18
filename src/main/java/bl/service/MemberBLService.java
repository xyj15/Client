package bl.service;

import java.util.ArrayList;
import java.util.Date;

import other.MemberType;
import vo.CreditChangeVO;
import vo.HotelVO;
import vo.MemberVO;
import vo.OrderVO;

/**
 * Member模块的bl层和ui层之间的接口
 * @author CROFF
 * @version 2016-11-28
 */
public interface MemberBLService {

	public String getName();	//获得客户名称
	public String getTel();	//获得客户联系方式
	public double getCredit();	//获得客户信用
	public ArrayList<CreditChangeVO> getCreditChangeList();	//获得客户信用变化列表
	public int getLevel();	//获得客户会员等级
	public double getDiscount();	//获得客户当前等级享受折扣
	public MemberType getMemberType();	//获得客户的类型（普通客户、企业客户）
	public Date getBirthday();	//获得客户生日，企业客户此项为null
	public String getEnterprise();	//获得客户所属的合作企业，普通客户此项为null
	public ArrayList<HotelVO> getReservedHotelList();	//获得预定过的酒店列表
	public ArrayList<OrderVO> getHotelOrderList(String hotelID);	//获得客户在某酒店的所有订单
	
	public MemberVO getMemberInformation();	//获得客户信息
	public boolean updateMemberInformation(MemberVO memberVO);	//更新客户信息

	public boolean newReservation(String hotelID);	//打开对应酒店的预订界面
	public boolean createOrder(OrderVO orderVO);	//创建订单
}
