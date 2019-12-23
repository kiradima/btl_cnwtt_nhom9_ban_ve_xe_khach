package com.cnwtt.ban_ve_xe_khach.api.response.trangdautien;

import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXe;
import com.cnwtt.ban_ve_xe_khach.entity.ViTriChuyenXe;

import java.util.List;

public class SearchResponse {
    private ChuyenXe chuyenXe;
    private String tenNhaXe;
    private String tinhXuatPhat;
    private String tinhDung;
    private List<ViTriChuyenXe> viTriChuyenXesDi;
    private List<ViTriChuyenXe> viTriChuyenXesDung;
    private String soGheTrong;
    private String danhGiaSao;
    private String soBinhLuan;

    public SearchResponse(ChuyenXe chuyenXe, String tenNhaXe, String tinhXuatPhat, String tinhDung,
                          List<ViTriChuyenXe> viTriChuyenXesDi,
                          List<ViTriChuyenXe> viTriChuyenXesDung, String soGheTrong, String danhGiaSao, String soBinhLuan) {
        this.chuyenXe = chuyenXe;
        this.tenNhaXe = tenNhaXe;
        this.tinhXuatPhat = tinhXuatPhat;
        this.tinhDung = tinhDung;
        this.viTriChuyenXesDi = viTriChuyenXesDi;
        this.viTriChuyenXesDung = viTriChuyenXesDung;
        this.soGheTrong = soGheTrong;
        this.danhGiaSao = danhGiaSao;
        this.soBinhLuan = soBinhLuan;
    }

    public SearchResponse() {
    }

    public String getTinhXuatPhat() {
        return tinhXuatPhat;
    }

    public void setTinhXuatPhat(String tinhXuatPhat) {
        this.tinhXuatPhat = tinhXuatPhat;
    }

    public String getTinhDung() {
        return tinhDung;
    }

    public void setTinhDung(String tinhDung) {
        this.tinhDung = tinhDung;
    }

    public ChuyenXe getChuyenXe() {
        return chuyenXe;
    }

    public void setChuyenXe(ChuyenXe chuyenXe) {
        this.chuyenXe = chuyenXe;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }

    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }

    public List<ViTriChuyenXe> getViTriChuyenXesDi() {
        return viTriChuyenXesDi;
    }

    public void setViTriChuyenXesDi(List<ViTriChuyenXe> viTriChuyenXesDi) {
        this.viTriChuyenXesDi = viTriChuyenXesDi;
    }

    public List<ViTriChuyenXe> getViTriChuyenXesDung() {
        return viTriChuyenXesDung;
    }

    public void setViTriChuyenXesDung(List<ViTriChuyenXe> viTriChuyenXesDung) {
        this.viTriChuyenXesDung = viTriChuyenXesDung;
    }

    public String getSoGheTrong() {
        return soGheTrong;
    }

    public void setSoGheTrong(String soGheTrong) {
        this.soGheTrong = soGheTrong;
    }

    public String getDanhGiaSao() {
        return danhGiaSao;
    }

    public void setDanhGiaSao(String danhGiaSao) {
        this.danhGiaSao = danhGiaSao;
    }

    public String getSoBinhLuan() {
        return soBinhLuan;
    }

    public void setSoBinhLuan(String soBinhLuan) {
        this.soBinhLuan = soBinhLuan;
    }
}
