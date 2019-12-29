/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.CustomerInfo;

import dao.CustomerInfoDao;
import dao.ICommonDao;

import java.util.List;

/**
 *
 * @author HangNT
 */
public class CustomerInfoService implements ICommonService<CustomerInfo>,CustomerCommonService {

    ICommonDao<CustomerInfo> commonDao = new CustomerInfoDao();
    CustomerInfoDao customerInfoCommonDao = new CustomerInfoDao();

    @Override
    public List<CustomerInfo> getAll() {
        return commonDao.getAll();
    }

    @Override
    public CustomerInfo getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(CustomerInfo obj) {
        return commonDao.add(obj);
    }

    @Override
    public boolean update(int id, CustomerInfo obj) {
        return commonDao.update(id, obj);
    }

    @Override
    public int addCustomerReturnId(CustomerInfo order) {
        return customerInfoCommonDao.addCustomerReturnId(order);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }

    @Override
    public boolean remove(int id) {
        return customerInfoCommonDao.remove(id);
    }
}
