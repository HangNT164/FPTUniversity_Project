/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Card;
import entity.OrderDetail;

import java.util.List;

/**
 *
 * @author HangNT
 */
public interface OrderDetailCommonService {

    OrderDetail getOrderDetailByOrder(int id);

    boolean addListCard(List<Card> list, int orderID);
}
