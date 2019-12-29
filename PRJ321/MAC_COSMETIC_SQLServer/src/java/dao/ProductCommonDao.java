/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import entity.SubCate;

import java.util.List;

/**
 *
 * @author HangNT
 */
public interface ProductCommonDao {

    List<Product> listProductBySubId(List<SubCate> listSubCates, List<Product> listProduct, int subID);

    List<Product> listProductInOnePageInAll(int page, int numberInAPage);

    List<Product> listProductInOnePageInSubCategory(int page, int numberInAPage, int subCateID);

    List<Integer> getListPage(List<Product> listProduct, int number);

    List<Product> getAllNewProduct();

    List<Product> getListProductNew(int page, int numberInAPage);

    List<Product> getListBuyMuch(int page, int numberInAPage);

    boolean updateQuantity(int id, int newQuantity);

    boolean updateTypeProduct(int id);

    List<Product> search(String text);

    List<Product> getListProductSearch(int page, int numberInAPage, String text);

    List<Product> getAllBuyMax();
}
