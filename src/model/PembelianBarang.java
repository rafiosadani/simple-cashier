package model;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PembelianBarang {
    private static String query;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static String kodeTransaksiPembelianOtomatis() {
        Connection conn = Koneksi.koneksiDB();
        String kodeTransaksi = null;
        try {
            java.util.Date tgl = new java.util.Date();
            DateFormat bulanTahun = new SimpleDateFormat("YYYYMMdd");
            String strDate = bulanTahun.format(tgl);
            
            DateFormat bulanTahun2 = new SimpleDateFormat("YYYY-MM-dd");
            String strDate2 = bulanTahun2.format(tgl);
            
            stmt = conn.createStatement();
            query = "SELECT kode_transaksi_pembelian FROM pembelian "
                    + "WHERE tgl_pembelian = '"+ strDate2 +"' ORDER BY kode_transaksi_pembelian DESC";
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                String kode = rs.getString("kode_transaksi_pembelian").substring(13);
                
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
                kodeTransaksi = "TRSPB" + strDate + NOL + angka;
            } else {
                kodeTransaksi = "TRSPB" + strDate + "00001";
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kodeTransaksi;
    }
    
    public static String[][] getSupplierByKode(String kodeSupplier) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_supplier, nama_supplier, alamat_supplier "
                    + "FROM supplier WHERE kode_supplier = '"+ kodeSupplier +"' "
                    + "ORDER BY kode_supplier ASC";
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
    
    public static String[] getListBarangByKodeSupplier(String kodeSupplier) {
        Connection conn = Koneksi.koneksiDB();
        String [] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_barang, nama_barang FROM barang WHERE kode_supplier = '"+ kodeSupplier +"'";
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
    
    public static String[][] getKodeSupplierByKodeBarang(String kodeBarang) {
        Connection conn = Koneksi.koneksiDB();
        String [][] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_supplier "
                    + "FROM barang WHERE kode_barang = '"+ kodeBarang +"'";
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
    
    public static void simpanDataTransaksiPembelian(String kodeTransaksi, String tglPembelian, int jumlahBarang, int totalHarga, 
            int bayar, int kembali, String statusBeli, String kodePegawai) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "INSERT INTO pembelian(kode_transaksi_pembelian, tgl_pembelian, jumlah_barang, total_harga, "
                    + "bayar, kembali, status_pembelian, kode_pegawai) "
                    + "VALUES('"+ kodeTransaksi +"', '"+ tglPembelian +"', '"+ jumlahBarang +"', '"+ totalHarga +"', "
                    + "'"+ bayar +"', '"+ kembali +"', '"+ statusBeli +"', '"+ kodePegawai +"')";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void simpanDataDetailTransaksiPembelian(String kodeTransaksi, String kodeBarang, int hargaBarang, 
            int jumlahBarang, int totalHarga, String kodeSupplier) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "INSERT INTO detail_pembelian(kode_transaksi_pembelian, kode_barang, harga_barang, "
                    + "jumlah, total_harga, kode_supplier) "
                    + "VALUES('"+ kodeTransaksi +"', '"+ kodeBarang +"', '"+ hargaBarang +"', "
                    + "'"+ jumlahBarang +"', '"+ totalHarga +"', '"+ kodeSupplier +"')";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
