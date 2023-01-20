package view;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Supplier;

public class DataSupplier extends javax.swing.JFrame {

    String status = "";
    DefaultTableModel TblSupplier;
    
    public DataSupplier() {
        initComponents();
        int baris = 0;
        Object kolom[] = {"No", "Kode Supplier", "Nama Supplier", "Alamat", "No Telepon"};
        TblSupplier = new DefaultTableModel(kolom, baris);
        
        kondisiAwal();
        kodeSupplierOtomatis();
        tampilDataSupplier();
    }

    public void kondisiAwal() {
        TxtKode.setEnabled(false);
        TxtNama.setEnabled(false);
        TxtAlamat.setEnabled(false);
        TxtTelepon.setEnabled(false);
        BtnTambah.setEnabled(true);
        BtnEdit.setEnabled(false);
        BtnHapus.setEnabled(false);
        BtnSimpan.setEnabled(false);
        BtnBatal.setEnabled(false);
        BtnBersih.setEnabled(false);
        
        TxtNama.setText("");
        TxtAlamat.setText("");
        TxtTelepon.setText("");
        TxtKeyword.setText("");
        BtnTambah.requestFocus();
    }
    
    public void aktifkanKomponen() {
        TxtKode.setEnabled(false);
        TxtNama.setEnabled(true);
        TxtAlamat.setEnabled(true);
        TxtTelepon.setEnabled(true);
        BtnTambah.setEnabled(false);
        BtnEdit.setEnabled(false);
        BtnHapus.setEnabled(false);
        BtnSimpan.setEnabled(true);
        BtnBatal.setEnabled(true);
        BtnBersih.setEnabled(true);
        TxtNama.requestFocus();
    }
    
    public void tampilDataSupplier() {
        TblSupplier.getDataVector().removeAllElements();
        
        String [][] data = Supplier.getSupplier();
        for (int i = 0; i < data.length; i++) {
            int no = i + 1;
            TblSupplier.addRow(new Object[]{no, data[i][1], data[i][2], data[i][3], data[i][4]});
        }
        TabelSupplier.setModel(TblSupplier);
        
        // Lebar Kolom Tabel
        TabelSupplier.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelSupplier.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelSupplier.getColumnModel().getColumn(2).setPreferredWidth(100);
        TabelSupplier.getColumnModel().getColumn(3).setPreferredWidth(100);
        TabelSupplier.getColumnModel().getColumn(4).setPreferredWidth(95);
    }
    
    public void cariDataSupplier(String keyword) {
        TblSupplier.getDataVector().removeAllElements();
        
        String [][] data = Supplier.cariDataSupplier(keyword);
        for (int i = 0; i < data.length; i++) {
            int no = i + 1;
            TblSupplier.addRow(new Object[]{no, data[i][0], data[i][1], data[i][2], data[i][3]});
        }
        TabelSupplier.setModel(TblSupplier);
        
        // Lebar Kolom Tabel
        TabelSupplier.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelSupplier.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelSupplier.getColumnModel().getColumn(2).setPreferredWidth(100);
        TabelSupplier.getColumnModel().getColumn(3).setPreferredWidth(100);
        TabelSupplier.getColumnModel().getColumn(4).setPreferredWidth(95);
    }
    
    public void kodeSupplierOtomatis() {
        String kodeSupplier = Supplier.kodeKategoriOtomatis();
        TxtKode.setText(kodeSupplier);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelSupplier = new javax.swing.JTable();
        BtnTambah = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnBersih = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TxtKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtTelepon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtKeyword = new javax.swing.JTextField();
        TxtAlamat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Supplier");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 158, 188));
        jPanel1.setPreferredSize(new java.awt.Dimension(511, 75));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Supplier");

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

        TabelSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelSupplier);

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

        jLabel2.setText("Kode Supplier");

        jLabel3.setText("Nama Supplier");

        jLabel4.setText("Alamat");

        jLabel5.setText("No Telepon");

        jLabel6.setText("Cari Data");

        TxtKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtKeywordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(23, 23, 23)
                        .addComponent(TxtKeyword)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(TxtNama, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtKode, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtAlamat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                            .addComponent(TxtTelepon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(BtnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TxtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnTambah)
                            .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        status = "Tambah";
        aktifkanKomponen();
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        // TODO add your handling code here:
        kondisiAwal();
        kodeSupplierOtomatis();
        tampilDataSupplier();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        String kodeSupplier = TxtKode.getText();
        String namaSupplier = TxtNama.getText();
        String alamatSupplier = TxtAlamat.getText();
        String noSupplier = TxtTelepon.getText();
        
        if(status == "Tambah") {
            if(kodeSupplier.isEmpty() && namaSupplier.isEmpty() && alamatSupplier.isEmpty() && noSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(kodeSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kode Supplier harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(namaSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Supplier harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtNama.requestFocus();
            } else if(alamatSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Alamat Supplier harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtAlamat.requestFocus();
            } else if(noSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No Telepon Supplier harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtTelepon.requestFocus();
            } else {
                Supplier.tambahDataSupplier(kodeSupplier, namaSupplier, alamatSupplier, noSupplier);
                kondisiAwal();
                kodeSupplierOtomatis();
                tampilDataSupplier();
                JOptionPane.showMessageDialog(this, "Data Supplier berhasil di tambahkan", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if(status == "Edit") {
            if(kodeSupplier.isEmpty() && namaSupplier.isEmpty() && alamatSupplier.isEmpty() && noSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(kodeSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kode Supplier harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(namaSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Supplier harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtNama.requestFocus();
            } else if(alamatSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Alamat Supplier harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtAlamat.requestFocus();
            } else if(noSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No Telepon Supplier harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtTelepon.requestFocus();
            } else {
                Supplier.updateDataSupplier(kodeSupplier, namaSupplier, alamatSupplier, noSupplier);
                kondisiAwal();
                kodeSupplierOtomatis();
                tampilDataSupplier();
                JOptionPane.showMessageDialog(this, "Data Supplier berhasil di edit", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void TabelSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelSupplierMouseClicked
        // TODO add your handling code here:
        BtnTambah.setEnabled(false);
        BtnEdit.setEnabled(true);
        BtnHapus.setEnabled(true);
        BtnSimpan.setEnabled(false);
        BtnBatal.setEnabled(true);
        BtnBersih.setEnabled(false);
        
        int pilihBaris = TabelSupplier.getSelectedRow();
        String kodeSupplier = TblSupplier.getValueAt(pilihBaris, 1).toString();
        
        String [][] data = Supplier.getSupplierByKodeSupplier(kodeSupplier);
        TxtKode.setText(data[0][0]);
        TxtNama.setText(data[0][1]);
        TxtAlamat.setText(data[0][2]);
        TxtTelepon.setText(data[0][3]);
    }//GEN-LAST:event_TabelSupplierMouseClicked

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        status = "Edit";
        aktifkanKomponen();
        BtnBersih.setEnabled(false);
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        int pilihBaris = TabelSupplier.getSelectedRow();
        String KodeSupplier = TblSupplier.getValueAt(pilihBaris, 1).toString();
       
        String [][] data = Supplier.getSupplierByKodeSupplier(KodeSupplier);
        String kodeSupplier = data[0][0];
        String namaSupplier = data[0][1];
        String alamatSupplier = data[0][2];
        String noSupplier = data[0][3];
        
        TxtKode.setText(kodeSupplier);
        TxtNama.setText(namaSupplier);
        TxtAlamat.setText(alamatSupplier);
        TxtTelepon.setText(noSupplier);
        
        if(KodeSupplier.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Supplier tidak boleh kosong, pilih data supplier terlebih dahulu");
        } else if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data ini?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            Supplier.hapusDataSupplier(kodeSupplier);
            kondisiAwal();
            kodeSupplierOtomatis();
            tampilDataSupplier();
            JOptionPane.showMessageDialog(this, "Data Supplier berhasil di hapus", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void TxtKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKeywordKeyReleased
        // TODO add your handling code here:
        String keyword = TxtKeyword.getText();
        
        if(keyword != "") {
            cariDataSupplier(keyword);
        } else {
            tampilDataSupplier();
        }
    }//GEN-LAST:event_TxtKeywordKeyReleased

    private void BtnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBersihActionPerformed
        // TODO add your handling code here:
        TxtNama.setText("");
        TxtAlamat.setText("");
        TxtTelepon.setText("");
        kodeSupplierOtomatis();
        TxtNama.requestFocus();
    }//GEN-LAST:event_BtnBersihActionPerformed

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
            java.util.logging.Logger.getLogger(DataSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSupplier().setVisible(true);
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
    private javax.swing.JTable TabelSupplier;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JTextField TxtKeyword;
    private javax.swing.JTextField TxtKode;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JTextField TxtTelepon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
