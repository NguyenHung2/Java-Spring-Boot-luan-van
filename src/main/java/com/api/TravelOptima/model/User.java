package com.api.TravelOptima.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNguoiDung")
    private Long maNguoiDung;

    @Column(name = "tenNguoiDung")
    private String tenNguoiDung;

    @Column(name = "email")
    private String email;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "vaiTro")
    private String vaiTro;

    @Column(name = "ngayDangKy")
    private Date ngayDangKy;

    // Nếu có nhiều đánh giá bởi người dùng, bạn có thể sử dụng mối quan hệ OneToMany

    // Constructors
    public User() {
    }

    public User(String tenNguoiDung, String email, String gioiTinh, String diaChi, Date ngaySinh, String matKhau, String vaiTro, Date ngayDangKy) {
        this.tenNguoiDung = tenNguoiDung;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.ngayDangKy = ngayDangKy;
    }

    // Getters and setters
    public Long getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(Long maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

}
