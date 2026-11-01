package gui;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VolkshochschuleView {
    private final Pane pane = new Pane();

    private final Label lblEingabe = new Label("Eingabe");
    private final Label lblAnzeige = new Label("Anzeige");
    private final Label lblKursname = new Label("Kursname:");
    private final Label lblKursbeitrag = new Label("Kursbeitrag:");
    private final Label lblWochentag = new Label("Wochentag:");
    private final Label lblStartuhrzeit = new Label("Startuhrzeit:");
    private final Label lblVorkenntnisse = new Label("Vorkenntnisse:");

    private final TextField txtKursname = new TextField();
    private final TextField txtKursbeitrag = new TextField();
    private final TextField txtWochentag = new TextField();
    private final TextField txtStartuhrzeit = new TextField();
    private final TextField txtVorkenntnisse = new TextField();
    private final TextArea txtAnzeige = new TextArea();

    private final Button btnEingabe = new Button("Eingabe");
    private final Button btnAnzeige = new Button("Anzeige");

    private final MenuItem mnItmCsvImport = new MenuItem("csv-Import");
    private final MenuItem mnItmTxtImport = new MenuItem("txt-Import");
    private final MenuItem mnItmCsvExport = new MenuItem("csv-Export");

    public VolkshochschuleView(Stage primaryStage) {
        Scene scene = new Scene(pane, 700, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Verwaltung einer Volkshochschule");
        initKomponenten();
        primaryStage.show();
    }

    private void initKomponenten() {
        lblEingabe.setLayoutX(20); lblEingabe.setLayoutY(40);
        Font font = new Font("Arial", 24);
        lblEingabe.setFont(font); lblEingabe.setStyle("-fx-font-weight: bold;");
        lblAnzeige.setLayoutX(400); lblAnzeige.setLayoutY(40);
        lblAnzeige.setFont(font); lblAnzeige.setStyle("-fx-font-weight: bold;");

        lblKursname.setLayoutX(20); lblKursname.setLayoutY(90);
        lblKursbeitrag.setLayoutX(20); lblKursbeitrag.setLayoutY(130);
        lblWochentag.setLayoutX(20); lblWochentag.setLayoutY(170);
        lblStartuhrzeit.setLayoutX(20); lblStartuhrzeit.setLayoutY(210);
        lblVorkenntnisse.setLayoutX(20); lblVorkenntnisse.setLayoutY(250);
        pane.getChildren().addAll(lblEingabe, lblAnzeige, lblKursname,
                lblKursbeitrag, lblWochentag, lblStartuhrzeit, lblVorkenntnisse);

        txtKursname.setLayoutX(170); txtKursname.setLayoutY(90); txtKursname.setPrefWidth(200);
        txtKursbeitrag.setLayoutX(170); txtKursbeitrag.setLayoutY(130); txtKursbeitrag.setPrefWidth(200);
        txtWochentag.setLayoutX(170); txtWochentag.setLayoutY(170); txtWochentag.setPrefWidth(200);
        txtStartuhrzeit.setLayoutX(170); txtStartuhrzeit.setLayoutY(210); txtStartuhrzeit.setPrefWidth(200);
        txtVorkenntnisse.setLayoutX(170); txtVorkenntnisse.setLayoutY(250); txtVorkenntnisse.setPrefWidth(200);
        pane.getChildren().addAll(txtKursname, txtKursbeitrag, txtWochentag,
                txtStartuhrzeit, txtVorkenntnisse);

        txtAnzeige.setEditable(false);
        txtAnzeige.setLayoutX(400); txtAnzeige.setLayoutY(90);
        txtAnzeige.setPrefWidth(270); txtAnzeige.setPrefHeight(185);
        pane.getChildren().add(txtAnzeige);

        btnEingabe.setLayoutX(20); btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400); btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige);

        MenuBar menuBar = new MenuBar();
        Menu datei = new Menu("Datei");
        datei.getItems().addAll(mnItmCsvImport, mnItmTxtImport,
                new SeparatorMenuItem(), mnItmCsvExport);
        menuBar.getMenus().add(datei);
        pane.getChildren().add(menuBar);
    }

    public String getKursname() { return txtKursname.getText(); }
    public String getKursbeitrag() { return txtKursbeitrag.getText(); }
    public String getWochentag() { return txtWochentag.getText(); }
    public String getStartuhrzeit() { return txtStartuhrzeit.getText(); }
    public String getVorkenntnisse() { return txtVorkenntnisse.getText(); }
    public void setAnzeige(String text) { txtAnzeige.setText(text); }

    public Button getBtnEingabe() { return btnEingabe; }
    public Button getBtnAnzeige() { return btnAnzeige; }
    public MenuItem getMnItmCsvImport() { return mnItmCsvImport; }
    public MenuItem getMnItmTxtImport() { return mnItmTxtImport; }
    public MenuItem getMnItmCsvExport() { return mnItmCsvExport; }
}
