package org.unibl.etf.projekat_bazepodataka.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    @FXML private StackPane contentArea;
    @FXML private Button btnVozila;
    @FXML private Button btnKupci;
    @FXML private Button btnProdaja;
    @FXML private Button btnTestneVoznje;

    private Button aktivniBtn = null;

    @FXML
    public void prikaziVozila() {
        ucitajPogled("/org/unibl/etf/projekat_bazepodataka/VozilaView.fxml", btnVozila);
    }

    @FXML
    public void prikaziKupce() {
        ucitajPogled("/org/unibl/etf/projekat_bazepodataka/KupciView.fxml", btnKupci);
    }

    @FXML
    public void prikaziProdaju() {
        ucitajPogled("/org/unibl/etf/projekat_bazepodataka/ProdajaView.fxml", btnProdaja);
    }

    @FXML
    public void prikaziTestneVoznje() {
        ucitajPogled("/org/unibl/etf/projekat_bazepodataka/TestnaVoznjaView.fxml", btnTestneVoznje);
    }

    private void ucitajPogled(String putanja, Button kliknutiBtn) {
        try {
            // Makni aktivni stil sa prethodnog dugmeta
            if (aktivniBtn != null) {
                aktivniBtn.getStyleClass().remove("accent");
            }

            // Postavi aktivni stil na kliknuto dugme
            kliknutiBtn.getStyleClass().add("accent");
            aktivniBtn = kliknutiBtn;

            // Ucitaj FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(putanja));
            Node pogled = loader.load();
            contentArea.getChildren().setAll(pogled);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}