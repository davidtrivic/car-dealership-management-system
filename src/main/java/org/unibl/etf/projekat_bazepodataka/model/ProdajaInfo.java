package org.unibl.etf.projekat_bazepodataka.model;

import java.time.LocalDate;

public class ProdajaInfo {
    private int idProdaje;
    private int idAgenta;
    private String imeAgenta;
    private String prezimeAgenta;
    private String jmbKupca;
    private String imeKupca;
    private String prezimeKupca;
    private String vinVozila;
    private String markaVozila;
    private String modelVozila;
    private int godisteVozila;
    private int idPlacanja;
    private String tipPlacanja;
    private LocalDate datumProdaje;
    private double cijena;

    public ProdajaInfo(int idProdaje, int idAgenta, String imeAgenta, String prezimeAgenta,
                       String jmbKupca, String imeKupca, String prezimeKupca,
                       String vinVozila, String markaVozila, String modelVozila,
                       int godisteVozila, int idPlacanja, String tipPlacanja,
                       LocalDate datumProdaje, double cijena) {
        this.idProdaje = idProdaje;
        this.idAgenta = idAgenta;
        this.imeAgenta = imeAgenta;
        this.prezimeAgenta = prezimeAgenta;
        this.jmbKupca = jmbKupca;
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
        this.vinVozila = vinVozila;
        this.markaVozila = markaVozila;
        this.modelVozila = modelVozila;
        this.godisteVozila = godisteVozila;
        this.idPlacanja = idPlacanja;
        this.tipPlacanja = tipPlacanja;
        this.datumProdaje = datumProdaje;
        this.cijena = cijena;
    }

    public int getIdProdaje() { return idProdaje; }
    public int getIdAgenta() { return idAgenta; }
    public String getImeAgenta() { return imeAgenta; }
    public String getPrezimeAgenta() { return prezimeAgenta; }
    public String getJmbKupca() { return jmbKupca; }
    public String getImeKupca() { return imeKupca; }
    public String getPrezimeKupca() { return prezimeKupca; }
    public String getVinVozila() { return vinVozila; }
    public String getMarkaVozila() { return markaVozila; }
    public String getModelVozila() { return modelVozila; }
    public int getGodisteVozila() { return godisteVozila; }
    public int getIdPlacanja() { return idPlacanja; }
    public String getTipPlacanja() { return tipPlacanja; }
    public LocalDate getDatumProdaje() { return datumProdaje; }
    public double getCijena() { return cijena; }
    public String getAgent() { return imeAgenta + " " + prezimeAgenta; }
    public String getKupac() { return imeKupca + " " + prezimeKupca; }
    public String getVozilo() { return markaVozila + " " + modelVozila + " (" + godisteVozila + ")"; }
}