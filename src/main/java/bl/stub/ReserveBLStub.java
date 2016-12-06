package bl.stub;

import bl.service.ReserveBLService;
import other.PromotionType;
import other.RoomType;
import vo.PromotionVO;
import vo.RoomVO;

import java.util.ArrayList;
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
	private RoomVO roomVO;
	
	public ReserveBLStub() {
		String promotionID = "00000";
		String promotionName = "";
		PromotionType promotionType = PromotionType.Discount;
		promotionVO = new PromotionVO(promotionID, promotionName, promotionType);
		promotionVO.setRankPromotion();
		
		boolean reserved = false;
		boolean available = false;
		String roomNumber = "3304";
		String roomName = "总统专用豪华研讨间";
		RoomType roomType = RoomType.Suite;
		double price = 99999;
		String hotelID = "123456";
		roomVO = new RoomVO(reserved, available, roomNumber, roomName, roomType, price, hotelID);
	}
	
	@Override
	public ArrayList<PromotionVO> getPromotionList() {
		System.out.println("获取可用优惠列表成功");
		ArrayList<PromotionVO> promotionList = new ArrayList<PromotionVO>();
		promotionList.add(promotionVO);
		return promotionList;
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
	public ArrayList<RoomVO> getRoomList(Date date) {
		System.out.println("获取客房列表成功");
		ArrayList<RoomVO> roomList = new ArrayList<RoomVO>();
		roomList.add(roomVO);
		return roomList;
	}
	
	@Override
	public RoomVO getSelectedRoom() {
		System.out.println("获取客房成功");
		return roomVO;
	}
	
	@Override
	public boolean setSelectedRoom(RoomVO roomVO) {
		System.out.println("设置客房成功");
		return true;
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
	public boolean createOrder() {
		System.out.println("创建订单成功");
		return true;
	}
}
