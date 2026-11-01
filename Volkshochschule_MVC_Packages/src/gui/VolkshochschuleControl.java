package gui;

import business.Volkshochschulkurs;
import business.VolkshochschulkursModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class VolkshochschuleControl {
    private final VolkshochschulkursModel model = new VolkshochschulkursModel();
    private final VolkshochschuleView view;

    public VolkshochschuleControl(Stage primaryStage) {
        view = new VolkshochschuleView(primaryStage);
        initListener();
    }

    private void initListener() {
        view.getBtnEingabe().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) { nehmeKursAuf(); }
        });
        view.getBtnAnzeige().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) { zeigeKursAn(); }
        });
        view.getMnItmCsvImport().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) { leseAusDatei("csv"); }
        });
        view.getMnItmTxtImport().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                zeigeInformationsfensterAn("Noch nicht implementiert!");
            }
        });
        view.getMnItmCsvExport().setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) { schreibeKursInCsvDatei(); }
        });
    }

    private void nehmeKursAuf() {
        try {
            Volkshochschulkurs kurs = new Volkshochschulkurs(
                    view.getKursname(),
                    Integer.parseInt(view.getKursbeitrag()),
                    view.getWochentag(),
                    Float.parseFloat(view.getStartuhrzeit()),
                    view.getVorkenntnisse().split(";")
            );
            model.setVolkshochschulkurs(kurs);
            zeigeInformationsfensterAn("Der Volkshochschulkurs wurde aufgenommen!");
        } catch (Exception exc) {
            zeigeFehlermeldungsfensterAn(exc.getMessage());
        }
    }

    private void zeigeKursAn() {
        if (model.getVolkshochschulkurs() != null) {
            view.setAnzeige(model.getVolkshochschulkurs().gibVolkshochschuleZurueck(' '));
        } else {
            zeigeInformationsfensterAn("Bisher wurde kein Volkshochschulkurs aufgenommen!");
        }
    }

    private void leseAusDatei(String typ) {
        if (!"csv".equals(typ)) {
            zeigeInformationsfensterAn("Noch nicht implementiert!");
            return;
        }
        try {
            model.leseAusCsvDatei("Volkshochschulkurs.csv");
            zeigeInformationsfensterAn("Der Volkshochschulkurs wurde gelesen!");
        } catch (java.io.IOException exc) {
            zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
        } catch (Exception exc) {
            zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
        }
    }

    private void schreibeKursInCsvDatei() {
        try {
            model.schreibeInCsvDatei("VolkshochschulkurseAusgabe.csv");
            zeigeInformationsfensterAn("Die Volkshochschulkurse wurden gespeichert!");
        } catch (java.io.IOException exc) {
            zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
        } catch (Exception exc) {
            zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
        }
    }

    private void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung)
                .zeigeMeldungsfensterAn();
    }

    private void zeigeFehlermeldungsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung)
                .zeigeMeldungsfensterAn();
    }
}
