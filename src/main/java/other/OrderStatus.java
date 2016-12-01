package other;

/**
 * Created by 97147 on 2016/11/19.
 * 订单状态枚举类，分为已执行、未执行、异常、已撤销
 * Excuted：已执行(0)
 * Unexecuted：未执行(1)
 * Abnormal：异常(2)
 * Canceled：已撤销(3)
 * CancelAbnormal：已撤销异常(4)
 * @author CROFF
 * @version 2016-11-30
 */
public enum OrderStatus {
    Executed(0), Unexecuted(1), Abnormal(2), Canceled(3), CancelAbnormal(4);
	
    int value;
    private OrderStatus(int value) {
        this.value = value;
    }
	
	public int getValue() {
		return value;
	}
}
