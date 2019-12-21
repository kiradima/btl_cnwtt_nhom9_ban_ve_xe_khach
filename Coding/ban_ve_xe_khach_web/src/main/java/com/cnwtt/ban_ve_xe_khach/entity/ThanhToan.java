package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name = "thanh_toan")
public class ThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "so_luong_ve")
    private Long soLuongVe;
    @Column(name = "tong_tien")
    private Long tongTien;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "id_nha_xe")
    private Long idNhaXe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(Long soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public Long getTongTien() {
        return tongTien;
    }

    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getIdNhaXe() {
        return idNhaXe;
    }

    public void setIdNhaXe(Long idNhaXe) {
        this.idNhaXe = idNhaXe;
    }
}
