package org.unibl.etf.projekat_bazepodataka.model;

public abstract class Vozilo {
    private String vin;
    private String marka;
    private String model;
    private int godiste;
    private String boja;
    private String opis;

    public Vozilo(String vin, String marka, String model, int godiste, String boja, String opis){
        this.vin = vin;
        this.marka = marka;
        this.model = model;
        this.godiste = godiste;
        this.boja = boja;
        this.opis = opis;
    }

    public int getGodiste() {
        return godiste;
    }

    public String getBoja() {
        return boja;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getOpis() {
        return opis;
    }

    public String getVin() {
        return vin;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setVin(String vin) {
        if(vin == null || vin.length() != 17){
            throw new IllegalArgumentException("VIN mora imati tacno 17 znakova");
        }
        this.vin = vin;
    }
}
