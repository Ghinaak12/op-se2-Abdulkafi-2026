package business;

import java.io.*;

public class VolkshochschuleModel {

    public VolkshochschuleModel() {
    }

    public String getUeberschrift() {
        return "Verwaltung einer Volkshochschule";
    }

    public void schreibeInDatei(String text)
            throws Exception {

        BufferedWriter aus =
                new BufferedWriter(
                        new FileWriter("Text.txt"));

        aus.write(text);
        aus.close();
    }
}