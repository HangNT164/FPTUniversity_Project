/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Image;
import entity.Product;

import dao.ICommonDao;
import dao.ImageCommonDao;
import dao.ImageDao;

import java.util.List;

/**
 *
 * @author HangNT
 */
public class ImageService implements ICommonService<Image>, ImageCommonService {

    ICommonDao<Image> commonDao = new ImageDao();
    ImageCommonDao imageCommonDao = new ImageDao();

    @Override
    public List<Image> getAll() {
        return commonDao.getAll();
    }

    @Override
    public Image getOne(int id) {
        return commonDao.getOne(id);
    }

    @Override
    public boolean add(Image image) {
        return commonDao.add(image);
    }

    @Override
    public boolean update(int id, Image image) {
        return commonDao.update(id, image);
    }

    @Override
    public boolean delete(int id) {
        return commonDao.delete(id);
    }

    @Override
    public List<String> getAllImageTrue(List<Product> lists) {
        return imageCommonDao.getAllImageTrue(lists);
    }

    @Override
    public List<String> getAllImageFalse(List<Product> lists) {
        return imageCommonDao.getAllImageFalse(lists);
    }

    @Override
    public List<Image> listAllImageByProductId(int productID) {
        return imageCommonDao.listAllImageByProductId(productID);
    }

    @Override
    public Image getImageCover(int id) {
        return imageCommonDao.getImageCover(id);
    }
}
