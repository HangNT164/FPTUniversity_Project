/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Account;

import dao.ICommonDao;
import dao.AccountDao;

import java.util.List;
import dao.AccountCommonDao;

/**
 *
 * @author HangNT
 */
public class AccountService implements ICommonService<Account>, AccountCommonService {

    ICommonDao<Account> commonDao = new AccountDao();
    AccountCommonDao userCommon = new AccountDao();

    @Override
    public List<Account> getAll() {
        return commonDao.getAll();
    }

    @Override
    public Account getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(Account obj) {
        return commonDao.add(obj);
    }

    @Override
    public boolean update(int id, Account obj) {
        return commonDao.update(id, obj);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }

    @Override
    public boolean isDulicapte(String email) {
        return userCommon.isDulicapte(email);
    }

    @Override
    public Account login(String email, String password) {
        return userCommon.login(email, password);
    }

    @Override
    public Account getOneByAccountDetailID(int id) {
        return userCommon.getOneByAccountDetailID(id);
    }
}
