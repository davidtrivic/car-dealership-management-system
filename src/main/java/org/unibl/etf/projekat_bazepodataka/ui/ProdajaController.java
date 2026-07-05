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
import org.unibl.etf.projekat_bazepodataka.model.ProdajaInfo;
import org.unibl.etf.projekat_bazepodataka.model.ProdajaPoAgentu;
import org.unibl.etf.projekat_bazepodataka.service.ProdajaService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProdajaController implements Initializable {

    @FXML private TableView<ProdajaInfo> tabelaProdaja;
    @FXML private TableColumn<ProdajaInfo, Integer> colId;
    @FXML private TableColumn<ProdajaInfo, String> colDatum;
    @FXML private TableColumn<ProdajaInfo, String> colVozilo;
    @FXML private TableColumn<ProdajaInfo, String> colKupac;
    @FXML private TableColumn<ProdajaInfo, String> colAgent;
    @FXML private TableColumn<ProdajaInfo, String> colTipPlacanja;
    @FXML private TableColumn<ProdajaInfo, Double> colCijena;

    @FXML private TableView<ProdajaPoAgentu> tabelaPoAgentu;
    @FXML private TableColumn<ProdajaPoAgentu, Integer> colAgentId;
    @FXML private TableColumn<ProdajaPoAgentu, String> colAgentIme;
    @FXML private TableColumn<ProdajaPoAgentu, Integer> colBrojProdaja;
    @FXML private TableColumn<ProdajaPoAgentu, Double> colUkupnaVrijednost;

    private ProdajaService prodajaService = new ProdajaService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        postaviKolone();
        ucitajPodatke();
    }

    private void postaviKolone() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idProdaje"));
        colDatum.setCellValueFactory(new PropertyValueFactory<>("datumProdaje"));
        colVozilo.setCellValueFactory(new PropertyValueFactory<>("vozilo"));
        colKupac.setCellValueFactory(new PropertyValueFactory<>("kupac"));
        colAgent.setCellValueFactory(new PropertyValueFactory<>("agent"));
        colTipPlacanja.setCellValueFactory(new PropertyValueFactory<>("tipPlacanja"));
        colCijena.setCellValueFactory(new PropertyValueFactory<>("cijena"));

        colAgentId.setCellValueFactory(new PropertyValueFactory<>("idAgenta"));
        colAgentIme.setCellValueFactory(new PropertyValueFactory<>("agent"));
        colBrojProdaja.setCellValueFactory(new PropertyValueFactory<>("ukupnoProdaja"));
        colUkupnaVrijednost.setCellValueFactory(new PropertyValueFactory<>("ukupnaVrijednost"));
    }

    private void ucitajPodatke() {
        try {
            ObservableList<ProdajaInfo> prodaje =
                    FXCollections.observableArrayList(prodajaService.getSveProdajeInfo());
            tabelaProdaja.setItems(prodaje);

            ObservableList<ProdajaPoAgentu> poAgentu =
                    FXCollections.observableArrayList(prodajaService.getProdajePoAgentu());
            tabelaPoAgentu.setItems(poAgentu);

        } catch (SQLException e) {
            prikaziGresku("Greška pri učitavanju: " + e.getMessage());
        }
    }

    @FXML
    public void onKlikProdaja(MouseEvent event) {
        if (event.getClickCount() == 2) {
            ProdajaInfo odabrana = tabelaProdaja.getSelectionModel().getSelectedItem();
            if (odabrana != null) {
                otvoriDetaljiProdaje(odabrana);
            }
        }
    }

    private void otvoriDetaljiProdaje(ProdajaInfo prodaja) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/unibl/etf/projekat_bazepodataka/DetaljiProdaje.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Detalji prodaje #" + prodaja.getIdProdaje());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 450, 400));

            DetaljiProdajeController ctrl = loader.getController();
            ctrl.postaviProdaju(prodaja);

            stage.showAndWait();
        } catch (IOException e) {
            prikaziGresku("Greška: " + e.getMessage());
        }
    }

    @FXML
    public void otvoriNovaProdaja() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/unibl/etf/projekat_bazepodataka/NovaProdaja.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Nova prodaja");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 550, 600));
            stage.showAndWait();
            ucitajPodatke();
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