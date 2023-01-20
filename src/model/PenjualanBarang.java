package model;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;
import javax.swing.JOptionPane;

public class PenjualanBarang {
    private static String query;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static String kodeTransaksiPenjualanOtomatis() {
        Connection conn = Koneksi.koneksiDB();
        String kodeTransaksi = null;
        try {
            java.util.Date tgl = new java.util.Date();
            DateFormat bulanTahun = new SimpleDateFormat("YYYYMMdd");
            String strDate = bulanTahun.format(tgl);
            
            DateFormat bulanTahun2 = new SimpleDateFormat("YYYY-MM-dd");
            String strDate2 = bulanTahun2.format(tgl);
            
            stmt = conn.createStatement();
            query = "SELECT kode_transaksi_penjualan FROM penjualan "
                    + "WHERE tgl_penjualan = '"+ strDate2 +"' ORDER BY kode_transaksi_penjualan DESC";
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                String kode = rs.getString("kode_transaksi_penjualan").substring(13);
                
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
                kodeTransaksi = "TRSPJ" + strDate + NOL + angka;
            } else {
                kodeTransaksi = "TRSPJ" + strDate + "00001";
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kodeTransaksi;
    }
    
    public static String[][] getBarangByKode(String kodeBarang) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_barang, nama_barang, harga_barang "
                    + "FROM barang WHERE kode_barang = '"+ kodeBarang +"' "
                    + "ORDER BY kode_barang ASC";
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
    
    public static String[] getListBarang() {
        Connection conn = Koneksi.koneksiDB();
        String [] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_barang, nama_barang FROM barang";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000];
            int r = 0;
            while (rs.next()) {
                String kodeBarang = rs.getString("kode_barang");
                String namaBarang = rs.getString("nama_barang");
                String listBarang = kodeBarang + " - " + namaBarang;
                data[r] = listBarang;
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
    
    public static void simpanDataTransaksiPenjualan(String kodeTransaksi, String tglPenjualan, int jumlahBarang, int totalHarga, 
            int bayar, int kembali, String statusJual, String kodePegawai) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "INSERT INTO penjualan(kode_transaksi_penjualan, tgl_penjualan, jumlah_barang, total_harga, "
                    + "bayar, kembali, status_penjualan, kode_pegawai) "
                    + "VALUES('"+ kodeTransaksi +"', '"+ tglPenjualan +"', '"+ jumlahBarang +"', '"+ totalHarga +"', "
                    + "'"+ bayar +"', '"+ kembali +"', '"+ statusJual +"', '"+ kodePegawai +"')";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void simpanDataDetailTransaksiPenjualan(String kodeTransaksi, String kodeBarang, int hargaBarang, 
            int jumlahBarang, int totalHarga) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "INSERT INTO detail_penjualan(kode_transaksi_penjualan, kode_barang, harga_barang, "
                    + "jumlah, total_harga) "
                    + "VALUES('"+ kodeTransaksi +"', '"+ kodeBarang +"', '"+ hargaBarang +"', "
                    + "'"+ jumlahBarang +"', '"+ totalHarga +"')";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
