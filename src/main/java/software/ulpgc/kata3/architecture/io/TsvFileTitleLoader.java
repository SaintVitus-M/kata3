package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Title;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class TsvFileTitleLoader implements TitleLoader {
    private final File file;

    public TsvFileTitleLoader(File file) {
        this.file = file;
    }

    public static TitleLoader with(File file) {return new TsvFileTitleLoader(file);}

    @Override
    public List<Title> load() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return load(br);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private List<Title> load(BufferedReader br) throws IOException {
        List<Title> titles = new ArrayList<>();
        br.readLine();

        while (true) {
            String line = br.readLine();
            if(line == null) break;
            titles.add(toTitle(line));
        }
        return titles;
    }

    private Title toTitle(String line) {
        return toTitle(line.split("\t"));
    }

    private Title toTitle(String[] split) {
        return new Title(
                split[0],
                split[1],
                split[2],
                split[3],
                split[4].equals("1"),
                split[5],
                split[6],
                split[7],
                split[8].split(",")
        );
    }
}
