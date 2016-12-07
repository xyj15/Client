package bl.stub;

import java.util.ArrayList;
import java.util.Date;

import bl.service.MemberBLService;
import other.MemberType;
import other.OrderAction;
import other.OrderStatus;
import vo.CreditChangeVO;
import vo.MemberVO;
import vo.OrderVO;

public class MemberBLStub implements MemberBLService {
	
	private MemberVO memberVO;
	private ArrayList<OrderVO> orderList;
	private double credit = 100;
	
	public MemberBLStub() {
		String memberID = "12345678";
		String password = "12345678910";
		String name = "周杰伦";
		String tel = "12345678910";
		int level = 1;
		double discount = 1;
		MemberType memberType = MemberType.Orinary;
		Date birthday = new Date();
		String enterprise = "南京大学有限公司";
		memberVO = new MemberVO(memberID, password, name, tel, level, discount,
				memberType, birthday, enterprise);
		
		memberID = "12345678";
		String hotelID = "123456";
		String orderID = "00000";
		OrderStatus orderStatus = OrderStatus.Executed;
		Date createTime = new Date();
		Date checkinTime = new Date();
		Date actualCheckinTime = new Date();
		Date latestCheckinTime = new Date();
		Date checkoutTime = new Date();
		Date actualCheckoutTime = new Date();
		int numberOfRoom = 4;
		String roomName = "商务大床房";
		int numberOfClient = 4;
		boolean haveKids = false;
		double score = 5;
		String evaluation = "床太硬了不酥服555555";
		double recover = 0.5;
		String promotionID = "00000";
		double price = 99999;
		Date cancelTime = new Date();
		OrderVO orderVO = new OrderVO(memberID, hotelID, orderID, orderStatus, createTime,
				checkinTime, actualCheckinTime, latestCheckinTime, checkoutTime, actualCheckoutTime,
				numberOfRoom, roomName, numberOfClient, haveKids, score, evaluation, recover,
				promotionID, price, cancelTime);
		orderList.add(orderVO);
	}
	
	@Override
	public String getName() {
		System.out.println("获取名称成功");
		return memberVO.getName();
	}
	
	@Override
	public String getTel() {
		System.out.println("获取联系方式成功");
		return memberVO.getTel();
	}
	
	@Override
	public double getCredit() {
		System.out.println("获取客户信用成功");
		return credit;
	}
	
	@Override
	public ArrayList<CreditChangeVO> getCreditChangeList() {
		System.out.println("获取信用变化情况成功");
		ArrayList<CreditChangeVO> creditChangeList = new ArrayList<CreditChangeVO>();
		CreditChangeVO creditChange = new CreditChangeVO(new Date(), "20161101000000", OrderAction.ExecuteOrder, 100, 100);
		creditChangeList.add(creditChange);
		creditChange = new CreditChangeVO(new Date(), "20161102000000", OrderAction.ExecuteOrder, 100, 200);
		creditChangeList.add(creditChange);
		return creditChangeList;
	}
	
	@Override
	public int getLevel() {
		System.out.println("获取客户会员等级成功");
		return memberVO.getLevel();
	}
	
	@Override
	public double getDiscount() {
		System.out.println("获取折扣成功");
		return memberVO.getDiscount();
	}
	
	@Override
	public MemberType getMemberType() {
		System.out.println("获取客户类型成功");
		return memberVO.getMemberType();
	}
	
	@Override
	public Date getBirthday() {
		System.out.println("获取生日成功");
		return memberVO.getBirthday();
	}
	
	@Override
	public String getEnterprise() {
		System.out.println("获取合作企业名称成功");
		return memberVO.getEnterprise();
	}
	
	@Override
	public ArrayList<OrderVO> getOrderList() {
		System.out.println("获取订单列表成功");
		return orderList;
	}
	
	@Override
	public ArrayList<OrderVO> getExcutedOrders() {
		System.out.println("获取已执行订单列表成功");
		orderList.get(0).setOrderStatus(OrderStatus.Executed);
		return orderList;
	}
	
	@Override
	public ArrayList<OrderVO> getUnexcutedOrders() {
		System.out.println("获取未执行订单列表成功");
		orderList.get(0).setOrderStatus(OrderStatus.Unexecuted);
		return orderList;
	}
	
	@Override
	public ArrayList<OrderVO> getAbnormalOrders() {
		System.out.println("获取异常订单列表成功");
		orderList.get(0).setOrderStatus(OrderStatus.Abnormal);
		return orderList;
	}
	
	@Override
	public ArrayList<OrderVO> getCanceledOrders() {
		System.out.println("获取已撤销订单列表成功");
		orderList.get(0).setOrderStatus(OrderStatus.Canceled);
		return orderList;
	}
	
	@Override
	public boolean cancelOrder(String orderID) {
		System.out.println("撤销订单成功");
		return true;
	}
	
	@Override
	public boolean evaluateOrder(String orderID, double score, String comment) {
		System.out.println("评价订单成功");
		return true;
	}
	
	@Override
	public MemberVO getMemberInformation() {
		System.out.println("获取客户信息成功");
		return memberVO;
	}
	
	@Override
	public boolean updateMemberInformation(MemberVO memberVO) {
		System.out.println("更新客户信息成功");
		return true;
	}
	
	@Override
	public boolean newReservation(String hotelID) {
		System.out.println("新建预订成功");
		return true;
	}
	
	@Override
	public boolean createOrder(OrderVO orderVO) {
		System.out.println("创建订单成功");
		return true;
	}
}
