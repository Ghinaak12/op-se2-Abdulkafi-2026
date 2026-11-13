package gui;

import business.VolkshochschuleModel;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VolkshochschuleView {

    private VolkshochschuleControl anwControl;
    private VolkshochschuleModel anwModel;

    private GridPane grid = new GridPane();
    private TextField txtTest = new TextField();
    private Button btnTest = new Button("Test");

    public VolkshochschuleView(
            VolkshochschuleControl anwControl,
            Stage primaryStage,
            VolkshochschuleModel anwModel) {

        this.anwControl = anwControl;
        this.anwModel = anwModel;

        this.grid.setAlignment(Pos.CENTER);
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(25, 25, 25, 25));

        primaryStage.setTitle(
                this.anwModel.getUeberschrift());

        Scene scene = new Scene(grid, 350, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

        this.initKomponenten();
        this.initListener();
    }

    private void initKomponenten() {
        this.grid.add(this.txtTest, 0, 0);
        this.grid.add(this.btnTest, 1, 0);
    }

    private void initListener() {
        btnTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                anwControl.schreibeInDatei(txtTest.getText());
            }
        });
    }

    void zeigeInformationsfensterAn(String meldung) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(meldung);
        alert.showAndWait();
    }

    void zeigeFehlermeldungAn(String meldung) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Fehlermeldung");
        alert.setContentText(meldung);
        alert.showAndWait();
    }
}