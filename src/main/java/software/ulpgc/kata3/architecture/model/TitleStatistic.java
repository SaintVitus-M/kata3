package software.ulpgc.kata3.architecture.model;

import java.util.List;

public interface TitleStatistic {
    TitleStatistic calculate(List<Title> titles);
}
