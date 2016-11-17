package bl.stub;

import bl.service.OrderBLService;
import vo.OrderVO;

public class OrderBLStub implements OrderBLService {
	
	public OrderVO getOrder(){
		return new OrderVO(1, "1997-2-2", "1997-2-5", 1, 2, "��", 0, 450,"1112585");
	}
	
    public boolean addOrder(OrderVO order) {
		return true;
	}
    
    public boolean cancelOrder(OrderVO order) {
		return true;
	}
    
    public boolean abnormalOrder(OrderVO order) {
		return true;
	}
    
    public boolean cancelAbnormalOrder(OrderVO order) {
		return true;
	}
    
    public OrderVO[] getOrderList() {
		return null;
    }
    
}
