package other;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 97147 on 2016/12/7.
 */
public class TableDateForMemberOrder {
    private final SimpleStringProperty num = new SimpleStringProperty();
    private final SimpleStringProperty date = new SimpleStringProperty();
    private final SimpleStringProperty hotelName = new SimpleStringProperty();
    private final SimpleStringProperty price = new SimpleStringProperty();

    public TableDateForMemberOrder(String num,String date,String hotelName, String price){
        setNum(num);
        setDate(date);
        setHotelName(hotelName);
        setPrice(price);
    }

    public void setNum(String num) {
        this.num.set(num);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setHotelName(String hotelName) {
        this.hotelName.set(hotelName);
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getNum() {
        return num.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getHotelName() {
        return hotelName.get();
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public SimpleStringProperty hotelNameProperty() {
        return hotelName;
    }

    public SimpleStringProperty numProperty() {
        return num;
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }
}
