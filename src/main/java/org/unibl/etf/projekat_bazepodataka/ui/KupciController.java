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
import org.unibl.etf.projekat_bazepodataka.dao.KupacDAO;
import org.unibl.etf.projekat_bazepodataka.model.Kupac;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class KupciController implements Initializable {

    @FXML private TableView<Kupac> tabelaKupaca;
    @FXML private TableColumn<Kupac, String> colJMB;
    @FXML private TableColumn<Kupac, String> colIme;
    @FXML private TableColumn<Kupac, String> colPrezime;
    @FXML private TableColumn<Kupac, String> colAdresa;
    @FXML private TableColumn<Kupac, String> colTelefon;
    @FXML private TableColumn<Kupac, String> colEmail;
    @FXML private TextField fieldPretraga;

    private KupacDAO kupacDAO = new KupacDAO();
    private ObservableList<Kupac> sviKupci = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        postaviKolone();
        ucitajKupce();
    }

    private void postaviKolone() {
        colJMB.setCellValueFactory(new PropertyValueFactory<>("jmb"));
        colIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        colPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        colAdresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        colTelefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void ucitajKupce() {
        try {
            sviKupci.setAll(kupacDAO.findAll());
            tabelaKupaca.setItems(sviKupci);
        } catch (SQLException e) {
            prikaziGresku("Greška pri učitavanju kupaca: " + e.getMessage());
        }
    }

    @FXML
    public void pretraziKupce() {
        String upit = fieldPretraga.getText().toLowerCase().trim();
        if (upit.isEmpty()) {
            tabelaKupaca.setItems(sviKupci);
            return;
        }
        ObservableList<Kupac> filtrirano = FXCollections.observableArrayList();
        for (Kupac k : sviKupci) {
            if (k.getIme().toLowerCase().contains(upit) ||
                    k.getPrezime().toLowerCase().contains(upit) ||
                    k.getJmb().contains(upit)) {
                filtrirano.add(k);
            }
        }
        tabelaKupaca.setItems(filtrirano);
    }



    @FXML
    public void otvoriDodajKupca() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/unibl/etf/projekat_bazepodataka/DodajKupca.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dodaj kupca");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 450, 400));
            stage.showAndWait();
            ucitajKupce();
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