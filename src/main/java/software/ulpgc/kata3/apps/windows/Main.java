package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.control.SelectStatisticCommand;
import software.ulpgc.kata3.architecture.control.StatisticFactory;
import software.ulpgc.kata3.architecture.io.ChartLoader;
import software.ulpgc.kata3.architecture.io.TitleChartLoader;
import software.ulpgc.kata3.architecture.model.StatisticType;
import software.ulpgc.kata3.architecture.model.Title;
import software.ulpgc.kata3.architecture.model.TitleStatistic;
import software.ulpgc.kata3.architecture.io.TsvFileTitleLoader;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Introduzca la ruta del archivo tsv");
            return;
        }
        // Load the TSV file path from the first argument.
        String tsvPath = args[0];

        // Load all the title objects from the TSV file into a list. 
        List<Title> titles = TsvFileTitleLoader.with(new File(tsvPath)).load();

        // Calculate two different statistics from title list data.
        TitleStatistic tStat = StatisticFactory.getStatistic(StatisticType.TIMESERIES);
        TitleStatistic cStat = StatisticFactory.getStatistic(StatisticType.CATEGORY);

        // Load the statistics respectively into charts. 
        ChartLoader loader = new TitleChartLoader(tStat.calculate(titles), cStat.calculate(titles));

        // Create the MainFrame where the chart will be visualized.
        // Insert selector component into the MainFrame.
        // Load a chart selected from the selector component.
        MainFrame mainFrame = new MainFrame();
        mainFrame.put("select", new SelectStatisticCommand(mainFrame.selectStatisticDialog(), loader, mainFrame.chartDisplay()));
        mainFrame.chartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }
}
