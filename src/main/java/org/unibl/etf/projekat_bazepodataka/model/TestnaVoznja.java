package org.unibl.etf.projekat_bazepodataka.model;

import java.time.LocalDate;

public class TestnaVoznja {
    private String vin;
    private String jmbKupca;
    private int idAgenta;
    private LocalDate datumVoznje;

    public TestnaVoznja(String vin, String jmbKupca, int idAgenta, LocalDate datumVoznje){
        this.vin = vin;
        this.jmbKupca = jmbKupca;
        this.idAgenta = idAgenta;
        this.datumVoznje = datumVoznje;
    }

    public String getVin() {
        return vin;
    }

    public int getIdAgenta() {
        return idAgenta;
    }

    public String getJmbKupca() {
        return jmbKupca;
    }

    public LocalDate getDatumVoznje() {
        return datumVoznje;
    }

    public void setVin(String vin) {
        if(vin == null || vin.length() != 17){
            throw new IllegalArgumentException("VIN mora imati tacno 17 znakova");
        }
        this.vin = vin;
    }

    public void setDatumVoznje(LocalDate datumVoznje) {
        this.datumVoznje = datumVoznje;
    }

    public void setIdAgenta(int idAgenta) {
        idAgenta = idAgenta;
    }

    public void setJmbKupca(String jmbKupca) {
        if(jmbKupca == null || jmbKupca.length() != 13){
            throw new IllegalArgumentException("JMB mora imati tacno 13 znakova");
        }
        this.jmbKupca = jmbKupca;
    }
}
