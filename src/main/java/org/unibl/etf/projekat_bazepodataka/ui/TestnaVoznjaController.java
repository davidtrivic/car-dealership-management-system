package org.unibl.etf.projekat_bazepodataka.ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bazepodataka.model.TestnaVoznjaInfo;
import org.unibl.etf.projekat_bazepodataka.service.TestnaVoznjaService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestnaVoznjaController implements Initializable {

    @FXML private TableView<TestnaVoznjaInfo> tabelaTestnihVoznji;
    @FXML private TableColumn<TestnaVoznjaInfo, String> colDatum;
    @FXML private TableColumn<TestnaVoznjaInfo, String> colVozilo;
    @FXML private TableColumn<TestnaVoznjaInfo, String> colVIN;
    @FXML private TableColumn<TestnaVoznjaInfo, String> colKupac;
    @FXML private TableColumn<TestnaVoznjaInfo, String> colAgent;

    private TestnaVoznjaService testnaVoznjaService = new TestnaVoznjaService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        postaviKolone();
        ucitajTestneVoznje();
    }

    private void postaviKolone() {
        colDatum.setCellValueFactory(new PropertyValueFactory<>("datumVoznje"));
        colVozilo.setCellValueFactory(new PropertyValueFactory<>("vozilo"));
        colVIN.setCellValueFactory(new PropertyValueFactory<>("vin"));
        colKupac.setCellValueFactory(new PropertyValueFactory<>("kupac"));
        colAgent.setCellValueFactory(new PropertyValueFactory<>("agent"));
    }

    private void ucitajTestneVoznje() {
        try {
            tabelaTestnihVoznji.setItems(FXCollections.observableArrayList(
                    testnaVoznjaService.getSveTestneVoznjeInfo()
            ));
        } catch (SQLException e) {
            prikaziGresku("Greška pri učitavanju: " + e.getMessage());
        }
    }

    @FXML
    public void otvoriNovaTestnaVoznja() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/unibl/etf/projekat_bazepodataka/NovaTestnaVoznja.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Zakaži testnu vožnju");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 500, 380));
            stage.showAndWait();
            ucitajTestneVoznje();
        } catch (IOException e) {
            prikaziGresku("Greška: " + e.getMessage());
        }
    }

    private void prikaziGresku(String poruka) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Greška");
        alert.setContentText(poruka);
        alert.showAndWait();
    }
}