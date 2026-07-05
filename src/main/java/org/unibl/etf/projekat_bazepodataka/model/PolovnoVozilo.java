package org.unibl.etf.projekat_bazepodataka.model;

public class PolovnoVozilo extends Vozilo {
    private int brojPrethodnihVlasnika;

    public PolovnoVozilo(String vin, String marka, String model, int godiste, String boja, String opis, int brojPrethodnihVlasnika){
        super(vin, marka, model, godiste, boja, opis);
        this.brojPrethodnihVlasnika = brojPrethodnihVlasnika;
    }

    public int getBrojPrethodnihVlasnika() {
        return brojPrethodnihVlasnika;
    }

    public void setBrojPrethodnihVlasnika(int brojPrethodnihVlasnika) {
        this.brojPrethodnihVlasnika = brojPrethodnihVlasnika;
    }
}
