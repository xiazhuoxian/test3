package com.test3.pojo;

public class user {
    private int id;
    private String username;
    private String password;
    private int sex;

    public user(int id) {
        this.id = id;
    }

    public user() {

    }

    public user(int id, String username, String password, int sex) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
