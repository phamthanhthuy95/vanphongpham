/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Connect.SQLServerProvider;
import Entity.HOADON;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
/**
 *
 * @author Douers
 */
public class DAO_HOADON {
    
     public static ArrayList<HOADON> getHOADON(){
        ArrayList<HOADON> lst = new ArrayList<>();
        
        String queryLoad = "  SELECT * FROM HOADON";
        try{
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(queryLoad);
            while(rs.next()){
                lst.add(new HOADON(rs.getString(1),
                                    rs.getString(2),
                                    rs.getInt(3),
                                    rs.getInt(4),
                                    rs.getInt(5)
                
                ));
            }
            provider.close();
        }catch(Exception e){
            
        }
        
        return lst;
    }
    public static int layMaKh(String tenkh){
        int maLoai = 0;
         try{
            String sql = "SELECT * FROM KHACHHANG WHERE TENKH = N'" + tenkh + "'";
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
              maLoai = rs.getInt(1);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
         return maLoai; 
    }
    public static int layTenKh(String tenkh){
        int maLoai = 0;
         try{
            String sql = "SELECT * FROM KHACHHANG WHERE MAKH = N'" + tenkh + "'";
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
              maLoai = rs.getInt(1);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
         return maLoai; 
    }
        public static String laySdtKh(int tenkh){
        String maLoai = null;
         try{
            String sql = "SELECT DIENTHOAI FROM KHACHHANG WHERE MAKH = " + tenkh + "";
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
              maLoai = rs.getString(1);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
         return maLoai; 
    }
//    public static ArrayList<HOADON> timKiemHOADONTheoTen(String tenHH) {
//        ArrayList<HOADON> dsHH = new ArrayList<HOADON>();
//        try{
//            String sql = "  SELECT * FROM HOADON"
//                        + "  WHERE TenKhachHang LIKE N'%" + tenHH + "%'";
//            SQLServerProvider provider = new SQLServerProvider();
//            provider.open();
//            ResultSet rs = provider.executeQuery(sql);
//            while (rs.next()) {
//                HOADON hh = new HOADON();
//                hh.setMaKhachHang(rs.getInt(1));
//                hh.setTenKhachHang(rs.getString(2));
//                hh.setDienThoai(rs.getString(3));
//                hh.setDiaChi(rs.getString(4));
//               
//                dsHH.add(hh);
//            }
//            provider.close();
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return dsHH;
//    }
     public static int demsoluonghdtrongngay() throws SQLException
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
        String sql = "SELECT COUNT(*) FROM HOADON WHERE NGAYBAN = ?";
       
        
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
     }
     
     
  /*  public static boolean themHOADON(HOADON hd) throws SQLException
    {
        boolean kq=false;
        SQLServerProvider  provider= new SQLServerProvider();
        String sql = "INSERT INTO HOADON(MAHD, NGAYBAN, MANV, MAKH) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement them = provider.open().prepareStatement(sql)) {
           them.setString(1, hd.getMaHoaDon());
            them.setString(2, hd.getNgayBan());
        them.setInt(3, hd.getMaNhanVien());
        them.setInt(4, hd.getMaKhachHang());
             int n = them.executeUpdate();
           if(n==1){
               kq=true;
            }
        }
        return kq;
    }*/
     public static boolean themHOADON(HOADON hd) throws SQLException {
    boolean kq = false;
    SQLServerProvider provider = new SQLServerProvider();
    String sql = "INSERT INTO HOADON(MAHD, NGAYBAN, MANV, MAKH) VALUES (?, ?, ?, ?)";

    try (PreparedStatement them = provider.open().prepareStatement(sql)) {
        them.setString(1, hd.getMaHoaDon());
        them.setString(2, hd.getNgayBan());
        them.setInt(3, hd.getMaNhanVien()); // Sử dụng setInt thay vì setString
        them.setInt(4, hd.getMaKhachHang());
        int n = them.executeUpdate();
        if (n == 1) {
            kq = true;
        }
    }
    return kq;
}

    
    
    public static boolean ktkhoachinh(String mahd) throws SQLException
    {
        ResultSet rs = null;
        PreparedStatement ps = null;
        boolean tontai=false;
        SQLServerProvider  provider= new SQLServerProvider();
        String query = "Select COUNT(*) FROM HOADON WHERE mahd=?";
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
     
//     public static boolean themHOADON (HOADON hh) throws SQLException {
//        boolean kq = false;
//        String sql = String.format("INSERT INTO HOADON(MAHD,NGAYBAN,MANV,MAKH)" 
//        + "VALUES ("+hh.getMaHoaDon()+",'" + hh.getNgayBan()+ "',"+hh.getMaNhanVien()+","+hh.getMaKhachHang()+")");
//        SQLServerProvider provider = new SQLServerProvider();
//        provider.open();
//        
//        int n = provider.executeUpdate(sql);
//        if (n==1) {
//            kq = true;
//        }
//        provider.close();
//        
//        return kq;
//    }
    
//    public static boolean xoaHOADON (String maHH) throws SQLException {
//        boolean kq = false;
//        String sql = String.format("DELETE FROM HOADON WHERE MAKH = " + maHH + "");
//        SQLServerProvider provider = new SQLServerProvider();
//        provider.open();
//        int n = provider.executeUpdate (sql);
//        
//        if (n == 1) {
//            kq = true;
//        }
//        provider.close();
//        
//        return kq;
//    }
//    
//    public static boolean capNhatHOADON (HOADON hh) throws SQLException {
//        boolean kq = false;
//        
//        String sql = String.format("UPDATE HOADON SET"
//                        + " TENKH = N'"+hh.getTenKhachHang()+"', DIACHI = N'"+hh.getDiaChi()+"', DIENTHOAI = '"+hh.getDienThoai()
//                        + "WHERE MAKH= "+hh.getMaKhachHang());
//        SQLServerProvider provider = new SQLServerProvider();
//        provider.open();
//        int n = provider.executeUpdate (sql);
//        
//        if (n == 1) {
//            kq = true;
//        }
//        provider.close();
//        
//        return kq;
//    }
    

    public static boolean xoaHOADON (String maHH) throws SQLException {
      boolean kq = false;
        String sql = String.format("DELETE FROM HOADON WHERE MAKH = " + maHH + "");
       SQLServerProvider provider = new SQLServerProvider();
       provider.open();
       int n = provider.executeUpdate (sql);
       
       if (n == 1) {
           kq = true;
       }        provider.close();
       
        return kq;
    }
}
