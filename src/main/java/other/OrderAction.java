package other;

/**
 * Created by 97147 on 2016/11/19.
 * 导致信用变化的行为
 * ExecuteOrder：订单正常执行
 * AbnormalOrder：订单异常
 * CancelOrder：取消订单
 * RechargeCredit：信用充值
 */
public enum OrderAction {
    ExecuteOrder, AbnormalOrder, CancelOrder, RechargeCredit;
}
