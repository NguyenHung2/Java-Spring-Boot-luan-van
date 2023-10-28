package com.api.TravelOptima.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DestinationCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDanhMuc")
    private Long maDanhMuc;

    @Column(name = "tenDanhMuc")
    private String tenDanhMuc;

    // Constructors, getters, and setters

    public DestinationCategory() {
        // Default constructor
    }

    public DestinationCategory(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    // Getters and setters

    public Long getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(Long maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
}
