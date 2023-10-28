package com.api.TravelOptima.entity;

import java.util.Date;

public class ImageRequestDTO {
    private String tenAnh;
    private String duongDan;
    private Date ngayTao;
    private Long maDiemDen;
    private Long maBaiViet;

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

    public Long getMaDiemDen() {
        return maDiemDen;
    }

    public void setMaDiemDen(Long maDiemDen) {
        this.maDiemDen = maDiemDen;
    }

    public Long getMaBaiViet() {
        return maBaiViet;
    }

    public void setMaBaiViet(Long maBaiViet) {
        this.maBaiViet = maBaiViet;
    }
}
