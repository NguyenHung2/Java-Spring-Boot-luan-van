package com.api.TravelOptima.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maBaiViet;

    private String tieuDe;

    @Lob
    private String tomTat;

    @Lob
    private String noiDung;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;

    @ManyToOne
    @JoinColumn(name = "maLoai")
    private PostCategory loai;

    public Post() {
        // Constructor mặc định
    }

    public Post(String tieuDe, String tomTat, String noiDung, Date ngayTao, PostCategory loai) {
        this.tieuDe = tieuDe;
        this.tomTat = tomTat;
        this.noiDung = noiDung;
        this.ngayTao = ngayTao;
        this.loai = loai;
    }

    public Long getMaBaiViet() {
        return maBaiViet;
    }

    public void setMaBaiViet(Long maBaiViet) {
        this.maBaiViet = maBaiViet;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public PostCategory getLoai() {
        return loai;
    }

    public void setLoai(PostCategory loai) {
        this.loai = loai;
    }
}
