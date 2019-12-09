package com.cnwtt.ban_ve_xe_khach.entity;

import javax.persistence.*;

@Entity
@Table(name = "vi_tri")
public class ViTri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vi_tri")
    private String viTri;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
}
