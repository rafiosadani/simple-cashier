package view;

import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Pegawai;

public class DataPegawai extends javax.swing.JFrame {
    String status = "";
    DefaultTableModel TblPegawai;
    DefaultComboBoxModel mdlRole = new DefaultComboBoxModel<>();
    
    public DataPegawai() {
        initComponents();
        int baris = 0;
        Object kolom[] = {"No", "Kode Pegawai", "Nama Pegawai", "Jenis Kelamin", "Alamat", "No Telepon", "Username", "Password", "Role"};
        TblPegawai = new DefaultTableModel(kolom, baris);
        
        kondisiAwal();
        kodePegawaiOtomatis();
        tampilListRole();
        tampilDataPegawai();
    }

    public void kondisiAwal() {
        TxtKode.setEnabled(false);
        TxtNama.setEnabled(false);
        TxtAlamat.setEnabled(false);
        TxtTelepon.setEnabled(false);
        TxtUsername.setEnabled(false);
        TxtPassword.setEnabled(false);
        RadioLaki.setEnabled(false);
        RadioPerempuan.setEnabled(false);
        ComboRole.setEnabled(false);
        
        
        BtnTambah.setEnabled(true);
        BtnEdit.setEnabled(false);
        BtnHapus.setEnabled(false);
        BtnSimpan.setEnabled(false);
        BtnBatal.setEnabled(false);
        BtnBersih.setEnabled(false);
        
        TxtNama.setText("");
        TxtAlamat.setText("");
        TxtTelepon.setText("");
        TxtUsername.setText("");
        TxtPassword.setText("");
        TxtKeyword.setText("");
        JKGroup.clearSelection();
        ComboRole.setSelectedIndex(0);
        BtnTambah.requestFocus();
    }
    
    public void aktifkanKomponen() {
        TxtKode.setEnabled(false);
        TxtNama.setEnabled(true);
        TxtAlamat.setEnabled(true);
        TxtTelepon.setEnabled(true);
        TxtUsername.setEnabled(true);
        TxtPassword.setEnabled(true);
        RadioLaki.setEnabled(true);
        RadioPerempuan.setEnabled(true);
        ComboRole.setEnabled(true);
        
        BtnTambah.setEnabled(false);
        BtnEdit.setEnabled(false);
        BtnHapus.setEnabled(false);
        BtnSimpan.setEnabled(true);
        BtnBatal.setEnabled(true);
        BtnBersih.setEnabled(true);
        TxtNama.requestFocus();
    }
    
    public void kodePegawaiOtomatis() {
        String kodePegawai = Pegawai.kodeKategoriOtomatis();
        TxtKode.setText(kodePegawai);
    }
    
    public void tampilListRole() {
        mdlRole.removeAllElements();
        String [] listRole = Pegawai.getListRole();
        for (int i = 0; i < listRole.length; i++) {
            mdlRole.addElement(listRole[i]);
        }
        ComboRole.setModel(mdlRole);
    }
    
    public void tampilDataPegawai() {
        TblPegawai.getDataVector().removeAllElements();
        
        String [][] data = Pegawai.getDataPegawai();
        for (int i = 0; i < data.length; i++) {
            int no = i + 1;
            TblPegawai.addRow(new Object[]{no, data[i][1], data[i][2], data[i][3], data[i][4], data[i][5], data[i][6], data[i][7], data[i][9]});
        }
        TabelPegawai.setModel(TblPegawai);
        
        // Lebar Kolom Tabel
        TabelPegawai.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelPegawai.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelPegawai.getColumnModel().getColumn(2).setPreferredWidth(160);
        TabelPegawai.getColumnModel().getColumn(3).setPreferredWidth(80);
        TabelPegawai.getColumnModel().getColumn(4).setPreferredWidth(200);
        TabelPegawai.getColumnModel().getColumn(5).setPreferredWidth(90);
        TabelPegawai.getColumnModel().getColumn(6).setPreferredWidth(100);
        TabelPegawai.getColumnModel().getColumn(7).setPreferredWidth(100);
        TabelPegawai.getColumnModel().getColumn(8).setPreferredWidth(100);
    }
    
    public void cariDataPegawai(String keyword) {
        TblPegawai.getDataVector().removeAllElements();
        
        String [][] data = Pegawai.cariDataPegawai(keyword);
        for (int i = 0; i < data.length; i++) {
            int no = i + 1;
            TblPegawai.addRow(new Object[]{no, data[i][1], data[i][2], data[i][3], data[i][4], data[i][5], data[i][6], data[i][7], data[i][9]});
        }
        TabelPegawai.setModel(TblPegawai);
        
        // Lebar Kolom Tabel
        TabelPegawai.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelPegawai.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelPegawai.getColumnModel().getColumn(2).setPreferredWidth(160);
        TabelPegawai.getColumnModel().getColumn(3).setPreferredWidth(80);
        TabelPegawai.getColumnModel().getColumn(4).setPreferredWidth(200);
        TabelPegawai.getColumnModel().getColumn(5).setPreferredWidth(90);
        TabelPegawai.getColumnModel().getColumn(6).setPreferredWidth(100);
        TabelPegawai.getColumnModel().getColumn(7).setPreferredWidth(100);
        TabelPegawai.getColumnModel().getColumn(8).setPreferredWidth(100);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JKGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtAlamat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtTelepon = new javax.swing.JTextField();
        TxtUsername = new javax.swing.JTextField();
        BtnTambah = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnBersih = new javax.swing.JButton();
        RadioLaki = new javax.swing.JRadioButton();
        RadioPerempuan = new javax.swing.JRadioButton();
        ComboRole = new javax.swing.JComboBox<>();
        TxtPassword = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        TxtKeyword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPegawai = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Data Pegawai");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 158, 188));
        jPanel1.setPreferredSize(new java.awt.Dimension(511, 75));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Pegawai");

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

        jLabel2.setText("Kode Pegawai");

        TxtKode.setNextFocusableComponent(TxtNama);

        jLabel3.setText("Nama Pegawai");

        TxtNama.setNextFocusableComponent(RadioLaki);

        jLabel4.setText("Jenis Kelamin");

        jLabel5.setText("Alamat");

        TxtAlamat.setNextFocusableComponent(TxtTelepon);

        jLabel6.setText("No Telepon");

        jLabel7.setText("Username");

        jLabel8.setText("Password");

        TxtTelepon.setNextFocusableComponent(TxtUsername);

        TxtUsername.setNextFocusableComponent(TxtPassword);

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

        JKGroup.add(RadioLaki);
        RadioLaki.setText("Laki-Laki");
        RadioLaki.setNextFocusableComponent(RadioPerempuan);
        RadioLaki.setPreferredSize(new java.awt.Dimension(87, 25));

        JKGroup.add(RadioPerempuan);
        RadioPerempuan.setText("Perempuan");
        RadioPerempuan.setNextFocusableComponent(TxtAlamat);

        ComboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboRole.setNextFocusableComponent(TxtKeyword);

        TxtPassword.setNextFocusableComponent(ComboRole);

        jLabel10.setText("Cari Data");

        TxtKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtKeywordKeyReleased(evt);
            }
        });

        TabelPegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelPegawai.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TabelPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelPegawai);

        jLabel11.setText("Role");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(TxtNama, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtKode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(TxtAlamat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(RadioLaki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(RadioPerempuan)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTelepon, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(ComboRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtPassword))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnTambah)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(BtnBersih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(TxtKeyword))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(RadioLaki, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RadioPerempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(TxtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(TxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ComboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(BtnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtnSimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnBersih, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnBatal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TxtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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
        kodePegawaiOtomatis();
        tampilListRole();
        tampilDataPegawai();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBersihActionPerformed
        // TODO add your handling code here:
        TxtNama.setText("");
        TxtAlamat.setText("");
        TxtTelepon.setText("");
        TxtUsername.setText("");
        TxtPassword.setText("");
        TxtKeyword.setText("");
        JKGroup.clearSelection();
        ComboRole.setSelectedIndex(0);
        kodePegawaiOtomatis();
        TxtNama.requestFocus();
    }//GEN-LAST:event_BtnBersihActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        String kodePegawai = TxtKode.getText();
        String namaPegawai = TxtNama.getText();
        String jenisKelamin = "";
        if(RadioLaki.isSelected()) {
            jenisKelamin = "Laki-Laki";
        } else if (RadioPerempuan.isSelected()) {
            jenisKelamin = "Perempuan";
        } else {
            jenisKelamin = "";
        }
        String alamatPegawai = TxtAlamat.getText();
        String noPegawai = TxtTelepon.getText();
        String username = TxtUsername.getText();
        String password = TxtPassword.getText();
        
        String rolePegawai = ComboRole.getSelectedItem().toString();
        String [] pisahRolePegawai = rolePegawai.split(" - ");
        String idrole = pisahRolePegawai[0];
        int idRole = Integer.parseInt(idrole);
        
        if(status == "Tambah") {
            if(kodePegawai.isEmpty() && namaPegawai.isEmpty() && jenisKelamin.isEmpty() &&  alamatPegawai.isEmpty() && noPegawai.isEmpty() 
                    && username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(kodePegawai.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kode Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(namaPegawai.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtNama.requestFocus();
            } else if(jenisKelamin.equals("")) {
                JOptionPane.showMessageDialog(this, "Jenis Kelamin Pegawai harus di pilih!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                RadioLaki.requestFocus();
            } else if(alamatPegawai.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Alamat Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtAlamat.requestFocus();
            } else if(noPegawai.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No Telpon Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtTelepon.requestFocus();
            } else if(username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtUsername.requestFocus();
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtPassword.requestFocus();
            } else {
                Pegawai.tambahDataPegawai(kodePegawai, namaPegawai, jenisKelamin, alamatPegawai, noPegawai, username, password, idRole);
                kondisiAwal();
                kodePegawaiOtomatis();
                tampilListRole();
                tampilDataPegawai();
                JOptionPane.showMessageDialog(this, "Data Pegawai berhasil di tambahkan", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if(status == "Edit") {
            if(kodePegawai.isEmpty() && namaPegawai.isEmpty() && jenisKelamin.isEmpty() &&  alamatPegawai.isEmpty() && noPegawai.isEmpty() 
                    && username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(kodePegawai.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kode Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            } else if(namaPegawai.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtNama.requestFocus();
            } else if(jenisKelamin.equals("")) {
                JOptionPane.showMessageDialog(this, "Jenis Kelamin Pegawai harus di pilih!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                RadioLaki.requestFocus();
            } else if(alamatPegawai.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Alamat Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtAlamat.requestFocus();
            } else if(noPegawai.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No Telpon Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtTelepon.requestFocus();
            } else if(username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtUsername.requestFocus();
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Password Pegawai harus di isi!", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
                TxtPassword.requestFocus();
            } else {
                Pegawai.updateDataPegawai(kodePegawai, namaPegawai, jenisKelamin, alamatPegawai, noPegawai, username, password, idRole);
                kondisiAwal();
                kodePegawaiOtomatis();
                tampilListRole();
                tampilDataPegawai();
                JOptionPane.showMessageDialog(this, "Data Pegawai berhasil di edit", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void TabelPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPegawaiMouseClicked
        // TODO add your handling code here:
        BtnTambah.setEnabled(false);
        BtnEdit.setEnabled(true);
        BtnHapus.setEnabled(true);
        BtnSimpan.setEnabled(false);
        BtnBatal.setEnabled(true);
        BtnBersih.setEnabled(false);
        
        int pilihBaris = TabelPegawai.getSelectedRow();
        String KodePegawai = TblPegawai.getValueAt(pilihBaris, 1).toString();
        
        String [][] data = Pegawai.getDataPegawaiByKode(KodePegawai);
        String kodePegawai = data[0][1];
        String namaPegawai = data[0][2];
        String jenisKelamin = data[0][3];
        String alamatPegawai = data[0][4];
        String noPegawai = data[0][5];
        String username = data[0][6];
        String password = data[0][7];
        String idRole = data[0][8];
        String namaRole = data[0][9];
        
        TxtKode.setText(kodePegawai);
        TxtNama.setText(namaPegawai);
        if(jenisKelamin.equalsIgnoreCase("Laki-Laki")) {
            RadioLaki.setSelected(true);
        } else {
            RadioPerempuan.setSelected(true);
        }
        TxtAlamat.setText(alamatPegawai);
        TxtTelepon.setText(noPegawai);
        TxtUsername.setText(username);
        TxtPassword.setText(password);
        ComboRole.setSelectedItem(idRole + " - " + namaRole);
    }//GEN-LAST:event_TabelPegawaiMouseClicked

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        status = "Edit";
        aktifkanKomponen();
        BtnBersih.setEnabled(false);
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        int pilihBaris = TabelPegawai.getSelectedRow();
        String kodeSupplier = TblPegawai.getValueAt(pilihBaris, 1).toString();
        
        String [][] data = Pegawai.getDataPegawaiByKode(kodeSupplier);
        String kodePegawai = data[0][1];
        String namaPegawai = data[0][2];
        String jenisKelamin = data[0][3];
        String alamatPegawai = data[0][4];
        String noPegawai = data[0][5];
        String username = data[0][6];
        String password = data[0][7];
        String idRole = data[0][8];
        String namaRole = data[0][9];
        
        TxtKode.setText(kodePegawai);
        TxtNama.setText(namaPegawai);
        if(jenisKelamin.equalsIgnoreCase("Laki-Laki")) {
            RadioLaki.setSelected(true);
        } else {
            RadioPerempuan.setSelected(true);
        }
        TxtAlamat.setText(alamatPegawai);
        TxtTelepon.setText(noPegawai);
        TxtUsername.setText(username);
        TxtPassword.setText(password);
        ComboRole.setSelectedItem(idRole + " - " + namaRole);
        
        if(kodePegawai.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Pegawai tidak boleh kosong, pilih data pegawai terlebih dahulu");
        } else if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan menghapus data ini?", "Konfirmasi",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
            Pegawai.hapusDataPegawai(kodePegawai);
            kondisiAwal();
            kodePegawaiOtomatis();
            tampilDataPegawai();
            JOptionPane.showMessageDialog(this, "Data Pegawai berhasil di hapus", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void TxtKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKeywordKeyReleased
        // TODO add your handling code here:
        String keyword = TxtKeyword.getText();
        
        if(keyword != "") {
            cariDataPegawai(keyword);
        } else {
            tampilDataPegawai();
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
            java.util.logging.Logger.getLogger(DataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPegawai().setVisible(true);
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
    private javax.swing.JComboBox<String> ComboRole;
    private javax.swing.ButtonGroup JKGroup;
    private javax.swing.JRadioButton RadioLaki;
    private javax.swing.JRadioButton RadioPerempuan;
    private javax.swing.JTable TabelPegawai;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JTextField TxtKeyword;
    private javax.swing.JTextField TxtKode;
    private javax.swing.JTextField TxtNama;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtTelepon;
    private javax.swing.JTextField TxtUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
