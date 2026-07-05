package org.unibl.etf.projekat_bazepodataka.model;

public class TehnickaSpecifikacija {
    private String vin;
    private int kilometraza;
    private int zapreminaMotora;
    private String vrstaGoriva;
    private String pogon;
    private String oprema;

    public TehnickaSpecifikacija(String vin, int kilometraza, int zapreminaMotora, String vrstaGoriva, String pogon, String oprema){
        this.vin = vin;
        this.kilometraza = kilometraza;
        this.zapreminaMotora = zapreminaMotora;
        this.vrstaGoriva = vrstaGoriva;
        this.pogon = pogon;
        this.oprema = oprema;
    }

    public String getVin() {
        return vin;
    }

    public int getKilometraza() {
        return kilometraza;
    }

    public int getZapreminaMotora() {
        return zapreminaMotora;
    }

    public String getOprema() {
        return oprema;
    }

    public String getPogon() {
        return pogon;
    }

    public String getVrstaGoriva() {
        return vrstaGoriva;
    }

    public void setVin(String vin) {
        if(vin == null || vin.length() != 17){
            throw new IllegalArgumentException("VIN mora imati tacno 17 znakova");
        }
        this.vin = vin;
    }

    public void setKilometraza(int kilometraza) {
        this.kilometraza = kilometraza;
    }

    public void setOprema(String oprema) {
        this.oprema = oprema;
    }

    public void setPogon(String pogon) {
        this.pogon = pogon;
    }

    public void setVrstaGoriva(String vrstaGoriva) {
        this.vrstaGoriva = vrstaGoriva;
    }

    public void setZapreminaMotora(int zapreminaMotora) {
        this.zapreminaMotora = zapreminaMotora;
    }
}
