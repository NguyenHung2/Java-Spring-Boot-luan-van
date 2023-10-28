package com.api.TravelOptima.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maAnh")
    private Long maAnh;

    @Column(name = "tenAnh")
    private String tenAnh;

    @Column(name = "duongDan")
    private String duongDan;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngayTao")
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "maDiemDen")
    private Destination diemDen;

    @ManyToOne
    @JoinColumn(name = "maBaiViet")
    private Post baiViet;

    // Constructors
    public Image() {
    }

    public Image(String tenAnh, String duongDan, Date ngayTao, Destination diemDen, Post baiViet) {
        this.tenAnh = tenAnh;
        this.duongDan = duongDan;
        this.ngayTao = ngayTao;
        this.diemDen = diemDen;
        this.baiViet = baiViet;
    }

    // Getters and setters
    public Long getMaAnh() {
        return maAnh;
    }

    public void setMaAnh(Long maAnh) {
        this.maAnh = maAnh;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Destination getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(Destination diemDen) {
        this.diemDen = diemDen;
    }

    public Post getBaiViet() {
        return baiViet;
    }

    public void setBaiViet(Post baiViet) {
        this.baiViet = baiViet;
    }
}