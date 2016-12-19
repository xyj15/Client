package other;

/**
 * Created by 97147 on 2016/12/19.
 */
public class roomState {
    private String name;

    public roomState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
