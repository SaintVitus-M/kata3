package software.ulpgc.kata3.architecture.control;

import software.ulpgc.kata3.architecture.io.ChartLoader;
import software.ulpgc.kata3.architecture.view.ChartDisplay;
import software.ulpgc.kata3.architecture.view.SelectStatisticDialog;

public class SelectStatisticCommand implements Command {
    private final SelectStatisticDialog dialog;
    private final ChartLoader loader;
    private final ChartDisplay display;

    public SelectStatisticCommand(SelectStatisticDialog dialog, ChartLoader loader, ChartDisplay display) {
        this.dialog = dialog;
        this.loader = loader;
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(loader.load(dialog.getSelection()));
    }
}
