/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.controllerBarang;
import database.Koneksi;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class viewBarang extends javax.swing.JInternalFrame {

    /**
     * Creates new form viewBarang
     */
    private DefaultTableModel model;
    private controllerBarang cB;

    public viewBarang() {
        initComponents();
        loadPemasok();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        cB = new controllerBarang(this);

        model = new DefaultTableModel();
        tabelBarang.setModel(model);
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("KATEGORI");
        model.addColumn("MODAL");
        model.addColumn("HRG JUAL");
        model.addColumn("STOK");
        model.addColumn("ID PEMASOK");

        tampilDataBarang();
        cB.controlButton();
    }
    
    

    public JTextField getHargaJual() {
        return hargaJual;
    }

    public JTextField getIdBarang() {
        return idBarang;
    }

    public JComboBox<String> getKategori() {
        return kategori;
    }
    
    public JComboBox<String> getPemasok() {
        return pemasok;
    }

    public JTextField getModal() {
        return modal;
    }

    public JTextField getNamaBarang() {
        return namaBarang;
    }

    public JSpinner getStok() {
        return stok;
    }

    public JButton getTombolBatal() {
        return tombolBatal;
    }

    public JButton getTombolEdit() {
        return tombolEdit;
    }

    public JButton getTombolHapus() {
        return tombolHapus;
    }

    public JButton getTombolTambah() {
        return tombolTambah;
    }

    private void tampilDataBarang() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        String sql = "SELECT * FROM barang";
        try {
            Statement stat = (Statement) Koneksi.getConnect().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                //mengambil hasil query variable sql
                Object[] hasil;
                hasil = new Object[7]; // karena ada 7 field
                hasil[0] = res.getString("idBarang");
                hasil[1] = res.getString("namaBarang");
                hasil[2] = res.getString("kategori");
                hasil[3] = res.getString("modal");
                hasil[4] = res.getString("hargaJual");
                hasil[5] = res.getString("stok");
                hasil[6] = res.getString("idPemasok");

                model.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ambilDataTabel() {
        int index = tabelBarang.getSelectedRow();

        String id = String.valueOf(tabelBarang.getValueAt(index, 0));
        String nama = String.valueOf(tabelBarang.getValueAt(index, 1));
        String kat = String.valueOf(tabelBarang.getValueAt(index, 2));
        String mod = String.valueOf(tabelBarang.getValueAt(index, 3));
        String jual = String.valueOf(tabelBarang.getValueAt(index, 4));
        String stk = String.valueOf(tabelBarang.getValueAt(index, 5));
        String idPemasok = String.valueOf(tabelBarang.getValueAt(index, 6));

        //mengisi nilai kedalam textField
        idBarang.setText(id);
        namaBarang.setText(nama);
        kategori.setSelectedItem(kat);
        modal.setText(mod);
        hargaJual.setText(jual);
        stok.setValue(Integer.parseInt(stk));
        
        for (int i = 0; i < pemasok.getItemCount(); i++) {
        String item = pemasok.getItemAt(i);

        if (item.startsWith(idPemasok + " -")) {
            pemasok.setSelectedIndex(i);
            break;
        }
    }

        cB.controlButton2();
    }

    private void loadPemasok() {
        try {
            String sql = "SELECT idPemasok, namaPemasok FROM pemasok";
            Statement stat = Koneksi.getConnect().createStatement();
            ResultSet rs = stat.executeQuery(sql);

            pemasok.removeAllItems(); // biar ga dobel

            while (rs.next()) {
                String id = rs.getString("idPemasok");
                String nama = rs.getString("namaPemasok");

                // format: id - nama
                pemasok.addItem(id + " - " + nama);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal load pemasok: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idBarang = new javax.swing.JTextField();
        namaBarang = new javax.swing.JTextField();
        hargaJual = new javax.swing.JTextField();
        modal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        kategori = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        stok = new javax.swing.JSpinner();
        tombolTambah = new javax.swing.JButton();
        tombolEdit = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        tombolBatal = new javax.swing.JButton();
        tombolCetak = new javax.swing.JButton();
        pemasok = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBarang.setRowHeight(25);
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        jLabel1.setText("ID Barang");

        jLabel2.setText("Nama Barang");

        jLabel3.setText("Harga Jual");

        jLabel4.setText("Modal");

        idBarang.setEditable(false);

        hargaJual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaJualKeyTyped(evt);
            }
        });

        modal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                modalKeyTyped(evt);
            }
        });

        jLabel6.setText("Kategori");

        kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bulat", "Halus", "Lainnya" }));
        kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriActionPerformed(evt);
            }
        });

        jLabel7.setText("Stok");

        stok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stokKeyTyped(evt);
            }
        });

        tombolTambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tombolTambah.setText("Tambah");
        tombolTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTambahActionPerformed(evt);
            }
        });

        tombolEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tombolEdit.setText("Ubah");
        tombolEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolEditActionPerformed(evt);
            }
        });

        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        tombolBatal.setText("Bersihkan");
        tombolBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBatalActionPerformed(evt);
            }
        });

        tombolCetak.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tombolCetak.setText("Cetak");
        tombolCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCetakActionPerformed(evt);
            }
        });

        pemasok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        pemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemasokActionPerformed(evt);
            }
        });

        jLabel8.setText("Pemasok");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tombolHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tombolBatal, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tombolTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(tombolEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tombolCetak, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(78, 78, 78)
                        .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 143, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(namaBarang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idBarang)
                            .addComponent(kategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(hargaJual)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(67, 67, 67)
                .addComponent(modal)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(57, 57, 57)
                .addComponent(pemasok, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(tombolCetak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolTambah)
                    .addComponent(tombolHapus))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolEdit)
                    .addComponent(tombolBatal))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BARANG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolTambahActionPerformed
        // TODO add your handling code here:
        if (namaBarang.getText().equals("") || modal.getText().equals("") || hargaJual.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
        } else if (Integer.parseInt(stok.getValue().toString()) <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah Barang tidak benar");
        } else {
            cB.simpanData();
            tampilDataBarang();
        }
    }//GEN-LAST:event_tombolTambahActionPerformed

    private void tombolEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolEditActionPerformed
        // TODO add your handling code here:
        cB.ubahData();
        tampilDataBarang();
    }//GEN-LAST:event_tombolEditActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        cB.hapusData();
        tampilDataBarang();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tombolBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBatalActionPerformed
        // TODO add your handling code here:
        cB.controlButton();
        cB.deleteForm();
    }//GEN-LAST:event_tombolBatalActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void modalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modalKeyTyped
        // TODO add your handling code here:
        char i = evt.getKeyChar();
        if (!((Character.isDigit(i)) || (i == KeyEvent.VK_BACK_SPACE)) || (i == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null, "Hanya Masukan Angka!");
            evt.consume();
        }
    }//GEN-LAST:event_modalKeyTyped

    private void hargaJualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaJualKeyTyped
        // TODO add your handling code here:
        char i = evt.getKeyChar();
        if (!((Character.isDigit(i)) || (i == KeyEvent.VK_BACK_SPACE)) || (i == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null, "Hanya Masukan Angka!");
            evt.consume();
        }
    }//GEN-LAST:event_hargaJualKeyTyped

    private void stokKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stokKeyTyped
        // TODO add your handling code here:
        char i = evt.getKeyChar();
        if (!((Character.isDigit(i)) || (i == KeyEvent.VK_BACK_SPACE)) || (i == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            //JOptionPane.showMessageDialog(null, "Hanya Masukan Angka!");
            evt.consume();
        }
    }//GEN-LAST:event_stokKeyTyped

    private void tombolCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCetakActionPerformed
        // TODO add your handling code here:
        try {
            Connection conn = new Koneksi().getConnect();
            HashMap<String, Object> parameter = new HashMap<>();
            InputStream is = getClass().getResourceAsStream("/laporan/laporanBarang.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(is);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, conn);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tombolCetakActionPerformed

    private void kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kategoriActionPerformed

    private void pemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemasokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pemasokActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hargaJual;
    private javax.swing.JTextField idBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JTextField modal;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JComboBox<String> pemasok;
    private javax.swing.JSpinner stok;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JButton tombolBatal;
    private javax.swing.JButton tombolCetak;
    private javax.swing.JButton tombolEdit;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolTambah;
    // End of variables declaration//GEN-END:variables
}
