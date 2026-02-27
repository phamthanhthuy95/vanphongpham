/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.SQLServerProvider;
import Entity.HANGHOA;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Douers
 */
public class DAO_HANGHOA {
    Connection conn = null;
    PreparedStatement  ps =  null;
    ResultSet rs = null;
    
    
    
    
    public static ArrayList<HANGHOA> getHANGHOA(){
        ArrayList<HANGHOA> lst = new ArrayList<>();
        
        String queryLoad = "  SELECT MAHANG, TENHANG,SOLUONG, DONGIANHAP,DONGIABAN,ANH,GHICHU,TENLOAI, TENNCC "
                            + "  FROM HANGHOA, LOAI, NHACC "
                            + "  WHERE HANGHOA.MALOAI = LOAI.MALOAI AND NHACC.MANCC=HANGHOA.MANCC ";
        try{
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(queryLoad);
            while(rs.next()){
                lst.add(new HANGHOA(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getInt(3),
                                    rs.getDouble(4),
                                    rs.getDouble(5),
                                    rs.getString(6),
                                    rs.getString(7),
                                    rs.getString(8),
                                    rs.getString(9)
                
                ));
            }
            provider.close();
        }catch(Exception e){
            
        }
        
        return lst;
    }
    
    public static ArrayList<HANGHOA> timKiemHANGHOATheoTen(String tenHH) {
        ArrayList<HANGHOA> dsHH = new ArrayList<HANGHOA>();
        try{
            String sql = "SELECT HANGHOA.MAHANG, HANGHOA.TENHANG, HANGHOA.SOLUONG, HANGHOA.DONGIANHAP, HANGHOA.DONGIABAN, HANGHOA.ANH, HANGHOA.GHICHU, LOAI.TENLOAI, NHACC.TENNCC " +
                     "FROM HANGHOA " +
                     "JOIN LOAI ON HANGHOA.MALOAI = LOAI.MALOAI " +
                     "JOIN NHACC ON HANGHOA.MANCC = NHACC.MANCC " +
                     "WHERE TENHANG LIKE N'%" + tenHH + "%'";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                HANGHOA hh = new HANGHOA();
                hh.setMAHANG(rs.getInt(1));
                hh.setTENHANG(rs.getString(2));
                hh.setSOLUONG(rs.getInt(3));
                hh.setDONGIANHAP(rs.getDouble(4));
                hh.setDONGIAXUAT(rs.getDouble(5));
                hh.setANH(rs.getString(6));
                hh.setGHICHU(rs.getString(7));
                hh.setLOAI(rs.getString(8));
                hh.setNHACC(rs.getString(9));

                dsHH.add(hh);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsHH;
    }
    
    public static int layMaLoai(String TenLoai){
        int maLoai = 0;
         try{
            String sql = "SELECT * FROM LOAI WHERE TENLOAI = N'" + TenLoai + "'";
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
      public static int layMaNCC(String TenNCC){
        int maNCC = 0;
         try{
            String sql = "SELECT * FROM NHACC WHERE TENNCC = N'" + TenNCC + "'";
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
              maNCC = rs.getInt(1);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
         return maNCC; 
    }
    
    
     public static boolean themHANGHOA (HANGHOA hh) throws SQLException {
        boolean kq = false;
        int maloai = layMaLoai(hh.getLOAI());
        int mancc=layMaNCC(hh.getNHACC());
        String sql = String.format("INSERT INTO HANGHOA( TENHANG,SOLUONG, DONGIANHAP,DONGIABAN,ANH,GHICHU,MALOAI, MANCC)" 
        + "VALUES (N'"+hh.getTENHANG()+"'," + hh.getSOLUONG() + ","+hh.getDONGIANHAP()+","+hh.getDONGIAXUAT()+",N'"+hh.getANH()+"',N'"+hh.getGHICHU()+"',"+maloai+","+mancc+")");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        
        int n = provider.executeUpdate(sql);
        if (n==1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static boolean xoaHANGHOA (String maHH) throws SQLException {
        boolean kq = false;
        String sql = String.format("DELETE FROM HANGHOA WHERE MAHANG = " + maHH + "");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static boolean capNhatHANGHOA (HANGHOA hh) throws SQLException {
        boolean kq = false;
        int maloai = layMaLoai(hh.getLOAI());
        int mancc=layMaNCC(hh.getNHACC());
       
       String sql = String.format("UPDATE HANGHOA SET TENHANG = N'%s', SOLUONG = %d, DONGIANHAP = %f, DONGIABAN = %f, ANH = '%s', GHICHU = '%s', MALOAI = %d, MANCC = %d WHERE MAHANG = %d",
                            hh.getTENHANG(), hh.getSOLUONG(), hh.getDONGIANHAP(), hh.getDONGIAXUAT(), hh.getANH(), hh.getGHICHU(), maloai, mancc, hh.getMAHANG());

        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    
    public static HANGHOA layHANGHOA (int maHH) {
        HANGHOA hh = null;
        try{
            String sql = "SELECT * FROM HANGHOA WHERE MAHANG =" + maHH;
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
                hh = new HANGHOA();
                hh.setMAHANG(rs.getInt(1));
                hh.setTENHANG(rs.getString(2));
                hh.setSOLUONG(rs.getInt(3));
                hh.setDONGIANHAP(rs.getDouble(4));
                hh.setDONGIAXUAT(rs.getDouble(5));
                hh.setANH(rs.getString(6));
                hh.setGHICHU(rs.getString(7));
                hh.setLOAI(rs.getString(8));
                hh.setNHACC(rs.getString(9));
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return hh;
    }
    
    
//======================TEST======================
    
    
//    public static void main(String[] args) {
//        DAO_HANGHOA dao = new DAO_HANGHOA();
//        ArrayList<HANGHOA> lst = dao.getHANGHOA();
//        for(HANGHOA o : lst){
//            System.out.println(o);
//        }
//    }


}
