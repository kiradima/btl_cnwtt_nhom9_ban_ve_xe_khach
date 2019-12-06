package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vi_tri_chuyen_xe")
public class ViTriChuyenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idViTri;
    private Integer idChuyenXe;
    private Date thoiDiemDuKien;
    private Integer type;

    public ViTriChuyenXe(Integer idViTri, Integer idChuyenXe, Date thoiDiemDuKien, Integer type) {
        this.idViTri = idViTri;
        this.idChuyenXe = idChuyenXe;
        this.thoiDiemDuKien = thoiDiemDuKien;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdViTri() {
        return idViTri;
    }

    public void setIdViTri(Integer idViTri) {
        this.idViTri = idViTri;
    }

    public Integer getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(Integer idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }

    public Date getThoiDiemDuKien() {
        return thoiDiemDuKien;
    }

    public void setThoiDiemDuKien(Date thoiDiemDuKien) {
        this.thoiDiemDuKien = thoiDiemDuKien;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
