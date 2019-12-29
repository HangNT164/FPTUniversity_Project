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
public class Users {
    private String userName;
    private String displayName;
    private String password;
    private String description;

    public Users() {
    }

    public Users(String username,String displayName, String description) {
        this.displayName = displayName;
        this.userName = username;
        this.description = description;
    }

    public Users(String userName, String displayName, String password, String description) {
        this.userName = userName;
        this.displayName = displayName;
        this.password = password;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Users{" + "userName=" + userName + ", displayName=" + displayName + ", password=" + password + ", description=" + description + '}';
    }
    
}
