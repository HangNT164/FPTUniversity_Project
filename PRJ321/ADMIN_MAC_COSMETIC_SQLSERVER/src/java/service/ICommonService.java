/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author HangNT
 * @param <T>
 */

//Toán tử kim cương <T> : tạo 1 cái đối tượng để đại diện cho những thằng truyền vào. 
public interface ICommonService<T> {
    List<T> getAll();
    
    
    T getOne(int id);
    
    boolean add(T obj);
    
    boolean update(int id, T obj);
    
    boolean delete(int id);
}
