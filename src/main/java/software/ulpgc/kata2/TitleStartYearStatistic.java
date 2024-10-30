package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TitleStartYearStatistic implements TitleStatistic {
    @Override
    public Map<String, Integer> calculate(List<Title> titles) {
        Map<String, Integer> map = new HashMap<>();
        for (Title title : titles) {
            String key = title.startYear();
            if(!key.equals("\\N")) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        return map;
    }
}
