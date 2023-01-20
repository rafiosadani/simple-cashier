package model;

import java.sql.*;

public class Barang {
    private static String query;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static String kodeBarangOtomatis() {
        Connection conn = Koneksi.koneksiDB();
        String kodeBarang = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_barang FROM barang ORDER BY kode_barang DESC";
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                String kode = rs.getString("kode_barang").substring(3);
                String angka = "" + (Integer.parseInt(kode) + 1);
                String NOL = "";
                
                if(angka.length() == 1) {
                    NOL = "0000";
                } else if(angka.length() == 2) {
                    NOL = "000";
                } else if(angka.length() == 3) {
                    NOL = "00";
                } else if(angka.length() == 4) {
                    NOL = "0";
                } else if(angka.length() == 5) {
                    NOL = "";
                }
                kodeBarang = "BRG" + NOL + angka;
            } else {
                kodeBarang = "BRG00001";
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kodeBarang;
    }
    
    public static String[][] getBarang() {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT b.kode_barang, b.nama_barang, kb.nama_kategori, b.satuan, b.stok_barang, b.harga_barang, s.nama_supplier "
                    + "FROM barang b INNER JOIN kategori_barang kb ON b.kode_kategori = kb.kode_kategori "
                    + "INNER JOIN supplier s ON b.kode_supplier = s.kode_supplier "
                    + "ORDER BY b.kode_barang ASC";
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
    
    public static String[][] getBarangByKode(String kodeBarang) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT b.kode_barang, b.nama_barang, kb.kode_kategori, kb.nama_kategori, b.satuan, b.stok_barang, b.harga_barang, s.kode_supplier, s.nama_supplier "
                    + "FROM barang b INNER JOIN kategori_barang kb ON b.kode_kategori = kb.kode_kategori "
                    + "INNER JOIN supplier s ON b.kode_supplier = s.kode_supplier "
                    + "WHERE b.kode_barang = '"+ kodeBarang +"' "
                    + "ORDER BY b.kode_barang ASC";
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
    
    public static void tambahDataBarang(String kodeBarang, String kodeKategori, String namaBarang, String satuan, 
            int stokBarang, int hargaBarang, String kodeSupplier) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "INSERT INTO barang(kode_barang, kode_kategori, nama_barang, satuan, stok_barang, harga_barang, kode_supplier) "
                    + "VALUES('"+ kodeBarang +"', '"+ kodeKategori +"', '"+ namaBarang +"', '"+ satuan +"', "
                    + "'"+ stokBarang +"', '"+ hargaBarang +"', '"+ kodeSupplier +"')";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void updateDataBarang(String kodeBarang, String kodeKategori, String namaBarang, String satuan, 
            int stokBarang, int hargaBarang, String kodeSupplier) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "UPDATE barang SET kode_kategori = '"+ kodeKategori +"', nama_barang = '"+ namaBarang +"', satuan = '"+ satuan +"', "
                    + "stok_barang = '"+ stokBarang +"', harga_barang = '"+ hargaBarang +"', kode_supplier = '"+ kodeSupplier +"' "
                    + "WHERE kode_barang = '"+ kodeBarang +"'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void hapusDataBarang(String kodeBarang) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "DELETE FROM barang WHERE kode_barang = '"+ kodeBarang +"'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static String[][] cariDataBarang(String keyword) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT b.kode_barang, b.nama_barang, kb.nama_kategori, b.satuan, b.stok_barang, b.harga_barang, s.nama_supplier "
                    + "FROM barang b INNER JOIN kategori_barang kb ON b.kode_kategori = kb.kode_kategori "
                    + "INNER JOIN supplier s ON b.kode_supplier = s.kode_supplier "
                    + "WHERE b.kode_barang LIKE '%"+ keyword +"%' OR b.nama_barang LIKE '%"+ keyword +"%' OR kb.nama_kategori LIKE '%"+ keyword +"%' "
                    + "OR b.satuan LIKE '%"+ keyword +"' OR s.nama_supplier LIKE '%"+ keyword +"%' "
                    + "ORDER BY b.kode_barang ASC";
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
}
