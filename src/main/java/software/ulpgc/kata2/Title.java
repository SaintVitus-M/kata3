package software.ulpgc.kata2;

import java.util.Arrays;

public record Title(
        String tconst,
        String titleType,
        String primaryTitle,
        String originalTitle,
        boolean isAdult,
        String startYear,
        String endYear,
        String runtimeMinutes,
        String[] genres
) {
    @Override
    public String toString() {
        return tconst + '\t' +
                 titleType + '\t' +
                 primaryTitle + '\t' +
                 originalTitle + '\t' +
                 isAdult + "\t" +
                startYear + '\t' +
                endYear + '\t' +
                runtimeMinutes + '\t' +
                Arrays.toString(genres);
    }
}
