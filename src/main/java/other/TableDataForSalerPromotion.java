package other;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 婧婧 on 2016/12/8.
 */
public class TableDataForSalerPromotion {
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty startDate = new SimpleStringProperty();
    private final SimpleStringProperty endDate = new SimpleStringProperty();
    private final SimpleStringProperty discount = new SimpleStringProperty();

    public TableDataForSalerPromotion(String name,String startDate,String endDate, String discount){
        setName(name);
        setStartDate(startDate);
        setEndDate(endDate);
        setDiscount(discount);
    }

    public void setDiscount(String discount) {
        this.discount.set(discount);
    }

    public void setEndDate(String endDate) {
        this.endDate.set(endDate);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }

    public String getDiscount() {
        return discount.get();
    }

    public String getEndDate() {
        return endDate.get();
    }

    public String getName() {
        return name.get();
    }

    public String getStartDate() {
        return startDate.get();
    }
    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty startDateProperty() {
        return startDate;
    }

    public SimpleStringProperty endDateProperty() {
        return endDate;
    }

    public SimpleStringProperty discountProperty() {
        return discount;
    }
}
