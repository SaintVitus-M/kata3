package software.ulpgc.kata3.architecture.control;

import software.ulpgc.kata3.architecture.model.StatisticType;
import software.ulpgc.kata3.architecture.model.TitleStatistic;

public class StatisticFactory {
    public static TitleStatistic getStatistic(StatisticType type) {
        return type.getConstructor().get();
    }
}
