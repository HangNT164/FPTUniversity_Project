/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.CustomerInfo;

/**
 *
 * @author HangNT
 */
public interface CustomerCommonDao {

    int addCustomerReturnId(CustomerInfo order);

    boolean remove(int id);
}
