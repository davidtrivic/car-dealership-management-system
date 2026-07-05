package org.unibl.etf.projekat_bazepodataka.ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bazepodataka.service.VoziloService;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DodajVoziloController implements Initializable {

    @FXML private ComboBox<String> tipVozila;
    @FXML private TextField fieldVIN, fieldMarka, fieldModel;
    @FXML private TextField fieldGodiste, fieldBoja, fieldOprema;
    @FXML private TextField fieldKilometraza, fieldZapremina;
    @FXML private ComboBox<String> vrstaGoriva, pogon;
    @FXML private TextField fieldNabavnaCijena, fieldProdajnaCijena;
    @FXML private Label labelDinamicko;
    @FXML private TextField fieldDinamicko;

    private VoziloService voziloService = new VoziloService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipVozila.setItems(FXCollections.observableArrayList("Novo vozilo", "Polovno vozilo"));
        vrstaGoriva.setItems(FXCollections.observableArrayList("Benzin", "Dizel", "Hibrid", "Elektricni"));
        pogon.setItems(FXCollections.observableArrayList("Prednji", "Zadnji", "Svi"));
        labelDinamicko.setVisible(false);
        fieldDinamicko.setVisible(false);
    }

    @FXML
    public void tipVozilaPromjenjen() {
        String tip = tipVozila.getValue();
        if (tip == null) return;

        if (tip.equals("Novo vozilo")) {
            labelDinamicko.setText("Period garancije (mj):");
            labelDinamicko.setVisible(true);
            fieldDinamicko.setVisible(true);
        } else {
            labelDinamicko.setText("Broj preth. vlasnika:");
            labelDinamicko.setVisible(true);
            fieldDinamicko.setVisible(true);
        }
    }

    @FXML
    public void sacuvaj() {
        try {
            if (!validirajPolja()) return;

            String tip = tipVozila.getValue();
            String vin = fieldVIN.getText().trim();
            String marka = fieldMarka.getText().trim();
            String model = fieldModel.getText().trim();
            int godiste = Integer.parseInt(fieldGodiste.getText().trim());
            String boja = fieldBoja.getText().trim();
            String opis = "";
            int kilometraza = Integer.parseInt(fieldKilometraza.getText().trim());
            int zapremina = Integer.parseInt(fieldZapremina.getText().trim());
            String gorivo = vrstaGoriva.getValue();
            String pogonVr = pogon.getValue();
            String oprema = fieldOprema.getText().trim();
            double nabavna = Double.parseDouble(fieldNabavnaCijena.getText().trim());
            double prodajna = Double.parseDouble(fieldProdajnaCijena.getText().trim());

            if (tip.equals("Novo vozilo")) {
                int garancija = Integer.parseInt(fieldDinamicko.getText().trim());
                voziloService.dodajNovoVozilo(vin, marka, model, godiste, boja, opis,
                        kilometraza, zapremina, gorivo, pogonVr, oprema,
                        nabavna, prodajna, garancija);
            } else {
                int brVlasnika = Integer.parseInt(fieldDinamicko.getText().trim());
                voziloService.dodajPolovnoVozilo(vin, marka, model, godiste, boja, opis,
                        kilometraza, zapremina, gorivo, pogonVr, oprema,
                        nabavna, prodajna, brVlasnika);
            }

            prikaziInfo("Vozilo uspjesno dodano!");
            zatvoriFormu();

        } catch (NumberFormatException e) {
            prikaziGresku("Provjerite numericka polja (godiste, kilometraza, cijena...)");
        } catch (SQLException e) {
            prikaziGresku("Greska: " + e.getMessage());
        }
    }

    private boolean validirajPolja() {
        if (tipVozila.getValue() == null) { prikaziGresku("Odaberite tip vozila"); return false; }
        if (fieldVIN.getText().trim().length() != 17) { prikaziGresku("VIN mora imati 17 znakova"); return false; }
        if (fieldMarka.getText().trim().isEmpty()) { prikaziGresku("Unesite marku"); return false; }
        if (fieldModel.getText().trim().isEmpty()) { prikaziGresku("Unesite model"); return false; }
        if (vrstaGoriva.getValue() == null) { prikaziGresku("Odaberite vrstu goriva"); return false; }
        if (pogon.getValue() == null) { prikaziGresku("Odaberite pogon"); return false; }
        if (fieldDinamicko.getText().trim().isEmpty()) { prikaziGresku("Unesite period garancije ili broj vlasnika"); return false; }
        return true;
    }

    @FXML
    public void odustani() {
        zatvoriFormu();
    }

    private void zatvoriFormu() {
        ((Stage) fieldVIN.getScene().getWindow()).close();
    }

    private void prikaziGresku(String poruka) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Greska");
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