/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Image;
import entity.Product;

import java.util.List;

/**
 *
 * @author HangNT
 */
public interface ImageCommonService {

    List<String> getAllImageTrue(List<Product> lists);

    List<String> getAllImageFalse(List<Product> lists);

    List<Image> listAllImageByProductId(int productID);

    Image getImageCover(int id);

}
