package other;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by 97147 on 2016/12/7.
 */
public class TableDataForMemberHisHotel {
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty level = new SimpleStringProperty();
    private final SimpleStringProperty price = new SimpleStringProperty();
    private final SimpleStringProperty score = new SimpleStringProperty();

    public TableDataForMemberHisHotel(String name, String level, String price, String score){
        setName(name);
        setLevel(level);
        setPrice(price);
        setScore(score);
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setScore(String score) {
        this.score.set(score);
    }

    public String getPrice() {
        return price.get();
    }

    public String getLevel() {
        return level.get();
    }

    public String getName() {
        return name.get();
    }

    public String getScore() {
        return score.get();
    }

    public SimpleStringProperty scoreProperty() {
        return score;
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public SimpleStringProperty levelProperty() {
        return level;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
}
