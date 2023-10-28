package com.api.TravelOptima.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDiemDen")
    private Long maDiemDen;

    @Column(name = "tenDiemDen")
    private String tenDiemDen;

    @Column(name = "kinhDo")
    private double kinhDo;

    @Column(name = "viDo")
    private double viDo;

    @Lob
    @Column(name = "moTa", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "diaChi")
    private String diaChi;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngayTao")
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "maDanhMuc")
    private DestinationCategory danhmuc;

    public Destination() {
        // Default constructor
    }

    public Destination(String tenDiemDen, double kinhDo, double viDo, String moTa, String diaChi, Date ngayTao, DestinationCategory danhmuc) {
        this.tenDiemDen = tenDiemDen;
        this.kinhDo = kinhDo;
        this.viDo = viDo;
        this.moTa = moTa;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.danhmuc = danhmuc;
    }

    public Long getMaDiemDen() {
        return maDiemDen;
    }

    public void setMaDiemDen(Long maDiemDen) {
        this.maDiemDen = maDiemDen;
    }

    public String getTenDiemDen() {
        return tenDiemDen;
    }

    public void setTenDiemDen(String tenDiemDen) {
        this.tenDiemDen = tenDiemDen;
    }

    public double getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(double kinhDo) {
        this.kinhDo = kinhDo;
    }

    public double getViDo() {
        return viDo;
    }

    public void setViDo(double viDo) {
        this.viDo = viDo;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public DestinationCategory getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(DestinationCategory danhmuc) {
        this.danhmuc = danhmuc;
    }
}
