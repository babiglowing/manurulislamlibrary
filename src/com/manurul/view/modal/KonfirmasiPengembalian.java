/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.view.modal;

import com.manurul.lib.GenKode;
import com.manurul.lib.InputBorder;
import com.manurul.lib.RoundedPanel;
import com.manurul.view.Dashboard;
import static com.manurul.view.modal.konfirmasiTransaksiPinjam.LABEL_TGL_PINJAM_TRANSAKSI;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caesarhome
 */
public class KonfirmasiPengembalian extends javax.swing.JFrame {

    /**
     * Creates new form KonfirmasiPengembalian
     */
    private int BukuDipinjam;
    private int BukuBermasalah;
    private int BukuYangAkanDikembalikan;
    private int BukuYangSudahDikembalikan;
    private String StatusTransaksi;
    
    public KonfirmasiPengembalian() {
        
        initComponents();
        
        // SET ICON
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../src/LOGO_MANURUL.png")));

        // SET TITLE
        this.setTitle("MA Nurul Islam Library Management - Konfirmasi Pengembalian");
        
        // SET CENTER LOCATION
        this.setLocationRelativeTo(null);
        
        // SET DISABLE RESIZESABLE
        this.setResizable(false);
        
        // SET PADDING
        InputBorder.set(INPUT_NAMA_PEMINJAM, 8);
        InputBorder.set(INPUT_JENIS_BUKU, 8);
        InputBorder.set(INPUT_BUKU_DIPINJAM, 8);
        InputBorder.set(INPUT_BUKU_BERMASALAH, 8);
        InputBorder.set(INPUT_BUKU_YANG_AKAN_DIKEMBALIKAN, 8);
        InputBorder.set(INPUT_BUKU_YANG_SUDAH_DIKEMBALIKAN, 8);
        InputBorder.set(INPUT_STATUS_TRANSAKSI, 8);
        
        // GET REALTIME
        getDateRealTime();
        
        // SET VALUE INPUT
        
            LABEL_ID_TRANSAKSI.setText("#TR-"+Dashboard.PJ_INPUT_ID_TRANSAKSI_PENGEMBALIAN.getText());
            LABEL_PENGURUS.setText(Dashboard.USERNAME.getText());
            INPUT_NAMA_PEMINJAM.setText(Dashboard.PJ_INPUT_PEMINJAM_PENGEMBALIAN.getText());

            String jenis = "UMUM";
            if(Dashboard.PJ_INPUT_JENIS_BUKU_PENGEMBALIAN.getSelectedItem().toString().contains("PAKET")){
                jenis = "PAKET";
            }
            INPUT_JENIS_BUKU.setText(jenis);

            // GET BUKU YANG MASIH DIPINJAM
            
            DefaultTableModel table_list_dipinjam = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN.getModel();
            DefaultTableModel table_list_dikembali = (DefaultTableModel)Dashboard.TABLE_LIST_PENGEMBALIAN1.getModel();
        
            int rowDipinjam = table_list_dipinjam.getRowCount();
            int rowDikembali = table_list_dikembali.getRowCount();
    
                // cek buku yang tidak bermasalah dan masalah;
                
                if(table_list_dipinjam.getValueAt(0, 0) != null){
                    for(int i = 0; rowDipinjam > i; i++){
                        if(table_list_dipinjam.getValueAt(i, 2).toString().contains("Bermasalah")){
                            BukuBermasalah += 1;
                        }else{
                            BukuDipinjam += 1;
                        }
                    }
                }else{
                    BukuDipinjam = 0;
                }
                
                // cek buku yang sudah dikembalikan dan mau dikembalikan
                
                if(table_list_dikembali.getValueAt(0, 0) != null){
                    for(int j = 0; rowDikembali > j; j++){
                        if(table_list_dikembali.getValueAt(j, 2).toString().contains("LUNAS")){
                            BukuYangSudahDikembalikan += 1;
                        }else{
                            BukuYangAkanDikembalikan += 1;
                        }
                    }
                }
                
                // cek status transaksi
                
                if(BukuDipinjam == 0 && BukuBermasalah == 0){
                    StatusTransaksi = "SELESAI";
                }else if(BukuBermasalah != 0){
                    StatusTransaksi = "BERMASALAH";
                }else{
                    StatusTransaksi = "DIPINJAM";
                }
            
                
            INPUT_BUKU_DIPINJAM.setText(String.valueOf(BukuDipinjam));
            INPUT_BUKU_BERMASALAH.setText(String.valueOf(BukuBermasalah));
            INPUT_BUKU_YANG_AKAN_DIKEMBALIKAN.setText(String.valueOf(BukuYangAkanDikembalikan));
            INPUT_BUKU_YANG_SUDAH_DIKEMBALIKAN.setText(String.valueOf(BukuYangSudahDikembalikan));
            INPUT_STATUS_TRANSAKSI.setText(StatusTransaksi);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WRAPPER = new RoundedPanel(15, Color.WHITE);
        LABEL_TRANSAKSI = new javax.swing.JLabel();
        LABEL_ID_TRANSAKSI = new javax.swing.JLabel();
        LABEL_TGL_PINJAM_TRANSAKSI = new javax.swing.JLabel();
        LABEL_NAMA_PEMINJAM = new javax.swing.JLabel();
        INPUT_NAMA_PEMINJAM = new javax.swing.JTextField();
        INPUT_JENIS_BUKU = new javax.swing.JTextField();
        LABEL_JENIS_BUKU = new javax.swing.JLabel();
        BTN_CETAK_PENGEMBALIAN_TRANSAKSI = new javax.swing.JButton();
        LABEL_PENGURUS = new javax.swing.JLabel();
        INPUT_BUKU_BERMASALAH = new javax.swing.JTextField();
        INPUT_BUKU_DIPINJAM = new javax.swing.JTextField();
        LABEL_BUKU_DIPINJAM = new javax.swing.JLabel();
        LABEL_BUKU_BERMASALAH = new javax.swing.JLabel();
        INPUT_BUKU_YANG_SUDAH_DIKEMBALIKAN = new javax.swing.JTextField();
        INPUT_BUKU_YANG_AKAN_DIKEMBALIKAN = new javax.swing.JTextField();
        LABEL_BUKU_YANG_SUDAH_DIKEMBALIKAN = new javax.swing.JLabel();
        LABEL_BUKU_YANG_AKAN_DIKEMBALIKAN = new javax.swing.JLabel();
        INPUT_STATUS_TRANSAKSI = new javax.swing.JTextField();
        LABEL_STATUS_TRANSAKSI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LABEL_TRANSAKSI.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        LABEL_TRANSAKSI.setText("TRANSAKSI");

        LABEL_ID_TRANSAKSI.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        LABEL_ID_TRANSAKSI.setText("#TR-46235367492");

        LABEL_TGL_PINJAM_TRANSAKSI.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        LABEL_TGL_PINJAM_TRANSAKSI.setText("19 / 08 / 2022 11:31:00");

        LABEL_NAMA_PEMINJAM.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_NAMA_PEMINJAM.setText("Peminjam");

        INPUT_NAMA_PEMINJAM.setEditable(false);
        INPUT_NAMA_PEMINJAM.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_NAMA_PEMINJAM.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        INPUT_JENIS_BUKU.setEditable(false);
        INPUT_JENIS_BUKU.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_JENIS_BUKU.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LABEL_JENIS_BUKU.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_JENIS_BUKU.setText("Jenis Buku");

        BTN_CETAK_PENGEMBALIAN_TRANSAKSI.setBackground(new java.awt.Color(0, 171, 60));
        BTN_CETAK_PENGEMBALIAN_TRANSAKSI.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        BTN_CETAK_PENGEMBALIAN_TRANSAKSI.setForeground(new java.awt.Color(255, 255, 255));
        BTN_CETAK_PENGEMBALIAN_TRANSAKSI.setText("Cetak Transaksi");
        BTN_CETAK_PENGEMBALIAN_TRANSAKSI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_CETAK_PENGEMBALIAN_TRANSAKSIMouseClicked(evt);
            }
        });

        LABEL_PENGURUS.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        LABEL_PENGURUS.setText("Indah Novitasari");

        INPUT_BUKU_BERMASALAH.setEditable(false);
        INPUT_BUKU_BERMASALAH.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_BUKU_BERMASALAH.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        INPUT_BUKU_DIPINJAM.setEditable(false);
        INPUT_BUKU_DIPINJAM.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_BUKU_DIPINJAM.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LABEL_BUKU_DIPINJAM.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_BUKU_DIPINJAM.setText("Buku Dipinjam");

        LABEL_BUKU_BERMASALAH.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_BUKU_BERMASALAH.setText("Buku Bermasalah");

        INPUT_BUKU_YANG_SUDAH_DIKEMBALIKAN.setEditable(false);
        INPUT_BUKU_YANG_SUDAH_DIKEMBALIKAN.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_BUKU_YANG_SUDAH_DIKEMBALIKAN.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        INPUT_BUKU_YANG_AKAN_DIKEMBALIKAN.setEditable(false);
        INPUT_BUKU_YANG_AKAN_DIKEMBALIKAN.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_BUKU_YANG_AKAN_DIKEMBALIKAN.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LABEL_BUKU_YANG_SUDAH_DIKEMBALIKAN.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_BUKU_YANG_SUDAH_DIKEMBALIKAN.setText("Buku Yang Sudah DiKembalikan");

        LABEL_BUKU_YANG_AKAN_DIKEMBALIKAN.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_BUKU_YANG_AKAN_DIKEMBALIKAN.setText("Buku Yang Akan Dikembalikan");

        INPUT_STATUS_TRANSAKSI.setEditable(false);
        INPUT_STATUS_TRANSAKSI.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        INPUT_STATUS_TRANSAKSI.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LABEL_STATUS_TRANSAKSI.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        LABEL_STATUS_TRANSAKSI.setText("Status Transaksi");

        javax.swing.GroupLayout WRAPPERLayout = new javax.swing.GroupLayout(WRAPPER);
        WRAPPER.setLayout(WRAPPERLayout);
        WRAPPERLayout.setHorizontalGroup(
            WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WRAPPERLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(WRAPPERLayout.createSequentialGroup()
                        .addComponent(LABEL_TRANSAKSI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LABEL_TGL_PINJAM_TRANSAKSI))
                    .addGroup(WRAPPERLayout.createSequentialGroup()
                        .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LABEL_NAMA_PEMINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INPUT_NAMA_PEMINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LABEL_JENIS_BUKU, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(INPUT_JENIS_BUKU)))
                    .addGroup(WRAPPERLayout.createSequentialGroup()
                        .addComponent(LABEL_ID_TRANSAKSI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LABEL_PENGURUS))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, WRAPPERLayout.createSequentialGroup()
                        .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LABEL_BUKU_DIPINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INPUT_BUKU_DIPINJAM, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LABEL_BUKU_BERMASALAH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(INPUT_BUKU_BERMASALAH, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, WRAPPERLayout.createSequentialGroup()
                        .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LABEL_BUKU_YANG_AKAN_DIKEMBALIKAN, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INPUT_BUKU_YANG_AKAN_DIKEMBALIKAN, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LABEL_STATUS_TRANSAKSI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(INPUT_STATUS_TRANSAKSI, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LABEL_BUKU_YANG_SUDAH_DIKEMBALIKAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(INPUT_BUKU_YANG_SUDAH_DIKEMBALIKAN, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
            .addGroup(WRAPPERLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(BTN_CETAK_PENGEMBALIAN_TRANSAKSI, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WRAPPERLayout.setVerticalGroup(
            WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WRAPPERLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LABEL_TRANSAKSI)
                    .addComponent(LABEL_TGL_PINJAM_TRANSAKSI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LABEL_ID_TRANSAKSI)
                    .addComponent(LABEL_PENGURUS))
                .addGap(25, 25, 25)
                .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(WRAPPERLayout.createSequentialGroup()
                        .addComponent(LABEL_NAMA_PEMINJAM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(INPUT_NAMA_PEMINJAM))
                    .addGroup(WRAPPERLayout.createSequentialGroup()
                        .addComponent(LABEL_JENIS_BUKU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(INPUT_JENIS_BUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(WRAPPERLayout.createSequentialGroup()
                        .addComponent(LABEL_BUKU_DIPINJAM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(INPUT_BUKU_DIPINJAM))
                    .addGroup(WRAPPERLayout.createSequentialGroup()
                        .addComponent(LABEL_BUKU_BERMASALAH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(INPUT_BUKU_BERMASALAH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(WRAPPERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(WRAPPERLayout.createSequentialGroup()
                        .addComponent(LABEL_BUKU_YANG_AKAN_DIKEMBALIKAN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(INPUT_BUKU_YANG_AKAN_DIKEMBALIKAN))
                    .addGroup(WRAPPERLayout.createSequentialGroup()
                        .addComponent(LABEL_BUKU_YANG_SUDAH_DIKEMBALIKAN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(INPUT_BUKU_YANG_SUDAH_DIKEMBALIKAN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(LABEL_STATUS_TRANSAKSI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(INPUT_STATUS_TRANSAKSI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(BTN_CETAK_PENGEMBALIAN_TRANSAKSI, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(WRAPPER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(WRAPPER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_CETAK_PENGEMBALIAN_TRANSAKSIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_CETAK_PENGEMBALIAN_TRANSAKSIMouseClicked
        Dashboard.TM.cetakPengembalian();
        this.dispose();
    }//GEN-LAST:event_BTN_CETAK_PENGEMBALIAN_TRANSAKSIMouseClicked

    // GET REALTIME
        private void getDateRealTime(){

            Timer timer;

            timer = new Timer(0, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                  String date = GenKode.TransaksiGetDate();
                  LABEL_TGL_PINJAM_TRANSAKSI.setText(date);
                }
            });

            timer.start();
            
        }
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
            java.util.logging.Logger.getLogger(KonfirmasiPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KonfirmasiPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KonfirmasiPengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CETAK_PENGEMBALIAN_TRANSAKSI;
    public static javax.swing.JTextField INPUT_BUKU_BERMASALAH;
    public static javax.swing.JTextField INPUT_BUKU_DIPINJAM;
    public static javax.swing.JTextField INPUT_BUKU_YANG_AKAN_DIKEMBALIKAN;
    public static javax.swing.JTextField INPUT_BUKU_YANG_SUDAH_DIKEMBALIKAN;
    public static javax.swing.JTextField INPUT_JENIS_BUKU;
    public static javax.swing.JTextField INPUT_NAMA_PEMINJAM;
    public static javax.swing.JTextField INPUT_STATUS_TRANSAKSI;
    private javax.swing.JLabel LABEL_BUKU_BERMASALAH;
    private javax.swing.JLabel LABEL_BUKU_DIPINJAM;
    private javax.swing.JLabel LABEL_BUKU_YANG_AKAN_DIKEMBALIKAN;
    private javax.swing.JLabel LABEL_BUKU_YANG_SUDAH_DIKEMBALIKAN;
    public static javax.swing.JLabel LABEL_ID_TRANSAKSI;
    private javax.swing.JLabel LABEL_JENIS_BUKU;
    private javax.swing.JLabel LABEL_NAMA_PEMINJAM;
    public static javax.swing.JLabel LABEL_PENGURUS;
    private javax.swing.JLabel LABEL_STATUS_TRANSAKSI;
    public static javax.swing.JLabel LABEL_TGL_PINJAM_TRANSAKSI;
    private javax.swing.JLabel LABEL_TRANSAKSI;
    private javax.swing.JPanel WRAPPER;
    // End of variables declaration//GEN-END:variables
}
