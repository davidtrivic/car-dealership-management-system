package org.unibl.etf.projekat_bazepodataka.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bazepodataka.dao.KupacDAO;
import org.unibl.etf.projekat_bazepodataka.model.Kupac;
import org.unibl.etf.projekat_bazepodataka.service.KupacService;

import java.sql.SQLException;

public class DodajKupcaController {

    @FXML private TextField fieldJMB, fieldIme, fieldPrezime;
    @FXML private TextField fieldAdresa, fieldTelefon, fieldEmail;

    private KupacDAO kupacDAO = new KupacDAO();
    private KupacService kupacService = new KupacService();

    @FXML
    public void sacuvaj() {
        try {
            if (!validirajPolja()) return;

            kupacService.registrujNovogKupca(
                    fieldJMB.getText().trim(),
                    fieldIme.getText().trim(),
                    fieldPrezime.getText().trim(),
                    fieldAdresa.getText().trim(),
                    fieldTelefon.getText().trim(),
                    fieldEmail.getText().trim()
            );
            prikaziInfo("Kupac uspješno dodan!");
            zatvoriFormu();

        } catch (SQLException e) {
            prikaziGresku("Greška: " + e.getMessage());
        }
    }

    private boolean validirajPolja() {
        if (fieldJMB.getText().trim().length() != 13) {
            prikaziGresku("JMB mora imati tačno 13 znakova");
            return false;
        }
        if (fieldIme.getText().trim().isEmpty()) {
            prikaziGresku("Unesite ime");
            return false;
        }
        if (fieldPrezime.getText().trim().isEmpty()) {
            prikaziGresku("Unesite prezime");
            return false;
        }
        if (fieldTelefon.getText().trim().isEmpty()) {
            prikaziGresku("Unesite telefon");
            return false;
        }
        return true;
    }

    @FXML
    public void odustani() {
        zatvoriFormu();
    }

    private void zatvoriFormu() {
        ((Stage) fieldJMB.getScene().getWindow()).close();
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