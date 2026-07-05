package org.unibl.etf.projekat_bazepodataka.model;

public class ProdajaPoAgentu {
    private int idAgenta;
    private String imeAgenta;
    private String prezimeAgenta;
    private int ukupnoProdaja;
    private double ukupnaVrijednost;

    public ProdajaPoAgentu(int idAgenta, String imeAgenta, String prezimeAgenta,
                                int ukupnoProdaja, double ukupnaVrijednost) {
        this.idAgenta = idAgenta;
        this.imeAgenta = imeAgenta;
        this.prezimeAgenta = prezimeAgenta;
        this.ukupnoProdaja = ukupnoProdaja;
        this.ukupnaVrijednost = ukupnaVrijednost;
    }

    public int getIdAgenta() { return idAgenta; }
    public String getImeAgenta() { return imeAgenta; }
    public String getPrezimeAgenta() { return prezimeAgenta; }
    public int getUkupnoProdaja() { return ukupnoProdaja; }
    public double getUkupnaVrijednost() { return ukupnaVrijednost; }
    public String getAgent() { return imeAgenta + " " + prezimeAgenta; }
}