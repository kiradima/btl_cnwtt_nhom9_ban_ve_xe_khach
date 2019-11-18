package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chuyenxe")
public class ChuyenXe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String loaiXe;
    private String chinhSachHuyVe;
    private String luuY;
    private Integer idNhaXe;

    public ChuyenXe(String loaiXe, String chinhSachHuyVe, String luuY, Integer idNhaXe) {
        this.loaiXe = loaiXe;
        this.chinhSachHuyVe = chinhSachHuyVe;
        this.luuY = luuY;
        this.idNhaXe = idNhaXe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getChinhSachHuyVe() {
        return chinhSachHuyVe;
    }

    public void setChinhSachHuyVe(String chinhSachHuyVe) {
        this.chinhSachHuyVe = chinhSachHuyVe;
    }

    public String getLuuY() {
        return luuY;
    }

    public void setLuuY(String luuY) {
        this.luuY = luuY;
    }

    public Integer getIdNhaXe() {
        return idNhaXe;
    }

    public void setIdNhaXe(Integer idNhaXe) {
        this.idNhaXe = idNhaXe;
    }
}
