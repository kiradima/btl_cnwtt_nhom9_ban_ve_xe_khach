package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idOrder;
    private Integer idVe;
    private Integer idDiemDon;
    private Integer idDiemDung;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdOder() {
        return idOrder;
    }

    public void setIdOder(Integer idOder) {
        this.idOrder = idOder;
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
