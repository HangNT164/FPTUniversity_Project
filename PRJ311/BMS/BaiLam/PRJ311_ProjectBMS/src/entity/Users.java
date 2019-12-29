/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author langt
 */
public class Users {
    private String userName;
    private String displayName;
    private String password;
    private String description;

    public Users(String userName, String displayName, String password, String description) {
        this.userName = userName;
        this.displayName = displayName;
        this.password = password;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }
    
    
}
