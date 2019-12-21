package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name = "chuyen_xe")
public class ChuyenXe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "loai_xe")
    private String loaiXe;
    @Column(name = "chinh_sach_huy_ve")
    private String chinhSachHuyVe;
    @Column(name = "luu_y")
    private String luuY;
    @Column(name = "id_nha_xe")
    private int idNhaXe;
    @Column(name = "so_ghe")
    private int soGhe;
    @Column(name = "muc_gia")
    private float mucGia;

    public ChuyenXe(int id, String loaiXe, String chinhSachHuyVe,
                    String luuY, int idNhaXe, int soGhe, float mucGia) {
        this.id = id;
        this.loaiXe = loaiXe;
        this.chinhSachHuyVe = chinhSachHuyVe;
        this.luuY = luuY;
        this.idNhaXe = idNhaXe;
        this.soGhe = soGhe;
        this.mucGia = mucGia;
    }

    public ChuyenXe() {
    }

    public float getMucGia() {
        return mucGia;
    }

    public void setMucGia(float mucGia) {
        this.mucGia = mucGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getIdNhaXe() {
        return idNhaXe;
    }

    public void setIdNhaXe(int idNhaXe) {
        this.idNhaXe = idNhaXe;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
}
