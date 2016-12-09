package other;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 97147 on 2016/12/7.
 */
public final class TableDataForMemberInfor {
    private final SimpleStringProperty num = new SimpleStringProperty();
    private final SimpleStringProperty date = new SimpleStringProperty();
    private final SimpleStringProperty action = new SimpleStringProperty();
    private final SimpleStringProperty change = new SimpleStringProperty();
    private final SimpleStringProperty now = new SimpleStringProperty();

    public TableDataForMemberInfor(String num, String d, String a, String c, String n){
        setNum(num);
        setDate(d);
        setAction(a);
        setChange(c);
        setNow(n);
    }

    public void setAction(String action) {
        this.action.set(action);
    }

    public String getAction() {
        return action.get();
    }

    public SimpleStringProperty numProperty() {
        return num;
    }

    public void setChange(String change) {
        this.change.set(change);
    }

    public String getChange() {
        return change.get();
    }

    public SimpleStringProperty changeProperty() {
        return change;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setNow(String now) {
        this.now.set(now);
    }

    public String getNow() {
        return now.get();
    }

    public SimpleStringProperty nowProperty() {
        return now;
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public String getNum() {
        return num.get();
    }

    public SimpleStringProperty actionProperty() {
        return action;
    }
}
