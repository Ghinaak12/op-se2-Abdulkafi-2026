package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VolkshochschulkursModel {
    private Volkshochschulkurs volkshochschulkurs;

    public Volkshochschulkurs getVolkshochschulkurs() {
        return volkshochschulkurs;
    }

    public void setVolkshochschulkurs(Volkshochschulkurs volkshochschulkurs) {
        this.volkshochschulkurs = volkshochschulkurs;
    }

    public void leseAusCsvDatei(String dateiname) throws IOException {
        try (BufferedReader ein = new BufferedReader(new FileReader(dateiname))) {
            String zeile = ein.readLine();
            if (zeile == null || zeile.isEmpty()) {
                throw new IOException("Die CSV-Datei ist leer.");
            }
            String[] felder = zeile.split(";", -1);
            if (felder.length < 5) {
                throw new IOException("Die CSV-Datei enthält nicht genügend Felder.");
            }
            volkshochschulkurs = new Volkshochschulkurs(
                    felder[0],
                    Integer.parseInt(felder[1]),
                    felder[2],
                    Float.parseFloat(felder[3]),
                    felder[4].split("_")
            );
        }
    }

    public void schreibeInCsvDatei(String dateiname) throws IOException {
        if (volkshochschulkurs == null) {
            throw new IllegalStateException("Es wurde noch kein Volkshochschulkurs aufgenommen.");
        }
        try (BufferedWriter aus = new BufferedWriter(new FileWriter(dateiname, true))) {
            aus.write(volkshochschulkurs.gibVolkshochschuleZurueck(';'));
        }
    }
}
