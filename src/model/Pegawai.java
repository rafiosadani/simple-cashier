package model;

import java.sql.*;

public class Pegawai {
    private static String query;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static String kodeKategoriOtomatis() {
        Connection conn = Koneksi.koneksiDB();
        String kodePegawai = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT kode_pegawai FROM pegawai ORDER BY kode_pegawai DESC";
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                String kode = rs.getString("kode_pegawai").substring(3);
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
                kodePegawai = "PGW" + NOL + angka;
            } else {
                kodePegawai = "PGW0001";
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kodePegawai;
    }
    
    public static String [][] getDataPegawai() {
        Connection conn = Koneksi.koneksiDB();
        String data [][] = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT pegawai.*, role.nama_role FROM pegawai "
                    + "INNER JOIN role ON pegawai.id_role = role.id_role";
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
    
    public static String [][] getDataPegawaiByKode(String kodePegawai) {
        Connection conn = Koneksi.koneksiDB();
        String data [][] = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT pegawai.*, role.nama_role FROM pegawai "
                    + "INNER JOIN role ON pegawai.id_role = role.id_role "
                    + "WHERE kode_pegawai = '"+ kodePegawai +"'";
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
    
    public static String[] getListRole() {
        Connection conn = Koneksi.koneksiDB();
        String [] data = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT * FROM role";
            rs = stmt.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            int jmlKolom = meta.getColumnCount();
            data = new String[1000];
            int r = 0;
            while (rs.next()) {
                String idRole = rs.getString("id_role");
                String namaRole = rs.getString("nama_role");
                String listRole = idRole + " - " + namaRole;
                data[r] = listRole;
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
    
    public static void tambahDataPegawai(String kodePegawai, String namaPegawai, String jenisKelamin, String alamatPegawai, 
            String noTeleponPegawai, String username, String password, int idRole) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "INSERT INTO pegawai(kode_pegawai, nama_pegawai, jenis_kelamin, alamat_pegawai, no_telp_pegawai, username, "
                    + "password, id_role) VALUES('"+ kodePegawai +"', '"+ namaPegawai +"', '"+ jenisKelamin +"', '"+ alamatPegawai +"', "
                    + "'"+ noTeleponPegawai +"', '"+ username +"', '"+ password +"', '"+ idRole +"')";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void updateDataPegawai(String kodePegawai, String namaPegawai, String jenisKelamin, String alamatPegawai, 
            String noTeleponPegawai, String username, String password, int idRole) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "UPDATE pegawai SET nama_pegawai = '"+ namaPegawai +"', jenis_kelamin = '"+ jenisKelamin +"', alamat_pegawai = '"+ alamatPegawai +"', "
                    + "no_telp_pegawai = '"+ noTeleponPegawai +"', username = '"+ username +"', password = '"+ password +"', id_role = '"+ idRole +"' "
                    + "WHERE kode_pegawai = '"+ kodePegawai +"'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static void hapusDataPegawai(String kodePegawai) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "DELETE FROM pegawai WHERE kode_pegawai = '"+ kodePegawai +"'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public static String [][] cariDataPegawai(String keyword) {
        Connection conn = Koneksi.koneksiDB();
        String data [][] = null;
        try {
            stmt = conn.createStatement();
            query = "SELECT pegawai.*, role.nama_role FROM pegawai "
                    + "INNER JOIN role ON pegawai.id_role = role.id_role "
                    + "WHERE kode_pegawai LIKE '%"+ keyword +"%' OR nama_pegawai LIKE '%"+ keyword +"%' OR "
                    + "jenis_kelamin LIKE '%"+ keyword +"%' OR alamat_pegawai LIKE '%"+ keyword +"%' OR nama_role LIKE '%"+ keyword +"%'";
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
    
    public static void editProfilDataPegawai(String kodePegawai, String namaPegawai, String jenisKelamin, String alamatPegawai, 
            String noTeleponPegawai, String username, String password) {
        Connection conn = Koneksi.koneksiDB();
        try {
            stmt = conn.createStatement();
            query = "UPDATE pegawai SET nama_pegawai = '"+ namaPegawai +"', jenis_kelamin = '"+ jenisKelamin +"', alamat_pegawai = '"+ alamatPegawai +"', "
                    + "no_telp_pegawai = '"+ noTeleponPegawai +"', username = '"+ username +"', password = '"+ password +"' "
                    + "WHERE kode_pegawai = '"+ kodePegawai +"'";
            stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
