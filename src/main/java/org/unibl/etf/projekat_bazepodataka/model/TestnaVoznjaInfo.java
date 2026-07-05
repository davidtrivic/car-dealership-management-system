package org.unibl.etf.projekat_bazepodataka.model;

import java.time.LocalDate;

public class TestnaVoznjaInfo {
    private String vin;
    private String marka;
    private String model;
    private String jmbKupca;
    private String imeKupca;
    private String prezimeKupca;
    private int idAgenta;
    private String imeAgenta;
    private String prezimeAgenta;
    private LocalDate datumVoznje;

    public TestnaVoznjaInfo(String vin, String marka, String model,
                                 String jmbKupca, String imeKupca, String prezimeKupca,
                                 int idAgenta, String imeAgenta, String prezimeAgenta,
                                 LocalDate datumVoznje) {
        this.vin = vin;
        this.marka = marka;
        this.model = model;
        this.jmbKupca = jmbKupca;
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
        this.idAgenta = idAgenta;
        this.imeAgenta = imeAgenta;
        this.prezimeAgenta = prezimeAgenta;
        this.datumVoznje = datumVoznje;
    }

    public String getVin() { return vin; }
    public String getMarka() { return marka; }
    public String getModel() { return model; }
    public String getJmbKupca() { return jmbKupca; }
    public String getImeKupca() { return imeKupca; }
    public String getPrezimeKupca() { return prezimeKupca; }
    public int getIdAgenta() { return idAgenta; }
    public String getImeAgenta() { return imeAgenta; }
    public String getPrezimeAgenta() { return prezimeAgenta; }
    public LocalDate getDatumVoznje() { return datumVoznje; }
    public String getVozilo() { return marka + " " + model; }
    public String getKupac() { return imeKupca + " " + prezimeKupca; }
    public String getAgent() { return imeAgenta + " " + prezimeAgenta; }
}