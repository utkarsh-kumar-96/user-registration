package com.utkarsh.projects.userreg.enums;

public enum AppUserRole {
    USER(0, "user"),
    ADMIN(1, "admin");
    private int type;
    private String value;

    AppUserRole(int type, String value) {
        this.type = type;
        this.value = value;
    }
}
