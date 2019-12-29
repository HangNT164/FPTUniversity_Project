/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Card;

import java.util.List;

/**
 *
 * @author HangNT
 */
public class Validate {

    /**
     * Check validate with integer in url
     *
     * @param strID a string enter
     * @return type right of number enter
     */
    public static int getValidateID(String strID) {
        int number = -1;
        try {
            number = Integer.parseInt(strID.trim());
        } catch (NumberFormatException e) {
            e.printStackTrace(System.out);
        }
        return number;
    }

    /**
     * Update quantity with user want
     *
     * @param id id of product
     * @param quantity new quantity
     * @param items a list items choice
     */
    public static void update(int id, int quantity, List<Card> items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.get(i).setQuantity(quantity);
            }
        }
    }
}
