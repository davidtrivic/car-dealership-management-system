package org.unibl.etf.projekat_bazepodataka.ui;

import atlantafx.base.theme.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Application.setUserAgentStylesheet(new CupertinoLight().getUserAgentStylesheet());

        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource(
                "/org/unibl/etf/projekat_bazepodataka/MainWindow.fxml"));
        Scene scene = new Scene(loader.load(), 1200, 700);
        stage.setTitle("Autosalon");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}