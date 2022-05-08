/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.model;

import com.manurul.lib.DBConfig;
import com.manurul.lib.SqlTime;
import com.manurul.view.Dashboard;
import com.manurul.view.modal.AnggotaUSER;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caesarhome
 */
public class AnggotaModel extends DBConfig{
    
    //init state
    
    private int id;
    private String nis;
    private String nama_lengkap;
    private String jurusan;
    private String kelas;
    private String jumlah_buku_dipinjam;
    private String skor;
    private String created_at;
    private String updated_at;
    
    private String message;
    
    private Connection conn = (Connection)getConnection();
    DefaultTableModel table_model = new DefaultTableModel();
    
    //init modifier
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNis(String nis){
        this.nis = nis;
    }
    
    public String getNis(){
        return this.nis;
    }
    
    public void setNama(String nama){
        this.nama_lengkap = nama;
    }
    
    public String getNama(){
        return this.nama_lengkap;
    }
    
    public void setJurusan(String jurusan){
        this.jurusan = jurusan;
    }
    
    public String getJurusan(){
        return this.jurusan;
    }
    
    public void setKelas(String kelas){
        this.kelas = kelas;
    }
    
    public String getKelas(){
        return this.kelas;
    }
    
    public String getJumlahBukuDipinjam(){
        return this.jumlah_buku_dipinjam;
    }
    
    public void setJumlahBukuDipinjam(String jumlah){
        this.jumlah_buku_dipinjam = jumlah;
    }
    
    public void setSkor(String skor){
        this.skor = skor;
    }
    
    public String getSkor(){
        return this.skor;
    }
    
    public void setCreated(String tgl){
        this.created_at = tgl;
    }
    
    public String getCreated(){
        return this.created_at;
    }
    
    public void setUpdated(String tgl){
        this.updated_at = tgl;
    }
    
    public String getUpdated(){
        return this.updated_at;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    
    //getDataTable
    public void getDataTable(String Key, String Group, String Showing){
    
        table_model.setColumnCount(0);
        table_model.addColumn("No");
        table_model.addColumn("NIS");
        table_model.addColumn("Nama Lengkap");
        table_model.addColumn("Jurusan");
        table_model.addColumn("Kelas");
        
        Dashboard.TABLE_LIST_ANGGOTA.setModel(table_model);
        table_model.setRowCount(0);
        
        try{
            
            String GroupSelected;
            if(Group.equals("Semua")){
                GroupSelected = "ma_anggota.id";
            }else{
                GroupSelected = Group;
            }

            String limited;
            if(Showing.equals("Semua")){
                limited = "";
            }else{
                limited = " LIMIT " + Showing;
            }
            
            String sql = "SELECT ma_anggota.nis, ma_anggota.nama_lengkap, ma_jurusan.nama AS jurusan, ma_kelas.kode AS kode_kelas "
                    + "FROM ma_anggota JOIN ma_jurusan ON ma_anggota.jurusan = ma_jurusan.id "
                    + "JOIN ma_kelas ON ma_anggota.kelas = ma_kelas.id WHERE ma_anggota.nis LIKE '%"+Key+"%' OR ma_anggota.nama_lengkap LIKE '%"+Key+"%' ORDER BY "+GroupSelected+limited;
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            
            int i = 1;
            while(res.next()){
                table_model.addRow(new Object[]{
                    i++,
                    res.getString("nis"),
                    res.getString("nama_lengkap"),
                    res.getString("jurusan"),
                    res.getString("kode_kelas")
                });
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void setJurusanKelas(String Jurusan, String Kelas){
    
        try{
            
            //set jurusan
            PreparedStatement pst_jur = conn.prepareStatement("SELECT nama FROM ma_jurusan");
            ResultSet res = pst_jur.executeQuery();
            
            while(res.next()){
                AnggotaUSER.COMBO_BOX_JURUSAN.addItem(res.getString("nama"));
            }
            
                if(!Jurusan.equals("")){
                    AnggotaUSER.COMBO_BOX_JURUSAN.setSelectedItem(Jurusan);
                }
            
            //set kelas
            PreparedStatement pst_kelas = conn.prepareStatement("SELECT kode FROM ma_kelas");
            ResultSet res_kelas = pst_kelas.executeQuery();
            
            while(res_kelas.next()){
                AnggotaUSER.COMBO_BOX_KELAS.addItem(res_kelas.getString("kode"));
            }
                
                if(!Kelas.equals("")){
                    AnggotaUSER.COMBO_BOX_KELAS.setSelectedItem(Kelas);
                }
            
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    //insert data
    public boolean insertData(){
    
        try{
            
            PreparedStatement pst = conn.prepareStatement("INSERT INTO ma_anggota ( nis, nama_lengkap, jurusan, kelas, "
                    + " skor, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ? )");
            
            pst.setString(1, getNis());
            pst.setString(2, getNama());
            
            // get id jurusan
            PreparedStatement getJurId = conn.prepareStatement("SELECT id FROM ma_jurusan WHERE nama = '"+ getJurusan() + "'");
            ResultSet ResJur = getJurId.executeQuery();
            if(ResJur.next()){
                pst.setString(3, ResJur.getString("id"));
            }
            
            // get id kelas
            PreparedStatement getKelasId = conn.prepareStatement("SELECT id FROM ma_kelas WHERE kode = '" + getKelas() + "'");
            ResultSet ResKel = getKelasId.executeQuery();
            if(ResKel.next()){
                pst.setString(4, ResKel.getString("id"));
            }
            
            pst.setInt(5, Integer.parseInt(getSkor()));
            pst.setTimestamp(6, new SqlTime().getTimeStamp());
            pst.setTimestamp(7, new SqlTime().getTimeStamp());
            
            if(pst.execute()){
                throw new SQLException("Gagal menambahkan anggota!");
            }
            
            // cetak log
            new LogModel().Action("TAMBAH ANGGOTA", "Menambahkan anggota "+ getNama(), Dashboard.nama_user);
            
            // refresh
            new AnggotaModel().getDataTable(Dashboard.SEARCH_USER.getText(), Dashboard.GROUP_COMBOBOX_USER.getSelectedItem().toString(), Dashboard.TAMPILKAN_COMBOBOX_USER.getSelectedItem().toString());
            
            setMessage("Berhasil menambahkan anggota " + getNama());
            return true;
        
        }catch(SQLException error){
        
            if(error.getErrorCode() == 1062){
                setMessage("Anggota ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
            
        }
        
    }
    
    //getSelected
    public void getSelectedData(String Nis){
        
        try{
        
            String sql = "SELECT * FROM ma_anggota WHERE nis = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Nis);
            
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
            
                setId(res.getInt("id"));
                setNis(res.getString("nis"));
                setNama(res.getString("nama_lengkap"));
                
                PreparedStatement pst_jur = conn.prepareStatement("SELECT nama FROM ma_jurusan WHERE id = ?");
                pst_jur.setString(1, res.getString("jurusan"));
                
                ResultSet res_jur = pst_jur.executeQuery();
                if(res_jur.next()){
                    setJurusan(res_jur.getString("nama"));
                }
               
                PreparedStatement pst_kelas = conn.prepareStatement("SELECT kode FROM ma_kelas WHERE id = ?");
                pst_kelas.setString(1, res.getString("kelas"));
                
                ResultSet res_kelas = pst_kelas.executeQuery();
                if(res_kelas.next()){
                    setKelas(res_kelas.getString("kode"));
                }
                
                setJumlahBukuDipinjam(res.getString("jumlah_buku_dipinjam"));
                setSkor(res.getString("skor"));
                setCreated(res.getString("created_at"));
                setUpdated(res.getString("updated_at"));
                
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage(), "Terjadi Kesalahaan!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    //update data
    public boolean updateData(){
        
        try{
            
            String sql = "UPDATE ma_anggota SET "
                    + "nis = ?,"
                    + "nama_lengkap = ?,"
                    + "jurusan = ?,"
                    + "kelas = ?,"
                    + "skor = ?,"
                    + "updated_at = ?"
                    + " WHERE id = ?";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, getNis());
            pst.setString(2, getNama());
            
            PreparedStatement pst_jur = conn.prepareStatement("SELECT id FROM ma_jurusan WHERE nama = ?");
            pst_jur.setString(1, getJurusan());

            ResultSet res_jur = pst_jur.executeQuery();
            if(res_jur.next()){
                pst.setString(3, res_jur.getString("id"));
            }

            PreparedStatement pst_kelas = conn.prepareStatement("SELECT id FROM ma_kelas WHERE kode = ?");
            pst_kelas.setString(1, getKelas());

            ResultSet res_kelas = pst_kelas.executeQuery();
            if(res_kelas.next()){
                pst.setString(4, res_kelas.getString("id"));
            }
            
            pst.setInt(5, Integer.parseInt(getSkor()));
            pst.setTimestamp(6, new SqlTime().getTimeStamp());
            pst.setInt(7, getId());
            
            int updated = pst.executeUpdate();
            
            if(updated == 0){
                throw new SQLException("Gagal memperbarui anggota " + getNama());
            }
            
            // cetak log
            new LogModel().Action("UPDATE ANGGOTA", "Memperbarui anggota "+ getNama(), Dashboard.nama_user);
            
            // refresh
            new AnggotaModel().getDataTable(Dashboard.SEARCH_USER.getText(), Dashboard.GROUP_COMBOBOX_USER.getSelectedItem().toString(), Dashboard.TAMPILKAN_COMBOBOX_USER.getSelectedItem().toString());
            
            setMessage("Berhasil memperbarui anggota " + getNama());
            return true;
        
        }catch(SQLException error){
            if(error.getErrorCode() == 1062){
                setMessage("Anggota ini sudah tersedia !");
            }else{
                setMessage(error.getMessage());
            }
            
            return false;
        }
    
    }
    
    //delete data
    public boolean deleteData(){
    
        try{
            
            String sql = "DELETE FROM ma_anggota WHERE id = ?";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, getId());
            
            if(pst.execute()){
                throw new SQLException("Gagal menghapus anggota " + getNama());
            }
            
            // cetak log
            new LogModel().Action("DELETE ANGGOTA", "Menghapus anggota "+ getNama(), Dashboard.nama_user);
            
            // refresh
            new AnggotaModel().getDataTable(Dashboard.SEARCH_USER.getText(), Dashboard.GROUP_COMBOBOX_USER.getSelectedItem().toString(), Dashboard.TAMPILKAN_COMBOBOX_USER.getSelectedItem().toString());
            
            setMessage("Berhasil menghapus anggota " + getNama());
            return true;
        
        }catch(SQLException error){
            
            setMessage(error.getMessage());
            
            return false;
        }
        
    }
    
}
