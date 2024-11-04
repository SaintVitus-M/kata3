package software.ulpgc.kata3.architecture.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TimeSeriesStatistic implements TitleStatistic {
    private final List<String> years;
    private final List<Integer> values;

    public TimeSeriesStatistic() {
        this.years = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public List<String> years() {
        return new ArrayList<>(years);
    }

    public List<Integer> values() {
        return new ArrayList<>(values);
    }

    @Override
    public TitleStatistic calculate(List<Title> titles) {
        Map<String, Long> count = titles.stream()
                .filter(title -> !title.startYear().equals("\\N"))
                .collect(Collectors.groupingBy(Title::startYear, Collectors.counting()));

        count.forEach((year, countValue) -> {years.add(year); values.add(Math.toIntExact(countValue));});
        return this;
    }
}
