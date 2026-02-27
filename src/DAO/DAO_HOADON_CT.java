/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import Connect.SQLServerProvider;
import Entity.HOADON_CT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Douers
 */
public class DAO_HOADON_CT {
    
     
    public static ArrayList<HOADON_CT> getHOADON_CT(String mahd){
        ArrayList<HOADON_CT> lst = new ArrayList<>();
        
        String queryLoad = "  SELECT *  FROM CHITIETHOADON Where MAHD = '" + mahd+"'";
                            
        try{
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(queryLoad);
            while(rs.next()){
                lst.add(new HOADON_CT(rs.getString(1),
                                    rs.getInt(2),
                                    rs.getInt(3),
                                    rs.getDouble(4),
                                    rs.getDouble(5),
                        rs.getDouble(6)
                
                ));
            }
            provider.close();
        }catch(Exception e){
            
        }
        
        return lst;
    }
    
    
    public static double getGiaHangHoa(int mahang){
        double gia = 0;
        try{
            String sql = "SELECT DONGIABAN FROM HANGHOA WHERE MAHANG = " + mahang ;
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
              gia = rs.getInt(1);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return gia;
    }
//public static double getGiamGia(int mahd) {
//    double gia = 0;
//    try {
//        String sql = "SELECT GIAMGIA FROM CHITIETHOADON WHERE MAHD = '" + mahd + "'";
//        SQLServerProvider provider = new SQLServerProvider();
//        provider.open();
//        ResultSet rs = provider.executeQuery(sql);
//        
//        if (rs.next()) {
//            gia = rs.getDouble(1);
//        }
//        provider.close();
//    } catch (Exception ex) {
//        ex.printStackTrace();
//    }
//    
//    return gia;
//}
public static double getGiamGia(String mahd) throws SQLException {
    double gia = 0;
    try {
        String sql = "SELECT GIAMGIA FROM CHITIETHOADON WHERE MAHD = '" + mahd + "'";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        ResultSet rs = provider.executeQuery(sql);

        if (rs.next()) {
            gia = rs.getDouble("GIAMGIA");
        }
        provider.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return gia;
}



    public static int layMahang(String ten){
        int ma = 0;
        try{
            String sql = "SELECT MAHANG FROM HANGHOA WHERE TENHANG = '" + ten +"'" ;
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
              ma = rs.getInt(1);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return ma;
    }
    public static boolean themHOADON_CT (HOADON_CT hh) throws SQLException {
        boolean kq = false;
        String sql = String.format("INSERT INTO CHITIETHOADON(MAHD,MAHANG,SOLUONG,DONGIA,GIAMGIA)" 
        + "VALUES ('"+hh.getMaHoDon()+"'," + hh.getMaHang()+ ","+hh.getSoLuong()+","+hh.getDonGia()+","+hh.getGiamGia()+")");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        
        int n = provider.executeUpdate(sql);
        if (n==1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }

     

    
    public static boolean xoaHOADON_CT (String maHH, String mahh, int macthd ) throws SQLException {
        boolean kq = false;
        String sql = String.format("DELETE FROM HOADON_CT WHERE MAHD = " + maHH + " AND MAHANG = "+ mahh);
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }

     


     
    
    public static boolean capNhatHOADON_CT (HOADON_CT hh) throws SQLException {
        boolean kq = false;
        String sql = String.format("UPDATE HOADON_CT SET"
                        + " SOLUONG = "+hh.getSoLuong()+", DONGIA = "+hh.getDonGia()
                        + ", GIAMGIA = "+hh.getGiamGia()
                        + " WHERE MAHD = " + hh.getMaHoDon() + " AND MAHANG = "+ hh.getMaHang());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static HOADON_CT layHOADON_CT (int maHH) {
        HOADON_CT hh = null;
        try{
            String sql = "SELECT * FROM HOADON_CT WHERE MAHANG =" + maHH;
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
                hh = new HOADON_CT();
                hh.setMaHoDon(rs.getString(1));
                hh.setMaHang(rs.getInt(2));
                hh.setSoLuong(rs.getInt(3));
                hh.setDonGia(rs.getDouble(4));
                hh.setGiamGia(rs.getDouble(5));

            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return hh;
    }
   
    
}
