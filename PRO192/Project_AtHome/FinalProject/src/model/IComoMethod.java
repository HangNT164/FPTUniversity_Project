package model;

import java.util.ArrayList;

public interface IComoMethod<T> {

    boolean add(ArrayList<T> list, T obj);

    boolean delete(ArrayList<T> list, String rollNumber);

    boolean update(ArrayList<T> list, String rollnumber);

    int getIndex(ArrayList<T> list, String rollnumber);

    void display(ArrayList<T> list);

    ArrayList<T> search(ArrayList<T> list); //overload

    void sort(ArrayList<T> list);

    String inputName();

    String inputRollNumber();

    boolean isGender();

}
