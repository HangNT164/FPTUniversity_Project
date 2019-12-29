/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultis;

import entity.Staff;
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
public class FileMethodStaff implements IFileMethod<Staff> {

    @Override
    public ArrayList<Staff> readDatatoFile(String fileName) {
        File file = new File(fileName);
        ArrayList<Staff> list = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                list.add(new FileMethodStaff().getStaff(scan.nextLine())); // tung dong trong file
            }
            scan.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public void writeDataToFile(ArrayList<Staff> list, String fileName) {
        File file = new File(fileName);
        try {
            if (!file.exists()) // neu file chua ton tai thi tao moi
            {
                file.createNewFile(); // tao luong moi
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile()); //tao chuan bi ghi vao file
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter) // mo luong du lieu
                    ) {
                for (Staff s : list) {
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
    private Staff getStaff(String s) {
        String[] str = s.split(" - ");
        boolean gender = true;
        if (str[1].equalsIgnoreCase("Female")) {
            gender = false;
        }
        return new Staff(str[2], Long.valueOf(str[3]), str[0], gender);
    }
}
