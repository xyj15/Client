package bl.service;

import java.util.ArrayList;

import other.CreditChange;
import other.Date;
import other.Enterprise;
import other.MemberType;
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
	public ArrayList<CreditChange> getCreditChangeList();	//获得客户信用变化列表
	public int getLevel();	//获得客户会员等级
	public double getDiscount();	//获得客户当前等级享受折扣
	public MemberType getMemberType();	//获得客户的类型（普通客户、企业客户）
	public Date getBirthday();	//获得客户生日，企业客户此项为null
	public Enterprise getEnterprise();	//获得客户所属的合作企业，普通客户此项为null
	
	public MemberVO getMemberInformation();	//获得客户信息
	public boolean updateMemberInformation(MemberVO memberVO);	//更新客户信息

	public boolean startSearch();	//开始搜索酒店
	public boolean newReservation(String hotelID, String roomID);	//预定酒店
	public boolean showOrder();	//查看订单
	public boolean markHotel();	//收藏（标记）酒店
	public boolean CreateOrder(OrderVO orderVO);	//创建订单
}
