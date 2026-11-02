package main;

import gui.VolkshochschuleControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        new VolkshochschuleControl(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}