package org.unibl.etf.projekat_bazepodataka.dao;

import org.unibl.etf.projekat_bazepodataka.model.Agent;
import org.unibl.etf.projekat_bazepodataka.util.DBKonekcija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgentDAO {
    public void insert(Agent agent) throws SQLException {
        String sql = "INSERT INTO Agent (ID, Ime, Prezime) VALUES (?, ?, ?)";

        try(Connection con = DBKonekcija.getKonekcija();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, agent.getId());
            ps.setString(2, agent.getIme());
            ps.setString(3, agent.getPrezime());

            ps.executeUpdate();
        }
    }

    public Agent findById(int id) throws SQLException {
        String sql = "SELECT a.ID, z.Ime, z.Prezime FROM Agent a JOIN Zaposleni z ON a.ID = z.ID WHERE a.ID = ?";

        try(Connection con = DBKonekcija.getKonekcija();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Agent(
                        rs.getInt("ID"),
                        rs.getString("Ime"),
                        rs.getString("Prezime")
                );
            }
        }
        return null;
    }

    public List<Agent> findAll() throws SQLException {
        String sql = "SELECT a.ID, z.Ime, z.Prezime FROM Agent a JOIN Zaposleni z ON a.ID = z.ID";
        List<Agent> lista = new ArrayList<>();

        try(Connection con = DBKonekcija.getKonekcija();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){

            while(rs.next()){
                lista.add(new Agent(
                        rs.getInt("ID"),
                        rs.getString("Ime"),
                        rs.getString("Prezime")
                ));
            }
        }

        return lista;
    }

    public void update(Agent agent) throws SQLException {
        String sql = "UPDATE Agent SET Ime = ?, Prezime = ? WHERE ID = ?";

        try(Connection con = DBKonekcija.getKonekcija();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setString(1, agent.getIme());
            ps.setString(2, agent.getPrezime());
            ps.setInt(3, agent.getId());

            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Agent WHERE ID = ?";

        try(Connection con = DBKonekcija.getKonekcija();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

}
