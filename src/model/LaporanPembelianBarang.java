package model;

import java.sql.*;

public class LaporanPembelianBarang {
    private static String query;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static String[] getListKodeTransaksi() {
        Connection conn = Koneksi.koneksiDB();
        String [] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_transaksi_pembelian FROM pembelian ORDER BY kode_transaksi_pembelian ASC";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000];
            int r = 0;
            while (rs.next()) {
                String kodeTransaksi = rs.getString("kode_transaksi_pembelian");
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
    
    public static String[][] getLaporanPembelianByTanggal(String tanggal) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT p.kode_transaksi_pembelian, p.tgl_pembelian, b.kode_barang, b.nama_barang, kb.nama_kategori, "
                    + "b.harga_barang, dp.jumlah, dp.total_harga, s.nama_supplier, pg.nama_pegawai "
                    + "FROM pembelian p "
                    + "INNER JOIN detail_pembelian dp ON p.kode_transaksi_pembelian = dp.kode_transaksi_pembelian "
                    + "INNER JOIN barang b ON b.kode_barang = dp.kode_barang "
                    + "INNER JOIN kategori_barang kb ON kb.kode_kategori = b.kode_kategori "
                    + "INNER JOIN supplier s ON s.kode_supplier = b.kode_supplier "
                    + "INNER JOIN pegawai pg ON p.kode_pegawai = pg.kode_pegawai "
                    + "WHERE p.tgl_pembelian = '"+ tanggal +"' "
                    + "ORDER BY p.tgl_pembelian ASC";
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
    
    public static String[][] getLaporanPembelianByKodeTransaksi(String kodeTransaksi) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT p.kode_transaksi_pembelian, p.tgl_pembelian, b.kode_barang, b.nama_barang, kb.nama_kategori, "
                    + "b.harga_barang, dp.jumlah, dp.total_harga, s.nama_supplier, pg.nama_pegawai "
                    + "FROM pembelian p "
                    + "INNER JOIN detail_pembelian dp ON p.kode_transaksi_pembelian = dp.kode_transaksi_pembelian "
                    + "INNER JOIN barang b ON b.kode_barang = dp.kode_barang "
                    + "INNER JOIN kategori_barang kb ON kb.kode_kategori = b.kode_kategori "
                    + "INNER JOIN supplier s ON s.kode_supplier = b.kode_supplier "
                    + "INNER JOIN pegawai pg ON p.kode_pegawai = pg.kode_pegawai "
                    + "WHERE p.kode_transaksi_pembelian = '"+ kodeTransaksi +"' "
                    + "ORDER BY p.kode_transaksi_pembelian ASC";
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
    
    public static String[][] getLaporanPembelianPeriodik(String tanggal1, String tanggal2) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT p.kode_transaksi_pembelian, p.tgl_pembelian, b.kode_barang, b.nama_barang, kb.nama_kategori, "
                    + "b.harga_barang, dp.jumlah, dp.total_harga, s.nama_supplier, pg.nama_pegawai "
                    + "FROM pembelian p "
                    + "INNER JOIN detail_pembelian dp ON p.kode_transaksi_pembelian = dp.kode_transaksi_pembelian "
                    + "INNER JOIN barang b ON b.kode_barang = dp.kode_barang "
                    + "INNER JOIN kategori_barang kb ON kb.kode_kategori = b.kode_kategori "
                    + "INNER JOIN supplier s ON s.kode_supplier = b.kode_supplier "
                    + "INNER JOIN pegawai pg ON p.kode_pegawai = pg.kode_pegawai "
                    + "WHERE p.tgl_pembelian BETWEEN '"+ tanggal1 +"' AND '"+ tanggal2 +"' "
                    + "ORDER BY p.tgl_pembelian ASC";
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
