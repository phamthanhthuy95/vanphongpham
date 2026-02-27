/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Connect.SQLServerProvider;
import Entity.KHACHHANG;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Douers
 */
public class DAO_KHACHHANG {
    
    
     
    
    public static ArrayList<KHACHHANG> getKHACHHANG(){
        ArrayList<KHACHHANG> lst = new ArrayList<>();
        
        String queryLoad = "  SELECT * FROM KHACHHANG";
        try{
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(queryLoad);
            while(rs.next()){
                lst.add(new KHACHHANG(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4)
                
                ));
            }
            provider.close();
        }catch(Exception e){
            
        }
        
        return lst;
    }
    
    public static ArrayList<KHACHHANG> timKiemKHACHHANGTheoTen(String tenHH) {
        ArrayList<KHACHHANG> dsHH = new ArrayList<KHACHHANG>();
        try{
            String sql = "  SELECT * FROM KHACHHANG"
                        + "  WHERE TenKH LIKE N'%" + tenHH + "%'";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                KHACHHANG hh = new KHACHHANG();
                hh.setMaKhachHang(rs.getInt(1));
                hh.setTenKhachHang(rs.getString(2));
                hh.setDienThoai(rs.getString(3));
                hh.setDiaChi(rs.getString(4));
               
                dsHH.add(hh);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsHH;
       
    }
    
    
    
     public static boolean themKHACHHANG (KHACHHANG hh) throws SQLException {
        boolean kq = false;
        String sql = String.format("INSERT INTO KHACHHANG(TENKH,DIACHI,DIENTHOAI)" 
        + " VALUES(N'" + hh.getTenKhachHang()+ "',N'" +hh.getDiaChi()+"','"+hh.getDienThoai()+"')");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        
        int n = provider.executeUpdate(sql);
        if (n==1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static boolean xoaKHACHHANG (String maHH) throws SQLException {
        boolean kq = false;
        String sql = String.format("DELETE FROM KHACHHANG WHERE MAKH = " + maHH + "");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static boolean capNhatKHACHHANG (KHACHHANG hh) throws SQLException {
        boolean kq = false;
        
        String sql = String.format("UPDATE KHACHHANG SET"
                        + " TENKH = N'"+hh.getTenKhachHang()+"', DIACHI = N'"+hh.getDiaChi()+"', DIENTHOAI = '"+hh.getDienThoai()
                        + "' WHERE MAKH= "+hh.getMaKhachHang());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static KHACHHANG layKHACHHANG (int maHH) {
        KHACHHANG hh = null;
        try{
            String sql = "SELECT * FROM KHACHHANG WHERE MAHANG =" + maHH;
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
                hh = new KHACHHANG();
                hh.setMaKhachHang(rs.getInt(1));
                hh.setTenKhachHang(rs.getString(2));
                hh.setDiaChi(rs.getString(3));
                hh.setDienThoai(rs.getString(4));
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return hh;
    }
    
    
    
}
