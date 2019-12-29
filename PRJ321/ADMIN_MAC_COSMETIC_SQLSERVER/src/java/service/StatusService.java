/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ICommonDao;
import dao.StatusDao;
import entity.Status;
import java.util.List;

/**
 *
 * @author HangNT
 */
public class StatusService implements ICommonService<Status> {

    ICommonDao<Status> commonDao = new StatusDao();

    @Override
    public List<Status> getAll() {
        return commonDao.getAll();
    }

    @Override
    public Status getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(Status obj) {
        return commonDao.add(obj);
    }

    @Override
    public boolean update(int id, Status obj) {
        return commonDao.update(id, obj);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }
}
