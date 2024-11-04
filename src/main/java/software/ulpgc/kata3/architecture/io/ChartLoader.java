package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Chart;

public interface ChartLoader {
    Chart load(int id);
}
