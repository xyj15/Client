package bl.service;
import vo.OrderVO;

public interface OrderBLService {
	public OrderVO getOrder();
	public boolean addOrder(OrderVO order);
	public boolean cancelOrder(OrderVO order) ;
	public boolean abnormalOrder(OrderVO order);
	public boolean cancelAbnormalOrder(OrderVO order);
	public OrderVO[] getOrderList();
}
