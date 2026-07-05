package org.unibl.etf.projekat_bazepodataka.model;

import org.unibl.etf.projekat_bazepodataka.model.Zaposleni;

public class Agent extends Zaposleni {

    public Agent(int id, String ime, String prezime) {
        super(id, ime, prezime);
    }

    public int getId() {
        return super.getId();
    }

    public String getIme() {
        return super.getIme();
    }

    public String getPrezime() {
        return super.getPrezime();
    }

    public void setId(int id) {
        super.setId(id);
    }

    public void setIme(String ime) {
        super.setIme(ime);
    }

    public void setPrezime(String prezime) {
        super.setPrezime(prezime);
    }

}
