package com.quanlysieuthi.quanlysieuthimini.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "NhaCungCap")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NhaCungCap {
    @Id
    @Column(name = "maNhaCungCap", nullable = false, unique = true)
    private String maNhaCungCap;

    private String tenNhaCungCap;
    private String soDienThoai;
    private String email;
    private String diaChi;

}

