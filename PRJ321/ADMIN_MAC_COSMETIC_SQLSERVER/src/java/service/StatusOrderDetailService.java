/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ICommonDao;
import dao.StatusOrderDetailDao;
import entity.StatusOrderDetail;
import java.util.List;

/**
 *
 * @author HangNT
 */
public class StatusOrderDetailService implements ICommonService<StatusOrderDetail>{

    ICommonDao<StatusOrderDetail>commonDao=new StatusOrderDetailDao();
    @Override
    public List<StatusOrderDetail> getAll() {
        return commonDao.getAll();
    }

    @Override
    public StatusOrderDetail getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(StatusOrderDetail obj) {
        return commonDao.add(obj);
    }

    @Override
    public boolean update(int id, StatusOrderDetail obj) {
        return commonDao.update(id, obj);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }
    
}
