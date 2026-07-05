package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.Kupac;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KupacDAO {

    public void insert(Kupac kupac) throws SQLException {
        String sql = "INSERT INTO Kupac (JMB, Ime, Prezime, Adresa, Telefon, Email) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection con = DBKonekcija.getKonekcija();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, kupac.getJmb());
            ps.setString(2, kupac.getIme());
            ps.setString(3, kupac.getPrezime());
            ps.setString(4, kupac.getAdresa());
            ps.setString(5, kupac.getTelefon());
            ps.setString(6, kupac.getEmail());

            ps.executeUpdate();
        }
    }

    public Kupac findByJmb(String jmb) throws SQLException {
        String sql = "SELECT * FROM Kupac WHERE JMB = ?";

        try(Connection con = DBKonekcija.getKonekcija();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, jmb);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Kupac(
                        rs.getString("JMB"),
                        rs.getString("Ime"),
                        rs.getString("Prezime"),
                        rs.getString("Adresa"),
                        rs.getString("Telefon"),
                        rs.getString("Email")
                );
            }
        }
        return null;
    }

    public List<Kupac> findAll() throws SQLException {
        String sql = "SELECT * FROM Kupac";
        List<Kupac> lista = new ArrayList<>();

        try(Connection con = DBKonekcija.getKonekcija();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){

            while(rs.next()){
                lista.add(new Kupac(
                        rs.getString("JMB"),
                        rs.getString("Ime"),
                        rs.getString("Prezime"),
                        rs.getString("Adresa"),
                        rs.getString("Telefon"),
                        rs.getString("Email")
                ));
            }
        }

        return lista;
    }

    public void update(Kupac kupac) throws SQLException {
        String sql = "UPDATE Kupac SET Ime = ?, Prezime = ?, Adresa = ?, Telefon = ?, Email = ? WHERE JMB = ?";

        try(Connection con = DBKonekcija.getKonekcija();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, kupac.getIme());
            ps.setString(2, kupac.getPrezime());
            ps.setString(3, kupac.getAdresa());
            ps.setString(4, kupac.getTelefon());
            ps.setString(5, kupac.getEmail());
            ps.setString(6, kupac.getJmb());

            ps.executeUpdate();
        }
    }

    public void delete(String jmb) throws SQLException {
        String sql = "DELETE FROM Kupac WHERE JMB = ?";

        try(Connection con = DBKonekcija.getKonekcija();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, jmb);
            ps.executeUpdate();
        }
    }

}
