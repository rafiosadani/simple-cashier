package model;

import java.sql.*;

public class LaporanPenjualanBarang {
    private static String query;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static String[][] getLaporanPenjualanByTanggal(String tanggal) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT p.kode_transaksi_penjualan, p.tgl_penjualan, b.kode_barang, b.nama_barang, kb.nama_kategori, "
                    + "b.harga_barang, dp.jumlah, dp.total_harga, pg.nama_pegawai "
                    + "FROM penjualan p "
                    + "INNER JOIN detail_penjualan dp ON p.kode_transaksi_penjualan = dp.kode_transaksi_penjualan "
                    + "INNER JOIN barang b ON b.kode_barang = dp.kode_barang "
                    + "INNER JOIN kategori_barang kb ON kb.kode_kategori = b.kode_kategori "
                    + "INNER JOIN pegawai pg ON p.kode_pegawai = pg.kode_pegawai "
                    + "WHERE p.tgl_penjualan = '"+ tanggal +"'"
                    + "ORDER BY p.tgl_penjualan ASC";
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
    
    public static String[][] getLaporanPenjualanByKodeTransaksi(String kodeTransaksi) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT p.kode_transaksi_penjualan, p.tgl_penjualan, b.kode_barang, b.nama_barang, kb.nama_kategori, "
                    + "b.harga_barang, dp.jumlah, dp.total_harga, pg.nama_pegawai "
                    + "FROM penjualan p "
                    + "INNER JOIN detail_penjualan dp ON p.kode_transaksi_penjualan = dp.kode_transaksi_penjualan "
                    + "INNER JOIN barang b ON b.kode_barang = dp.kode_barang "
                    + "INNER JOIN kategori_barang kb ON kb.kode_kategori = b.kode_kategori "
                    + "INNER JOIN pegawai pg ON p.kode_pegawai = pg.kode_pegawai "
                    + "WHERE p.kode_transaksi_penjualan = '"+ kodeTransaksi +"'"
                    + "ORDER BY p.kode_transaksi_penjualan ASC";
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
    
    public static String[][] getLaporanPenjualanPeriodik(String tanggal1, String tanggal2) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT p.kode_transaksi_penjualan, p.tgl_penjualan, b.kode_barang, b.nama_barang, kb.nama_kategori, "
                    + "b.harga_barang, dp.jumlah, dp.total_harga, pg.nama_pegawai "
                    + "FROM penjualan p "
                    + "INNER JOIN detail_penjualan dp ON p.kode_transaksi_penjualan = dp.kode_transaksi_penjualan "
                    + "INNER JOIN barang b ON b.kode_barang = dp.kode_barang "
                    + "INNER JOIN kategori_barang kb ON kb.kode_kategori = b.kode_kategori "
                    + "INNER JOIN pegawai pg ON p.kode_pegawai = pg.kode_pegawai "
                    + "WHERE p.tgl_penjualan BETWEEN '"+ tanggal1 +"' AND '"+ tanggal2 +"'"
                    + "ORDER BY p.tgl_penjualan ASC";
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
    
    public static String[] getListKodeTransaksi() {
        Connection conn = Koneksi.koneksiDB();
        String [] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_transaksi_penjualan FROM penjualan ORDER BY kode_transaksi_penjualan ASC";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000];
            int r = 0;
            while (rs.next()) {
                String kodeTransaksi = rs.getString("kode_transaksi_penjualan");
                data[r] = kodeTransaksi;
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
