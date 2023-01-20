package view;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.Barang;
import model.KategoriBarang;
import model.Pegawai;
import model.Supplier;

public class DataBarang extends javax.swing.JFrame {
    String status = "";
    DefaultTableModel TblBarang;
    DefaultComboBoxModel mdlKategori = new DefaultComboBoxModel<>();
    DefaultComboBoxModel mdlSatuan = new DefaultComboBoxModel<>();
    DefaultComboBoxModel mdlSupplier = new DefaultComboBoxModel<>();
    
    public DataBarang() {
        initComponents();
        int baris = 0;
        Object kolom[] = {"No", "Kode Barang", "Nama Barang", "Kategori Barang", "Satuan", "Stok", "Harga", "Supplier"};
        TblBarang = new DefaultTableModel(kolom, baris);
        
        kondisiAwal();
        kodeBarangOtomatis();
        tampilListKategori();
        tampilListSatuan();
        tampilListSupplier();
        tampilDataBarang();
    }
    
    public void kondisiAwal() {
        TxtKode.setEnabled(false);
        TxtNama.setEnabled(false);
        TxtStok.setEnabled(false);
        TxtHarga.setEnabled(false);
        ComboKategori.setEnabled(false);
        ComboSatuan.setEnabled(false);
        ComboSupplier.setEnabled(false);
        ComboKategori.setSelectedIndex(0);
        ComboSatuan.setSelectedIndex(0);
        ComboSupplier.setSelectedIndex(0);
        
        BtnTambah.setEnabled(true);
        BtnEdit.setEnabled(false);
        BtnHapus.setEnabled(false);
        BtnSimpan.setEnabled(false);
        BtnBatal.setEnabled(false);
        BtnBersih.setEnabled(false);
        BtnTambah.requestFocus();
        
        TxtNama.setText("");
        ComboKategori.setSelectedIndex(0);
        ComboSatuan.setSelectedIndex(0);
        TxtStok.setText("");
        TxtHarga.setText("");
        ComboSupplier.setSelectedIndex(0);
    }
    
    public void aktifkanKomponen() {
        TxtKode.setEnabled(false);
        TxtNama.setEnabled(true);
        TxtStok.setEnabled(true);
        TxtHarga.setEnabled(true);
        ComboKategori.setEnabled(true);
        ComboSatuan.setEnabled(true);
        ComboSupplier.setEnabled(true);
        
        BtnTambah.setEnabled(false);
        BtnEdit.setEnabled(false);
        BtnHapus.setEnabled(false);
        BtnSimpan.setEnabled(true);
        BtnBatal.setEnabled(true);
        BtnBersih.setEnabled(true);
        TxtNama.requestFocus();
    }
    
    public void kodeBarangOtomatis() {
        String kodeBarang = Barang.kodeBarangOtomatis();
        TxtKode.setText(kodeBarang);
    }
    
    public void tampilListKategori() {
        mdlKategori.removeAllElements();
        String [] listKategori = KategoriBarang.getListKategori();
        for (int i = 0; i < listKategori.length; i++) {
            mdlKategori.addElement(listKategori[i]);
        }
        ComboKategori.setModel(mdlKategori);
    }
    
    public void tampilListSatuan() {
        mdlSatuan.removeAllElements();
        mdlSatuan.addElement("PCS");
        mdlSatuan.addElement("PAK");
        mdlSatuan.addElement("DUS");
        ComboSatuan.setModel(mdlSatuan);
    }
    
    public void tampilListSupplier() {
        mdlSupplier.removeAllElements();
        String [] listSupplier = Supplier.getListSupplier();
        for (int i = 0; i < listSupplier.length; i++) {
            mdlSupplier.addElement(listSupplier[i]);
        }
        ComboSupplier.setModel(mdlSupplier);
    }
    
    public void tampilDataBarang() {
        TblBarang.getDataVector().removeAllElements();
        
        String [][] data = Barang.getBarang();
        for (int i = 0; i < data.length; i++) {
            int no = i + 1;
            TblBarang.addRow(new Object[]{no, data[i][0], data[i][1], data[i][2], data[i][3], data[i][4], data[i][5], data[i][6]});
        }
        TabelBarang.setModel(TblBarang);
        
        // Lebar Kolom Tabel
        TabelBarang.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelBarang.getColumnModel().getColumn(1).setPreferredWidth(70);
        TabelBarang.getColumnModel().getColumn(2).setPreferredWidth(220);
        TabelBarang.getColumnModel().getColumn(3).setPreferredWidth(90);
        TabelBarang.getColumnModel().getColumn(4).setPreferredWidth(50);
        TabelBarang.getColumnModel().getColumn(5).setPreferredWidth(50);
        TabelBarang.getColumnModel().getColumn(6).setPreferredWidth(50);
        TabelBarang.getColumnModel().getColumn(7).setPreferredWidth(120);
        
        // Aligment
//        DefaultTableCellRenderer aligmentCenter = new DefaultTableCellRenderer();
//        aligmentCenter.setHorizontalAlignment(SwingConstants.CENTER);
//        
          DefaultTableCellRenderer aligmentRight = new DefaultTableCellRenderer();
          aligmentRight.setHorizontalAlignment(SwingConstants.RIGHT);
//        
//        TabelBarang.getColumnModel().getColumn(0).setCellRenderer(aligmentCenter);
//        TabelBarang.getColumnModel().getColumn(4).setCellRenderer(aligmentCenter);
//        TabelBarang.getColumnModel().getColumn(5).setCellRenderer(aligmentCenter);
          TabelBarang.getColumnModel().getColumn(6).setCellRenderer(aligmentRight);
    }
    
    public void cariDataBarang(String keyword) {
        TblBarang.getDataVector().removeAllElements();
        
        String [][] data = Barang.cariDataBarang(keyword);
        for (int i = 0; i < data.length; i++) {
            int no = i + 1;
            TblBarang.addRow(new Object[]{no, data[i][0], data[i][1], data[i][2], data[i][3], data[i][4], data[i][5], data[i][6]});
        }
        TabelBarang.setModel(TblBarang);
        
        // Lebar Kolom Tabel
        TabelBarang.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelBarang.getColumnModel().getColumn(1).setPreferredWidth(70);
        TabelBarang.getColumnModel().getColumn(2).setPreferredWidth(220);
        TabelBarang.getColumnModel().getColumn(3).setPreferredWidth(90);
        TabelBarang.getColumnModel().getColumn(4).setPreferredWidth(50);
        TabelBarang.getColumnModel().getColumn(5).setPreferredWidth(50);
        TabelBarang.getColumnModel().getColumn(6).setPreferredWidth(50);
        TabelBarang.getColumnModel().getColumn(7).setPreferredWidth(120);
        
        // Aligment
//        DefaultTableCellRenderer aligmentCenter = new DefaultTableCellRenderer();
//        aligmentCenter.setHorizontalAlignment(SwingConstants.CENTER);
//        
          DefaultTableCellRenderer aligmentRight = new DefaultTableCellRenderer();
          aligmentRight.setHorizontalAlignment(SwingConstants.RIGHT);
//        
//        TabelBarang.getColumnModel().getColumn(0).setCellRenderer(aligmentCenter);
//        TabelBarang.getColumnModel().getColumn(4).setCellRenderer(aligmentCenter);
//        TabelBarang.getColumnModel().getColumn(5).setCellRenderer(aligmentCenter);
          TabelBarang.getColumnModel().getColumn(6).setCellRenderer(aligmentRight);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TxtKode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtNama = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ComboKategori = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        ComboSatuan = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        TxtStok = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TxtHarga = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        ComboSupplier = new javax.swing.JComboBox<>();
        BtnTambah = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        TxtKeyword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelBarang = new javax.swing.JTable();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnBersih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Barang");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 158, 188));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        jLabel9.setText("Kode Barang");

        jLabel10.setText("Nama Barang");

        TxtNama.setNextFocusableComponent(ComboKategori);

        jLabel11.setText("Kategori Barang");

        ComboKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboKategori.setNextFocusableComponent(ComboSatuan);

        jLabel12.setText("Satuan Barang");

        ComboSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboSatuan.setNextFocusableComponent(TxtStok);

        jLabel13.setText("Stok Barang");

        TxtStok.setNextFocusableComponent(TxtHarga);

        jLabel14.setText("Harga Barang");

        TxtHarga.setNextFocusableComponent(ComboSupplier);

        jLabel15.setText("Supplier");

        ComboSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel16.setText("Cari Data");

        TxtKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtKeywordKeyReleased(evt);
            }
        });

        TabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelBarang);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(21, 21, 21))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(38, 38, 38)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TxtKode)
                            .addComponent(TxtNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboKategori, javax.swing.GroupLayout.Alignment.LEADING, 0, 260, Short.MAX_VALUE)
                            .addComponent(ComboSatuan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtHarga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboSupplier, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtStok, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtKeyword))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(TxtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(ComboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(ComboSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(TxtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(ComboSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnTambah)
                            .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        status = "Tambah";
        aktifkanKomponen();
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        String kodeBarang = TxtKode.getText();
        String namaBarang = TxtNama.getText();
        
        String KodeKategori = ComboKategori.getSelectedItem().toString();
        String [] pisahKategori = KodeKategori.split(" - ");
        String kodeKategori = pisahKategori[0];
        
        String satuan = ComboSatuan.getSelectedItem().toString();
        String stok = TxtStok.getText();
        String harga = TxtHarga.getText();
        
        String KodeSupplier = ComboSupplier.getSelectedItem().toString();
        String [] pisahSupplier = KodeSupplier.split(" - ");
        String kodeSupplier = pisahSupplier[0];
        
        if(status == "Tambah") {
            if(kodeBarang.isEmpty() && namaBarang.isEmpty() && kodeKategori.isEmpty() && stok.isEmpty() && harga.isEmpty() 
                    && kodeSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(kodeBarang.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kode Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(namaBarang.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtNama.requestFocus();
            } else if(stok.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Stok Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtStok.requestFocus();
            } else if(!(new Scanner(stok).hasNextInt())) {
                JOptionPane.showMessageDialog(null, "Stok Barang harus angka!");
                TxtStok.requestFocus();
            } else if(harga.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Harga Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtHarga.requestFocus();
            } else if(!(new Scanner(harga).hasNextInt())) {
                JOptionPane.showMessageDialog(null, "Harga Barang harus angka!");
                TxtHarga.requestFocus();
            } else {
                int stokBarang = Integer.parseInt(stok);
                int hargaBarang = Integer.parseInt(harga);
                
                Barang.tambahDataBarang(kodeBarang, kodeKategori, namaBarang, satuan, stokBarang, hargaBarang, kodeSupplier);
                kondisiAwal();
                kodeBarangOtomatis();
                tampilListKategori();
                tampilListSatuan();
                tampilListSupplier();
                tampilDataBarang();
                JOptionPane.showMessageDialog(this, "Data Barang berhasil di tambahkan", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if(status == "Edit") {
            if(kodeBarang.isEmpty() && namaBarang.isEmpty() && kodeKategori.isEmpty() && stok.isEmpty() && harga.isEmpty() 
                    && kodeSupplier.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(kodeBarang.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kode Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(namaBarang.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtNama.requestFocus();
            } else if(stok.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Stok Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtStok.requestFocus();
            } else if(!(new Scanner(stok).hasNextInt())) {
                JOptionPane.showMessageDialog(null, "Stok Barang harus angka!");
                TxtStok.requestFocus();
            } else if(harga.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Harga Barang harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtHarga.requestFocus();
            } else if(!(new Scanner(harga).hasNextInt())) {
                JOptionPane.showMessageDialog(null, "Harga Barang harus angka!");
                TxtHarga.requestFocus();
            } else {
                int stokBarang = Integer.parseInt(stok);
                int hargaBarang = Integer.parseInt(harga);
                
                Barang.updateDataBarang(kodeBarang, kodeKategori, namaBarang, satuan, stokBarang, hargaBarang, kodeSupplier);
                kondisiAwal();
                kodeBarangOtomatis();
                tampilListKategori();
                tampilListSatuan();
                tampilListSupplier();
                tampilDataBarang();
                JOptionPane.showMessageDialog(this, "Data Barang berhasil di edit", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        status = "Edit";
        aktifkanKomponen();
        BtnBersih.setEnabled(false);
    }//GEN-LAST:event_BtnEditActionPerformed

    private void TabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelBarangMouseClicked
        // TODO add your handling code here:
        BtnTambah.setEnabled(false);
        BtnEdit.setEnabled(true);
        BtnHapus.setEnabled(true);
        BtnSimpan.setEnabled(false);
        BtnBatal.setEnabled(true);
        BtnBersih.setEnabled(false);
        
        int pilihBaris = TabelBarang.getSelectedRow();
        String KodeBarang = TblBarang.getValueAt(pilihBaris, 1).toString();
        
        String [][] data = Barang.getBarangByKode(KodeBarang);
        String kodeBarang = data[0][0];
        String namaBarang = data[0][1];
        String kodeKategori = data[0][2];
        String namaKategori = data[0][3];
        String satuan = data[0][4];
        String stokBarang = data[0][5];
        String hargaBarang = data[0][6];
        String kodeSupplier = data[0][7];
        String namaSupplier = data[0][8];
        
        TxtKode.setText(kodeBarang);
        TxtNama.setText(namaBarang);
        ComboKategori.setSelectedItem(kodeKategori + " - " + namaKategori);
        ComboSatuan.setSelectedItem(satuan);
        TxtStok.setText(stokBarang);
        TxtHarga.setText(hargaBarang);
        ComboSupplier.setSelectedItem(kodeSupplier + " - " + namaSupplier);
    }//GEN-LAST:event_TabelBarangMouseClicked

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        int pilihBaris = TabelBarang.getSelectedRow();
        String KodeBarang = TblBarang.getValueAt(pilihBaris, 1).toString();
        
        String [][] data = Barang.getBarangByKode(KodeBarang);
        String kodeBarang = data[0][0];
        String namaBarang = data[0][1];
        String kodeKategori = data[0][2];
        String namaKategori = data[0][3];
        String satuan = data[0][4];
        String stokBarang = data[0][5];
        String hargaBarang = data[0][6];
        String kodeSupplier = data[0][7];
        String namaSupplier = data[0][8];
        
        TxtKode.setText(kodeBarang);
        TxtNama.setText(namaBarang);
        ComboKategori.setSelectedItem(kodeKategori + " - " + namaKategori);
        ComboSatuan.setSelectedItem(satuan);
        TxtStok.setText(stokBarang);
        TxtHarga.setText(hargaBarang);
        ComboSupplier.setSelectedItem(kodeSupplier + " - " + namaSupplier);
        
        if(kodeBarang.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Barang tidak boleh kosong, pilih data barang terlebih dahulu");
        } else if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data ini?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            Barang.hapusDataBarang(kodeBarang);
            kondisiAwal();
            kodeBarangOtomatis();
            tampilListKategori();
            tampilListSatuan();
            tampilListSupplier();
            tampilDataBarang();
            JOptionPane.showMessageDialog(this, "Data Barang berhasil di hapus", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        // TODO add your handling code here:
        kondisiAwal();
        kodeBarangOtomatis();
        tampilListKategori();
        tampilListSatuan();
        tampilListSupplier();
        tampilDataBarang();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBersihActionPerformed
        // TODO add your handling code here:
        TxtNama.setText("");
        ComboKategori.setSelectedIndex(0);
        ComboSatuan.setSelectedIndex(0);
        TxtStok.setText("");
        TxtHarga.setText("");
        ComboSupplier.setSelectedIndex(0);
        kodeBarangOtomatis();
        TxtNama.requestFocus();
    }//GEN-LAST:event_BtnBersihActionPerformed

    private void TxtKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKeywordKeyReleased
        // TODO add your handling code here:
        String keyword = TxtKeyword.getText();
        
        if(keyword != "") {
            cariDataBarang(keyword);
        } else {
            tampilDataBarang();
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
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBarang().setVisible(true);
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
    private javax.swing.JComboBox<String> ComboKategori;
    private javax.swing.JComboBox<String> ComboSatuan;
    private javax.swing.JComboBox<String> ComboSupplier;
    private javax.swing.JTable TabelBarang;
    private javax.swing.JTextField TxtHarga;
    private javax.swing.JTextField TxtKeyword;
    private javax.swing.JTextField TxtKode;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JTextField TxtStok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
