/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author HangNT
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
 
public class CopyImage {
 
    /**
     * copy folder
     * 
     * @param sourceFolder
     * @param targetFolder
     * @throws IOException
     */
    public static void copyFolder(File sourceFolder, File targetFolder) 
            throws IOException {
        // Check neu sourceFolder la mot thu muc hoac file
        // neu sourceFolder la file thi copy den thu muc dich
        if (sourceFolder.isDirectory()) {
            // Xac nhan neu targetFolder chua ton tai thi tao moi 
            if (!targetFolder.exists()) {
                targetFolder.mkdir();
                System.out.println("Thu muc da duoc tao " + targetFolder);
            }
            // Liet ke tat ca cac file va thu muc trong sourceFolder
            String files[] = sourceFolder.list();
            for (String file : files) {
                File srcFile = new File(sourceFolder, file);
                File tarFile = new File(targetFolder, file);
                // goi lai phuong thuc copyFolder
                copyFolder(srcFile, tarFile);
            }
        } else {
            // copy file tu thuc muc nguon den thu muc dich
            Files.copy(sourceFolder.toPath(), targetFolder.toPath(), 
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File da duoc copy " + targetFolder);
        }
    }
}