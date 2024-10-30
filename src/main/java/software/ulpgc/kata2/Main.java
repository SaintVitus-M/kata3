package software.ulpgc.kata2;

import java.io.File;
import java.util.HashMap;
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

        TitleStatistic stats = new TitleStartYearStatistic();
        Map<String, Integer> map = stats.calculate(titles);

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}