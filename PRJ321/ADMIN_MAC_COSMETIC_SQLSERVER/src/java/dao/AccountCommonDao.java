/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;

/**
 *
 * @author HangNT
 */
public interface AccountCommonDao {

    Account login(String name, String password);

    boolean isDulicapte(String name);

    Account getOneByAccountDetailID(int id);
}
