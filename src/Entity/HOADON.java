/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Douers
 */
public class HOADON {
    private String MaHoaDon;
    private String NgayBan;
    private int MaNhanVien;
    private int MaKhachHang;
    private int  TongTien;
    public HOADON(){
        
    }

    public HOADON(String MaHoaDon, String NgayBan, int MaNhanVien, int MaKhachHang, int  TongTien) {
        this.MaHoaDon = MaHoaDon;
        this.NgayBan = NgayBan;
        this.MaNhanVien = MaNhanVien;
        this.MaKhachHang = MaKhachHang;
        this.TongTien=TongTien;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(String NgayBan) {
        this.NgayBan = NgayBan;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    @Override
    public String toString() {
        return "HOADON{" + "MaHoaDon=" + MaHoaDon + ", NgayBan=" + NgayBan + ", MaNhanVien=" + MaNhanVien + ", MaKhachHang=" + MaKhachHang + '}';
    }
    
}
