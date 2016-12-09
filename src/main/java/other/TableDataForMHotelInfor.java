package other;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 97147 on 2016/12/8.
 */
public class TableDataForMHotelInfor {
    private final SimpleStringProperty type = new SimpleStringProperty();
    private final SimpleStringProperty num = new SimpleStringProperty();
    private final SimpleStringProperty price = new SimpleStringProperty();

    TableDataForMHotelInfor(String type,String num,String price){
        setType(type);
        setNum(num);
        setPrice(price);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getNum() {
        return num.get();
    }

    public String getPrice() {
        return price.get();
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public SimpleStringProperty numProperty() {
        return num;
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }
}
