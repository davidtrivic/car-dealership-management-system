package org.unibl.etf.projekat_bazepodataka.service;

import org.unibl.etf.projekat_bazepodataka.dao.KupacDAO;
import org.unibl.etf.projekat_bazepodataka.model.Kupac;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class KupacService {
    private KupacDAO kupacDAO = new KupacDAO();

    public void registrujNovogKupca(String jmb, String ime, String prezime, String adresa,
                                    String telefon, String email) throws SQLException {

        String sql = "{CALL registruj_novog_kupca(?, ?, ?, ?, ?, ?)}";

        try(Connection con = DBKonekcija.getKonekcija();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setString(1, jmb);
            cs.setString(2, ime);
            cs.setString(3, prezime);
            cs.setString(4, adresa);
            cs.setString(5, telefon);
            cs.setString(6, email);
            cs.execute();
        }
    }

    public Kupac pronadjiKupcaPoJMB(String jmb) throws SQLException {
        return kupacDAO.findByJmb(jmb);
    }
}
