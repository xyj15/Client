package bl.stub;

import bl.service.ReserveBLService;
import vo.DateVO;
import vo.PromotionVO;

public class ReserveBLStub implements ReserveBLService {

	@Override
	public void setDate(DateVO date) {
		// TODO Auto-generated method stub
		System.out.println("设置入住日期成功");
	}

	@Override
	public void setDays(int days) {
		// TODO Auto-generated method stub
		System.out.println("设置入住天数成功");
	}

	@Override
	public void setPromotion(PromotionVO promotion) {
		// TODO Auto-generated method stub
		System.out.println("设置促销策略成功");
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		System.out.println("获取订单价值成功");
		return 100;
	}

}
