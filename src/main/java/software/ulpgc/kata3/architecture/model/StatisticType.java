package software.ulpgc.kata3.architecture.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jfree.data.time.TimeSeries;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Getter
public enum StatisticType {
    TIMESERIES(TimeSeriesStatistic::new),
    CATEGORY(CategoryStatistic::new);

    private final Supplier<TitleStatistic> constructor;
}
