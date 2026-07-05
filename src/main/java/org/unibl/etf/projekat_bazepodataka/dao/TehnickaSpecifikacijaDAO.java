package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.TehnickaSpecifikacija;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;

public class TehnickaSpecifikacijaDAO {

    public void insert(TehnickaSpecifikacija ts) throws SQLException {
        String sql = "INSERT INTO Tehnicka_Specifikacija (VIN, Kilometraza, ZapreminaMotora, VrstaGoriva, Pogon, Oprema) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ts.getVin());
            ps.setInt(2, ts.getKilometraza());
            ps.setInt(3, ts.getZapreminaMotora());
            ps.setString(4, ts.getVrstaGoriva());
            ps.setString(5, ts.getPogon());
            ps.setString(6, ts.getOprema());
            ps.executeUpdate();
        }
    }

    public TehnickaSpecifikacija findByVin(String vin) throws SQLException {
        String sql = "SELECT * FROM Tehnicka_Specifikacija WHERE VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vin);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new TehnickaSpecifikacija(
                        rs.getString("VIN"),
                        rs.getInt("Kilometraza"),
                        rs.getInt("ZapreminaMotora"),
                        rs.getString("VrstaGoriva"),
                        rs.getString("Pogon"),
                        rs.getString("Oprema")
                );
            }
        }
        return null;
    }

    public void update(TehnickaSpecifikacija ts) throws SQLException {
        String sql = "UPDATE Tehnicka_Specifikacija SET Kilometraza = ?, ZapreminaMotora = ?, VrstaGoriva = ?, Pogon = ?, Oprema = ? WHERE VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, ts.getKilometraza());
            ps.setInt(2, ts.getZapreminaMotora());
            ps.setString(3, ts.getVrstaGoriva());
            ps.setString(4, ts.getPogon());
            ps.setString(5, ts.getOprema());
            ps.setString(6, ts.getVin());
            ps.executeUpdate();
        }
    }

    public void delete(String vin) throws SQLException {
        String sql = "DELETE FROM Tehnicka_Specifikacija WHERE VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vin);
            ps.executeUpdate();
        }
    }
}