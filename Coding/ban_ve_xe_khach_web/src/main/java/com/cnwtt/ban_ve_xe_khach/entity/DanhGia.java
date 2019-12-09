package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name = "danh_gia")
public class DanhGia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "noi_dung")
    private String noiDung;
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "id_chuyen_xe")
    private Integer idChuyenXe;
    @Column(name = "sao")
    private Integer sao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
