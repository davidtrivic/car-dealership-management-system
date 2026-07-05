package org.unibl.etf.projekat_bazepodataka.dao;


import org.unibl.etf.projekat_bazepodataka.model.Vozilo;
import org.unibl.etf.projekat_bazepodataka.model.VoziloTableModel;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoziloDAO {

    public void insert(Vozilo vozilo) throws SQLException {
        String sql = "INSERT INTO Vozilo (VIN, Marka, Model, Godiste, Boja, Opis) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vozilo.getVin());
            ps.setString(2, vozilo.getMarka());
            ps.setString(3, vozilo.getModel());
            ps.setInt(4, vozilo.getGodiste());
            ps.setString(5, vozilo.getBoja());
            ps.setString(6, vozilo.getOpis());
            ps.executeUpdate();
        }
    }

    public void delete(String vin) throws SQLException {
        String sql = "DELETE FROM Vozilo WHERE VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vin);
            ps.executeUpdate();
        }
    }

    public List<VoziloTableModel> findSvaVozilaZaPrikaz() throws SQLException {
        String sql = "SELECT * FROM sva_vozila_info";
        List<VoziloTableModel> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new VoziloTableModel(
                        rs.getString("VIN"),
                        rs.getString("Marka"),
                        rs.getString("Model"),
                        rs.getInt("Godiste"),
                        rs.getString("Boja"),
                        rs.getString("Opis"),
                        rs.getDouble("NabavnaCijena"),
                        rs.getDouble("ProdajnaCijena"),
                        rs.getString("Status"),
                        rs.getInt("Kilometraza"),
                        rs.getInt("ZapreminaMotora"),
                        rs.getString("VrstaGoriva"),
                        rs.getString("Pogon"),
                        rs.getString("Oprema"),
                        rs.getString("TipVozila"),
                        rs.getInt("PeriodGarancije"),
                        rs.getInt("BrojPrethodnihVlasnika")
                ));
            }
        }
        return lista;
    }

}