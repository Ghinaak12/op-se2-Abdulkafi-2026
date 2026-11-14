package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VolkshochschuleModel {

    private Volkshochschulkurs volkshochschulkurs;

    public void leseAusDatei(String typ) throws IOException {

        BufferedReader ein = new BufferedReader(
            new FileReader("Volkshochschulkurse.csv"));

        String[] zeile = ein.readLine().split(";");

        this.volkshochschulkurs = new Volkshochschulkurs(
            zeile[0],
            Integer.parseInt(zeile[1]),
            zeile[2],
            Float.parseFloat(zeile[3]),
            zeile[4].split("_"));

        ein.close();
    }

    public void schreibeVolkshochschulkurseInCsvDatei() throws IOException {

        BufferedWriter aus
            = new BufferedWriter(
                new FileWriter("VolkshochschulkurseAusgabe.csv", true));

        aus.write(volkshochschulkurs.gibVolkshochschuleZurueck(';'));
        aus.close();
    }

    public Volkshochschulkurs getVolkshochschulkurs() {
        return volkshochschulkurs;
    }

    public void setVolkshochschulkurs(Volkshochschulkurs volkshochschulkurs) {
        this.volkshochschulkurs = volkshochschulkurs;
    }

}