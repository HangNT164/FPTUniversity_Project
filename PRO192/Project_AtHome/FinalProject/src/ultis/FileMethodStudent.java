/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultis;

import entity.Student;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Desktop
 */
public class FileMethodStudent implements IFileMethod<Student> {

    @Override
    public ArrayList<Student> readDatatoFile(String fileName) {
        File file = new File(fileName);
        ArrayList<Student> list = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                list.add(new FileMethodStudent().getStudent(scan.nextLine())); // tung dong trong file
            }
            scan.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public void writeDataToFile(ArrayList<Student> list, String fileName) {
        File file = new File(fileName);
        try {
            if (!file.exists()) // neu file chua ton tai thi tao moi
            {
                file.createNewFile(); // tao luong moi
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile()); //tao chuan bi ghi vao file
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter) // mo luong du lieu
                    ) {
                for (Student s : list) {
                    bufferedWriter.write(s.display());
                    bufferedWriter.newLine();//de tao moi cai 1 dong , tao dong moi
                }
                // dong ko cho ghi nua , dong luong
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    // chuyen tu string (trong file )thanh object
    private Student getStudent(String s) {
        String[] str = s.split(" - ");
        boolean gender = true;
        if (str[1].equalsIgnoreCase("Female")) {
            gender = false;
        }
        return new Student(str[2], Double.valueOf(str[3]), str[0], gender);
    }
}
