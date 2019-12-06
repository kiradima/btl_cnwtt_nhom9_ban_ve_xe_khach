package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name="ve_xe")
public class VeXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float mucGia;
    private Integer viTriGhe;
    private Integer idChuyenXe;

    public VeXe(Float mucGia, Integer viTriGhe, Integer idChuyenXe) {
        this.mucGia = mucGia;
        this.viTriGhe = viTriGhe;
        this.idChuyenXe = idChuyenXe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMucGia() {
        return mucGia;
    }

    public void setMucGia(Float mucGia) {
        this.mucGia = mucGia;
    }

    public Integer getViTriGhe() {
        return viTriGhe;
    }

    public void setViTriGhe(Integer viTriGhe) {
        this.viTriGhe = viTriGhe;
    }

    public Integer getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(Integer idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }
}
