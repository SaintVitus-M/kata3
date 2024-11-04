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

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Introduzca la ruta del archivo tsv");
            return;
        }

        String tsvPath = args[0];

        List<Title> titles = TsvFileTitleLoader.with(new File(tsvPath)).load();

        TitleStatistic tStat = StatisticFactory.getStatistic(StatisticType.TIMESERIES);
        TitleStatistic cStat = StatisticFactory.getStatistic(StatisticType.CATEGORY);

        ChartLoader loader = new TitleChartLoader(tStat.calculate(titles), cStat.calculate(titles));

        MainFrame mainFrame = new MainFrame();
        mainFrame.put("select", new SelectStatisticCommand(mainFrame.selectStatisticDialog(), loader, mainFrame.chartDisplay()));
        mainFrame.chartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }
}