package com.cnwtt.ban_ve_xe_khach.api.response.trangchu;

import java.util.List;

public class GetDetailChuyenXeResponse {
    private List<String> listViTriGheOrdered;
    private boolean isTwoFloors;

    public GetDetailChuyenXeResponse(List<String> listViTriGheOrdered, boolean isTwoFloors) {
        this.listViTriGheOrdered = listViTriGheOrdered;
        this.isTwoFloors = isTwoFloors;
    }

    public GetDetailChuyenXeResponse() {
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
