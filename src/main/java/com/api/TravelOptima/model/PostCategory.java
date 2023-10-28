package com.api.TravelOptima.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maLoai;
    private String tenLoai;

    public PostCategory() {
        // Constructor mặc định
    }

    public PostCategory(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    // Getter và Setter cho các thuộc tính
    public Long getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Long maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "PostCategory [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
    }
}
