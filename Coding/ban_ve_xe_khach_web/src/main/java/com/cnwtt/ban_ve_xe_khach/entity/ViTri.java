package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name = "vitri")
public class ViTri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String viTri;

    public ViTri(String viTri) {
        this.viTri = viTri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
}
