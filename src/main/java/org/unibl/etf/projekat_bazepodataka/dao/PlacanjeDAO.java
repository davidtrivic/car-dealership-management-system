package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.Placanje;
import org.unibl.etf.projekat_bazepodataka.model.TipPlacanja;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlacanjeDAO {

    public void insert(Placanje placanje) throws SQLException {
        String sql = "INSERT INTO Placanje (Tip, Banka, BrojRata, IznosRate, Avans) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, placanje.getTip().name());
            ps.setString(2, placanje.getBanka());
            ps.setInt(3, placanje.getBrojRata());
            ps.setDouble(4, placanje.getIznosRate());
            ps.setDouble(5, placanje.getAvans());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                placanje.setId(rs.getInt(1));
            }
        }
    }

    public Placanje findById(int id) throws SQLException {
        String sql = "SELECT * FROM Placanje WHERE ID = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Placanje(
                        rs.getInt("ID"),
                        TipPlacanja.valueOf(rs.getString("Tip")),
                        rs.getString("Banka"),
                        rs.getInt("BrojRata"),
                        rs.getDouble("IznosRate"),
                        rs.getDouble("Avans")
                );
            }
        }
        return null;
    }

    public List<Placanje> findAll() throws SQLException {
        String sql = "SELECT * FROM Placanje";
        List<Placanje> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Placanje(
                        rs.getInt("ID"),
                        TipPlacanja.valueOf(rs.getString("Tip")),
                        rs.getString("Banka"),
                        rs.getInt("BrojRata"),
                        rs.getDouble("IznosRate"),
                        rs.getDouble("Avans")
                ));
            }
        }
        return lista;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Placanje WHERE ID = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}