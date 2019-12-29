/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author HangNT
 */
@Builder
@Getter
@Setter
@ToString
public class Card {

    private int id;
    private int orderID;
    private String productName;
    private String imageLink;
    private int sellPrice;
    private int orginPrice;

    private int productQuantity;
    private int quantity;
    private int totalPrice;
    private String createDate;
    private int statusCardID;
    private boolean deleted;

    /**
     * Change price with language =US
     *
     * @return new price
     */
    public double getChangePriceToUS() {
        return Math.round(this.sellPrice / 23);
    }

    /**
     * Change price with language =US
     *
     * @return new price
     */
    public double getChangePriceToJa() {
        return Math.round(this.sellPrice / 22);
    }

    /**
     * Change total price with language = US
     *
     * @return new price
     */
    public double getChangeTotalPriceToUS() {
        return Math.round(this.totalPrice / 23);
    }

    /**
     * Change total price with language = US
     *
     * @return new price
     */
    public double getChangeTotalPriceToJa() {
        return Math.round(this.totalPrice / 22);
    }
}
