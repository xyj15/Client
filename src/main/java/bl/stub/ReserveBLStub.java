package bl.stub;

import bl.service.ReserveBLService;
import other.Date;
import other.RoomType;
import vo.PromotionVO;

public class ReserveBLStub implements ReserveBLService {
	
	public void setPromotion(PromotionVO promotion) {
		// TODO Auto-generated method stub
		System.out.println("设置促销策略成功");
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		System.out.println("获取订单价值成功");
		return 100;
	}
	
	@Override
	public String getHotelName() {
		return null;
	}
	
	@Override
	public String getHotelAddress() {
		return null;
	}
	
	@Override
	public String getHotelLevel() {
		return null;
	}
	
	@Override
	public String getHotelTel() {
		return null;
	}
	
	@Override
	public RoomType getRoomType() {
		return null;
	}
	
	@Override
	public void setCheckinTime(Date checkinTime) {
		
	}
	
	@Override
	public void setChekckoutTime(Date chekckoutTime) {
		
	}
	
	@Override
	public void setClientName(String clientName) {
		
	}
	
	@Override
	public void setClientTel(String clientTel) {
		
	}
	
	@Override
	public void setOtherReq(String otherReq) {
		
	}
	
	@Override
	public void createOrder() {
		
	}
	
}
