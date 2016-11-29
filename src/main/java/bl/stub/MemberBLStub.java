//package bl.stub;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import bl.implementation.Search;
//import bl.service.MemberBLService;
//import other.CreditChange;
//import other.Date;
//import other.Enterprise;
//import other.MemberType;
//import vo.MemberVO;
//import vo.OrderVO;
//
//public class MemberBLStub implements MemberBLService {
//
//	String memberID;
//	String name;
//	String level;
//	String pass;
//	Double credit;
//	String phone;
//	String birth;
//
//	public MemberBLStub(String level,String memberID,String pass,String name,String birth,String phone,Double credit) {
//		this.memberID = memberID;
//		this.name = name;
//		this.level = level;
//		this.credit = credit;
//		this.phone = phone;
//		this.pass = pass;
//		this.birth = birth;
//	}
//
//	public MemberVO getMInformation(String memberID) {
//		// TODO Auto-generated method stub
//		return new MemberVO();
//	}
//
//	public boolean saveMInformation(String memberID, MemberVO M) {
//		// TODO Auto-generated method stub
//		System.out.println("用户信息保存成功");
//		return true;
//	}
//
//	public ArrayList<Double> getCreditList(String memberID) {
//		// TODO Auto-generated method stub
//		ArrayList<Double> creditList = new ArrayList<Double>();
//		creditList.add(100.0);
//		return creditList;
//	}
//
//	public Double getCredit(String memberID) {
//		// TODO Auto-generated method stub
//		return 0.0;
//	}
//
//	public boolean updateCredit(String memberID, double newCredit) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean checkCredit(String memberID) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public OrderVO getOrder(String orderID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public ArrayList<OrderVO> gerOrderList(String userID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getName() {
//		return null;
//	}
//
//	@Override
//	public String getTel() {
//		return null;
//	}
//
//	@Override
//	public double getCredit() {
//		return 0;
//	}
//
//	@Override
//	public ArrayList<CreditChange> getCreditChangeList() {
//		return null;
//	}
//
//	@Override
//	public int getLevel() {
//		return 0;
//	}
//
//	@Override
//	public double getDiscount() {
//		return 0;
//	}
//
//	@Override
//	public MemberType getMemberType() {
//		return null;
//	}
//
//	@Override
//	public Date getBirthday() {
//		return null;
//	}
//
//	@Override
//	public Enterprise getEnterprise() {
//		return null;
//	}
//
//	@Override
//	public MemberVO getMemberInformation() {
//		return null;
//	}
//
//	@Override
//	public boolean setMemberInformation(MemberVO memberVO) {
//		return false;
//	}
//
//	@Override
//	public ArrayList<OrderVO> getAllOrder() {
//		return null;
//	}
//
//	@Override
//	public ArrayList<OrderVO> getExcutedOrder() {
//		return null;
//	}
//
//	@Override
//	public ArrayList<OrderVO> getAbnormalOrder() {
//		return null;
//	}
//
//	@Override
//	public ArrayList<OrderVO> getCanceledOrder() {
//		return null;
//	}
//
//	public void cancelOrder(String orderID) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void evaluateOrder(double score, String comment) {
//
//	}
//
//	@Override
//	public void startSearch() {
//
//	}
//
//	@Override
//	public void newReservation() {
//
//	}
//
//	@Override
//	public void markHotel() {
//
//	}
//
//	@Override
//	public void CreateOrder() {
//
//	}
//
//}
