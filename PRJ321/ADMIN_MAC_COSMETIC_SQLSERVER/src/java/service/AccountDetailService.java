/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDetailCommonDao;
import dao.AccountDetailDao;
import dao.ICommonDao;
import entity.AccountDetail;
import java.util.List;

/**
 *
 * @author HangNT
 */
public class AccountDetailService implements ICommonService<AccountDetail>, AccountDetailCommonService {

    ICommonDao<AccountDetail> commonDao = new AccountDetailDao();
    AccountDetailCommonDao userCommon = new AccountDetailDao();

    @Override
    public List<AccountDetail> getAll() {
        return commonDao.getAll();
    }

    @Override
    public AccountDetail getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(AccountDetail obj) {
        return commonDao.add(obj);
    }

    @Override
    public boolean update(int id, AccountDetail obj) {
        return commonDao.update(id, obj);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }

    @Override
    public int addAccountDetailReturnId(AccountDetail user) {
        return userCommon.addAccountDetailReturnId(user);
    }

    @Override
    public boolean remove(int id) {
        return userCommon.remove(id);
    }
}
