package software.ulpgc.kata3.architecture.model;

public class TimeSeriesChart extends Chart {
    private final boolean legend;
    private final boolean tooltips;
    private final boolean urls;

    public TimeSeriesChart(String title, String xAxisLabel, String yAxisLabel, boolean legend, boolean tooltips, boolean urls) {
        super(title, xAxisLabel, yAxisLabel);
        this.legend = legend;
        this.tooltips = tooltips;
        this.urls = urls;
    }

    public boolean legend() {
        return legend;
    }

    public boolean tooltips() {
        return tooltips;
    }

    public boolean urls() {
        return urls;
    }
}
