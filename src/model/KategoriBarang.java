package model;

import java.sql.*;
import javax.swing.JOptionPane;

public class KategoriBarang {
    private static String query;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static String kodeKategoriOtomatis() {
        Connection conn = Koneksi.koneksiDB();
        String kodeKategori = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_kategori FROM kategori_barang ORDER BY kode_kategori DESC";
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                String kode = rs.getString("kode_kategori").substring(3);
                String angka = "" + (Integer.parseInt(kode) + 1);
                String NOL = "";
                
                if(angka.length() == 1) {
                    NOL = "000";
                } else if(angka.length() == 2) {
                    NOL = "00";
                } else if(angka.length() == 3) {
                    NOL = "0";
                } else if(angka.length() == 4) {
                    NOL = "";
                }
                kodeKategori = "KTR" + NOL + angka;
            } else {
                kodeKategori = "KTR0001";
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kodeKategori;
    }
    
    public static String [][] getKategori() {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_kategori, nama_kategori FROM kategori_barang";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String [1000][jmlKolom];
            int r = 0;
            while (rs.next()) {
                for(int c = 0; c < jmlKolom; c++) {
                    data[r][c] = rs.getString(c+1);
                }
                r++;
            }
            int jmlBaris = r;
            String [][] tmpArray = data;
            data = new String[jmlBaris][jmlKolom];
            for(r = 0; r < jmlBaris; r++) {
                for(int c = 0; c < jmlKolom; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Eror : " + e.getMessage());
        }
        return data;
    }
    
    public static String [][] getKategoriByKodeKategori(String kodeKategori) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_kategori, nama_kategori "
                    + "FROM kategori_barang "
                    + "WHERE kode_kategori = '"+ kodeKategori +"'";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String [1000][jmlKolom];
            int r = 0;
            while (rs.next()) {
                for(int c = 0; c < jmlKolom; c++) {
                    data[r][c] = rs.getString(c+1);
                }
                r++;
            }
            int jmlBaris = r;
            String [][] tmpArray = data;
            data = new String[jmlBaris][jmlKolom];
            for(r = 0; r < jmlBaris; r++) {
                for(int c = 0; c < jmlKolom; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return data;
    }
    
    public static void tambahDataKategori(String kodeKategori, String namaKategori) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "INSERT INTO kategori_barang(kode_kategori, nama_kategori) "
                    + "VALUES('"+ kodeKategori +"', '"+ namaKategori +"')";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void updateDataKategori(String kodeKategori, String namaKategori) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "UPDATE kategori_barang SET nama_kategori = '"+ namaKategori +"' "
                    + "WHERE kode_kategori = '"+ kodeKategori +"'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void hapusDataKategori(String kodeKategori) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "DELETE FROM kategori_barang WHERE kode_kategori = '"+ kodeKategori +"'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static String[][] cariDataKategori(String keyword) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_kategori, nama_kategori "
                    + "FROM kategori_barang "
                    + "WHERE kode_kategori LIKE '%"+ keyword +"%' OR nama_kategori LIKE '%"+ keyword +"%' "
                    + "ORDER BY kode_kategori, nama_kategori";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String [1000][jmlKolom];
            int r = 0;
            while (rs.next()) {
                for(int c = 0; c < jmlKolom; c++) {
                    data[r][c] = rs.getString(c+1);
                }
                r++;
            }
            int jmlBaris = r;
            String [][] tmpArray = data;
            data = new String[jmlBaris][jmlKolom];
            for(r = 0; r < jmlBaris; r++) {
                for(int c = 0; c < jmlKolom; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return data;
    }
    
    public static String[] getListKategori() {
        Connection conn = Koneksi.koneksiDB();
        String [] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_kategori, nama_kategori FROM kategori_barang";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000];
            int r = 0;
            while (rs.next()) {
                String kodeKategori = rs.getString("kode_kategori");
                String namaKategori = rs.getString("nama_kategori");
                String listKategori = kodeKategori + " - " + namaKategori;
                data[r] = listKategori;
                r++;
            }
            int jmlBaris = r;
            String [] tmpArray = data;
            data = new String[jmlBaris];
            for(r = 0; r < jmlBaris; r++) {
                data[r] = tmpArray[r];
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return data;
    }
}
