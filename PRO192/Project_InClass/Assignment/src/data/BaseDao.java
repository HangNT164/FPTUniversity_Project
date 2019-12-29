/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author HangNT
 */
public abstract class BaseDao <T> implements IEntity {

    public abstract boolean add(ArrayList<T> list, T obj);

    public abstract boolean delete(ArrayList<T> list, int id);

    public abstract boolean update(ArrayList<T> list, int id);

    public abstract int getIndex(ArrayList<T> list, int id);

    public abstract void display(ArrayList<T> list);

    public abstract ArrayList<T> search(ArrayList<T> list);

    public abstract void sort(ArrayList<T> list);

    public abstract String inputName();
}
