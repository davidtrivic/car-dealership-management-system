package org.unibl.etf.projekat_bazepodataka.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bazepodataka.dao.UplataDAO;
import org.unibl.etf.projekat_bazepodataka.model.ProdajaInfo;
import org.unibl.etf.projekat_bazepodataka.model.Uplata;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DetaljiProdajeController implements Initializable{

    @FXML private Label lblNaslov;
    @FXML private Label lblVIN, lblMarka, lblModel, lblGodiste;
    @FXML private Label lblJMB, lblKupac;
    @FXML private Label lblAgentId, lblAgent;
    @FXML private Label lblDatum, lblCijena, lblTipPlacanja;
    @FXML private TableView<Uplata> tabelaUplata;
    @FXML private TableColumn<Uplata, Integer> colIdUplate;
    @FXML private TableColumn<Uplata, String> colDatumUplate;
    @FXML private TableColumn<Uplata, Double> colIznosUplate;
    @FXML private Label lblStatusUplata;
    @FXML private Button btnDodajUplatu;

    private UplataDAO uplataDAO = new UplataDAO();
    private ProdajaInfo trenutnaProdaja;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colIdUplate.setCellValueFactory(new PropertyValueFactory<>("idUplate"));
        colDatumUplate.setCellValueFactory(new PropertyValueFactory<>("datumUplate"));
        colIznosUplate.setCellValueFactory(new PropertyValueFactory<>("iznos"));
    }

    public void postaviProdaju(ProdajaInfo p) {
        this.trenutnaProdaja = p;

        lblNaslov.setText("Prodaja #" + p.getIdProdaje());
        lblVIN.setText(p.getVinVozila());
        lblMarka.setText(p.getMarkaVozila());
        lblModel.setText(p.getModelVozila());
        lblGodiste.setText(String.valueOf(p.getGodisteVozila()));
        lblJMB.setText(p.getJmbKupca());
        lblKupac.setText(p.getKupac());
        lblAgentId.setText(String.valueOf(p.getIdAgenta()));
        lblAgent.setText(p.getAgent());
        lblDatum.setText(p.getDatumProdaje().toString());
        lblCijena.setText(String.format("%.2f KM", p.getCijena()));
        lblTipPlacanja.setText(p.getTipPlacanja());

        if (p.getTipPlacanja().equals("Gotovina")) {
            btnDodajUplatu.setVisible(false);
            btnDodajUplatu.setManaged(false);
        }

        ucitajUplate();
    }

    private void ucitajUplate() {
        try {
            List<Uplata> uplate = uplataDAO.findByIdPlacanja(trenutnaProdaja.getIdPlacanja());
            tabelaUplata.setItems(FXCollections.observableArrayList(uplate));
            lblStatusUplata.setText("Ukupno uplata: " + uplate.size());
        } catch (SQLException e) {
            lblStatusUplata.setText("Greška pri učitavanju uplata");
        }
    }

    @FXML
    public void otvoriDodajUplatu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/unibl/etf/projekat_bazepodataka/DodajUplatu.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj uplatu");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 400, 280));

            DodajUplatuController ctrl = loader.getController();
            ctrl.postaviIdPlacanja(trenutnaProdaja.getIdPlacanja());

            stage.showAndWait();
            ucitajUplate();
        } catch (IOException e) {
            prikaziGresku("Greška: " + e.getMessage());
        }
    }

    @FXML
    public void zatvori() {
        ((Stage) lblVIN.getScene().getWindow()).close();
    }

    private void prikaziGresku(String poruka) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Greška");
        alert.setContentText(poruka);
        alert.showAndWait();
    }
}