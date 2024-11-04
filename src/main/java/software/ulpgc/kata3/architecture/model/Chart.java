package software.ulpgc.kata3.architecture.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Chart {
    private final String title;
    private final String xAxisLabel;
    private final String yAxisLabel;
    private final Map<String, Integer> count;

    public Chart(String title, String xAxisLabel, String yAxisLabel) {
        this.title = title;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
        this.count = new HashMap<>();
    }

    public String title() {
        return title;
    }

    public String xAxisLabel() {
        return xAxisLabel;
    }

    public String yAxisLabel() {
        return yAxisLabel;
    }

    public int get(String category) {return count.get(category);}
    public void put(String category, int value) {count.put(category, value);}
    public Set<String> keySet() {return count.keySet();}
}
