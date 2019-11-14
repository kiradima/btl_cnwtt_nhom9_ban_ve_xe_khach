package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetail")
public class OrderDetail {
    private Integer idOder;
    private Integer idVe;
    private Integer idDiemDon;
    private Integer idDiemDung;

    public Integer getIdOder() {
        return idOder;
    }

    public void setIdOder(Integer idOder) {
        this.idOder = idOder;
    }

    public Integer getIdVe() {
        return idVe;
    }

    public void setIdVe(Integer idVe) {
        this.idVe = idVe;
    }

    public Integer getIdDiemDon() {
        return idDiemDon;
    }

    public void setIdDiemDon(Integer idDiemDon) {
        this.idDiemDon = idDiemDon;
    }

    public Integer getIdDiemDung() {
        return idDiemDung;
    }

    public void setIdDiemDung(Integer idDiemDung) {
        this.idDiemDung = idDiemDung;
    }
}
