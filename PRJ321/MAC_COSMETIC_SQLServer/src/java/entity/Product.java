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
import util.ProcessProduct;

/**
 *
 * @author HangNT
 */
@Builder
@Getter
@Setter
@ToString
public class Product {

    private int id;
    private int subCateID;
    private String productName;
    private String color;
    private int quantity;
    private int sellPrice;
    private int orginPrice;
    private String description;
    private String productCode;
    private String createDate;
    private boolean deleted;

    /**
     * Check product has color or not . If having to set color for product
     *
     * @return color
     */
    public String getTileColor() {
        return this.color.isEmpty() ? "" : "Màu:" + this.color;
    }

    /**
     * Change old price with language = US
     *
     * @return new price
     */
    public double getChangeOldPriceToUS() {
        return Math.round(this.sellPrice / 23);
    }

    /**
     * Change old price with language = US
     *
     * @return new price
     */
    public double getChangeOldPriceToJa() {
        return Math.round(this.sellPrice / 22);
    }

    /**
     * Get new price of product with sale =?
     *
     * @return new price after sale
     */
    public int getPriceNew() {
        return ProcessProduct.getPrice(id, sellPrice);
    }

    /**
     * Change new price with language = US
     *
     * @return new price
     */
    public double getChangeNewPriceToUS() {
        int newPrice = getPriceNew();
        return Math.round(newPrice / 23);
    }

    /**
     * Change new price with language = US
     *
     * @return new price
     */
    public double getChangeNewPriceToJa() {
        int newPrice = getPriceNew();
        return Math.round(newPrice / 22);
    }

    public String getDisplayStatus() {
        return ProcessProduct.getStatusProduct(id);
    }

    public int getDescriptionStatus() {
        return ProcessProduct.getDescriptionProduct(id);
    }

    /**
     * Compare price to set product has sale or not.
     *
     * @return number between two price
     */
    public int getComparePrice() {
        int priceNewTem = getPriceNew();
        return this.sellPrice - priceNewTem;
    }

    public int getStatusId() {
        return ProcessProduct.getStatusID(id);
    }
     public String getStatusName() {
        return ProcessProduct.getStatusName(id);
    }
}
