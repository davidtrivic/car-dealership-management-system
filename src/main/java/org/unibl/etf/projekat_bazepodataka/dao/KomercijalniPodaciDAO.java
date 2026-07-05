package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.KomercijalniPodaci;
import org.unibl.etf.projekat_bazepodataka.model.StatusVozila;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KomercijalniPodaciDAO {

    public void insert(KomercijalniPodaci kp) throws SQLException {
        String sql = "INSERT INTO Komercijalni_Podaci (VIN, NabavnaCijena, ProdajnaCijena, Status) VALUES (?, ?, ?, ?)";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, kp.getVin());
            ps.setDouble(2, kp.getNabavnaCijena());
            ps.setDouble(3, kp.getProdajnaCijena());
            ps.setString(4, kp.getStatus().name());
            ps.executeUpdate();
        }
    }

    public KomercijalniPodaci findByVin(String vin) throws SQLException {
        String sql = "SELECT * FROM Komercijalni_Podaci WHERE VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vin);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new KomercijalniPodaci(
                        rs.getString("VIN"),
                        rs.getDouble("NabavnaCijena"),
                        rs.getDouble("ProdajnaCijena"),
                        StatusVozila.valueOf(rs.getString("Status").toUpperCase())
                );
            }
        }
        return null;
    }

    public List<KomercijalniPodaci> findDostupna() throws SQLException {
        String sql = "SELECT * FROM Komercijalni_Podaci WHERE Status = 'Dostupno'";
        List<KomercijalniPodaci> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new KomercijalniPodaci(
                        rs.getString("VIN"),
                        rs.getDouble("NabavnaCijena"),
                        rs.getDouble("ProdajnaCijena"),
                        StatusVozila.valueOf(rs.getString("Status").toUpperCase())
                ));
            }
        }
        return lista;
    }

    public void update(KomercijalniPodaci kp) throws SQLException {
        String sql = "UPDATE Komercijalni_Podaci SET NabavnaCijena = ?, ProdajnaCijena = ?, Status = ? WHERE VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, kp.getNabavnaCijena());
            ps.setDouble(2, kp.getProdajnaCijena());
            ps.setString(3, kp.getStatus().name());
            ps.setString(4, kp.getVin());
            ps.executeUpdate();
        }
    }

    public void delete(String vin) throws SQLException {
        String sql = "DELETE FROM Komercijalni_Podaci WHERE VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vin);
            ps.executeUpdate();
        }
    }
}