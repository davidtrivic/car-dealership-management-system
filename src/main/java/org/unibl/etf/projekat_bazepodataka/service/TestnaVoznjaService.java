package org.unibl.etf.projekat_bazepodataka.service;

import org.unibl.etf.projekat_bazepodataka.dao.TestnaVoznjaDAO;
import org.unibl.etf.projekat_bazepodataka.model.TestnaVoznja;
import org.unibl.etf.projekat_bazepodataka.model.TestnaVoznjaInfo;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TestnaVoznjaService {
    private TestnaVoznjaDAO testnaVoznjaDAO = new TestnaVoznjaDAO();

    public void dodajTestnuVoznju(String vin, String jmbKupca, int idAgenta, LocalDate datumVoznje) throws SQLException {
        String sql = "{CALL dodaj_testnu_voznju(?, ?, ?, ?)}";

        try(Connection con = DBKonekcija.getKonekcija();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setString(1, vin);
            cs.setString(2, jmbKupca);
            cs.setInt(3, idAgenta);
            cs.setDate(4, Date.valueOf(datumVoznje));
            cs.execute();
        }
    }

    public List<TestnaVoznja> pronadjiPoKupcu(String jmbKupca) throws SQLException {
        return testnaVoznjaDAO.findByKupac(jmbKupca);
    }

    public List<TestnaVoznja> pronadjiSveTestneVoznje() throws SQLException {
        return testnaVoznjaDAO.findAll();
    }

    public List<TestnaVoznjaInfo> getSveTestneVoznjeInfo() throws SQLException {
        return testnaVoznjaDAO.findAllFromView();
    }
}
