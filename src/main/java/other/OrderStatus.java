package other;

/**
 * Created by 97147 on 2016/11/19.
 */
public enum OrderStatus {
    Executed(1), Unexecuted(2), Abnormal(3), Canceled(4);
    int v;
    private OrderStatus(int value){
        this.v=value;
    }
}
