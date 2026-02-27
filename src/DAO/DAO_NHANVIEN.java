/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Connect.SQLServerProvider;
import Entity.NHANVIEN;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Douers
 */
public class DAO_NHANVIEN {
    
    
    
    public static ArrayList<NHANVIEN> getNHANVIEN(){
        ArrayList<NHANVIEN> lst = new ArrayList<>();
        
        String queryLoad = "  SELECT * FROM NHANVIEN";
        try{
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(queryLoad);
            while(rs.next()){
                lst.add(new NHANVIEN(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getString(6),
                                     rs.getString(7)
                
                ));
            }
            provider.close();
        }catch(Exception e){
            
        }
        
        return lst;
    }
    
    public static ArrayList<NHANVIEN> timKiemNHANVIENTheoTen(String tenHH) {
        ArrayList<NHANVIEN> dsHH = new ArrayList<NHANVIEN>();
        try{
            String sql = "  SELECT * FROM NHANVIEN"
                        + "  WHERE TenNV LIKE N'%" + tenHH + "%'";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                NHANVIEN hh = new NHANVIEN();
                hh.setMaNhanvien(rs.getInt(1));
                hh.setTenNhanVien(rs.getString(2));
                hh.setDienThoai(rs.getString(3));
                hh.setDiaChi(rs.getString(4));
                hh.setNgaySinh(rs.getString(5));
                hh.setGioiTinh(rs.getString(6));
               hh.setAnhNhanVien(rs.getString(7));
                dsHH.add(hh);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsHH;
    }
    
    
    
     public static boolean themNHANVIEN (NHANVIEN hh) throws SQLException {
        boolean kq = false;
        String sql = String.format("INSERT INTO NHANVIEN(TENNV,DIACHI,DIENTHOAI,GIOITINH,NGAYSINH,ANHNV) " 
        + "VALUES (N'" + hh.getTenNhanVien()+ "',N'"+hh.getDiaChi()+"','"+hh.getDienThoai()+"','"+hh.getGioiTinh()+"','"+hh.getNgaySinh()+"','"+hh.getAnhNhanVien()+"')");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        
        int n = provider.executeUpdate(sql);
        if (n==1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static boolean xoaNHANVIEN (String maHH) throws SQLException {
        boolean kq = false;
        String sql = String.format("DELETE FROM NHANVIEN WHERE MANV = " + maHH + "");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static boolean capNhatNHANVIEN (NHANVIEN hh) throws SQLException {
        boolean kq = false;
        
        String sql = String.format("UPDATE NHANVIEN SET"
                        + " TENNV = N'"+hh.getTenNhanVien()+"', DIACHI = N'"+hh.getDiaChi()+"', DIENTHOAI = '"+hh.getDienThoai()
                        + "' ,GIOITINH = N'"+hh.getGioiTinh()+"', NGAYSINH = N'"+hh.getNgaySinh()+"', ANHNV = N'"+hh.getAnhNhanVien()+"'"
                        + " WHERE MANV= "+hh.getMaNhanvien());
        
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static NHANVIEN layNHANVIEN (int maHH) {
        NHANVIEN hh = null;
        try{
            String sql = "SELECT * FROM NHANVIEN WHERE MANV =" + maHH;
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
                hh = new NHANVIEN();
                hh.setMaNhanvien(rs.getInt(1));
                hh.setTenNhanVien(rs.getString(2));
                hh.setDiaChi(rs.getString(3));
                hh.setDienThoai(rs.getString(4));
                hh.setGioiTinh(rs.getString(5));
                hh.setNgaySinh(rs.getString(6));
                hh.setAnhNhanVien(rs.getString(7));
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return hh;
    }
    


}
