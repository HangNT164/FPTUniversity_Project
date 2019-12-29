/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HangNT
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String customerName;
    private int customerID;
    private boolean gender;
    private ArrayList<Invoice> listInvoice = new ArrayList<>();

    public Customer() {
    }

    public Customer(String customerName, int customerID, boolean gender) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.gender = gender;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public ArrayList<Invoice> getListInvoice() {
        return listInvoice;
    }

    public void setListInvoice(ArrayList<Invoice> listInvoice) {
        this.listInvoice = listInvoice;
    }

    @Override
    public String toString() {
        return this.customerName + " - " + (this.gender == false ? "female" : "male") + " - " + this.customerID;
    }

}
