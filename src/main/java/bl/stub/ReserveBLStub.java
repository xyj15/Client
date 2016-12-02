package bl.stub;

import bl.service.ReserveBLService;
import other.PromotionType;
import vo.OrderVO;
import vo.PromotionVO;

import java.util.Date;

public class ReserveBLStub implements ReserveBLService {
	
	private String hotelName = "辣鸡酒店";
	private String hotelAddress = "马群街道1号";
	private int level = 4;
	private String hotelTel = "12345678910";
	private String city = "江苏省南京市";
	private String district = "栖霞区";
	private double score = 4;
	private String service = "提供行李寄存服务";
	private double price = 500;
	private String roomName = "海景房";
	private PromotionVO promotionVO;
	
	public ReserveBLStub() {
		String promotionID = "00000";
		String promotionName = "";
		PromotionType promotionType = PromotionType.Discount;
		promotionVO = new PromotionVO(promotionID, promotionName, promotionType);
		promotionVO.setRankPromotion();
	}
	
	@Override
	public PromotionVO getPromotion() {
		System.out.println("获取优惠成功");
		return promotionVO;
	}
	
	@Override
	public boolean setPromotion(PromotionVO promotion) {
		System.out.println("设置优惠成功");
		return true;
	}
	
	@Override
	public double getPrice() {
		System.out.println("获取价格成功");
		return price;
	}
	
	@Override
	public String getHotelName() {
		System.out.println("获取酒店名称成功");
		return hotelName;
	}
	
	@Override
	public String getHotelAddress() {
		System.out.println("获取酒店地址成功");
		return hotelAddress;
	}
	
	@Override
	public int getHotelLevel() {
		System.out.println("获取酒店星级成功");
		return level;
	}
	
	@Override
	public String getHotelTel() {
		System.out.println("获取酒店联系方式成功");
		return hotelTel;
	}
	
	@Override
	public String getRoomName() {
		System.out.println("获取客房类型成功");
		return roomName;
	}
	
	@Override
	public boolean setCheckinTime(Date checkinTime) {
		System.out.println("设置入住时间成功");
		return true;
	}
	
	@Override
	public boolean setChekckoutTime(Date chekckoutTime) {
		System.out.println("设置退房时间成功");
		return true;
	}
	
	@Override
	public boolean setLatestArriveTime(Date date) {
		System.out.println("设置最晚到店时间成功");
		return true;
	}
	
	@Override
	public boolean setClientName(String clientName) {
		System.out.println("设置客户名称成功");
		return true;
	}
	
	@Override
	public boolean setClientTel(String clientTel) {
		System.out.println("设置客户联系方式成功");
		return true;
	}
	
	@Override
	public boolean setNumberOfClient(int numberOfClient) {
		System.out.println("设置客户数量成功");
		return true;
	}
	
	@Override
	public boolean setHaveKids(boolean haveKids) {
		System.out.println("设置是否有儿童成功");
		return true;
	}
	
	@Override
	public boolean setNumberOfRoom(int numberOfRoom) {
		System.out.println("设置预定客房数量成功");
		return true;
	}
	
	@Override
	public boolean setOtherReq(String otherReq) {
		System.out.println("设置其他需求成功");
		return true;
	}
	
	@Override
	public boolean createOrder(OrderVO orderVO) {
		System.out.println("创建订单成功");
		return true;
	}
}
