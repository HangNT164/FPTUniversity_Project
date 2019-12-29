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
public class Publishers {

    private String pub_id;
    private String pub_name;
    private String pub_address;

    public Publishers() {
    }

    public Publishers(String pub_id, String pub_name, String pub_address) {
        this.pub_id = pub_id;
        this.pub_name = pub_name;
        this.pub_address = pub_address;
    }

    public String getPub_id() {
        return pub_id;
    }

    public void setPub_id(String pub_id) {
        this.pub_id = pub_id;
    }

    public String getPub_name() {
        return pub_name;
    }

    public void setPub_name(String pub_name) {
        this.pub_name = pub_name;
    }

    public String getPub_address() {
        return pub_address;
    }

    public void setPub_address(String pub_address) {
        this.pub_address = pub_address;
    }

}
