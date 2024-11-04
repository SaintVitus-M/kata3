package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.*;

public class TitleChartLoader implements ChartLoader {
    private final TitleStatistic tss;
    private final TitleStatistic cs;

    public TitleChartLoader(TitleStatistic tss, TitleStatistic cs) {
        this.tss = tss;
        this.cs = cs;
    }

    @Override
    public Chart load(int id) {
        return switch(id) {
            case 0 -> timeSeriesChart((TimeSeriesStatistic) tss);
            case 1 -> barchart((CategoryStatistic) cs);
            default -> null;
        };
    }

    private Barchart barchart(CategoryStatistic cs) {
        Barchart barchart = new Barchart(
                "Total de películas 2020 según género",
                "Género",
                "Frecuencia"
        );
        for(int i = 0; i < cs.categories().size(); i++) {
            barchart.put(cs.categories().get(i), Math.toIntExact(cs.values().get(i)));
        }
        return barchart;
    }

    private TimeSeriesChart timeSeriesChart(TimeSeriesStatistic tss) {
        TimeSeriesChart tsc = new TimeSeriesChart(
                "Total de títulos lanzados según los años",
                "Año",
                "Frecuencia",
                true,
                false,
                false
        );
        for(int i = 0; i < tss.years().size(); i++) {
            tsc.put(tss.years().get(i), tss.values().get(i));
        }
        return tsc;
    }
}
