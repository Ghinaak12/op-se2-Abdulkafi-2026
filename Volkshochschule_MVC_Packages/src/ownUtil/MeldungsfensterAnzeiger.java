package ownUtil;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MeldungsfensterAnzeiger {
    private AlertType alertTyp;
    private String titel;
    private String meldung;

    public MeldungsfensterAnzeiger(AlertType alertTyp, String titel, String meldung) {
        this.alertTyp = alertTyp;
        this.titel = titel;
        this.meldung = (meldung == null || meldung.isEmpty())
                ? "Die Meldung ist nicht vorhanden." : meldung;
    }

    public void zeigeMeldungsfensterAn() {
        Alert alert = new Alert(alertTyp);
        alert.setTitle(titel);
        alert.setContentText(meldung);
        alert.showAndWait();
    }
}
