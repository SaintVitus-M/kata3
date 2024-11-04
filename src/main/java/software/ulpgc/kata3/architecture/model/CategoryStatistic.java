package software.ulpgc.kata3.architecture.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategoryStatistic implements TitleStatistic{
    private final List<String> categories;
    private final List<Long> values;

    public CategoryStatistic() {
        this.categories = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public List<String> categories() {
        return new ArrayList<>(categories);
    }

    public List<Long> values() {
        return new ArrayList<>(values);
    }

    @Override
    public TitleStatistic calculate(List<Title> titles) {
        Map<String, Long> count = titles.stream()
                .filter(title -> (title.titleType().equals("movie") && title.startYear().equals("2020")))
                .flatMap(title -> Arrays.stream(title.genres()))
                .filter(genre -> !genre.equals("\\N"))
                .collect(Collectors.groupingBy(genre -> genre, Collectors.counting()));

        count.forEach((genre, countValue) -> {categories.add(genre); values.add(countValue);});
        return this;
    }
}
