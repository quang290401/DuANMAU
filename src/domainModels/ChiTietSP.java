/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

import java.math.BigDecimal;

/**
 *
 * @author forre
 */
public class ChiTietSP {
    private String id;
    private String idSp;
    private String idNsx;
    private String idMS;
    private String idDongSP;
    private int namBH;
    private String moTa;
    private int soLgTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(String idSp, String idNsx, String idMS, String idDongSP, int namBH, String moTa, int soLgTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.idSp = idSp;
        this.idNsx = idNsx;
        this.idMS = idMS;
        this.idDongSP = idDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLgTon = soLgTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getIdNsx() {
        return idNsx;
    }

    public void setIdNsx(String idNsx) {
        this.idNsx = idNsx;
    }

    public String getIdMS() {
        return idMS;
    }

    public void setIdMS(String idMS) {
        this.idMS = idMS;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLgTon() {
        return soLgTon;
    }

    public void setSoLgTon(int soLgTon) {
        this.soLgTon = soLgTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }
    
    
    
}
