package org.unibl.etf.projekat_bazepodataka.model;

public class Kupac {
    private String jmb;
    private String ime;
    private String prezime;
    private String adresa;
    private String telefon;
    private String email;

    public Kupac(String jmb, String ime, String prezime, String adresa,
                 String telefon, String email){
        this.jmb = jmb;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
    }

    public String getJmb() {
        return jmb;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getIme() {
        return ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setJmb(String jmb) {
        if(jmb == null || jmb.length() != 13){
            throw new IllegalArgumentException("JMB mora imati tacno 13 znakova");
        }
        this.jmb = jmb;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
