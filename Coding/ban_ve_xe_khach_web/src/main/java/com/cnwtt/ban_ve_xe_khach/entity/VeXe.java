package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name = "ve_xe")
public class VeXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "muc_gia")
    private Float mucGia;
    @Column(name = "vi_tri_ghe")
    private Long viTriGhe;
    @Column(name = "id_chuyen_xe")
    private Long idChuyenXe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMucGia() {
        return mucGia;
    }

    public void setMucGia(Float mucGia) {
        this.mucGia = mucGia;
    }

    public Long getViTriGhe() {
        return viTriGhe;
    }

    public void setViTriGhe(Long viTriGhe) {
        this.viTriGhe = viTriGhe;
    }

    public Long getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(Long idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }
}
