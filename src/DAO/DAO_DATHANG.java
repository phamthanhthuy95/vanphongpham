/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.SQLServerProvider;
import Entity.DATHANG;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class DAO_DATHANG {
     public static ArrayList<DATHANG> getDATHANG(){
        ArrayList<DATHANG> lst = new ArrayList<>();
        
        String queryLoad = "  SELECT * FROM DATHANG";
        try{
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(queryLoad);
            while(rs.next()){
                lst.add(new DATHANG(rs.getString(1),
                                    rs.getString(2)                
                        ));
            }
            provider.close();
        }catch(Exception e){
            
        }
        
        return lst;
    }
     
  /*  public static int demsoluongDDHtrongngay() throws SQLException
     {
         int count = 0;
    
        SQLServerProvider  provider= new SQLServerProvider();   
        // Định dạng ngày Java
        Date today = new Date();

        // Định dạng ngày thành yyyy-MM-dd
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDateStr = dateFormat.format(today);
        java.sql.Date todayDate = java.sql.Date.valueOf(todayDateStr);
        // Truy vấn SQL với tham số cho ngày
        String sql = "SELECT COUNT(*) FROM DATHANG WHERE NGAYDATHANG = ?";
       
        
        try (PreparedStatement pstmt = provider.open().prepareStatement(sql)) {
            // Đặt tham số ngày
            pstmt.setDate(1, todayDate);
            
            // Thực thi truy vấn
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                    count++;
                    // Lấy số lượng từ kết quả truy vấn
                    
                }
            }
        }
        return count;
    }*/
     public static int demsoluongDDHtrongngay() throws SQLException {
    int count = 0;
    
    SQLServerProvider provider = new SQLServerProvider();
    // Định dạng ngày Java
    Date today = new Date();
    
    // Định dạng ngày thành yyyy-MM-dd
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String todayDateStr = dateFormat.format(today);
    java.sql.Date todayDate = java.sql.Date.valueOf(todayDateStr);
    
    // Truy vấn SQL với tham số cho ngày
    String sql = "SELECT COUNT(*) FROM DATHANG WHERE NGAYDATHANG = ?";
    
    try (PreparedStatement pstmt = provider.open().prepareStatement(sql)) {
        // Đặt tham số ngày
        pstmt.setDate(1, todayDate);
        
        // Thực thi truy vấn
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        }
    }
    return count;
}

    
     public static boolean themDONDATHANG(DATHANG dd) throws SQLException
    {
        boolean kq=false;
        SQLServerProvider  provider= new SQLServerProvider();
        String sql = "INSERT INTO DATHANG(MADONHANG, NGAYDATHANG) VALUES (?, ?)";
        
        try (PreparedStatement them = provider.open().prepareStatement(sql)) {
           them.setString(1, dd.getMaDonDatHang());
            them.setString(2, dd.getNgayDatHang());
             int n = them.executeUpdate();
           if(n==1){
               kq=true;
            }
        }
        return kq;
    }
    
     public static boolean xoaDONDATHANG(String maHH) throws SQLException {
        boolean kq = false;
        String sql = String.format("DELETE FROM DATHANG WHERE MADONHANG = '" + maHH + "'");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
        
    public static boolean ktkhoachinh(String mahd) throws SQLException
    {
        ResultSet rs = null;
        PreparedStatement ps = null;
        boolean tontai=false;
        SQLServerProvider  provider= new SQLServerProvider();
        String query = "Select COUNT(*) FROM DATHANG WHERE MADONHANG=?";
        ps = provider.open().prepareStatement(query);
        ps.setString(1, mahd);
        rs = ps.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            if (count > 0) {
                tontai = true; // Mã hóa đơn đã tồn tại
            }
        }
        
        return tontai;
    }
}
