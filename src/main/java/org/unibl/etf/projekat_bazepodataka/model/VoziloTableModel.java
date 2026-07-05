package org.unibl.etf.projekat_bazepodataka.model;

import javafx.beans.property.*;

public class VoziloTableModel {
    private StringProperty vin;
    private StringProperty marka;
    private StringProperty model;
    private IntegerProperty godiste;
    private StringProperty boja;
    private StringProperty opis;
    private DoubleProperty nabavnaCijena;
    private DoubleProperty prodajnaCijena;
    private StringProperty status;
    private IntegerProperty kilometraza;
    private IntegerProperty zapreminaMotora;
    private StringProperty vrstaGoriva;
    private StringProperty pogon;
    private StringProperty oprema;
    private StringProperty tipVozila;
    private IntegerProperty periodGarancije;
    private IntegerProperty brojPrethodnihVlasnika;

    public VoziloTableModel(String vin, String marka, String model, int godiste,
                            String boja, String opis, double nabavnaCijena, double prodajnaCijena, String status,
                            int kilometraza, int zapreminaMotora, String vrstaGoriva,
                            String pogon, String oprema, String tipVozila,
                            int periodGarancije, int brojPrethodnihVlasnika) {
        this.vin = new SimpleStringProperty(vin);
        this.marka = new SimpleStringProperty(marka);
        this.model = new SimpleStringProperty(model);
        this.godiste = new SimpleIntegerProperty(godiste);
        this.boja = new SimpleStringProperty(boja);
        this.opis = new SimpleStringProperty(opis);
        this.nabavnaCijena = new SimpleDoubleProperty(nabavnaCijena);
        this.prodajnaCijena = new SimpleDoubleProperty(prodajnaCijena);
        this.status = new SimpleStringProperty(status);
        this.kilometraza = new SimpleIntegerProperty(kilometraza);
        this.zapreminaMotora = new SimpleIntegerProperty(zapreminaMotora);
        this.vrstaGoriva = new SimpleStringProperty(vrstaGoriva);
        this.pogon = new SimpleStringProperty(pogon);
        this.oprema = new SimpleStringProperty(oprema);
        this.tipVozila = new SimpleStringProperty(tipVozila);
        this.periodGarancije = new SimpleIntegerProperty(periodGarancije);
        this.brojPrethodnihVlasnika = new SimpleIntegerProperty(brojPrethodnihVlasnika);
    }

    public String getVin() { return vin.get(); }
    public String getMarka() { return marka.get(); }
    public String getModel() { return model.get(); }
    public int getGodiste() { return godiste.get(); }
    public String getBoja() { return boja.get(); }
    public String getOpis() { return opis.get(); }
    public double getNabavnaCijena() { return nabavnaCijena.get(); }
    public double getProdajnaCijena() { return prodajnaCijena.get(); }
    public String getStatus() { return status.get(); }
    public int getKilometraza() { return kilometraza.get(); }
    public int getZapreminaMotora() { return zapreminaMotora.get(); }
    public String getVrstaGoriva() { return vrstaGoriva.get(); }
    public String getPogon() { return pogon.get(); }
    public String getOprema() { return oprema.get(); }
    public String getTipVozila() { return tipVozila.get(); }
    public int getPeriodGarancije() { return periodGarancije.get(); }
    public int getBrojPrethodnihVlasnika() { return brojPrethodnihVlasnika.get(); }

    public StringProperty vinProperty() { return vin; }
    public StringProperty markaProperty() { return marka; }
    public StringProperty modelProperty() { return model; }
    public IntegerProperty godisteProperty() { return godiste; }
    public StringProperty bojaProperty() { return boja; }
    public DoubleProperty prodajnaCijenaProperty() { return prodajnaCijena; }
    public StringProperty statusProperty() { return status; }
}