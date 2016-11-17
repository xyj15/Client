package ui.presentation;

import vo.OrderVO;

public class OrderUI {
	private class order_main{
		protected OrderVO getOrder(String orderID){
			return null;
		}
	    protected boolean addOrder(OrderVO order) {
			return true;
		}
	    protected boolean cancelOrder(OrderVO order) {
			return true;
		}
	    protected boolean abnormalOrder(OrderVO order) {
			return true;
		}
	    protected boolean cancelAbnormalOrder(OrderVO order) {
			return true;
		}
	    protected OrderVO[] getOrderList() {
			return null;
	    }
	}
}
