/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author HangNT
 */
public class Products implements Serializable{
    private static final long serialVersionUID = 1L;
    private String productName;
    private int productCode;
    private double price;

    public Products() {
    }

    public Products(String productName, int productCode, double price) {
        this.productName = productName;
        this.productCode = productCode;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String s = getProductName() + " - " + getProductCode() + " - " + getPrice();
        return s;
    }

}
