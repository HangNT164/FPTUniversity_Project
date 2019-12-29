/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Order;

/**
 *
 * @author HangNT
 */
public interface OrderCommonService {

    int addOrderReturnId(Order order);

    boolean remove(int id);
}
