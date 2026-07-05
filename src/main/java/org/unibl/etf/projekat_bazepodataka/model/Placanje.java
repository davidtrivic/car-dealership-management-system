package org.unibl.etf.projekat_bazepodataka.model;

public class Placanje {
    private int id;
    private TipPlacanja tip;
    private String banka;
    private int brojRata;
    private double iznosRate;
    private double avans;

    public Placanje(int id, TipPlacanja tip, String banka, int brojRata, double iznosRate, double avans){
        this.id = id;
        this.tip = tip;
        this.banka = banka;
        this.brojRata = brojRata;
        this.iznosRate = iznosRate;
        this.avans = avans;
    }

    public int getId() {
        return id;
    }

    public double getAvans() {
        return avans;
    }

    public double getIznosRate() {
        return iznosRate;
    }

    public int getBrojRata() {
        return brojRata;
    }

    public String getBanka() {
        return banka;
    }

    public TipPlacanja getTip() {
        return tip;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvans(double avans) {
        this.avans = avans;
    }

    public void setBanka(String banka) {
        this.banka = banka;
    }

    public void setBrojRata(int brojRata) {
        this.brojRata = brojRata;
    }

    public void setIznosRate(double iznosRate) {
        this.iznosRate = iznosRate;
    }

    public void setTip(TipPlacanja tip) {
        this.tip = tip;
    }

}
