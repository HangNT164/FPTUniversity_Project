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
public class Authors {

    private String au_id;
    private String au_name;
    private String address;

    public Authors() {
    }

    public Authors(String au_id, String au_name, String address) {
        this.au_id = au_id;
        this.au_name = au_name;
        this.address = address;
    }

    public String getAu_id() {
        return au_id;
    }

    public void setAu_id(String au_id) {
        this.au_id = au_id;
    }

    public String getAu_name() {
        return au_name;
    }

    public void setAu_name(String au_name) {
        this.au_name = au_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
