/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.AccountDetail;

/**
 *
 * @author HangNT
 */
public interface AccountDetailCommonDao {

    int addAccountDetailReturnId(AccountDetail user);

    boolean remove(int id);
}
