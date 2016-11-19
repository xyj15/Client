package setup;

/**
 * Created by 97147 on 2016/11/19.
 */
public enum OrderStatus {
    Execute(1),Unexecute(2),Abnormal(3),Cancel(4);
    int v;
    private OrderStatus(int value){
        this.v=value;
    }
}
