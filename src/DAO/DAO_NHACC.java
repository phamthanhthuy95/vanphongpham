/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.SQLServerProvider;
import java.sql.ResultSet;
import Entity.NHACC;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class DAO_NHACC {
    
     
    
    public static ArrayList<NHACC> getNHACC(){
        ArrayList<NHACC> lst = new ArrayList<>();
        
        String queryLoad = "  SELECT * FROM NHACC";
        try{
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(queryLoad);
            while(rs.next()){
                lst.add(new NHACC(rs.getInt(1),
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
    
    public static ArrayList<NHACC> timKiemNHACCTheoTen(String tenNCC) {
        ArrayList<NHACC> dsNHACC = new ArrayList<NHACC>();
        try{
            String sql = "  SELECT * FROM NHACC"
                        + "  WHERE TENNCC LIKE N'%" + tenNCC+ "%'";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                NHACC ncc = new NHACC();
                ncc.setMaNhacc(rs.getInt(1));
                ncc.setTenNhacc(rs.getString(2));
                ncc.setDienThoai(rs.getString(3));
                ncc.setDiaChi(rs.getString(4));
               
                dsNHACC.add(ncc);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsNHACC;
       
    }
    
    
    
     public static boolean themNHACC (NHACC ncc) throws SQLException {
        boolean kq = false;
        String sql = String.format("INSERT INTO NHACC(TENNCC,DIACHI,DIENTHOAI)" 
        + " VALUES(N'" + ncc.getTenNhacc()+ "',N'" +ncc.getDiaChi()+"','"+ncc.getDienThoai()+"')");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        
        int n = provider.executeUpdate(sql);
        if (n==1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static boolean xoaNHACC (String maNCC) throws SQLException {
        boolean kq = false;
        String sql = String.format("DELETE FROM NHACC WHERE MANCC = " + maNCC + "");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static boolean capNhatNCC (NHACC ncc) throws SQLException {
        boolean kq = false;
        
        String sql = String.format("UPDATE NHACC SET"
                        + " TENNCC = N'"+ncc.getTenNhacc()+"', DIACHI = N'"+ncc.getDiaChi()+"', DIENTHOAI = '"+ncc.getDienThoai()
                        + "' WHERE MANCC= "+ncc.getMaNhacc());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
    
    public static NHACC layNCC (int maNCC) {
        NHACC ncc = null;
        try{
            String sql = "SELECT * FROM NHACC WHERE MANCC =" + maNCC;
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            
            if (rs.next()) {
                ncc = new NHACC();
                ncc.setMaNhacc(rs.getInt(1));
                ncc.setTenNhacc(rs.getString(2));
                ncc.setDiaChi(rs.getString(3));
                ncc.setDienThoai(rs.getString(4));
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return ncc;
    }
    
    
}
