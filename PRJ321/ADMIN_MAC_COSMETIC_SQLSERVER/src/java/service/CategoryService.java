/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Category;

import dao.CategoryDao;
import dao.ICommonDao;

import java.util.List;

/**
 *
 * @author HangNT
 */
public class CategoryService implements ICommonService<Category> {

    ICommonDao<Category> commonDao = new CategoryDao();

    @Override
    public List<Category> getAll() {
        return commonDao.getAll();
    }

    @Override
    public Category getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(Category category) {
        return commonDao.add(category);
    }

    @Override
    public boolean update(int id, Category category) {
        return commonDao.update(id, category);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }
}
