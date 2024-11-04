package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.control.Command;
import software.ulpgc.kata3.architecture.view.ChartDisplay;
import software.ulpgc.kata3.architecture.view.SelectStatisticDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private SelectStatisticDialog selectStatisticDialog;
    private JFreeChartDisplay jFreeDisplay;

    public MainFrame() throws HeadlessException {
        this.setTitle("Kata 3 Application");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, toolbar());
        this.add(jFreeDisplay = statisticPanel());
        this.commands = new HashMap<>();
    }

    public void put(String name, Command command) {commands.put(name, command);}

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(selector());
        return panel;
    }

    private Component selector() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Histogram");
        comboBox.addItem("Time Series");
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) return;
                commands.get("select").execute();
            }
        });
        selectStatisticDialog = new SelectStatisticDialog() {
            @Override
            public int getSelection() {return comboBox.getSelectedIndex();}
        };
        return comboBox;
    }

    private JFreeChartDisplay statisticPanel() {
        return new JFreeChartDisplay();
    }

    public SelectStatisticDialog selectStatisticDialog() {
        return selectStatisticDialog;
    }

    public ChartDisplay chartDisplay() {
        return jFreeDisplay;
    }
}
