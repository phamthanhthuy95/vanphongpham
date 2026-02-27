/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class DATHANG_CT {
     private String maDonDatHang;
    private int maHangHoa;
    private int soLuong;
    private int ncc;
    
    public DATHANG_CT(){
        
    }

    public DATHANG_CT( String maDonDatHang, int maHangHoa, int soLuong, int ncc) {
        this.maDonDatHang = maDonDatHang;
        this.maHangHoa = maHangHoa;
        this.soLuong = soLuong;
        this.ncc = ncc;
    }

    public int getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(int maHangHoa) {
        this.maHangHoa = maHangHoa;
    }
    
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getNcc() {
        return ncc;
    }

    public void setNcc(int ncc) {
        this.ncc = ncc;
    }
 
    
    public String getMaDonDatHang() {
        return maDonDatHang;
    }

    public void setMaDonDatHang(String maDonDatHang) {
        this.maDonDatHang = maDonDatHang;
    }

    
}
