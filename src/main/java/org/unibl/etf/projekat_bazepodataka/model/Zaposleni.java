package org.unibl.etf.projekat_bazepodataka.model;

public abstract  class Zaposleni {
    private int id;
    private String ime;
    private String prezime;

    public Zaposleni(int id, String ime, String prezime){
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
