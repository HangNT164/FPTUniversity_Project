/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ICommonDao;
import dao.RoleDao;
import entity.Role;
import java.util.List;

/**
 *
 * @author HangNT
 */
public class RoleService implements ICommonService<Role> {

    ICommonDao<Role> commonDao = new RoleDao();

    @Override
    public List<Role> getAll() {
        return commonDao.getAll();
    }

    @Override
    public Role getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(Role obj) {
        return commonDao.add(obj);
    }

    @Override
    public boolean update(int id, Role obj) {
        return commonDao.update(id, obj);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }

}
