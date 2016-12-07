package bl.service;

import java.util.ArrayList;
import java.util.Date;

import bl.implementation.Order;
import other.MemberType;
import vo.CreditChangeVO;
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
	
	public ArrayList<OrderVO> getOrderList();	//获得全部订单列表
	public ArrayList<OrderVO> getExcutedOrders();	//获得已执行订单列表
	public ArrayList<OrderVO> getUnexcutedOrders();	//获得未执行订单列表
	public ArrayList<OrderVO> getAbnormalOrders();	//获得异常订单列表
	public ArrayList<OrderVO> getCanceledOrders();	//获得已撤销订单列表
	
	public boolean cancelOrder(String orderID);	//撤销订单
	public boolean evaluateOrder(String orderID, double score, String comment);	//评价订单
	
	public MemberVO getMemberInformation();	//获得客户信息
	public boolean updateMemberInformation(MemberVO memberVO);	//更新客户信息

	public boolean newReservation(String hotelID);	//打开对应酒店的预订界面
	public boolean createOrder(OrderVO orderVO);	//创建订单
}
