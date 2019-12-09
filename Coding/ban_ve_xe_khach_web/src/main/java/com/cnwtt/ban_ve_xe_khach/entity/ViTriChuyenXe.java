package com.cnwtt.ban_ve_xe_khach.entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vi_tri_chuyen_xe")
public class ViTriChuyenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_vi_tri")
    private Integer idViTri;
    @Column(name="id_chuyen_xe")
    private Long idChuyenXe;
    @Column(name = "thoi_diem_du_kien")
    private Date thoiDiemDuKien;
    @Column(name = "type")
    private Long type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdViTri() {
        return idViTri;
    }

    public void setIdViTri(Integer idViTri) {
        this.idViTri = idViTri;
    }

    public Long getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(Long idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }

    public Date getThoiDiemDuKien() {
        return thoiDiemDuKien;
    }

    public void setThoiDiemDuKien(Date thoiDiemDuKien) {
        this.thoiDiemDuKien = thoiDiemDuKien;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
