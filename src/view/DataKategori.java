package view;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KategoriBarang;
import model.Koneksi;

public final class DataKategori extends javax.swing.JFrame {
    String status = null;
    DefaultTableModel TblKategori;
    
    public DataKategori() {
        initComponents();
        int baris = 0;
        Object kolom[] = {"No", "Kode Kategori", "Nama Kategori Barang"};
        TblKategori = new DefaultTableModel(kolom, baris);
        
        kondisiAwal();
        kodeKategoriOtomatis();
        tampiDataKategori();
    }
    
    public void kondisiAwal() {
        TxtKode.setEnabled(false);
        TxtNama.setEnabled(false);
        BtnTambah.setEnabled(true);
        BtnEdit.setEnabled(false);
        BtnHapus.setEnabled(false);
        BtnSimpan.setEnabled(false);
        BtnBatal.setEnabled(false);
        BtnBersih.setEnabled(false);
        
        TxtNama.setText("");
        TxtKeyword.setText("");
        BtnTambah.requestFocus();
    }
    
    public void komponenAktif() {
        TxtKode.setEnabled(false);
        TxtNama.setEnabled(true);
        BtnTambah.setEnabled(false);
        BtnEdit.setEnabled(false);
        BtnHapus.setEnabled(false);
        BtnSimpan.setEnabled(true);
        BtnBatal.setEnabled(true);
        BtnBersih.setEnabled(true);
        TxtNama.requestFocus();
    }
    
    public void kodeKategoriOtomatis() {
        String kodeKategori = KategoriBarang.kodeKategoriOtomatis();
        TxtKode.setText(kodeKategori);
    }
    
    public void tampiDataKategori() {
        TblKategori.getDataVector().removeAllElements();
        
        // Tampil Data
        String [][] data = KategoriBarang.getKategori();
        for (int i = 0; i < data.length; i++) {
            int no = i + 1;
            TblKategori.addRow(new Object[]{no, data[i][0], data[i][1]});
        }
        TabelKategori.setModel(TblKategori);
        
        // Lebar Kolom Tabel
        TabelKategori.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelKategori.getColumnModel().getColumn(1).setPreferredWidth(60);
        TabelKategori.getColumnModel().getColumn(2).setPreferredWidth(180);
    }
    
    public void cariDataKategori(String keyword) {
        TblKategori.getDataVector().removeAllElements();
        
        // Tampil Data
        String [][] data = KategoriBarang.cariDataKategori(keyword);
        for (int i = 0; i < data.length; i++) {
            int no = i + 1;
            TblKategori.addRow(new Object[]{no, data[i][0], data[i][1]});
        }
        TabelKategori.setModel(TblKategori);
        
        // Lebar Kolom Tabel
        TabelKategori.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelKategori.getColumnModel().getColumn(1).setPreferredWidth(60);
        TabelKategori.getColumnModel().getColumn(2).setPreferredWidth(180);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnTambah = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnBersih = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TxtKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtNama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelKategori = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        TxtKeyword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Kategori");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(33, 158, 188));
        jPanel1.setPreferredSize(new java.awt.Dimension(295, 75));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Kategori");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        BtnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tambah.png"))); // NOI18N
        BtnTambah.setText("Tambah");
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        BtnEdit.setText("Edit");
        BtnEdit.setMaximumSize(new java.awt.Dimension(111, 41));
        BtnEdit.setMinimumSize(new java.awt.Dimension(111, 41));
        BtnEdit.setPreferredSize(new java.awt.Dimension(111, 41));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hapus.png"))); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.setMaximumSize(new java.awt.Dimension(111, 41));
        BtnHapus.setMinimumSize(new java.awt.Dimension(111, 41));
        BtnHapus.setPreferredSize(new java.awt.Dimension(111, 41));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        BtnBersih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bersihkan.png"))); // NOI18N
        BtnBersih.setText("Bersih");
        BtnBersih.setMaximumSize(new java.awt.Dimension(111, 41));
        BtnBersih.setMinimumSize(new java.awt.Dimension(111, 41));
        BtnBersih.setPreferredSize(new java.awt.Dimension(111, 41));
        BtnBersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBersihActionPerformed(evt);
            }
        });

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/batal.png"))); // NOI18N
        BtnBatal.setText("Batal");
        BtnBatal.setMaximumSize(new java.awt.Dimension(111, 41));
        BtnBatal.setMinimumSize(new java.awt.Dimension(111, 41));
        BtnBatal.setPreferredSize(new java.awt.Dimension(111, 41));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/simpan.png"))); // NOI18N
        BtnSimpan.setText("Simpan");
        BtnSimpan.setMaximumSize(new java.awt.Dimension(111, 41));
        BtnSimpan.setMinimumSize(new java.awt.Dimension(111, 41));
        BtnSimpan.setPreferredSize(new java.awt.Dimension(111, 41));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        jLabel2.setText("Kode Kategori");

        jLabel3.setText("Nama Kategori");

        TabelKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelKategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelKategori);

        jLabel4.setText("Cari Data");

        TxtKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtKeywordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtKeyword))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtKode)
                            .addComponent(TxtNama))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambah)
                    .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        status = "Tambah";
        komponenAktif();
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        // TODO add your handling code here:
        kondisiAwal();
        kodeKategoriOtomatis();
        tampiDataKategori();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBersihActionPerformed
        // TODO add your handling code here:
        TxtNama.setText("");
        kodeKategoriOtomatis();
        TxtNama.requestFocus();
    }//GEN-LAST:event_BtnBersihActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
//        int baris = 0;
//        Object kolom[] = {"No", "Kode Kategori", "Nama Kategori Barang"};
//        TblKategori = new DefaultTableModel(kolom, baris);
//        
//        kondisiAwal();
//        kodeKategoriOtomatis();
//        tampiDataKategori();
    }//GEN-LAST:event_formComponentShown

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        String kodeKategoriBuku = TxtKode.getText();
        String namaKategoriBuku = TxtNama.getText();
        if(status == "Tambah") {
            if(kodeKategoriBuku.isEmpty() && namaKategoriBuku.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if (kodeKategoriBuku.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kode Kategori Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if (namaKategoriBuku.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Kategori Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtNama.requestFocus();
            } else {
                KategoriBarang.tambahDataKategori(kodeKategoriBuku, namaKategoriBuku);
                kondisiAwal();
                kodeKategoriOtomatis();
                tampiDataKategori();
                JOptionPane.showMessageDialog(this, "Data Kategori Barang berhasil di tambahkan", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if(status == "Edit") {
            if(kodeKategoriBuku.isEmpty() && namaKategoriBuku.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if (namaKategoriBuku.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Kategori Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtNama.requestFocus();
            } else {
                KategoriBarang.updateDataKategori(kodeKategoriBuku, namaKategoriBuku);
                kondisiAwal();
                kodeKategoriOtomatis();
                tampiDataKategori();
                JOptionPane.showMessageDialog(this, "Data Kategori Barang berhasil di edit", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void TabelKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelKategoriMouseClicked
        // TODO add your handling code here:
        BtnTambah.setEnabled(false);
        BtnEdit.setEnabled(true);
        BtnHapus.setEnabled(true);
        BtnSimpan.setEnabled(false);
        BtnBatal.setEnabled(true);
        BtnBersih.setEnabled(false);
        
        int pilihBaris = TabelKategori.getSelectedRow();
        String kodeKategori = TblKategori.getValueAt(pilihBaris, 1).toString();
        
        String [][] data = KategoriBarang.getKategoriByKodeKategori(kodeKategori);
        String kodeKategoriBarang = data[0][0];
        String namaKategori = data[0][1];
        
        TxtKode.setText(kodeKategoriBarang);
        TxtNama.setText(namaKategori);
    }//GEN-LAST:event_TabelKategoriMouseClicked

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        status = "Edit";
        komponenAktif();
        BtnBersih.setEnabled(false);
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        int pilihBaris = TabelKategori.getSelectedRow();
        String kodeKategori = TblKategori.getValueAt(pilihBaris, 1).toString();
        
        String [][] data = KategoriBarang.getKategoriByKodeKategori(kodeKategori);
        String kodeKategoriBarang = data[0][0];
        String namaKategori = data[0][1];
        
        TxtKode.setText(kodeKategoriBarang);
        TxtNama.setText(namaKategori);
        
        if(kodeKategori.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Kategori Barangg tidak boleh kosong, pilih data kategori terlebih dahulu");
        } else if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data ini?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            KategoriBarang.hapusDataKategori(kodeKategori);
            kondisiAwal();
            kodeKategoriOtomatis();
            tampiDataKategori();
            JOptionPane.showMessageDialog(this, "Data Kategori Barang berhasil di hapus", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void TxtKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKeywordKeyReleased
        // TODO add your handling code here:
        String keyword = TxtKeyword.getText();
        if(keyword != "") {
            cariDataKategori(keyword);
        } else {
            tampiDataKategori();
        }
    }//GEN-LAST:event_TxtKeywordKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataKategori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBatal;
    private javax.swing.JButton BtnBersih;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JTable TabelKategori;
    private javax.swing.JTextField TxtKeyword;
    private javax.swing.JTextField TxtKode;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}