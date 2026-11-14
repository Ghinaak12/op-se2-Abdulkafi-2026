package gui;

import business.Volkshochschulkurs;

import java.io.IOException;

import business.VolkshochschuleModel;
import javafx.stage.Stage;

public class VolkshochschuleControl {

    private VolkshochschuleView volkshochschuleView;
    private VolkshochschuleModel volkshochschuleModel;

    public VolkshochschuleControl(Stage stage) {
        super();
        this.volkshochschuleModel = new VolkshochschuleModel();
        this.volkshochschuleView = new VolkshochschuleView(
            stage, this, volkshochschuleModel);
    }

    void nehmeVolkshochschulkursAuf() {
        try {
            this.volkshochschuleModel.setVolkshochschulkurs(
                new Volkshochschulkurs(
                    volkshochschuleView.getTxtKursname().getText(),
                    Integer.parseInt(volkshochschuleView.getTxtKursbeitrag().getText()),
                    volkshochschuleView.getTxtWochentag().getText(),
                    Float.parseFloat(volkshochschuleView.getTxtStartuhrzeit().getText()),
                    volkshochschuleView.getTxtVorkenntnisse().getText().split(";")));

            volkshochschuleView.zeigeInformationsfensterAn(
                "Der Volkshochschulkurs wurde aufgenommen!");
        }
        catch(Exception exc) {
            volkshochschuleView.zeigeFehlermeldungsfensterAn(exc.getMessage());
        }
    }

    void leseAusDatei(String typ) {
        try {
            if("csv".equals(typ)) {
                volkshochschuleModel.leseAusDatei(typ);
                volkshochschuleView.zeigeInformationsfensterAn(
                    "Der Volkshochschulkurs wurde gelesen!");
            }
            else {
                volkshochschuleView.zeigeInformationsfensterAn(
                    "Noch nicht implementiert!");
            }
        }
        catch(IOException exc) {
            volkshochschuleView.zeigeFehlermeldungsfensterAn(
                "IOException beim Lesen!");
        }
        catch(Exception exc) {
            volkshochschuleView.zeigeFehlermeldungsfensterAn(
                "Unbekannter Fehler beim Lesen!");
        }
    }

    void schreibeVolkshochschulkurseInCsvDatei() {
        try {
            volkshochschuleModel.schreibeVolkshochschulkurseInCsvDatei();
            volkshochschuleView.zeigeInformationsfensterAn(
                "Die Volkshochschulkurse wurden gespeichert!");
        }
        catch(IOException exc) {
            volkshochschuleView.zeigeFehlermeldungsfensterAn(
                "IOException beim Speichern!");
        }
        catch(Exception exc) {
            volkshochschuleView.zeigeFehlermeldungsfensterAn(
                "Unbekannter Fehler beim Speichern!");
        }
    }

}