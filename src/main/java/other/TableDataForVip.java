package other;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 婧婧 on 2016/12/8.
 */
public class TableDataForVip {
    private final SimpleStringProperty district = new SimpleStringProperty();
    private final SimpleStringProperty discount = new SimpleStringProperty();

    public TableDataForVip(String district,String discount){

        setDistrict(district);
        setDiscount(discount);
    }

    public void setDiscount(String discount) {
        this.discount.set(discount);
    }

    public void setDistrict(String district) {
        this.district.set(district);
    }

    public String getDiscount() {
        return discount.get();
    }

    public String getDistrict() {
        return district.get();
    }

    public SimpleStringProperty discountProperty() {
        return discount;
    }

    public SimpleStringProperty districtProperty() {
        return district;
    }
}
