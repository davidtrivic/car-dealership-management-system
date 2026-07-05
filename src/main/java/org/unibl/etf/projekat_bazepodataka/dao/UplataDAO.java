package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.Uplata;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UplataDAO {

    public void insert(Uplata uplata) throws SQLException {
        String sql = "INSERT INTO Uplata (IdPlacanja, Iznos, DatumUplate) VALUES (?, ?, ?)";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, uplata.getIdPlacanja());
            ps.setDouble(2, uplata.getIznos());
            ps.setDate(3, Date.valueOf(uplata.getDatumUplate()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                uplata.setIdUplate(rs.getInt(1));
            }
        }
    }


    public void delete(int idUplate) throws SQLException {
        String sql = "DELETE FROM Uplata WHERE IdUplate = ?";

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUplate);
            ps.executeUpdate();
        }
    }

    public List<Uplata> findByIdPlacanja(int idPlacanja) throws SQLException {
        String sql = "SELECT * FROM Uplata WHERE IdPlacanja = ? ORDER BY DatumUplate";
        List<Uplata> lista = new ArrayList<>();

        try (Connection con = DBKonekcija.getKonekcija();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPlacanja);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Uplata(
                        rs.getInt("IdUplate"),
                        rs.getInt("IdPlacanja"),
                        rs.getDouble("Iznos"),
                        rs.getDate("DatumUplate").toLocalDate()
                ));
            }
        }
        return lista;
    }
}