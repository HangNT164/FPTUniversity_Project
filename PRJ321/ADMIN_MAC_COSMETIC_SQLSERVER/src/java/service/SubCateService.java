/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.SubCate;

import dao.ICommonDao;
import dao.SubCateDao;

import java.util.List;

/**
 *
 * @author HangNT
 */
public class SubCateService implements ICommonService<SubCate> {

    ICommonDao<SubCate> commonDao = new SubCateDao();

    @Override
    public List<SubCate> getAll() {
        return commonDao.getAll();
    }

    @Override
    public SubCate getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(SubCate subCate) {
        return commonDao.add(subCate);
    }

    @Override
    public boolean update(int id, SubCate subCate) {
        return commonDao.update(id, subCate);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }
}
