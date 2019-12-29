/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.StatusDao;
import entity.Status;

/**
 *
 * @author HangNT
 */
public class ProcessProduct {

    public static int getPrice(int productID, int sellPrice) {
        Status status = new StatusDao().getOneByProductID(productID);
        return sellPrice - sellPrice * status.getDescriptionStatus() / 100;
    }

    public static String getStatusProduct(int productID) {
        Status status = new StatusDao().getOneByProductID(productID);
        return status.getStatusName();
    }

    public static int getDescriptionProduct(int productID) {
        Status status = new StatusDao().getOneByProductID(productID);
        return status.getDescriptionStatus();
    }

    public static int getStatusID(int productID) {
        Status status = new StatusDao().getOneByProductID(productID);
        return status.getId();
    }

    public static String getStatusName(int productID) {
        Status status = new StatusDao().getOneByProductID(productID);
        return status.getStatusName();
    }
}
