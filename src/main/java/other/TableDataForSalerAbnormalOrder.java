package other;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 婧婧 on 2016/12/8.
 */
public class TableDataForSalerAbnormalOrder {
    private final SimpleStringProperty orderID = new SimpleStringProperty();
    private final SimpleStringProperty memberName = new SimpleStringProperty();
    private final SimpleStringProperty memberTel = new SimpleStringProperty();

    public TableDataForSalerAbnormalOrder(String orderID,String memberName,String memberTel){
        setMemberName(memberName);
        setMemberTel(memberTel);
        setOrderID(orderID);
    }

    public void setMemberName(String memberName) {
        this.memberName.set(memberName);
    }

    public void setMemberTel(String memberTel) {
        this.memberTel.set(memberTel);
    }

    public void setOrderID(String orderID) {
        this.orderID.set(orderID);
    }

    public String getOrderID() {
        return orderID.get();
    }

    public String getMemberName() {
        return memberName.get();
    }

    public String getMemberTel() {
        return memberTel.get();
    }

    public SimpleStringProperty memberNameProperty() {
        return memberName;
    }

    public SimpleStringProperty memberTelProperty() {
        return memberTel;
    }

    public SimpleStringProperty orderIDProperty() {
        return orderID;
    }
}
