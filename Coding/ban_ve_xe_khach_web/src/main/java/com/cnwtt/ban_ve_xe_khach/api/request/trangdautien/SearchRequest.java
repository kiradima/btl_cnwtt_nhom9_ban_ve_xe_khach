package com.cnwtt.ban_ve_xe_khach.api.request.trangdautien;

public class SearchRequest {
    private String diemXuatPhat;
    private String diemDung;
    private String ngayXuatPhat;

    public SearchRequest(String diemXuatPhat, String diemDung, String ngayXuatPhat) {
        this.diemXuatPhat = diemXuatPhat;
        this.diemDung = diemDung;
        this.ngayXuatPhat = ngayXuatPhat;
    }

    public SearchRequest() {
    }

    public String getDiemXuatPhat() {
        return diemXuatPhat;
    }

    public void setDiemXuatPhat(String diemXuatPhat) {
        this.diemXuatPhat = diemXuatPhat;
    }

    public String getDiemDung() {
        return diemDung;
    }

    public void setDiemDung(String diemDung) {
        this.diemDung = diemDung;
    }

    public String getNgayXuatPhat() {
        return ngayXuatPhat;
    }

    public void setNgayXuatPhat(String ngayXuatPhat) {
        this.ngayXuatPhat = ngayXuatPhat;
    }
}
