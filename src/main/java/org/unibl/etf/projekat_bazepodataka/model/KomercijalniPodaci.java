package org.unibl.etf.projekat_bazepodataka.model;

public class KomercijalniPodaci {
    private String vin;
    private double nabavnaCijena;
    private double prodajnaCijena;
    private StatusVozila status;

    public KomercijalniPodaci(String vin, double nabavnaCijena, double prodajnaCijena, StatusVozila status){
        this.vin = vin;
        this.nabavnaCijena = nabavnaCijena;
        this.prodajnaCijena = prodajnaCijena;
        this.status = status;
    }

    public String getVin() {
        return vin;
    }

    public double getNabavnaCijena() {
        return nabavnaCijena;
    }

    public double getProdajnaCijena() {
        return prodajnaCijena;
    }

    public StatusVozila getStatus() {
        return status;
    }

    public void setVin(String vin) {
        if(vin == null || vin.length() != 17){
            throw new IllegalArgumentException("VIN mora imati tacno 17 znakova");
        }
        this.vin = vin;
    }

    public void setNabavnaCijena(double nabavnaCijena) {
        this.nabavnaCijena = nabavnaCijena;
    }

    public void setProdajnaCijena(double prodajnaCijena) {
        this.prodajnaCijena = prodajnaCijena;
    }

    public void setStatus(StatusVozila status) {
        this.status = status;
    }
}
