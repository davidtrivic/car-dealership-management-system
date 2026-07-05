package org.unibl.etf.projekat_bazepodataka.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.unibl.etf.projekat_bazepodataka.model.VoziloTableModel;

public class DetaljiVozilaController {

    @FXML private Label lblNaslov;
    @FXML private Label lblVIN, lblMarka, lblModel;
    @FXML private Label lblGodiste, lblBoja, lblOpis, lblTip;
    @FXML private Label lblKilometraza, lblZapremina;
    @FXML private Label lblGorivo, lblPogon, lblOprema;
    @FXML private Label lblNabavnaCijena, lblProdajnaCijena, lblStatus;
    @FXML private VBox vboxDinamicko;
    @FXML private Label lblDinamickoNaslov;
    @FXML private Label lblDinamickoKey, lblDinamickoValue;

    public void postaviVozilo(VoziloTableModel v) {
        lblNaslov.setText(v.getMarka() + " " + v.getModel());
        lblVIN.setText(v.getVin());
        lblMarka.setText(v.getMarka());
        lblModel.setText(v.getModel());
        lblGodiste.setText(String.valueOf(v.getGodiste()));
        lblBoja.setText(v.getBoja());
        lblOpis.setText(v.getOpis());
        lblTip.setText(v.getTipVozila());
        lblKilometraza.setText(v.getKilometraza() + " km");
        lblZapremina.setText(v.getZapreminaMotora() + " cc");
        lblGorivo.setText(v.getVrstaGoriva());
        lblPogon.setText(v.getPogon());
        lblOprema.setText(v.getOprema());
        lblNabavnaCijena.setText(String.format("%.2f KM", v.getNabavnaCijena()));
        lblProdajnaCijena.setText(String.format("%.2f KM", v.getProdajnaCijena()));
        lblStatus.setText(v.getStatus());

        if (v.getTipVozila().equals("Novo")) {
            lblDinamickoNaslov.setText("Garancija");
            lblDinamickoKey.setText("Period garancije:");
            lblDinamickoValue.setText(v.getPeriodGarancije() + " mjeseci");
        } else {
            lblDinamickoNaslov.setText("Historija");
            lblDinamickoKey.setText("Broj prethodnih vlasnika:");
            lblDinamickoValue.setText(String.valueOf(v.getBrojPrethodnihVlasnika()));
        }
    }

    @FXML
    public void zatvori() {
        ((Stage) lblVIN.getScene().getWindow()).close();
    }
}