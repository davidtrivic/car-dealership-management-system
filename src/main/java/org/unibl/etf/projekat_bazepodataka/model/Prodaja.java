package org.unibl.etf.projekat_bazepodataka.model;

import java.time.LocalDate;

public class Prodaja {
    private int idProdaje;
    private int idAgenta;
    private String jmbKupca;
    private String vin;
    private int idPlacanja;
    private LocalDate datum;
    private double cijena;

    public Prodaja(int idProdaje, int idAgenta, String jmbKupca, String vin, int idPlacanja, LocalDate datum, double cijena){
        this.idProdaje = idProdaje;
        this.idAgenta = idAgenta;
        this.jmbKupca = jmbKupca;
        this.vin = vin;
        this.idPlacanja = idPlacanja;
        this.datum = datum;
        this.cijena= cijena;
    }

    public String getJmbKupca() {
        return jmbKupca;
    }

    public int getIdAgenta() {
        return idAgenta;
    }

    public String getVin() {
        return vin;
    }

    public double getCijena() {
        return cijena;
    }

    public int getIdPlacanja() {
        return idPlacanja;
    }

    public int getIdProdaje() {
        return idProdaje;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setJmbKupca(String jmbKupca) {
        if(jmbKupca == null || jmbKupca.length() != 13){
            throw new IllegalArgumentException("JMB mora imati tacno 13 znakova");
        }
        this.jmbKupca = jmbKupca;
    }

    public void setIdAgenta(int idAgenta) {
        this.idAgenta = idAgenta;
    }

    public void setVin(String vin) {
        if(vin == null || vin.length() != 17){
            throw new IllegalArgumentException("VIN mora imati tacno 17 znakova");
        }
        this.vin = vin;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setIdPlacanja(int idPlacanja) {
        this.idPlacanja = idPlacanja;
    }

    public void setIdProdaje(int idProdaje) {
        this.idProdaje = idProdaje;
    }
}
