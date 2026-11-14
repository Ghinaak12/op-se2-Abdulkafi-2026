
package gui;

import business.VolkshochschuleModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class VolkshochschuleView {

    private VolkshochschuleControl volkshochschuleControl;
    private VolkshochschuleModel volkshochschuleModel;

    private Pane pane = new Pane();

    private Label lblEingabe = new Label("Eingabe");
    private Label lblAnzeige = new Label("Anzeige");
    private Label lblKursname = new Label("Kursname:");
    private Label lblKursbeitrag = new Label("Kursbeitrag:");
    private Label lblWochentag = new Label("Wochentag:");
    private Label lblStartuhrzeit = new Label("Startuhrzeit:");
    private Label lblVorkenntnisse = new Label("Vorkenntnisse:");

    private TextField txtKursname = new TextField();
    private TextField txtKursbeitrag = new TextField();
    private TextField txtWochentag = new TextField();
    private TextField txtStartuhrzeit = new TextField();
    private TextField txtVorkenntnisse = new TextField();

    private TextArea txtAnzeige = new TextArea();

    private Button btnEingabe = new Button("Eingabe");
    private Button btnAnzeige = new Button("Anzeige");

    private MenuBar mnbrMenuLeiste = new MenuBar();
    private Menu mnDatei = new Menu("Datei");
    private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport = new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport = new MenuItem("csv-Export");

    public VolkshochschuleView(Stage primaryStage,
            VolkshochschuleControl volkshochschuleControl,
            VolkshochschuleModel volkshochschuleModel) {

        Scene scene = new Scene(this.pane, 700, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Verwaltung von Volkshochschulkursen");
        primaryStage.show();

        this.initKomponenten();
        this.initListener();

        this.volkshochschuleControl = volkshochschuleControl;
        this.volkshochschuleModel = volkshochschuleModel;
    }

    private void initKomponenten() {

        // Labels
        lblEingabe.setLayoutX(20);
        lblEingabe.setLayoutY(40);

        Font font = new Font("Arial", 24);
        lblEingabe.setFont(font);
        lblEingabe.setStyle("-fx-font-weight: bold;");

        lblAnzeige.setLayoutX(400);
        lblAnzeige.setLayoutY(40);
        lblAnzeige.setFont(font);
        lblAnzeige.setStyle("-fx-font-weight: bold;");

        lblKursname.setLayoutX(20);
        lblKursname.setLayoutY(90);

        lblKursbeitrag.setLayoutX(20);
        lblKursbeitrag.setLayoutY(130);

        lblWochentag.setLayoutX(20);
        lblWochentag.setLayoutY(170);

        lblStartuhrzeit.setLayoutX(20);
        lblStartuhrzeit.setLayoutY(210);

        lblVorkenntnisse.setLayoutX(20);
        lblVorkenntnisse.setLayoutY(250);

        pane.getChildren().addAll(
            lblEingabe, lblAnzeige,
            lblKursname, lblKursbeitrag,
            lblWochentag, lblStartuhrzeit,
            lblVorkenntnisse);

        // Textfelder
        txtKursname.setLayoutX(170);
        txtKursname.setLayoutY(90);
        txtKursname.setPrefWidth(200);

        txtKursbeitrag.setLayoutX(170);
        txtKursbeitrag.setLayoutY(130);
        txtKursbeitrag.setPrefWidth(200);

        txtWochentag.setLayoutX(170);
        txtWochentag.setLayoutY(170);
        txtWochentag.setPrefWidth(200);

        txtStartuhrzeit.setLayoutX(170);
        txtStartuhrzeit.setLayoutY(210);
        txtStartuhrzeit.setPrefWidth(200);

        txtVorkenntnisse.setLayoutX(170);
        txtVorkenntnisse.setLayoutY(250);
        txtVorkenntnisse.setPrefWidth(200);

        pane.getChildren().addAll(
            txtKursname, txtKursbeitrag,
            txtWochentag, txtStartuhrzeit,
            txtVorkenntnisse);

        // Textbereich
        txtAnzeige.setEditable(false);
        txtAnzeige.setLayoutX(400);
        txtAnzeige.setLayoutY(90);
        txtAnzeige.setPrefWidth(270);
        txtAnzeige.setPrefHeight(185);

        pane.getChildren().add(txtAnzeige);

        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);

        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);

        pane.getChildren().addAll(btnEingabe, btnAnzeige);

        // Menue
        this.mnbrMenuLeiste.getMenus().add(mnDatei);
        this.mnDatei.getItems().add(mnItmCsvImport);
        this.mnDatei.getItems().add(mnItmTxtImport);
        this.mnDatei.getItems().add(new SeparatorMenuItem());
        this.mnDatei.getItems().add(mnItmCsvExport);

        pane.getChildren().add(mnbrMenuLeiste);
    }

    private void initListener() {

        btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                volkshochschuleControl.nehmeVolkshochschulkursAuf();
            }
        });

        btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                zeigeVolkshochschulkurseAn();
            }
        });

        mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                volkshochschuleControl.leseAusDatei("csv");
            }
        });

        mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                volkshochschuleControl.leseAusDatei("txt");
            }
        });

        mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                volkshochschuleControl.schreibeVolkshochschulkurseInCsvDatei();
            }
        });
    }

    void zeigeVolkshochschulkurseAn() {
        if (this.volkshochschuleModel.getVolkshochschulkurs() != null) {
            txtAnzeige.setText(
                this.volkshochschuleModel.getVolkshochschulkurs()
                    .gibVolkshochschuleZurueck(' '));
        }
        else {
            zeigeInformationsfensterAn(
                "Bisher wurde kein Volkshochschulkurs aufgenommen!");
        }
    }

    void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(
            AlertType.INFORMATION,
            "Information", meldung).zeigeMeldungsfensterAn();
    }

    void zeigeFehlermeldungsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(
            AlertType.ERROR,
            "Fehler", meldung).zeigeMeldungsfensterAn();
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public TextField getTxtKursname() {
        return txtKursname;
    }

    public void setTxtKursname(TextField txtKursname) {
        this.txtKursname = txtKursname;
    }

    public TextField getTxtKursbeitrag() {
        return txtKursbeitrag;
    }

    public void setTxtKursbeitrag(TextField txtKursbeitrag) {
        this.txtKursbeitrag = txtKursbeitrag;
    }

    public TextField getTxtWochentag() {
        return txtWochentag;
    }

    public void setTxtWochentag(TextField txtWochentag) {
        this.txtWochentag = txtWochentag;
    }

    public TextField getTxtStartuhrzeit() {
        return txtStartuhrzeit;
    }

    public void setTxtStartuhrzeit(TextField txtStartuhrzeit) {
        this.txtStartuhrzeit = txtStartuhrzeit;
    }

    public TextField getTxtVorkenntnisse() {
        return txtVorkenntnisse;
    }

    public void setTxtVorkenntnisse(TextField txtVorkenntnisse) {
        this.txtVorkenntnisse = txtVorkenntnisse;
    }

    public TextArea getTxtAnzeige() {
        return txtAnzeige;
    }

    public void setTxtAnzeige(TextArea txtAnzeige) {
        this.txtAnzeige = txtAnzeige;
    }

    public Button getBtnEingabe() {
        return btnEingabe;
    }

    public void setBtnEingabe(Button btnEingabe) {
        this.btnEingabe = btnEingabe;
    }

    public Button getBtnAnzeige() {
        return btnAnzeige;
    }

    public void setBtnAnzeige(Button btnAnzeige) {
        this.btnAnzeige = btnAnzeige;
    }

    public MenuBar getMnbrMenuLeiste() {
        return mnbrMenuLeiste;
    }

    public void setMnbrMenuLeiste(MenuBar mnbrMenuLeiste) {
        this.mnbrMenuLeiste = mnbrMenuLeiste;
    }

    public Menu getMnDatei() {
        return mnDatei;
    }

    public void setMnDatei(Menu mnDatei) {
        this.mnDatei = mnDatei;
    }

    public MenuItem getMnItmCsvImport() {
        return mnItmCsvImport;
    }

    public void setMnItmCsvImport(MenuItem mnItmCsvImport) {
        this.mnItmCsvImport = mnItmCsvImport;
    }

    public MenuItem getMnItmTxtImport() {
        return mnItmTxtImport;
    }

    public void setMnItmTxtImport(MenuItem mnItmTxtImport) {
        this.mnItmTxtImport = mnItmTxtImport;
    }

    public MenuItem getMnItmCsvExport() {
        return mnItmCsvExport;
    }

    public void setMnItmCsvExport(MenuItem mnItmCsvExport) {
        this.mnItmCsvExport = mnItmCsvExport;
    }
}
