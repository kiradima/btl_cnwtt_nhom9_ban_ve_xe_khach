package com.cnwtt.ban_ve_xe_khach.api.response.trangchu;

import com.cnwtt.ban_ve_xe_khach.entity.VeXe;

import java.util.List;

public class GetDetailChuyenXeResponse {
    private List<String> listViTriGheOrdered;
    private boolean isTwoFloors;
    private List<VeXe> veXes;

    public GetDetailChuyenXeResponse(List<String> listViTriGheOrdered, boolean isTwoFloors, List<VeXe> veXes) {
        this.listViTriGheOrdered = listViTriGheOrdered;
        this.isTwoFloors = isTwoFloors;
        this.veXes = veXes;
    }

    public GetDetailChuyenXeResponse() {
    }

    public List<VeXe> getVeXes() {
        return veXes;
    }

    public void setVeXes(List<VeXe> veXes) {
        this.veXes = veXes;
    }

    public List<String> getListViTriGheOrdered() {
        return listViTriGheOrdered;
    }

    public void setListViTriGheOrdered(List<String> listViTriGheOrdered) {
        this.listViTriGheOrdered = listViTriGheOrdered;
    }

    public boolean isTwoFloors() {
        return isTwoFloors;
    }

    public void setTwoFloors(boolean twoFloors) {
        isTwoFloors = twoFloors;
    }
}
