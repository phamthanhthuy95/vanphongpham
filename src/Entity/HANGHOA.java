/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Douers
 */
public class HANGHOA {
    private int MAHANG;
    private String TENHANG;
    private int SOLUONG;
    private double DONGIANHAP;
    private double DONGIAXUAT;
    private String ANH;
    private String GHICHU;
    private String LOAI;
    private String NHACC;

    public HANGHOA(){
        
    }
    
    public HANGHOA(int MAHANG, String TENHANG, int SOLUONG, double DONGIANHAP, double DONGIAXUAT, String ANH, String GHICHU, String LOAI, String NHACC) {
        this.MAHANG = MAHANG;
        this.TENHANG = TENHANG;
        this.SOLUONG = SOLUONG;
        this.DONGIANHAP = DONGIANHAP;
        this.DONGIAXUAT = DONGIAXUAT;
        this.ANH = ANH;
        this.GHICHU = GHICHU;
        this.LOAI = LOAI;
        this.NHACC=NHACC;
    }

    public String getNHACC() {
        return NHACC;
    }

    public void setNHACC(String NHACC) {
        this.NHACC = NHACC;
    }

    public int getMAHANG() {
        return MAHANG;
    }

    public void setMAHANG(int MAHANG) {
        this.MAHANG = MAHANG;
    }

    public String getTENHANG() {
        return TENHANG;
    }

    public void setTENHANG(String TENHANG) {
        this.TENHANG = TENHANG;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public double getDONGIANHAP() {
        return DONGIANHAP;
    }

    public void setDONGIANHAP(double DONGIANHAP) {
        this.DONGIANHAP = DONGIANHAP;
    }

    public double getDONGIAXUAT() {
        return DONGIAXUAT;
    }

    public void setDONGIAXUAT(double DONGIAXUAT) {
        this.DONGIAXUAT = DONGIAXUAT;
    }

    public String getANH() {
        return ANH;
    }

    public void setANH(String ANH) {
        this.ANH = ANH;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }

    public String getLOAI() {
        return LOAI;
    }

    public void setLOAI(String LOAI) {
        this.LOAI = LOAI;
    }

    @Override
    public String toString() {
        return "HANGHOA{" + "MAHANG=" + MAHANG + ", TENHANG=" + TENHANG + ", SOLUONG=" + SOLUONG + ", DONGIANHAP=" + DONGIANHAP + ", DONGIAXUAT=" + DONGIAXUAT + ", ANH=" + ANH + ", GHICHU=" + GHICHU + ", LOAI=" + LOAI + ",NHACC=" + NHACC +'}';
    }
    
   
    
    
    
}
