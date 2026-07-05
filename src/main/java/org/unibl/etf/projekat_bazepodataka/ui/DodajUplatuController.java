package org.unibl.etf.projekat_bazepodataka.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bazepodataka.service.ProdajaService;

import java.sql.Date;
import java.sql.SQLException;

public class DodajUplatuController {

    @FXML private TextField fieldIznos;
    @FXML private DatePicker datumUplate;

    private ProdajaService prodajaService = new ProdajaService();
    private int idPlacanja;

    public void postaviIdPlacanja(int idPlacanja) {
        this.idPlacanja = idPlacanja;
    }

    @FXML
    public void sacuvaj() {
        try {
            if (fieldIznos.getText().trim().isEmpty()) {
                prikaziGresku("Unesite iznos uplate");
                return;
            }
            if (datumUplate.getValue() == null) {
                prikaziGresku("Odaberite datum uplate");
                return;
            }

            double iznos = Double.parseDouble(fieldIznos.getText().trim());
            Date datum = Date.valueOf(datumUplate.getValue());

            prodajaService.unosUplate(idPlacanja, iznos, datum.toLocalDate());
            prikaziInfo("Uplata uspješno dodana!");
            zatvoriFormu();

        } catch (NumberFormatException e) {
            prikaziGresku("Unesite ispravan iznos");
        } catch (SQLException e) {
            prikaziGresku("Greška: " + e.getMessage());
        }
    }

    @FXML
    public void odustani() {
        zatvoriFormu();
    }

    private void zatvoriFormu() {
        ((Stage) fieldIznos.getScene().getWindow()).close();
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