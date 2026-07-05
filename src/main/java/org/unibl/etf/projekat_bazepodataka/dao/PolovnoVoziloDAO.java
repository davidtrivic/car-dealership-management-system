package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.PolovnoVozilo;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PolovnoVoziloDAO {
    private VoziloDAO voziloDAO = new VoziloDAO();

    public void insert(PolovnoVozilo vozilo) throws SQLException {
        voziloDAO.insert(vozilo);
        String sql = "INSERT INTO Polovno_Vozilo (VIN, BrojPrethodnihVlasnika) VALUES (?, ?)";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vozilo.getVin());
            ps.setInt(2, vozilo.getBrojPrethodnihVlasnika());
            ps.executeUpdate();
        }
    }

    public PolovnoVozilo findByVin(String vin) throws SQLException {
        String sql = "SELECT v.*, pv.BrojPrethodnihVlasnika FROM Vozilo v JOIN Polovno_Vozilo pv ON v.VIN = pv.VIN WHERE v.VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vin);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new PolovnoVozilo(
                        rs.getString("VIN"),
                        rs.getString("Marka"),
                        rs.getString("Model"),
                        rs.getInt("Godiste"),
                        rs.getString("Boja"),
                        rs.getString("Opis"),
                        rs.getInt("BrojPrethodnihVlasnika")
                );
            }
        }
        return null;
    }

    public List<PolovnoVozilo> findAll() throws SQLException {
        String sql = "SELECT v.*, pv.BrojPrethodnihVlasnika FROM Vozilo v JOIN Polovno_Vozilo pv ON v.VIN = pv.VIN";
        List<PolovnoVozilo> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new PolovnoVozilo(
                        rs.getString("VIN"),
                        rs.getString("Marka"),
                        rs.getString("Model"),
                        rs.getInt("Godiste"),
                        rs.getString("Boja"),
                        rs.getString("Opis"),
                        rs.getInt("BrojPrethodnihVlasnika")
                ));
            }
        }
        return lista;
    }

    public void update(PolovnoVozilo vozilo) throws SQLException {
        String sqlVozilo = "UPDATE Vozilo SET Marka = ?, Model = ?, Godiste = ?, Boja = ?, Opis = ? WHERE VIN = ?";
        String sqlPolovno = "UPDATE Polovno_Vozilo SET BrojPrethodnihVlasnika = ? WHERE VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija()) {
            try (PreparedStatement ps = con.prepareStatement(sqlVozilo)) {
                ps.setString(1, vozilo.getMarka());
                ps.setString(2, vozilo.getModel());
                ps.setInt(3, vozilo.getGodiste());
                ps.setString(4, vozilo.getBoja());
                ps.setString(5, vozilo.getOpis());
                ps.setString(6, vozilo.getVin());
                ps.executeUpdate();
            }
            try (PreparedStatement ps = con.prepareStatement(sqlPolovno)) {
                ps.setInt(1, vozilo.getBrojPrethodnihVlasnika());
                ps.setString(2, vozilo.getVin());
                ps.executeUpdate();
            }
        }
    }

    public void delete(String vin) throws SQLException {
        voziloDAO.delete(vin);
    }
}