package org.unibl.etf.projekat_bazepodataka.service;

import org.unibl.etf.projekat_bazepodataka.dao.ProdajaDAO;
import org.unibl.etf.projekat_bazepodataka.model.Prodaja;
import org.unibl.etf.projekat_bazepodataka.model.ProdajaInfo;
import org.unibl.etf.projekat_bazepodataka.model.ProdajaPoAgentu;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class ProdajaService {
    private ProdajaDAO prodajaDAO = new ProdajaDAO();

    public void kreirajProdaju(int idAgenta, String jmbKupca, String vin, String tipPlacanja,
                               String banka, int brojRata, double iznosRate, double avans, double cijena) throws SQLException {
        String sql = "{CALL kreiraj_prodaju(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try(Connection con = DBKonekcija.getKonekcija();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setInt(1, idAgenta);
            cs.setString(2, jmbKupca);
            cs.setString(3, vin);
            cs.setString(4, tipPlacanja);
            cs.setString(5, banka);
            cs.setInt(6, brojRata);
            cs.setDouble(7, iznosRate);
            cs.setDouble(8, avans);
            cs.setDouble(9, cijena);
            cs.registerOutParameter(10, Types.INTEGER);
            cs.execute();
        }
    }

    public void unosUplate(int idPlacanja, double iznos, LocalDate datumUplate) throws SQLException {
        String sql = "{CALL unos_uplate(?, ?, ?)}";

        try(Connection con = DBKonekcija.getKonekcija();
            CallableStatement cs = con.prepareCall(sql)){

            cs.setInt(1, idPlacanja);
            cs.setDouble(2, iznos);
            cs.setDate(3, Date.valueOf(datumUplate));
            cs.execute();
        }
    }

    public List<Prodaja> pronadjiProdajePoAgentu(int idAgenta) throws SQLException {
        return prodajaDAO.findByAgent(idAgenta);
    }

    public List<Prodaja> pronadjiSveProdaje() throws SQLException {
        return prodajaDAO.findAll();
    }

    public Prodaja pronadjiProdajaPoId(int idProdaje) throws SQLException {
        return prodajaDAO.findById(idProdaje);
    }

    public List<ProdajaInfo> getSveProdajeInfo() throws SQLException {
        return prodajaDAO.findAllFromView();
    }

    public List<ProdajaPoAgentu> getProdajePoAgentu() throws SQLException {
        return prodajaDAO.findProdajePoAgentu();
    }
}
