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
public class Author {
    private String authorID;
    private String authorName;
    private String authorAddress;

    public Author(String authorID, String authorName, String authorAddress) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.authorAddress = authorAddress;
    }

    public String getAu_id() {
        return authorID;
    }

    public void setAu_id(String authorID) {
        this.authorID = authorID;
    }

    public String getAu_name() {
        return authorName;
    }

    public void setAu_name(String authorName) {
        this.authorName = authorName;
    }

    public String getAu_address() {
        return authorAddress;
    }

    public void setAu_address(String authorAddress) {
        this.authorAddress = authorAddress;
    }
    
    
}
