package org.unibl.etf.projekat_bazepodataka.model;

public class NovoVozilo extends Vozilo {
    private int periodGarancije;

    public NovoVozilo(String vin, String marka, String model, int godiste, String boja, String opis, int periodGarancije){
        super(vin, marka, model, godiste, boja, opis);
        this.periodGarancije = periodGarancije;
    }

    public int getPeriodGarancije() {
        return periodGarancije;
    }

    public void setPeriodGarancije(int periodGarancije) {
        this.periodGarancije = periodGarancije;
    }
}
