package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "id_ve")
    private Integer idVe;
    @Column(name = "id_diem_don")
    private Integer idDiemDon;
    @Column(name = "id_diem_dung")
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
