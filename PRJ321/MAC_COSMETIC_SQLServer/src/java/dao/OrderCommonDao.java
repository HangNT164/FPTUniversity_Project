/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Order;

/**
 *
 * @author HangNT
 */
public interface OrderCommonDao {

    int addOrderReturnId(Order order);

    boolean remove(int id);
}
