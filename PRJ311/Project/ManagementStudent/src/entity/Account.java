/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author HangNT
 */
public class Account {

    private int id;
    private String userName;
    private String password;
    private int type;
    private int status;

    public Account() {
    }

    public Account(String userName, String password, int type, int status) {
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    public Account(int id, String userName, String password, int type, int status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.userName + " - " + this.password + " - " + this.type + " - " + this.status;
    }

}
