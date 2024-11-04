package software.ulpgc.kata3.apps.windows;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import software.ulpgc.kata3.architecture.model.Chart;
import software.ulpgc.kata3.architecture.model.TimeSeriesChart;

public class JFreeChartAdapter {
    public static JFreeChart adapt(Chart chart) {
        JFreeChart jFreechart;
        if(chart instanceof TimeSeriesChart) {
            jFreechart = ChartFactory.createTimeSeriesChart(
                    chart.title(),
                    chart.xAxisLabel(),
                    chart.yAxisLabel(),
                    datasetOfT(chart),
                    true,
                    false,
                    false
            );
        } else {
            jFreechart = ChartFactory.createBarChart(
                    chart.title(),
                    chart.xAxisLabel(),
                    chart.yAxisLabel(),
                    datasetOfB(chart)
            );
        }
        return jFreechart;
    }

    private static TimeSeriesCollection datasetOfT(Chart timeSeriesChart) {
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries series = new TimeSeries("Time");
        for(String year : timeSeriesChart.keySet()) {
            series.add(Year.parseYear(year), timeSeriesChart.get(year));
        }
        dataset.addSeries(series);

        return dataset;
    }

    private static CategoryDataset datasetOfB(Chart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(String category : barchart.keySet()) {
            dataset.addValue(barchart.get(category), "", category);
        }
        return dataset;
    }
}
