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
public class Publishers {
    private String publishID;
    private String publishName;
    private String pubAddress;

    public Publishers(String publishID, String publishName, String pubAddress) {
        this.publishID = publishID;
        this.publishName = publishName;
        this.pubAddress = pubAddress;
    }

    public String getPublishID() {
        return publishID;
    }

    public void setPublishID(String publishID) {
        this.publishID = publishID;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getPubAddress() {
        return pubAddress;
    }

    public void setPubAddress(String pubAddress) {
        this.pubAddress = pubAddress;
    }
    
    
}
