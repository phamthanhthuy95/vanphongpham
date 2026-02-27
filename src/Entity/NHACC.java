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
public class NHACC {
     private int MaNhacc;
    private String TenNhacc;
    private String DienThoai;
    private String DiaChi;

    public NHACC() {
       
    }

    public int getMaNhacc() {
        return MaNhacc;
    }

    public void setMaNhacc(int MaNhacc) {
        this.MaNhacc = MaNhacc;
    }

    public String getTenNhacc() {
        return TenNhacc;
    }

    public void setTenNhacc(String TenNhacc) {
        this.TenNhacc = TenNhacc;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public NHACC(int MaNhacc, String TenNhacc, String DienThoai, String DiaChi) {
        this.MaNhacc = MaNhacc;
        this.TenNhacc = TenNhacc;
        this.DienThoai = DienThoai;
        this.DiaChi = DiaChi;
    }
    
    @Override
    public String toString() {
        return "NHACC{" + "MaNCC=" + MaNhacc + ", TenNCC=" + TenNhacc + ", DiaChi=" + DiaChi + ", DienThoai=" + DienThoai + '}';
    }
    
}
