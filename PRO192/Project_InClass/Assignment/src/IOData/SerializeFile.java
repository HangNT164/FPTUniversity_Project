/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author HANGNT
 */
public class SerializeFile {

    public boolean writeDataToFile(Object data, String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        try {
            try (FileOutputStream fos = new FileOutputStream(path);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(data);
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return false;
    }

    public Object readDataFromFile(String path) {
        try {
            Object data;
            try (FileInputStream fis = new FileInputStream(path);
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                data = ois.readObject();
            }
            return data;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
        return null;
    }
}