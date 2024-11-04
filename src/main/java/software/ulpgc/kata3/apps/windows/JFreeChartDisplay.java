package software.ulpgc.kata3.apps.windows;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import software.ulpgc.kata3.architecture.model.Chart;
import software.ulpgc.kata3.architecture.view.ChartDisplay;

import javax.swing.*;
import java.awt.*;

public class JFreeChartDisplay extends JPanel implements ChartDisplay {
    public JFreeChartDisplay() {setLayout(new BorderLayout());}

    @Override
    public void show(Chart chart) {
        removeAll();
        add(new ChartPanel(adapt(chart)));
        revalidate();
    }

    public JFreeChart adapt(Chart chart) {return JFreeChartAdapter.adapt(chart);}
}
