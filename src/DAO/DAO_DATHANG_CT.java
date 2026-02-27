/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.SQLServerProvider;
import Entity.DATHANG_CT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class DAO_DATHANG_CT {
    
    public static ArrayList<DATHANG_CT> getDATHANG_CT(String mahd){
        ArrayList<DATHANG_CT> lst = new ArrayList<>();
        
        String queryLoad = "  SELECT *  FROM CHITIETDATHANG Where MADONHANG = '" + mahd+"'";
                            
        try{
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(queryLoad);
            while(rs.next()){
                lst.add(new DATHANG_CT(rs.getString(1),
                                    rs.getInt(2),
                                    rs.getInt(3),
                                    rs.getInt(4)
                ));
            }
            provider.close();
        }catch(Exception e){
            
        }
        
        return lst;
    }
    
    /* public static boolean themDATHANG_CT (DATHANG_CT hh) throws SQLException {
        boolean kq = false;
        String sql = String.format("INSERT INTO CHITIETDATHANG(MADONHANG,TENHANGHOA,SOLUONG,MANCC)" 
        + "VALUES ('"+hh.getMaDonDatHang()+"'," + hh.getMaHangHoa()+ ","+hh.getSoLuong()+","+hh.getNcc()+")");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        
        int n = provider.executeUpdate(sql);
        if (n==1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }*/
public static boolean themDATHANG_CT(DATHANG_CT hh) throws SQLException {
    boolean kq = false;
    String sql = String.format("INSERT INTO CHITIETDATHANG(MADONHANG, MAHANG, SOLUONG, MANCC) " 
            + "VALUES ('%s', %d, %d, %d)",
            hh.getMaDonDatHang(), hh.getMaHangHoa(), hh.getSoLuong(), hh.getNcc());
    
    SQLServerProvider provider = new SQLServerProvider();
    provider.open();
    
    int n = provider.executeUpdate(sql);
    if (n == 1) {
        kq = true;
    }
    provider.close();
    
    return kq;
}



  public static boolean xoaDATHANG_CT(String maHH, int mahh, int mancc) throws SQLException {
    boolean kq = false;
    String sql = String.format("DELETE FROM CHITIETDATHANG WHERE MADONHANG = '%s' AND MAHANG = %d AND MANCC = %d", maHH, mahh, mancc);
    
    SQLServerProvider provider = new SQLServerProvider();
    provider.open();
    
    int n = provider.executeUpdate(sql);
    
    if (n == 1) {
        kq = true;
    }
    
    provider.close();
    
    return kq;
}

    
  /*  public static boolean capNhatDATHANG_CT (DATHANG_CT hh) throws SQLException {
        boolean kq = false;
        String sql = String.format("UPDATE CHITIETDATHANG SET"
                        + " SOLUONG = "+hh.getSoLuong()
                        + ", MANCC = "+hh.getNcc()
                        + " WHERE MADONHANG = '" + hh.getMaDonDatHang()+"' AND MAHANG = N'"+hh.getMaHangHoa() +"'");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }*/
 public static boolean capNhatDATHANG_CT(DATHANG_CT hh) throws SQLException {
    boolean kq = false;
  String sql = String.format("UPDATE CHITIETDATHANG SET SOLUONG = %d, MANCC = %d , MAHANG = %d WHERE MADONHANG = '%s' AND MAHANG = %d",
                            hh.getSoLuong(), hh.getNcc(), hh.getMaHangHoa(), hh.getMaDonDatHang(), hh.getMaHangHoa());

    
    SQLServerProvider provider = new SQLServerProvider();
    provider.open();
    int n = provider.executeUpdate(sql);
    provider.close();
    if (n == 1) {
        kq = true;
    }
    
    return kq;
}




}
