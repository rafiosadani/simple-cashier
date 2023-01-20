package model;

import java.sql.*;
import javax.swing.JOptionPane;

public class UserLogin {
    private static String query;
    private static Statement stmt;
    private static ResultSet rs;
    private static String kodePegawai;
    
    public static void setKodePegawai(String kodepegawai) {
        UserLogin.kodePegawai = kodepegawai;
    }
    
    public static String getKodePegawai() {
        return kodePegawai;
    }
    
    public static int cekUserLogin(String username, String password) {
        Connection conn = Koneksi.koneksiDB();
        int data = 0;
        try {
            stmt = conn.createStatement();
            query = "SELECT COUNT(id_pegawai) FROM pegawai WHERE username = '"+ username +"' AND password = '"+ password +"'";
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                data = rs.getInt(1);
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return data;
    }
    
    public static String getPegawai(String username, String password) {
        Connection conn = Koneksi.koneksiDB();
        String data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_pegawai FROM pegawai WHERE username = '"+ username +"' AND password = '"+ password +"'";
            rs = stmt.executeQuery(query);
            rs = stmt.executeQuery(query);
            while(rs.next()) {
                data = rs.getString("kode_pegawai");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return data;
    }
}
