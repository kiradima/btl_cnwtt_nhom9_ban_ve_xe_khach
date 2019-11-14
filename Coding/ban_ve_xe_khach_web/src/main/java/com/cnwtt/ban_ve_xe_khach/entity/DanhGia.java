package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name = "danhgia")
public class DanhGia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String noiDung;
    private Integer idUser;
    private Integer idChuyenXe;
    private Integer sao;

    public DanhGia(String noiDung, Integer idUser, Integer idChuyenXe, Integer sao) {
        this.noiDung = noiDung;
        this.idUser = idUser;
        this.idChuyenXe = idChuyenXe;
        this.sao = sao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(Integer idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }

    public Integer getSao() {
        return sao;
    }

    public void setSao(Integer sao) {
        this.sao = sao;
    }
}
