package com.techvify.loginBasic.dto;

public class UserDTO {

    private short id;
    private String username;
    private String password;

    public UserDTO(short id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
