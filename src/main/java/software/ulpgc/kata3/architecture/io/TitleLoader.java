package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Title;

import java.util.List;

public interface TitleLoader {
    List<Title> load();
}
