/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Product;
import entity.SubCate;

import dao.ICommonDao;
import dao.ProductCommonDao;
import dao.ProductDao;

import java.util.List;

/**
 *
 * @author HangNT
 */
public class ProductService implements ICommonService<Product>, ProductCommonService {

    ICommonDao<Product> commonDao = new ProductDao();
    ProductCommonDao productCommonDao = new ProductDao();

    @Override
    public List<Product> getAll() {
        return commonDao.getAll();
    }

    @Override
    public Product getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(Product product) {
        return commonDao.add(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return commonDao.update(id, product);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }

    @Override
    public List<Product> listProductBySubId(List<SubCate> listSubCates, List<Product> listProduct, int subID) {
        return productCommonDao.listProductBySubId(listSubCates, listProduct, subID);
    }

    @Override
    public List<Product> listProductInOnePageInAll(int page, int numberInAPage) {
        return productCommonDao.listProductInOnePageInAll(page, numberInAPage);
    }

    @Override
    public List<Product> listProductInOnePageInSubCategory(int page, int numberInAPage, int subCateID) {
        return productCommonDao.listProductInOnePageInSubCategory(page, numberInAPage, subCateID);
    }

    @Override
    public List<Integer> getListPage(List<Product> listProduct, int number) {
        return productCommonDao.getListPage(listProduct, number);
    }

    @Override
    public List<Product> getAllNewProduct() {
        return productCommonDao.getAllNewProduct();
    }

    @Override
    public List<Product> getListProductNew(int page, int numberInAPage) {
        return productCommonDao.getListProductNew(page, numberInAPage);
    }

    @Override
    public List<Product> getListBuyMuch(int page, int numberInAPage) {
        return productCommonDao.getListBuyMuch(page, numberInAPage);
    }

    @Override
    public boolean updateQuantity(int id, int newQuantity) {
        return productCommonDao.updateQuantity(id, newQuantity);
    }

    @Override
    public boolean updateTypeProduct(int id) {
        return productCommonDao.updateTypeProduct(id);
    }

    @Override
    public List<Product> search(String text) {
        return productCommonDao.search(text);
    }

    @Override
    public List<Product> getListProductSearch(int page, int numberInAPage, String text) {
        return productCommonDao.getListProductSearch(page, numberInAPage, text);
    }

    @Override
    public List<Product> getAllBuyMax() {
        return productCommonDao.getAllBuyMax();
    }
}
