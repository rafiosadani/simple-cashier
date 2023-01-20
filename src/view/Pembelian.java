package view;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;
import model.PembelianBarang;
import model.Supplier;
import model.UserLogin;

public class Pembelian extends javax.swing.JFrame {

    DefaultTableModel TblPembelian;
    DefaultComboBoxModel mdlSupplier = new DefaultComboBoxModel<>();
    DefaultComboBoxModel mdlBarang = new DefaultComboBoxModel<>();
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    
    public Pembelian() {
        initComponents();
        int baris = 0;
        Object kolom[] = {"No", "Kode Barang", "Nama Barang", "Harga", "Jumlah", "Sub Total"};
        TblPembelian = new DefaultTableModel(kolom, baris);
        TabelPembelian.setModel(TblPembelian);
        
        TabelPembelian.getColumnModel().getColumn(0).setPreferredWidth(15);
        TabelPembelian.getColumnModel().getColumn(1).setPreferredWidth(80);
        TabelPembelian.getColumnModel().getColumn(2).setPreferredWidth(220);
        TabelPembelian.getColumnModel().getColumn(3).setPreferredWidth(80);
        TabelPembelian.getColumnModel().getColumn(4).setPreferredWidth(60);
        TabelPembelian.getColumnModel().getColumn(5).setPreferredWidth(80);
        
        kondisiAwal();
        tampilKodeTransaksiOtomatis();
        tampilTanggal();
        tampilListSupplier();
        tampilListBarang();
    }
    
    public void kondisiAwal() {
        TxtKode.setEnabled(false);
        DTanggal.setEnabled(false);
        TxtStatus.setEnabled(false);
        TxtNamaSupplier.setEnabled(false);
        TxtAlamatSupplier.setEnabled(false);
        TxtTotalHarga.setEditable(false);
        TxtStatus.setEditable(false);
        TxtNamaBarang.setEnabled(false);
        TxtHarga.setEnabled(false);
        TxtSubTotal.setEnabled(false);
        TxtTotalJumlah.setEnabled(false);
        TxtKurang.setEnabled(false);
        TxtKembali.setEnabled(false);
        BtnTambah.setEnabled(false);
        
        TxtNamaSupplier.setText("");
        TxtAlamatSupplier.setText("");
        
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
        ComboSupplier.requestFocus();
    }
    
    public void bersihBarang() {
        TxtNamaBarang.setText("");
        TxtHarga.setText("");
        TxtJumlah.setText("");
        TxtSubTotal.setText("");
        ComboKode.requestFocus();
    }
    
    public void tampilKodeTransaksiOtomatis() {
        String kodeTransaksi = PembelianBarang.kodeTransaksiPembelianOtomatis();
        TxtKode.setText(kodeTransaksi);
    }
    
    public void tampilTanggal() {
        Date tgl = new Date();
        DTanggal.setDate(tgl);
    }
    
    public void tampilListSupplier() {
        mdlSupplier.removeAllElements();
        
        String [] listSupplier = Supplier.getListSupplier();
        for (int i = 0; i < listSupplier.length; i++) {
            mdlSupplier.addElement(listSupplier[i]);
        }
        ComboSupplier.setModel(mdlSupplier);
    }
    
    public void tampilListBarang() {
        mdlBarang.removeAllElements();
        
        String [] listBarang = PembelianBarang.getListBarang();
        for (int i = 0; i < listBarang.length; i++) {
            mdlBarang.addElement(listBarang[i]);
        }
        ComboKode.setModel(mdlBarang);
    }
    
    public void insertDataKeTabel() {
        String KodeBarang = ComboKode.getSelectedItem().toString();
        String [] pisahBarang = KodeBarang.split(" - ");
        String kodeBarang = pisahBarang[0];
        
        DefaultTableModel model = (DefaultTableModel) TabelPembelian.getModel();
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
        DefaultTableModel model = (DefaultTableModel) TabelPembelian.getModel();
        
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
    
    public void totalHarga() {
        int jumlahBaris = TabelPembelian.getRowCount();
        int totalHarga = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            hargaBarang = Integer.parseInt(TabelPembelian.getValueAt(i, 3).toString());
            jumlahBarang = Integer.parseInt(TabelPembelian.getValueAt(i, 4).toString());
            
            totalHarga = totalHarga + (hargaBarang * jumlahBarang);
        }
        TxtTotalHarga.setText("Rp. " + nf.format(totalHarga) + ".00");
    }
    
    public void totalBarang() {
        int jumlahBaris = TabelPembelian.getRowCount();
        int totalBarang = 0;
        int jumlahBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(TabelPembelian.getValueAt(i, 4).toString());
                
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
        TxtKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DTanggal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        TxtStatus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ComboSupplier = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        TxtNamaSupplier = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtAlamatSupplier = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelPembelian = new javax.swing.JTable();
        TxtTotalHarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ComboKode = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TxtNamaBarang = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtHarga = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtJumlah = new javax.swing.JTextField();
        BtnTambah = new javax.swing.JButton();
        TxtSubTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnKembali = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        TxtTotalJumlah = new javax.swing.JTextField();
        BtnBatalkan = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        TxtBayar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TxtKembali = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TxtKurang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transaksi Pembelian Barang");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 158, 188));
        jPanel1.setPreferredSize(new java.awt.Dimension(295, 75));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaksi Pembelian Barang");

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

        jLabel4.setText("Statul Beli");

        jLabel5.setText("Kode Supplier");

        ComboSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboSupplier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboSupplierItemStateChanged(evt);
            }
        });

        jLabel6.setText("Nama Supplier");

        jLabel7.setText("Alamat Supplier");

        TabelPembelian.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TabelPembelian);

        TxtTotalHarga.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        TxtTotalHarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtTotalHarga.setText("Rp. 0");
        TxtTotalHarga.setPreferredSize(new java.awt.Dimension(290, 90));

        jLabel9.setText("Kode Barang");

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

        BtnTambah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnTambah.setText("+");
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        jLabel13.setText("Sub Total");

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

        jLabel14.setText("Jumlah Barang");

        BtnBatalkan.setText("Batalkan (Hapus Barang)");
        BtnBatalkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalkanActionPerformed(evt);
            }
        });

        jLabel15.setText("Bayar");

        TxtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBayarActionPerformed(evt);
            }
        });

        jLabel16.setText("Kembali");

        jLabel17.setText("Kurang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtTotalJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtKurang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtBayar)
                            .addComponent(TxtKembali)))
                    .addComponent(BtnBatalkan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtStatus)
                            .addComponent(TxtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtNamaSupplier)
                            .addComponent(ComboSupplier, 0, 190, Short.MAX_VALUE)
                            .addComponent(TxtAlamatSupplier))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(BtnKembali))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(TxtJumlah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtTotalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboKode, 0, 301, Short.MAX_VALUE)
                            .addComponent(TxtNamaBarang)
                            .addComponent(TxtHarga, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(ComboSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DTanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(TxtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(TxtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(TxtAlamatSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtTotalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnBatalkan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTotalJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtKurang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void ComboKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboKodeActionPerformed
        // TODO add your handling code here:
        try {
            TxtNamaBarang.setText("");
            TxtHarga.setText("");
        
            String KodeBarang = ComboKode.getSelectedItem().toString();
            String [] pisahBarang = KodeBarang.split(" - ");
            String kodeBarang = pisahBarang[0];
        
            String [][] data = PembelianBarang.getBarangByKode(kodeBarang);
            String namaBarang = data[0][1];
            String hargaBarang = data[0][2];
        
            TxtNamaBarang.setText(namaBarang);
            TxtHarga.setText(hargaBarang);
            TxtJumlah.requestFocus();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboKodeActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        // TODO add your handling code here:
        kondisiAwal();
        tampilKodeTransaksiOtomatis();
        tampilTanggal();
        tampilListBarang();
        kosongkanTabel();
        TxtNamaBarang.setText("");
        TxtHarga.setText("");
        ComboSupplier.requestFocus();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        insertDataKeTabel();
        bersihBarang();
        totalHarga();
        totalBarang();
        ComboKode.requestFocus();
        BtnTambah.setEnabled(false);
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKembaliActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtnKembaliActionPerformed

    private void BtnBatalkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalkanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TabelPembelian.getModel();
        int row = TabelPembelian.getSelectedRow();
        model.removeRow(row);
        totalHarga();
        totalBarang();
    }//GEN-LAST:event_BtnBatalkanActionPerformed

    private void TxtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBayarActionPerformed
        // TODO add your handling code here:
        int jumlahBaris = TabelPembelian.getRowCount();
        int totalHarga = 0, totalBayar = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            hargaBarang = Integer.parseInt(TabelPembelian.getValueAt(i, 3).toString());
            jumlahBarang = Integer.parseInt(TabelPembelian.getValueAt(i, 4).toString());
            
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

    private void ComboSupplierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboSupplierItemStateChanged
        // TODO add your handling code here:
        try {
            TxtNamaSupplier.setText("");
            TxtAlamatSupplier.setText("");
        
            String KodeSupplier = ComboSupplier.getSelectedItem().toString();
            String [] pisahSupplier = KodeSupplier.split(" - ");
            String kodeSupplier = pisahSupplier[0];
            String namaSupplierr = pisahSupplier[1];
            
            String [][] data = PembelianBarang.getSupplierByKode(kodeSupplier);
            String namaSupplier = data[0][1];
            String alamatSupplier = data[0][2];
            TxtNamaSupplier.setText(namaSupplier);
            TxtAlamatSupplier.setText(alamatSupplier);
            
            if(ComboSupplier.getSelectedItem().equals(kodeSupplier + " - " + namaSupplierr)) {
                String [] listBarang = PembelianBarang.getListBarangByKodeSupplier(kodeSupplier);
                mdlBarang.removeAllElements();
                for (int i = 0; i < listBarang.length; i++) {
                    mdlBarang.addElement(listBarang[i]);
                }
                ComboKode.setModel(mdlBarang);
            }
        } catch (Exception e) {
//            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_ComboSupplierItemStateChanged

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        String kodeTransaksi = TxtKode.getText();
        
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(DTanggal.getDate()));
        
        String statusBeli = TxtStatus.getText();
        String namaSupplier = TxtNamaSupplier.getText();
        String alamatSupplier = TxtAlamatSupplier.getText();
        String jumlahBrg = TxtTotalJumlah.getText();
        String totalHrg = TxtTotalHarga.getText();
        String bayar = TxtBayar.getText();
        String kembali = TxtKembali.getText();
        String kodePegawai = UserLogin.getKodePegawai();
        
        if(kodeTransaksi.isEmpty() && tanggal.isEmpty() && statusBeli.isEmpty() && namaSupplier.isEmpty() && alamatSupplier.isEmpty() && jumlahBrg.equalsIgnoreCase("0") && totalHrg.equalsIgnoreCase("Rp. 0.00") 
                && bayar.equalsIgnoreCase("0") && statusBeli.equalsIgnoreCase("Belum Lunas")) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong, lakukan transaksi pembelian barang terlebih dahulu", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
        } else if(kodeTransaksi.isEmpty() || tanggal.isEmpty() || statusBeli.isEmpty() || namaSupplier.isEmpty() || alamatSupplier.isEmpty() || jumlahBrg.equalsIgnoreCase("0") || totalHrg.equalsIgnoreCase("Rp. 0.00") 
                || bayar.equalsIgnoreCase("0") || statusBeli.equalsIgnoreCase("Belum Lunas")) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong, lakukan transaksi pembelian barang terlebih dahulu", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
        } else if (bayar.isEmpty() || bayar.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Masukkan Uang Bayar terlebih dahulu", "Pesan Kesalahan", JOptionPane.INFORMATION_MESSAGE);
            TxtBayar.requestFocus();
        } else {
            int jumlahBarang = Integer.parseInt(jumlahBrg);
            
            int jumlahBaris = TabelPembelian.getRowCount();
            int totalHarga = 0;
            int jumlahBarang2, hargaBarang2;
            for (int i = 0; i < jumlahBaris; i++) {
                hargaBarang2 = Integer.parseInt(TabelPembelian.getValueAt(i, 3).toString());
                jumlahBarang2 = Integer.parseInt(TabelPembelian.getValueAt(i, 4).toString());
            
                totalHarga = totalHarga + (hargaBarang2 * jumlahBarang2);
            }
            
            int bayarBarang = Integer.parseInt(bayar);
            int kembalian = Integer.parseInt(kembali);
            
            PembelianBarang.simpanDataTransaksiPembelian(kodeTransaksi, tanggal, jumlahBarang, totalHarga, bayarBarang, kembalian, statusBeli, kodePegawai);
            
            int baris = TabelPembelian.getRowCount();
            
            for (int i = 0; i < baris; i++) {
                String kodeBarang = TabelPembelian.getValueAt(i, 1).toString();
                int hargaBarangDetail = Integer.parseInt(TabelPembelian.getValueAt(i, 3).toString());
                int jumlahBarangDetail = Integer.parseInt(TabelPembelian.getValueAt(i, 4).toString());
                int totalHargaDetail = Integer.parseInt(TabelPembelian.getValueAt(i, 5).toString());
                
                String [][] data = PembelianBarang.getKodeSupplierByKodeBarang(kodeBarang);
                String kodeSupplier = data[0][0];
                
                PembelianBarang.simpanDataDetailTransaksiPembelian(kodeTransaksi, kodeBarang, hargaBarangDetail, jumlahBarangDetail, totalHargaDetail, kodeSupplier);
            }
            kondisiAwal();
            tampilKodeTransaksiOtomatis();
            tampilTanggal();
            tampilListSupplier();
            tampilListBarang();
            kosongkanTabel();
            TxtNamaBarang.setText("");
            TxtHarga.setText("");
            ComboSupplier.requestFocus();
            TxtNamaSupplier.setText("");
            TxtAlamatSupplier.setText("");
            JOptionPane.showMessageDialog(this, "Transaksi Pembelian Barang berhasil disimpan", "Pesan Berhasil", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

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
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembelian().setVisible(true);
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
    private javax.swing.JComboBox<String> ComboSupplier;
    private com.toedter.calendar.JDateChooser DTanggal;
    private javax.swing.JTable TabelPembelian;
    private javax.swing.JTextField TxtAlamatSupplier;
    private javax.swing.JTextField TxtBayar;
    private javax.swing.JTextField TxtHarga;
    private javax.swing.JTextField TxtJumlah;
    private javax.swing.JTextField TxtKembali;
    private javax.swing.JTextField TxtKode;
    private javax.swing.JTextField TxtKurang;
    private javax.swing.JTextField TxtNamaBarang;
    private javax.swing.JTextField TxtNamaSupplier;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
