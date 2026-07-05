package org.unibl.etf.projekat_bazepodataka.ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bazepodataka.dao.AgentDAO;
import org.unibl.etf.projekat_bazepodataka.dao.KupacDAO;
import org.unibl.etf.projekat_bazepodataka.model.Agent;
import org.unibl.etf.projekat_bazepodataka.model.Kupac;
import org.unibl.etf.projekat_bazepodataka.model.VoziloTableModel;
import org.unibl.etf.projekat_bazepodataka.service.TestnaVoznjaService;
import org.unibl.etf.projekat_bazepodataka.service.VoziloService;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class NovaTestnaVoznjaController implements Initializable {

    @FXML private ComboBox<String> comboVozilo;
    @FXML private ComboBox<String> comboKupac;
    @FXML private ComboBox<String> comboAgent;
    @FXML private DatePicker datumVoznje;

    private TestnaVoznjaService testnaVoznjaService = new TestnaVoznjaService();
    private VoziloService voziloService = new VoziloService();
    private KupacDAO kupacDAO = new KupacDAO();
    private AgentDAO agentDAO = new AgentDAO();

    private List<VoziloTableModel> listaVozila;
    private List<Kupac> listaKupaca;
    private List<Agent> listaAgenata;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ucitajVozila();
        ucitajKupce();
        ucitajAgente();
    }

    private void ucitajVozila() {
        try {
            listaVozila = voziloService.getSvaVozilaZaPrikaz();
            listaVozila.removeIf(v -> v.getStatus().equals("Prodano"));
            comboVozilo.setItems(FXCollections.observableArrayList(
                    listaVozila.stream()
                            .map(v -> v.getVin() + " - " + v.getMarka() + " " + v.getModel())
                            .toList()
            ));
        } catch (SQLException e) {
            prikaziGresku("Greška pri učitavanju vozila: " + e.getMessage());
        }
    }

    private void ucitajKupce() {
        try {
            listaKupaca = kupacDAO.findAll();
            comboKupac.setItems(FXCollections.observableArrayList(
                    listaKupaca.stream()
                            .map(k -> k.getJmb() + " - " + k.getIme() + " " + k.getPrezime())
                            .toList()
            ));
        } catch (SQLException e) {
            prikaziGresku("Greška pri učitavanju kupaca: " + e.getMessage());
        }
    }

    private void ucitajAgente() {
        try {
            listaAgenata = agentDAO.findAll();
            comboAgent.setItems(FXCollections.observableArrayList(
                    listaAgenata.stream()
                            .map(a -> a.getId() + " - " + a.getIme() + " " + a.getPrezime())
                            .toList()
            ));
        } catch (SQLException e) {
            prikaziGresku("Greška pri učitavanju agenata: " + e.getMessage());
        }
    }

    @FXML
    public void sacuvaj() {
        try {
            if (!validirajPolja()) return;

            int idxVozilo = comboVozilo.getSelectionModel().getSelectedIndex();
            int idxKupac = comboKupac.getSelectionModel().getSelectedIndex();
            int idxAgent = comboAgent.getSelectionModel().getSelectedIndex();

            String vin = listaVozila.get(idxVozilo).getVin();
            String jmbKupca = listaKupaca.get(idxKupac).getJmb();
            int idAgenta = listaAgenata.get(idxAgent).getId();

            testnaVoznjaService.dodajTestnuVoznju(vin, jmbKupca, idAgenta,
                    datumVoznje.getValue());

            prikaziInfo("Testna vožnja uspješno zakazana!");
            zatvoriFormu();

        } catch (SQLException e) {
            prikaziGresku("Greška: " + e.getMessage());
        }
    }

    private boolean validirajPolja() {
        if (comboVozilo.getValue() == null) { prikaziGresku("Odaberite vozilo"); return false; }
        if (comboKupac.getValue() == null) { prikaziGresku("Odaberite kupca"); return false; }
        if (comboAgent.getValue() == null) { prikaziGresku("Odaberite agenta"); return false; }
        if (datumVoznje.getValue() == null) { prikaziGresku("Odaberite datum vožnje"); return false; }
        return true;
    }

    @FXML
    public void odustani() { zatvoriFormu(); }

    private void zatvoriFormu() {
        ((Stage) comboVozilo.getScene().getWindow()).close();
    }

    private void prikaziGresku(String poruka) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Greška");
        alert.setContentText(poruka);
        alert.showAndWait();
    }

    private void prikaziInfo(String poruka) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Uspjeh");
        alert.setContentText(poruka);
        alert.showAndWait();
    }
}