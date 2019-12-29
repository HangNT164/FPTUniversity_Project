/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Order;

import dao.ICommonDao;
import dao.OrderCommonDao;
import dao.OrderDao;

import java.util.List;

/**
 *
 * @author HangNT
 */
public class OrderService implements ICommonService<Order>, OrderCommonService {

    ICommonDao<Order> commonDao = new OrderDao();
    OrderCommonDao orderCommonDao = new OrderDao();

    @Override
    public List<Order> getAll() {
        return commonDao.getAll();
    }

    @Override
    public Order getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(Order obj) {
        return commonDao.add(obj);
    }

    @Override
    public boolean update(int id, Order obj) {
        return commonDao.update(id, obj);
    }

    @Override
    public int addOrderReturnId(Order order) {
        return orderCommonDao.addOrderReturnId(order);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }

    @Override
    public boolean remove(int id) {
        return orderCommonDao.remove(id);
    }
}
