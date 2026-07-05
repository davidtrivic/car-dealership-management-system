package org.unibl.etf.projekat_bazepodataka.service;

import javafx.collections.ObservableList;
import org.unibl.etf.projekat_bazepodataka.dao.NovoVoziloDAO;
import org.unibl.etf.projekat_bazepodataka.dao.PolovnoVoziloDAO;
import org.unibl.etf.projekat_bazepodataka.dao.VoziloDAO;
import org.unibl.etf.projekat_bazepodataka.model.NovoVozilo;
import org.unibl.etf.projekat_bazepodataka.model.PolovnoVozilo;
import org.unibl.etf.projekat_bazepodataka.model.Vozilo;
import org.unibl.etf.projekat_bazepodataka.model.VoziloTableModel;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.CompactNumberFormat;
import java.util.List;

public class VoziloService {
    private VoziloDAO voziloDAO = new VoziloDAO();
    private NovoVoziloDAO novoVoziloDAO = new NovoVoziloDAO();
    private PolovnoVoziloDAO polovnoVoziloDAO = new PolovnoVoziloDAO();

    public void dodajNovoVozilo(String vin, String marka, String model, int godiste, String boja,
                                String opis, int kilometraza, int zapreminaMotora, String vrstaGoriva,
                                String pogon, String oprema, double nabavnaCijena, double prodajnaCijena,
                                int periodGarancije) throws SQLException {

        String sql = "{CALL dodaj_novo_vozilo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try(Connection con = DBKonekcija.getKonekcija();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setString(1, vin);
            cs.setString(2, marka);
            cs.setString(3, model);
            cs.setInt(4, godiste);
            cs.setString(5, boja);
            cs.setString(6, opis);
            cs.setInt(7, kilometraza);
            cs.setInt(8, zapreminaMotora);
            cs.setString(9, vrstaGoriva);
            cs.setString(10, pogon);
            cs.setString(11, oprema);
            cs.setDouble(12, nabavnaCijena);
            cs.setDouble(13, prodajnaCijena);
            cs.setInt(14, periodGarancije);
            cs.execute();
        }
    }

    public void dodajPolovnoVozilo(String vin, String marka, String model,
                                   int godiste, String boja, String opis,
                                   int kilometraza, int zapreminaMotora,
                                   String vrstaGoriva, String pogon, String oprema,
                                   double nabavnaCijena, double prodajnaCijena,
                                   int brojPrethodnihVlasnika) throws SQLException {

        String sql = "{CALL dodaj_polovno_vozilo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection con = DBKonekcija.getKonekcija();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, vin);
            cs.setString(2, marka);
            cs.setString(3, model);
            cs.setInt(4, godiste);
            cs.setString(5, boja);
            cs.setString(6, opis);
            cs.setInt(7, kilometraza);
            cs.setInt(8, zapreminaMotora);
            cs.setString(9, vrstaGoriva);
            cs.setString(10, pogon);
            cs.setString(11, oprema);
            cs.setDouble(12, nabavnaCijena);
            cs.setDouble(13, prodajnaCijena);
            cs.setInt(14, brojPrethodnihVlasnika);
            cs.execute();
        }
    }

    public void rezervisiVozilo(String vin) throws SQLException {
        String sql = "{CALL rezervisi_vozilo(?, ?)}";

        try (Connection con = DBKonekcija.getKonekcija();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, vin);
            cs.execute();
        }
    }

    public void otkaziRezervaciju(String vin) throws SQLException {
        String sql = "{CALL otkazi_rezervaciju_vozila(?)}";

        try (Connection con = DBKonekcija.getKonekcija();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, vin);
            cs.execute();
        }
    }

    public NovoVozilo pronadjiNovoVoziloPoVIN(String vin) throws SQLException {
        return novoVoziloDAO.findByVin(vin);
    }

    public PolovnoVozilo pronadjiPolovnoVoziloPoVIN(String vin) throws SQLException {
        return polovnoVoziloDAO.findByVin(vin);
    }

    public List<NovoVozilo> pronadjiSvaNovaVozila() throws SQLException {
        return novoVoziloDAO.findAll();
    }

    public List<PolovnoVozilo> pronadjiSvaPolovnaVozila() throws SQLException {
        return polovnoVoziloDAO.findAll();
    }

    public List<VoziloTableModel> getSvaVozilaZaPrikaz() throws SQLException {
        return voziloDAO.findSvaVozilaZaPrikaz();
    }
}
