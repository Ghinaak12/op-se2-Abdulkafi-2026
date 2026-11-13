package gui;

import javafx.stage.Stage;
import business.VolkshochschuleModel;

public class VolkshochschuleControl {

    private VolkshochschuleView anwView;
    private VolkshochschuleModel anwModel;

    public VolkshochschuleControl(Stage primaryStage) {
        this.anwModel = new VolkshochschuleModel();
        this.anwView = new VolkshochschuleView(
                this, primaryStage, anwModel);
    }

    public void schreibeInDatei(String text) {
        try {
            this.anwModel.schreibeInDatei(text);
            this.anwView.zeigeInformationsfensterAn(
                    "Der Text wurde in die Datei geschrieben.");
        }
        catch (Exception exc) {
            this.anwView.zeigeFehlermeldungAn(
                    "Fehler beim Schreiben in die Datei.");
        }
    }
}
