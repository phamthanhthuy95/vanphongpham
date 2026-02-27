/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Douers
 */
public class KHACHHANG {
    private int MaKhachHang;
    private String TenKhachHang;
    private String DienThoai;
    private String DiaChi;
    
    public KHACHHANG(){
        
    }

    public KHACHHANG(int MaKhachHang, String TenKhachHang, String DienThoai, String DiaChi) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    @Override
    public String toString() {
        return "KHACHHANG{" + "MaKhachHang=" + MaKhachHang + ", TenKhachHang=" + TenKhachHang + ", DiaChi=" + DiaChi + ", DienThoai=" + DienThoai + '}';
    }
    
    
}
