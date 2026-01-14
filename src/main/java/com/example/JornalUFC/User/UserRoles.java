package com.example.JornalUFC.User;

public enum UserRoles {
    ADMIN("admin"),
    EDITOR("editor");

    private String role;

    UserRoles(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
