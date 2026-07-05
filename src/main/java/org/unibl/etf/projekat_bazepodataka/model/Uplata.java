package org.unibl.etf.projekat_bazepodataka.model;

import java.time.LocalDate;

public class Uplata {
    private int idUplate;
    private int idPlacanja;
    private double iznos;
    private LocalDate datumUplate;

    public Uplata(int idUplate, int idPlacanja, double iznos, LocalDate datumUplate){
        this.idUplate = idUplate;
        this.idPlacanja = idPlacanja;
        this.iznos = iznos;
        this.datumUplate = datumUplate;
    }

    public int getIdPlacanja() {
        return idPlacanja;
    }

    public double getIznos() {
        return iznos;
    }

    public int getIdUplate() {
        return idUplate;
    }

    public LocalDate getDatumUplate() {
        return datumUplate;
    }

    public void setIdPlacanja(int idPlacanja) {
        this.idPlacanja = idPlacanja;
    }

    public void setDatumUplate(LocalDate datumUplate) {
        this.datumUplate = datumUplate;
    }

    public void setIdUplate(int idUplate) {
        this.idUplate = idUplate;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }
}
