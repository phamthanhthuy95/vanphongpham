/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.SQLServerProvider;
import Entity.LOAI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Douers
 */
public class DAO_LOAI {
    
    
    
    
    
    public static ArrayList<LOAI> getLOAI(){
        ArrayList<LOAI> lst = new ArrayList<>();
        
        String queryLoad = "  SELECT * FROM LOAI ";
        try{
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(queryLoad);
            while(rs.next()){
                lst.add(new LOAI(rs.getInt(1),
                                 rs.getString(2)));
            }
            provider.close();
        }catch(Exception e){
            
        }
        
        return lst;
    }
    
    public static ArrayList<LOAI> timKiemLOAITheoTen(String tenHH) {
        ArrayList<LOAI> dsHH = new ArrayList<LOAI>();
        try{
            String sql = "  SELECT * "
                            + "  FROM LOAI "
                            + "  WHERE TENLOAI LIKE N'%" + tenHH + "%'";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                LOAI hh = new LOAI();
                hh.setMaLoai(rs.getInt(1));
                hh.setTenLoai(rs.getString(2));


                dsHH.add(hh);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsHH;
    }

    public static boolean themLOAI(LOAI hh) throws SQLException {
        boolean kq = false;
        String sql = String.format("INSERT INTO LOAI( TENLOAI )" 
                                    + "VALUES (N'"+hh.getTenLoai()+"')");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        
        int n = provider.executeUpdate(sql);
        if (n==1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }

    public static boolean xoaLOAI(String mahh) throws SQLException {
        boolean kq = false;
        String sql = String.format("DELETE FROM LOAI WHERE MALOAI = " + mahh + "");
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }

    public static boolean capNhatLOAI(LOAI hh) throws SQLException {
        boolean kq = false;
        
        String sql = String.format("UPDATE LOAI SET "
                        + " TENLOAI = N'"+hh.getTenLoai()
                        + "' WHERE MALOAI= "+hh.getMaLoai());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        
        if (n == 1) {
            kq = true;
        }
        provider.close();
        
        return kq;
    }
}
