package com.cnwtt.ban_ve_xe_khach.enums;

public enum Role {
    ADMIN("ADMIN"), USER("USER");
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Role(String name) {
        this.name = name;
    }

}
