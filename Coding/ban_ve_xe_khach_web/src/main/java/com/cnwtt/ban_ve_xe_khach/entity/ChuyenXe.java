package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name = "chuyen_xe")
public class ChuyenXe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="loai_xe")
    private String loaiXe;
    @Column(name="chinh_sach_huy_ve")
    private String chinhSachHuyVe;
    @Column(name="luu_y")
    private String luuY;
    @Column(name="id_nha_xe")
    private Integer idNhaXe;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
