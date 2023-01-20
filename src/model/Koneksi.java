package model;

import java.sql.*;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection koneksiDatabase;
    public static Connection koneksiDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String DB = "jdbc:mysql:///kasir";
            String user = "root";
            String pass = "";
            koneksiDatabase = DriverManager.getConnection(DB, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi", "Eror", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Connection Error : " + e.getMessage());
            System.exit(0);
        }
        return koneksiDatabase;
    }
}
