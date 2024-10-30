package software.ulpgc.kata2;

import java.io.File;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Introduzca la ruta del archivo tsv");
            return;
        }

        String tsvPath = args[0];

        List<Title> titles = TsvFileTitleLoader.with(new File(tsvPath)).load();

        for (Title title : titles) {
            System.out.println(title);
        }
    }
}