package model;

import java.sql.*;

public class Supplier {
    private static String query;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static String kodeKategoriOtomatis() {
        Connection conn = Koneksi.koneksiDB();
        String kodeSupplier = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_supplier FROM supplier ORDER BY kode_supplier DESC";
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                String kode = rs.getString("kode_supplier").substring(3);
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
                kodeSupplier = "SPL" + NOL + angka;
            } else {
                kodeSupplier = "SPL0001";
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kodeSupplier;
    }
    
    public static String [][] getSupplier() {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT * FROM supplier";
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
    
    public static String [][] getSupplierByKodeSupplier(String kodeSupplier) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_supplier, nama_supplier, alamat_supplier, no_telp_supplier "
                    + "FROM supplier "
                    + "WHERE kode_supplier = '"+ kodeSupplier +"'";
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
    
    public static void tambahDataSupplier(String kodeSupplier, String namaSupplier, String alamatSupplier, String noSupplier) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "INSERT INTO supplier(kode_supplier, nama_supplier, alamat_supplier, no_telp_supplier) "
                    + "VALUES('"+ kodeSupplier +"', '"+ namaSupplier +"', '"+ alamatSupplier +"', '"+ noSupplier +"')";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void updateDataSupplier(String kodeSupplier, String namaSupplier, String alamatSupplier, String noSupplier) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "UPDATE supplier SET nama_supplier = '"+ namaSupplier +"', alamat_supplier = '"+ alamatSupplier +"', "
                    + "no_telp_supplier = '"+ noSupplier +"' "
                    + "WHERE kode_supplier = '"+ kodeSupplier +"'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void hapusDataSupplier(String kodeSupplier) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "DELETE FROM supplier WHERE kode_supplier = '"+ kodeSupplier +"'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static String [][] cariDataSupplier(String keyword) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_supplier, nama_supplier, alamat_supplier, no_telp_supplier "
                    + "FROM supplier WHERE kode_supplier LIKE '%"+ keyword +"%' OR nama_supplier LIKE '%"+ keyword +"%' "
                    + "OR alamat_supplier LIKE '%"+ keyword +"%' OR no_telp_supplier LIKE '%"+ keyword +"%'";
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
    
    public static String[] getListSupplier() {
        Connection conn = Koneksi.koneksiDB();
        String [] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_supplier, nama_supplier FROM supplier";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000];
            int r = 0;
            while (rs.next()) {
                String kodeSupplier = rs.getString("kode_supplier");
                String namaSupplier = rs.getString("nama_supplier");
                String listSupplier = kodeSupplier + " - " + namaSupplier;
                data[r] = listSupplier;
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
