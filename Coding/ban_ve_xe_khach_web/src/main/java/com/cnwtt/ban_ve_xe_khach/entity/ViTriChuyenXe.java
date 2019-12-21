package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name = "vi_tri_chuyen_xe")
public class ViTriChuyenXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_vi_tri")
    private int idViTri;
    @Column(name = "id_chuyen_xe")
    private int idChuyenXe;
    @Column(name = "thoi_diem_du_kien")
    private String thoiDiemDuKien;
    @Column(name = "type")
    private int type;

    public ViTriChuyenXe() {
    }

    public ViTriChuyenXe(int id, int idViTri, int idChuyenXe, String thoiDiemDuKien, int type){
        this.id = id;
        this.idViTri = idViTri;
        this.idChuyenXe = idChuyenXe;
        this.thoiDiemDuKien = thoiDiemDuKien;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdViTri() {
        return idViTri;
    }

    public void setIdViTri(int idViTri) {
        this.idViTri = idViTri;
    }

    public int getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(int idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }

    public String getThoiDiemDuKien() {
        return thoiDiemDuKien;
    }

    public void setThoiDiemDuKien(String thoiDiemDuKien) {
        this.thoiDiemDuKien = thoiDiemDuKien;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
