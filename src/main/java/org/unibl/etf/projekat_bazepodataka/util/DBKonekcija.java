package org.unibl.etf.projekat_bazepodataka.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBKonekcija {
    private static final String URL = "jdbc:mysql://localhost:3306/projekat_baze_podataka";
    private static final String USER = "root";
    private static final String PASSWORD = "student";

    private static Connection konekcija = null;

    public static Connection getKonekcija() throws SQLException {
        if (konekcija == null || konekcija.isClosed()) {
            konekcija = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return konekcija;
    }

    public static void zatvoriKonekciju() {
        try {
            if (konekcija != null && !konekcija.isClosed()) {
                konekcija.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
