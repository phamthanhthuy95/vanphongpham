/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Douers
 */
public class HOADON_CT {
    private String MaHoDon;
    private int MaHang;
    private int SoLuong;
    private double DonGia;
    private double GiamGia;
    private double ThanhTien;

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    public HOADON_CT(){
        
    }

    public HOADON_CT( String MaHoDon, int MaHang, int SoLuong, double DonGia, double GiamGia, double ThanhTien) {
        this.MaHoDon = MaHoDon;
        this.MaHang = MaHang;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.GiamGia = GiamGia;
        this.ThanhTien = ThanhTien;
    }



    
    public String getMaHoDon() {
        return MaHoDon;
    }

    public void setMaHoDon(String MaHoDon) {
        this.MaHoDon = MaHoDon;
    }

    public int getMaHang() {
        return MaHang;
    }

    public void setMaHang(int MaHang) {
        this.MaHang = MaHang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public double getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(double GiamGia) {
        this.GiamGia = GiamGia;
    }

    @Override
    public String toString() {
        return "HOADON_CT{" + "MaHoDon=" + MaHoDon + ", MaHang=" + MaHang + ", SoLuong=" + SoLuong + ", DonGia=" + DonGia + ", GiamGia=" + GiamGia + '}';
    }
    
    
}
