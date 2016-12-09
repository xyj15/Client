package other;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 97147 on 2016/12/8.
 */
public class TableData {
    private final SimpleStringProperty first = new SimpleStringProperty();
    private final SimpleStringProperty second = new SimpleStringProperty();
    private final SimpleStringProperty third = new SimpleStringProperty();
    private final SimpleStringProperty fourth = new SimpleStringProperty();
    private final SimpleStringProperty fifth = new SimpleStringProperty();
    public TableData(String  first, String second){
        setFirst(first);
        setSecond(second);
    }public TableData(String  first, String second, String third){
        setFirst(first);
        setSecond(second);
        setThird(third);
    }public TableData(String  first, String second, String third, String fourth){
        setFirst(first);
        setSecond(second);
        setThird(third);
        setFourth(fourth);
    }
    public TableData(String  first, String second, String third, String fourth, String fifth){
        setFirst(first);
        setSecond(second);
        setThird(third);
        setFourth(fourth);
        setFifth(fifth);
    }

    public void setFirst(String first) {
        this.first.set(first);
    }

    public void setSecond(String second) {
        this.second.set(second);
    }

    public void setThird(String third) {
        this.third.set(third);
    }

    public void setFourth(String fourth) {
        this.fourth.set(fourth);
    }

    public void setFifth(String fifth) {
        this.fifth.set(fifth);
    }

    public String getFifth() {
        return fifth.get();
    }

    public String getFirst() {
        return first.get();
    }

    public String getFourth() {
        return fourth.get();
    }

    public String getSecond() {
        return second.get();
    }

    public String getThird() {
        return third.get();
    }

    public SimpleStringProperty secondProperty() {
        return second;
    }

    public SimpleStringProperty firstProperty() {
        return first;
    }

    public SimpleStringProperty fourthProperty() {
        return fourth;
    }

    public SimpleStringProperty thirdProperty() {
        return third;
    }

    public SimpleStringProperty fifthProperty() {
        return fifth;
    }
}
