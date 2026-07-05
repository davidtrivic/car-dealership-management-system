package org.unibl.etf.projekat_bazepodataka.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bazepodataka.model.VoziloTableModel;
import org.unibl.etf.projekat_bazepodataka.service.VoziloService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class VozilaController implements Initializable {

    @FXML private TableView<VoziloTableModel> tabelaVozila;
    @FXML private TableColumn<VoziloTableModel, String> colVIN;
    @FXML private TableColumn<VoziloTableModel, String> colMarka;
    @FXML private TableColumn<VoziloTableModel, String> colModel;
    @FXML private TableColumn<VoziloTableModel, Integer> colGodiste;
    @FXML private TableColumn<VoziloTableModel, String> colBoja;
    @FXML private TableColumn<VoziloTableModel, Integer> colKilometraza;
    @FXML private TableColumn<VoziloTableModel, String> colGorivo;
    @FXML private TableColumn<VoziloTableModel, Double> colCijena;
    @FXML private TableColumn<VoziloTableModel, String> colStatus;
    @FXML private TableColumn<VoziloTableModel, String> colTip;
    @FXML private ComboBox<String> filterStatus;

    private VoziloService voziloService = new VoziloService();
    private ObservableList<VoziloTableModel> svaVozila = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        postaviKolone();
        postaviFilter();
        ucitajVozila();
    }

    private void postaviKolone() {
        colVIN.setCellValueFactory(new PropertyValueFactory<>("vin"));
        colMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colGodiste.setCellValueFactory(new PropertyValueFactory<>("godiste"));
        colBoja.setCellValueFactory(new PropertyValueFactory<>("boja"));
        colKilometraza.setCellValueFactory(new PropertyValueFactory<>("kilometraza"));
        colGorivo.setCellValueFactory(new PropertyValueFactory<>("vrstaGoriva"));
        colCijena.setCellValueFactory(new PropertyValueFactory<>("prodajnaCijena"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colTip.setCellValueFactory(new PropertyValueFactory<>("tipVozila"));
    }

    private void postaviFilter() {
        filterStatus.setItems(FXCollections.observableArrayList(
                "Svi statusi", "Dostupno", "Rezervisano", "Prodano"
        ));
        filterStatus.setValue("Svi statusi");
        filterStatus.setOnAction(e -> filtrirajVozila());
    }

    private void ucitajVozila() {
        try {
            svaVozila.setAll(voziloService.getSvaVozilaZaPrikaz());
            tabelaVozila.setItems(svaVozila);
        } catch (SQLException e) {
            prikaziGresku("Greška pri učitavanju vozila: " + e.getMessage());
        }
    }

    private void filtrirajVozila() {
        String odabrani = filterStatus.getValue();
        if (odabrani == null || odabrani.equals("Svi statusi")) {
            tabelaVozila.setItems(svaVozila);
        } else {
            ObservableList<VoziloTableModel> filtrirano = FXCollections.observableArrayList();
            for (VoziloTableModel v : svaVozila) {
                if (v.getStatus().equals(odabrani)) {
                    filtrirano.add(v);
                }
            }
            tabelaVozila.setItems(filtrirano);
        }
    }

    @FXML
    public void onKlikVozilo(MouseEvent event) {
        if (event.getClickCount() == 2) {
            VoziloTableModel odabrano = tabelaVozila.getSelectionModel().getSelectedItem();
            if (odabrano != null) {
                otvoriDetaljeVozila(odabrano);
            }
        }
    }

    private void otvoriDetaljeVozila(VoziloTableModel vozilo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/unibl/etf/projekat_bazepodataka/DetaljiVozila.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Detalji vozila — " + vozilo.getMarka() + " " + vozilo.getModel());
            stage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(loader.load(), 500, 450);
            stage.setScene(scene);

            DetaljiVozilaController ctrl = loader.getController();
            ctrl.postaviVozilo(vozilo);

            stage.showAndWait();
        } catch (IOException e) {
            prikaziGresku("Greška pri otvaranju detalja: " + e.getMessage());
        }
    }

    @FXML
    public void otvoriDodajVozilo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/unibl/etf/projekat_bazepodataka/DodajVozilo.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj vozilo");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 550, 600));
            stage.showAndWait();
            ucitajVozila();
        } catch (IOException e) {
            prikaziGresku("Greška pri otvaranju forme: " + e.getMessage());
        }
    }

    private void prikaziGresku(String poruka) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Greška");
        alert.setContentText(poruka);
        alert.showAndWait();
    }
}