package view;

import java.sql.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import model.Koneksi;
import model.PenjualanBarang;
import model.UserLogin;

public class Penjualan extends javax.swing.JFrame {
    DefaultTableModel TblPenjualan;
    DefaultComboBoxModel mdlBarang = new DefaultComboBoxModel<>();
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    
    public Penjualan() {
        initComponents();
        int baris = 0;
        Object kolom[] = {"No", "Kode Barang", "Nama Barang", "Harga", "Jumlah", "Sub Total"};
        TblPenjualan = new DefaultTableModel(kolom, baris);
        TabelPenjualan.setModel(TblPenjualan);
        
        TabelPenjualan.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelPenjualan.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelPenjualan.getColumnModel().getColumn(2).setPreferredWidth(220);
        TabelPenjualan.getColumnModel().getColumn(3).setPreferredWidth(80);
        TabelPenjualan.getColumnModel().getColumn(4).setPreferredWidth(60);
        TabelPenjualan.getColumnModel().getColumn(5).setPreferredWidth(80);
        
        kondisiAwal();
        tampilKodeTransaksiOtomatis();
        tampilTanggal();
        tampilListBarang();
        kosongkanTabel();
    }
    
    public void kondisiAwal() {
        TxtKode.setEnabled(false);
        DTanggal.setEnabled(false);
        TxtStatus.setEnabled(false);
        TxtTotalHarga.setEditable(false);
        TxtStatus.setEditable(false);
        TxtNamaBarang.setEnabled(false);
        TxtHarga.setEnabled(false);
        TxtSubTotal.setEnabled(false);
        TxtTotalJumlah.setEnabled(false);
        TxtKurang.setEnabled(false);
        TxtKembali.setEnabled(false);
        BtnTambah.setEnabled(false);
        
        TxtNamaBarang.setText("");
        TxtHarga.setText("");
        TxtJumlah.setText("");
        TxtSubTotal.setText("");
        
        TxtStatus.setText("");
        TxtKurang.setText("0");
        TxtBayar.setText("");
        TxtKembali.setText("0");
        TxtTotalJumlah.setText("0");
        TxtTotalHarga.setText("Rp. 0.00");
        ComboKode.requestFocus();
    }
    
    public void bersihBarang() {
        TxtNamaBarang.setText("");
        TxtHarga.setText("");
        TxtJumlah.setText("");
        TxtSubTotal.setText("");
        ComboKode.requestFocus();
    }
    
    public void tampilKodeTransaksiOtomatis() {
        String kodeTransaksi = PenjualanBarang.kodeTransaksiPenjualanOtomatis();
        TxtKode.setText(kodeTransaksi);
    }
    
    public void tampilTanggal() {
        Date tgl = new Date();
        DTanggal.setDate(tgl);
    }
    
    public void tampilListBarang() {
        mdlBarang.removeAllElements();
        
        String [] listBarang = PenjualanBarang.getListBarang();
        for (int i = 0; i < listBarang.length; i++) {
            mdlBarang.addElement(listBarang[i]);
        }
        ComboKode.setModel(mdlBarang);
    }
    
    public void insertDataKeTabel() {
        String KodeBarang = ComboKode.getSelectedItem().toString();
        String [] pisahBarang = KodeBarang.split(" - ");
        String kodeBarang = pisahBarang[0];
        
        DefaultTableModel model = (DefaultTableModel) TabelPenjualan.getModel();
        Object obj[] = new Object[6];
        obj[1] = kodeBarang;
        obj[2] = TxtNamaBarang.getText();
        obj[3] = TxtHarga.getText();
        obj[4] = TxtJumlah.getText();
        obj[5] = TxtSubTotal.getText();
        
        model.addRow(obj);
        
        int baris = model.getRowCount();
        for(int a = 0; a < baris; a++) {
            String no = String.valueOf(a + 1);
            model.setValueAt(no, a, 0);
        } 
    }
    
    public void kosongkanTabel() {
        DefaultTableModel model = (DefaultTableModel) TabelPenjualan.getModel();
        
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
    
    public void totalHarga() {
        int jumlahBaris = TabelPenjualan.getRowCount();
        int totalHarga = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            hargaBarang = Integer.parseInt(TabelPenjualan.getValueAt(i, 3).toString());
            jumlahBarang = Integer.parseInt(TabelPenjualan.getValueAt(i, 4).toString());
            
            totalHarga = totalHarga + (hargaBarang * jumlahBarang);
        }
        TxtTotalHarga.setText("Rp. " + nf.format(totalHarga) + ".00");
    }
    
    public void totalBarang() {
        int jumlahBaris = TabelPenjualan.getRowCount();
        int totalBarang = 0;
        int jumlahBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(TabelPenjualan.getValueAt(i, 4).toString());
                
            totalBarang += jumlahBarang;
        }
        TxtTotalJumlah.setText(String.valueOf(totalBarang));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DTanggal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        TxtStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPenjualan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        TxtTotalHarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnKembali = new javax.swing.JButton();
        ComboKode = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TxtNamaBarang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtHarga = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtJumlah = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtSubTotal = new javax.swing.JTextField();
        BtnTambah = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        TxtTotalJumlah = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TxtBayar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TxtKembali = new javax.swing.JTextField();
        TxtKode = new javax.swing.JTextField();
        BtnBatalkan = new javax.swing.JButton();
        TxtKurang = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transaksi Penjualan Barang");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 158, 188));
        jPanel1.setPreferredSize(new java.awt.Dimension(295, 75));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaksi Penjualan Barang");

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

        jLabel2.setText("Kode Transaksi");

        jLabel3.setText("Tanggal");
        jLabel3.setPreferredSize(new java.awt.Dimension(42, 18));

        DTanggal.setDateFormatString("dd MMMM yyyy");

        jLabel4.setText("Status Jual");

        TabelPenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TabelPenjualan);

        TxtTotalHarga.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TxtTotalHarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtTotalHarga.setText("Rp. 0");
        TxtTotalHarga.setPreferredSize(new java.awt.Dimension(290, 90));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(TxtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TxtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel9.setText("Kode Barang");

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

        BtnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/kembali.png"))); // NOI18N
        BtnKembali.setText("Kembali");
        BtnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKembaliActionPerformed(evt);
            }
        });

        ComboKode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboKodeActionPerformed(evt);
            }
        });

        jLabel10.setText("Nama Barang");

        jLabel11.setText("Harga");

        jLabel12.setText("Jumlah");

        TxtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtJumlahActionPerformed(evt);
            }
        });

        jLabel13.setText("Sub Total");

        BtnTambah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnTambah.setText("+");
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        jLabel14.setText("Jumlah Barang");

        jLabel15.setText("Bayar");

        TxtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBayarActionPerformed(evt);
            }
        });

        jLabel16.setText("Kembali");

        BtnBatalkan.setText("Batalkan (Hapus Barang)");
        BtnBatalkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalkanActionPerformed(evt);
            }
        });

        jLabel17.setText("Kurang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtKode)
                            .addComponent(DTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(TxtStatus)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtTotalJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtKurang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtBayar)
                            .addComponent(TxtKembali)))
                    .addComponent(BtnBatalkan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnKembali))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(TxtJumlah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboKode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtNamaBarang)
                            .addComponent(TxtHarga))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DTanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(ComboKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TxtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(TxtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(TxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(BtnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(BtnBatalkan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnBatal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(TxtKurang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtTotalJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(BtnKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnSimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboKodeActionPerformed
        // TODO add your handling code here:
        try {
            TxtNamaBarang.setText("");
            TxtHarga.setText("");
        
            String KodeBarang = ComboKode.getSelectedItem().toString();
            String [] pisahBarang = KodeBarang.split(" - ");
            String kodeBarang = pisahBarang[0];
        
            String [][] data = PenjualanBarang.getBarangByKode(kodeBarang);
            String namaBarang = data[0][1];
            String hargaBarang = data[0][2];
        
            TxtNamaBarang.setText(namaBarang);
            TxtHarga.setText(hargaBarang);
            TxtJumlah.requestFocus();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboKodeActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        insertDataKeTabel();
        bersihBarang();
        tampilListBarang();
        totalHarga();
        totalBarang();
        TxtNamaBarang.setText("");
        TxtHarga.setText("");
        ComboKode.requestFocus();
        BtnTambah.setEnabled(false);
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void TxtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtJumlahActionPerformed
        // TODO add your handling code here:
        int hargaBarang, jumlahBarang, subTotal;
        
        hargaBarang = Integer.valueOf(TxtHarga.getText());
        jumlahBarang = Integer.valueOf(TxtJumlah.getText());
        subTotal = hargaBarang * jumlahBarang;
        
        TxtSubTotal.setText(String.valueOf(subTotal));
        if(TxtSubTotal.getText() != "") {
            BtnTambah.setEnabled(true);
            BtnTambah.requestFocus();
        }
    }//GEN-LAST:event_TxtJumlahActionPerformed

    private void BtnBatalkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalkanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TabelPenjualan.getModel();
        int row = TabelPenjualan.getSelectedRow();
        model.removeRow(row);
        totalHarga();
        totalBarang();
    }//GEN-LAST:event_BtnBatalkanActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        // TODO add your handling code here:
        kondisiAwal();
        tampilKodeTransaksiOtomatis();
        tampilTanggal();
        tampilListBarang();
        kosongkanTabel();
        TxtNamaBarang.setText("");
        TxtHarga.setText("");
        ComboKode.requestFocus();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void TxtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBayarActionPerformed
        // TODO add your handling code here:
        int jumlahBaris = TabelPenjualan.getRowCount();
        int totalHarga = 0, totalBayar = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            hargaBarang = Integer.parseInt(TabelPenjualan.getValueAt(i, 3).toString());
            jumlahBarang = Integer.parseInt(TabelPenjualan.getValueAt(i, 4).toString());
            
            totalHarga = totalHarga + (hargaBarang * jumlahBarang);
        }
        totalBayar = Integer.valueOf(TxtBayar.getText());
        
        int kurang = 0, kembali = 0;
        
        if(totalBayar < totalHarga) {
            kembali = 0;
            kurang = totalHarga - totalBayar;
            TxtStatus.setText("Belum Lunas");
            TxtKurang.setText(String.valueOf(kurang));
            TxtKembali.setText(String.valueOf(kembali));
            JOptionPane.showMessageDialog(this, "Uang tidak cukup untuk melakukan pembayaran, kurang Rp. " + nf.format(kurang) + ".00", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            TxtBayar.setText("");
            TxtBayar.requestFocus();
        } else if (totalBayar == totalHarga) {
            kembali = 0;
            kurang = 0;
            TxtStatus.setText("Lunas");
            TxtKurang.setText(String.valueOf(kurang));
            TxtKembali.setText(String.valueOf(kembali));
            BtnSimpan.requestFocus();
        } else if (totalBayar > totalHarga) {
            kembali = totalBayar - totalHarga;
            kurang = 0;
            TxtStatus.setText("Lunas");
            TxtKurang.setText(String.valueOf(kurang));
            TxtKembali.setText(String.valueOf(kembali));
            BtnSimpan.requestFocus();
        }
    }//GEN-LAST:event_TxtBayarActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        String kodeTransaksi = TxtKode.getText();
        
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(DTanggal.getDate()));
        
        String statusJual = TxtStatus.getText();
        String jumlahBrg = TxtTotalJumlah.getText();
        String totalHrg = TxtTotalHarga.getText();
        String bayar = TxtBayar.getText();
        String kembali = TxtKembali.getText();
        String kodePegawai = UserLogin.getKodePegawai();
        
        if(kodeTransaksi.isEmpty() && tanggal.isEmpty() && statusJual.isEmpty() && jumlahBrg.equalsIgnoreCase("0") && totalHrg.equalsIgnoreCase("Rp. 0.00") 
                && bayar.equalsIgnoreCase("0") && kembali.equalsIgnoreCase("0") && statusJual.equalsIgnoreCase("Belum Lunas")) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong, lakukan transaksi penjualan barang terlebih dahulu", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
        } else if(kodeTransaksi.isEmpty() || tanggal.isEmpty() || statusJual.isEmpty() || jumlahBrg.equalsIgnoreCase("0") || totalHrg.equalsIgnoreCase("Rp. 0.00") 
                || bayar.equalsIgnoreCase("0") || kembali.equalsIgnoreCase("0") || statusJual.equalsIgnoreCase("Belum Lunas")) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong, lakukan transaksi penjualan barang terlebih dahulu", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
        } else if (bayar.isEmpty() || bayar.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Masukkan Uang Bayar terlebih dahulu", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            TxtBayar.requestFocus();
        } else {
            int jumlahBarang = Integer.parseInt(jumlahBrg);
            
            int jumlahBaris = TabelPenjualan.getRowCount();
            int totalHarga = 0;
            int jumlahBarang2, hargaBarang2;
            for (int i = 0; i < jumlahBaris; i++) {
                hargaBarang2 = Integer.parseInt(TabelPenjualan.getValueAt(i, 3).toString());
                jumlahBarang2 = Integer.parseInt(TabelPenjualan.getValueAt(i, 4).toString());
            
                totalHarga = totalHarga + (hargaBarang2 * jumlahBarang2);
            }
            
            int bayarBarang = Integer.parseInt(bayar);
            int kembalian = Integer.parseInt(kembali);
            
            PenjualanBarang.simpanDataTransaksiPenjualan(kodeTransaksi, tanggal, jumlahBarang, totalHarga, bayarBarang, kembalian, statusJual, kodePegawai);
            
            int baris = TabelPenjualan.getRowCount();
            
            for (int i = 0; i < baris; i++) {
                String kodeBarang = TabelPenjualan.getValueAt(i, 1).toString();
                int hargaBarangDetail = Integer.parseInt(TabelPenjualan.getValueAt(i, 3).toString());
                int jumlahBarangDetail = Integer.parseInt(TabelPenjualan.getValueAt(i, 4).toString());
                int totalHargaDetail = Integer.parseInt(TabelPenjualan.getValueAt(i, 5).toString());
                
                PenjualanBarang.simpanDataDetailTransaksiPenjualan(kodeTransaksi, kodeBarang, hargaBarangDetail, jumlahBarangDetail, totalHargaDetail);
            }
            
            kondisiAwal();
            tampilKodeTransaksiOtomatis();
            tampilTanggal();
            tampilListBarang();
            kosongkanTabel();
            ComboKode.requestFocus();
            TxtNamaBarang.setText("");
            TxtHarga.setText("");
            JOptionPane.showMessageDialog(this, "Transaksi Penjualan Barang berhasil disimpan", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKembaliActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtnKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBatal;
    private javax.swing.JButton BtnBatalkan;
    private javax.swing.JButton BtnKembali;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JComboBox<String> ComboKode;
    private com.toedter.calendar.JDateChooser DTanggal;
    private javax.swing.JTable TabelPenjualan;
    private javax.swing.JTextField TxtBayar;
    private javax.swing.JTextField TxtHarga;
    private javax.swing.JTextField TxtJumlah;
    private javax.swing.JTextField TxtKembali;
    private javax.swing.JTextField TxtKode;
    private javax.swing.JTextField TxtKurang;
    private javax.swing.JTextField TxtNamaBarang;
    private javax.swing.JTextField TxtStatus;
    private javax.swing.JTextField TxtSubTotal;
    private javax.swing.JTextField TxtTotalHarga;
    private javax.swing.JTextField TxtTotalJumlah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
