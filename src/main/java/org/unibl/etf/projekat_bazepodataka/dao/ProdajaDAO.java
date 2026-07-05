package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.Prodaja;
import org.unibl.etf.projekat_bazepodataka.model.ProdajaInfo;
import org.unibl.etf.projekat_bazepodataka.model.ProdajaPoAgentu;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdajaDAO {

    public void insert(Prodaja prodaja) throws SQLException {
        String sql = "INSERT INTO Prodaja (ID_Agenta, JMB_Kupca, VIN, ID_Placanja, Datum, Cijena) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, prodaja.getIdAgenta());
            ps.setString(2, prodaja.getJmbKupca());
            ps.setString(3, prodaja.getVin());
            ps.setInt(4, prodaja.getIdPlacanja());
            ps.setDate(5, Date.valueOf(prodaja.getDatum()));
            ps.setDouble(6, prodaja.getCijena());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                prodaja.setIdProdaje(rs.getInt(1));
            }
        }
    }

    public Prodaja findById(int id) throws SQLException {
        String sql = "SELECT * FROM Prodaja WHERE IdProdaje = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Prodaja(
                        rs.getInt("IdProdaje"),
                        rs.getInt("ID_Agenta"),
                        rs.getString("JMB_Kupca"),
                        rs.getString("VIN"),
                        rs.getInt("ID_Placanja"),
                        rs.getDate("Datum").toLocalDate(),
                        rs.getDouble("Cijena")
                );
            }
        }
        return null;
    }

    public List<Prodaja> findAll() throws SQLException {
        String sql = "SELECT * FROM Prodaja";
        List<Prodaja> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Prodaja(
                        rs.getInt("IdProdaje"),
                        rs.getInt("ID_Agenta"),
                        rs.getString("JMB_Kupca"),
                        rs.getString("VIN"),
                        rs.getInt("ID_Placanja"),
                        rs.getDate("Datum").toLocalDate(),
                        rs.getDouble("Cijena")
                ));
            }
        }
        return lista;
    }

    public List<Prodaja> findByAgent(int idAgenta) throws SQLException {
        String sql = "SELECT * FROM Prodaja WHERE ID_Agenta = ?";
        List<Prodaja> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idAgenta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Prodaja(
                        rs.getInt("IdProdaje"),
                        rs.getInt("ID_Agenta"),
                        rs.getString("JMB_Kupca"),
                        rs.getString("VIN"),
                        rs.getInt("ID_Placanja"),
                        rs.getDate("Datum").toLocalDate(),
                        rs.getDouble("Cijena")
                ));
            }
        }
        return lista;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Prodaja WHERE IdProdaje = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<ProdajaInfo> findAllFromView() throws SQLException {
        String sql = "SELECT * FROM prodaje_info ORDER BY Datum_Prodaje DESC";
        List<ProdajaInfo> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new ProdajaInfo(
                        rs.getInt("IdProdaje"),
                        rs.getInt("ID_Agenta"),
                        rs.getString("Ime_Agenta"),
                        rs.getString("Prezime_Agenta"),
                        rs.getString("JMB_Kupca"),
                        rs.getString("Ime_Kupca"),
                        rs.getString("Prezime_Kupca"),
                        rs.getString("VIN_Vozila"),
                        rs.getString("Marka_Vozila"),
                        rs.getString("Model_Vozila"),
                        rs.getInt("Godiste_Vozila"),
                        rs.getInt("ID_Placanja"),
                        rs.getString("Tip_Placanja"),
                        rs.getDate("Datum_Prodaje").toLocalDate(),
                        rs.getDouble("Cijena")
                ));
            }
        }
        return lista;
    }

    public List<ProdajaPoAgentu> findProdajePoAgentu() throws SQLException {
        String sql = "SELECT * FROM prodaja_po_agentu ORDER BY Ukupno_Prodaja DESC";
        List<ProdajaPoAgentu> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new ProdajaPoAgentu(
                        rs.getInt("ID_Agenta"),
                        rs.getString("Ime_Agenta"),
                        rs.getString("Prezime_Agenta"),
                        rs.getInt("Ukupno_Prodaja"),
                        rs.getDouble("Ukupna_Vrijednost")
                ));
            }
        }
        return lista;
    }
}