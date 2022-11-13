package com.utkarsh.projects.userreg.util;

public class CommonUtil {
    public static boolean validateEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
