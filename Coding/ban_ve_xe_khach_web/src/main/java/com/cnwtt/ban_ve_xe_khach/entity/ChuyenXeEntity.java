package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chuyen_xe")
public class ChuyenXeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String diemXuatPhat;
    private String diemKetThuc;

    private Date gioXuatPhat;
    private Date gioKetThuc;

    private String loaiXe;
    private String chinhSachHuyVe;
    private String luuY;
    private Integer idNhaXe;

    public ChuyenXeEntity(String diemXuatPhat, String diemKetThuc, Date gioXuatPhat, Date gioKetThuc, String loaiXe, String chinhSachHuyVe, String luuY, Integer idNhaXe) {
        this.diemXuatPhat = diemXuatPhat;
        this.diemKetThuc = diemKetThuc;
        this.gioXuatPhat = gioXuatPhat;
        this.gioKetThuc = gioKetThuc;
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

    public String getDiemXuatPhat() {
        return diemXuatPhat;
    }

    public void setDiemXuatPhat(String diemXuatPhat) {
        this.diemXuatPhat = diemXuatPhat;
    }

    public String getDiemKetThuc() {
        return diemKetThuc;
    }

    public void setDiemKetThuc(String diemKetThuc) {
        this.diemKetThuc = diemKetThuc;
    }

    public Date getGioXuatPhat() {
        return gioXuatPhat;
    }

    public void setGioXuatPhat(Date gioXuatPhat) {
        this.gioXuatPhat = gioXuatPhat;
    }

    public Date getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(Date gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
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
