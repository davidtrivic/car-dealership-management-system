package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.NovoVozilo;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NovoVoziloDAO {
    private VoziloDAO voziloDAO = new VoziloDAO();

    public void insert(NovoVozilo vozilo) throws SQLException {
        voziloDAO.insert(vozilo);
        String sql = "INSERT INTO Novo_Vozilo (VIN, PeriodGarancije) VALUES (?, ?)";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vozilo.getVin());
            ps.setInt(2, vozilo.getPeriodGarancije());
            ps.executeUpdate();
        }
    }

    public NovoVozilo findByVin(String vin) throws SQLException {
        String sql = "SELECT v.*, nv.PeriodGarancije FROM Vozilo v JOIN Novo_Vozilo nv ON v.VIN = nv.VIN WHERE v.VIN = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, vin);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new NovoVozilo(
                        rs.getString("VIN"),
                        rs.getString("Marka"),
                        rs.getString("Model"),
                        rs.getInt("Godiste"),
                        rs.getString("Boja"),
                        rs.getString("Opis"),
                        rs.getInt("PeriodGarancije")
                );
            }
        }
        return null;
    }

    public List<NovoVozilo> findAll() throws SQLException {
        String sql = "SELECT v.*, nv.PeriodGarancije FROM Vozilo v JOIN Novo_Vozilo nv ON v.VIN = nv.VIN";
        List<NovoVozilo> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new NovoVozilo(
                        rs.getString("VIN"),
                        rs.getString("Marka"),
                        rs.getString("Model"),
                        rs.getInt("Godiste"),
                        rs.getString("Boja"),
                        rs.getString("Opis"),
                        rs.getInt("PeriodGarancije")
                ));
            }
        }
        return lista;
    }

    public void update(NovoVozilo vozilo) throws SQLException {
        String sqlVozilo = "UPDATE Vozilo SET Marka = ?, Model = ?, Godiste = ?, Boja = ?, Opis = ? WHERE VIN = ?";
        String sqlNovo = "UPDATE Novo_Vozilo SET PeriodGarancije = ? WHERE VIN = ?";

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
            try (PreparedStatement ps = con.prepareStatement(sqlNovo)) {
                ps.setInt(1, vozilo.getPeriodGarancije());
                ps.setString(2, vozilo.getVin());
                ps.executeUpdate();
            }
        }
    }

    public void delete(String vin) throws SQLException {
        voziloDAO.delete(vin);
    }
}