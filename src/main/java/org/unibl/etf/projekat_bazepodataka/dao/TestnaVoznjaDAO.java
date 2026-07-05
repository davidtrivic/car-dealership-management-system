package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.TestnaVoznja;
import org.unibl.etf.projekat_bazepodataka.model.TestnaVoznjaInfo;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestnaVoznjaDAO {

    public void insert(TestnaVoznja tv) throws SQLException {
        String sql = "INSERT INTO Testna_Voznja (VIN, JMB_Kupca, ID_Agenta, DatumVoznje) VALUES (?, ?, ?, ?)";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tv.getVin());
            ps.setString(2, tv.getJmbKupca());
            ps.setInt(3, tv.getIdAgenta());
            ps.setDate(4, Date.valueOf(tv.getDatumVoznje()));
            ps.executeUpdate();
        }
    }

    public List<TestnaVoznja> findByKupac(String jmbKupca) throws SQLException {
        String sql = "SELECT * FROM Testna_Voznja WHERE JMB_Kupca = ?";
        List<TestnaVoznja> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, jmbKupca);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new TestnaVoznja(
                        rs.getString("VIN"),
                        rs.getString("JMB_Kupca"),
                        rs.getInt("ID_Agenta"),
                        rs.getDate("DatumVoznje").toLocalDate()
                ));
            }
        }
        return lista;
    }

    public List<TestnaVoznja> findAll() throws SQLException {
        String sql = "SELECT * FROM Testna_Voznja";
        List<TestnaVoznja> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new TestnaVoznja(
                        rs.getString("VIN"),
                        rs.getString("JMB_Kupca"),
                        rs.getInt("ID_Agenta"),
                        rs.getDate("DatumVoznje").toLocalDate()
                ));
            }
        }
        return lista;
    }

    public void delete(String vin, String jmbKupca, LocalDate datumVoznje) throws SQLException {
        String sql = "DELETE FROM Testna_Voznja WHERE VIN = ? AND JMB_Kupca = ? AND DatumVoznje = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vin);
            ps.setString(2, jmbKupca);
            ps.setDate(3, Date.valueOf(datumVoznje));
            ps.executeUpdate();
        }
    }

    public List<TestnaVoznjaInfo> findAllFromView() throws SQLException {
        String sql = "SELECT * FROM testne_voznje_info ORDER BY DatumVoznje DESC";
        List<TestnaVoznjaInfo> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new TestnaVoznjaInfo(
                        rs.getString("VIN"),
                        rs.getString("Marka"),
                        rs.getString("Model"),
                        rs.getString("JMB_Kupca"),
                        rs.getString("Ime_Kupca"),
                        rs.getString("Prezime_Kupca"),
                        rs.getInt("ID_Agenta"),
                        rs.getString("Ime_Agenta"),
                        rs.getString("Prezime_Agenta"),
                        rs.getDate("DatumVoznje").toLocalDate()
                ));
            }
        }
        return lista;
    }
}