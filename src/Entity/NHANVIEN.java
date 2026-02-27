/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Douers
 */
public class NHANVIEN {
     private int MaNhanvien;
    private String TenNhanVien;
    private String GioiTinh;
    private String DiaChi;
    private String DienThoai;
    private String NgaySinh;
    private String AnhNhanVien;

    public int getMaNhanvien() {
        return MaNhanvien;
    }

    public void setMaNhanvien(int MaNhanvien) {
        this.MaNhanvien = MaNhanvien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
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

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getAnhNhanVien() {
        return AnhNhanVien;
    }

    public void setAnhNhanVien(String AnhNhanVien) {
        this.AnhNhanVien = AnhNhanVien;
    }

    public NHANVIEN(int MaNhanvien, String TenNhanVien, String GioiTinh, String DiaChi, String DienThoai, String NgaySinh, String AnhNhanVien) {
        this.MaNhanvien = MaNhanvien;
        this.TenNhanVien = TenNhanVien;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.NgaySinh = NgaySinh;
        this.AnhNhanVien = AnhNhanVien;
    }
    
    public NHANVIEN(){
        
    }

    

    @Override
    public String toString() {
        return "NHANVIEN{" + "MaNhanvien=" + MaNhanvien + ", TenNhanVien=" + TenNhanVien + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + ", DienThoai=" + DienThoai + ", NgaySinh=" + NgaySinh + ", AnhNhanVien=" + AnhNhanVien + '}';
    }
    
    
}
