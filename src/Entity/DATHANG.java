/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ACER
 */
public class DATHANG {
     private String maDonDatHang;
    private String ngayDatHang;
    
    public DATHANG(){
        
    }
    
    public DATHANG(String maDonDatHang, String ngayDatHang) {
        this.maDonDatHang = maDonDatHang;
        this.ngayDatHang = ngayDatHang;
    }
    
    public String getMaDonDatHang() {
        return maDonDatHang;
    }

    public void setMaDonDatHang(String maDonDatHang) {
        this.maDonDatHang = maDonDatHang;
    }

    public String getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }
}
