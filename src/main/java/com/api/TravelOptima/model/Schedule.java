package com.api.TravelOptima.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLichTrinh")
    private Long maLichTrinh;

    @Column(name = "tenLichTrinh")
    private String tenLichTrinh;

    @Column(name = "moTa")
    private String moTa;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "thoiGianBatDau")
    private Date thoiGianBatDau;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "thoiGianKetThuc")
    private Date thoiGianKetThuc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "thuTu")
    private int thuTu;

    @Column(name = "soLuongDiemDenToiDa")
    private int soLuongDiemDenToiDa = 5;

    @Column(name = "diaDiemXuatPhat")
    private String diaDiemXuatPhat;

    @ManyToMany
    @JoinTable(
            name = "schedule_destinations", // Tên bảng trung gian trong cơ sở dữ liệu
            joinColumns = @JoinColumn(name = "maLichTrinh"), // Cột của bảng trung gian liên quan đến "maLichTrinh"
            inverseJoinColumns = @JoinColumn(name = "maDiemDen") // Cột của bảng trung gian liên quan đến "maDiemDen"
    )
    private List<Destination> danhSachDiemDen;

    // Constructors
    public Schedule() {
    }

    public Schedule(String tenLichTrinh, String moTa, Date thoiGianBatDau, Date thoiGianKetThuc, Date ngayTao, String trangThai, int thuTu, int soLuongDiemDenToiDa, String diaDiemXuatPhat) {
        this.tenLichTrinh = tenLichTrinh;
        this.moTa = moTa;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.thuTu = thuTu;
        this.soLuongDiemDenToiDa = soLuongDiemDenToiDa;
        this.diaDiemXuatPhat = diaDiemXuatPhat;
    }

    // Getters and setters
    public Long getMaLichTrinh() {
        return maLichTrinh;
    }

    public void setMaLichTrinh(Long maLichTrinh) {
        this.maLichTrinh = maLichTrinh;
    }

    public String getTenLichTrinh() {
        return tenLichTrinh;
    }

    public void setTenLichTrinh(String tenLichTrinh) {
        this.tenLichTrinh = tenLichTrinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getThuTu() {
        return thuTu;
    }

    public void setThuTu(int thuTu) {
        this.thuTu = thuTu;
    }

    public int getSoLuongDiemDenToiDa() {
        return soLuongDiemDenToiDa;
    }

    public void setSoLuongDiemDenToiDa(int soLuongDiemDenToiDa) {
        this.soLuongDiemDenToiDa = soLuongDiemDenToiDa;
    }

    public String getDiaDiemXuatPhat() {
        return diaDiemXuatPhat;
    }

    public void setDiaDiemXuatPhat(String diaDiemXuatPhat) {
        this.diaDiemXuatPhat = diaDiemXuatPhat;
    }

    public List<Destination> getDanhSachDiemDen() {
        return danhSachDiemDen;
    }

    public void setDanhSachDiemDen(List<Destination> danhSachDiemDen) {
        this.danhSachDiemDen = danhSachDiemDen;
    }
}
