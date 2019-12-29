/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultis;

import java.util.ArrayList;

/**
 *
 * @author Desktop
 * @param <T>
 */
public interface IFileMethod<T> {

    ArrayList<T> readDatatoFile(String fileName);

    void writeDataToFile(ArrayList<T> obj, String fileName);
}
