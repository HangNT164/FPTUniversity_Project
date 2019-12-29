/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Card;
import entity.OrderDetail;

import dao.ICommonDao;
import dao.OrderDetailCommonDao;
import dao.OrderDetailDao;

import java.util.List;

/**
 *
 * @author HangNT
 */
public class OrderDetailService implements ICommonService<OrderDetail>, OrderDetailCommonService {

    ICommonDao<OrderDetail> commonDao = new OrderDetailDao();
    OrderDetailCommonDao orderDetailCommonDao = new OrderDetailDao();

    @Override
    public List<OrderDetail> getAll() {
        return commonDao.getAll();
    }

    @Override
    public OrderDetail getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(OrderDetail obj) {
        return commonDao.add(obj);
    }

    @Override
    public boolean update(int id, OrderDetail obj) {
        return commonDao.update(id, obj);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }

    @Override
    public boolean addListCard(List<Card> list, int orderID) {
        return orderDetailCommonDao.addListCard(list, orderID);
    }

    @Override
    public OrderDetail getOrderDetailByOrder(int id) {
        return orderDetailCommonDao.getOrderDetailByOrder(id);
    }
}
