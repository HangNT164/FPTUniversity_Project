/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Student;
import java.util.ArrayList;
import java.util.Scanner;
import model.StudentModel;
import ultis.FileMethodStudent;

/**
 *
 * @author Shado
 */
public class StudentMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int isContinue = 0;
        ArrayList<Student> listStudent = new ArrayList<>();
        StudentModel studentModel = new StudentModel();
        FileMethodStudent fileMethod = new FileMethodStudent();
        // start loop
        process:
        do {
            // menu student
            System.out.println("\n1. Data");
            System.out.println("2. Add new Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search ");
            System.out.println("6. Sort  ");
            System.out.println("7. Display Students");
            System.out.println("8. Save new list");
            System.out.println("9. Exit");
            System.out.print("\nYou choose: ");
            int choose = Integer.valueOf(scan.nextLine());

            System.out.println("- - - - - - - - - - - -");
            switch (choose) {
                case 1:
                    // tim file
                    System.out.println("\n1. Add new list");
                    System.out.println("2. Load file");
                    System.out.print("You choose: ");
                    int f1 = Integer.valueOf(scan.nextLine());
                    if (f1 == 1) {
                        System.out.println("Add new list sucess!!!");
                    } else {
                        System.out.print("Enter file name: ");
                        String fileName = scan.nextLine().trim();
                        listStudent = new FileMethodStudent().readDatatoFile(fileName);
                        // viet them check xem co file day hay ko
                        /*
                            list=null // tat ca cac obj luu vs contructor ko tg mac dinh la null
                            list=emtity // 
                         */

                        if (listStudent != null && listStudent.isEmpty()) {
                            System.out.println("Load data fail!!!");
                        } else {
                            System.out.println("Loat data success!!!");
                        }
                        System.out.println("---------------------------------");
                    }
                    break;
                case 2:
                    // addStudent
                    System.out.print("\tEnter number student want to add:");
                    int number = scan.nextInt();
                    for (int i = 0; i < number; i++) {
                        System.out.println("\n\t\tInformation of new student  " + (i + 1) + "\n");
                        boolean flag = studentModel.add(listStudent, studentModel.input());
                        if (flag) {
                            System.out.println("Add new student sucess!!");
                        } else {
                            System.out.println("Add new student fail!!");
                        }
                        if (i == (number - 1)) {
                            scan.nextLine();
                        }
                        System.out.println("---------------------------------");
                    }
                    break;
                case 3: {
                    //Update
                    System.out.print("Enter rollNumber you want to update :");
                    String rollNumber = scan.nextLine().trim();
                    boolean test = studentModel.update(listStudent, rollNumber);
                    if (test == false) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("\n\tUpdate sucessful");
                    }
                    System.out.println("---------------------------------");
                    break;
                }
                case 4:
                    //delete
                    System.out.print("Enter rollNumber you want to delete :");
                    String rollNumber = scan.nextLine().trim();
                    boolean test = studentModel.delete(listStudent, rollNumber);
                    if (test == false) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("Delete sucessful");
                    }
                    System.out.println("---------------------------------");
                    break;

                case 5: {
                    //Search
                    ArrayList<Student> newStudent = new ArrayList<>();
                    newStudent = studentModel.search(listStudent);
                    if (newStudent.isEmpty() == true) {
                        System.out.println("Not found");
                    } else {
                        studentModel.display(newStudent);
                    }
                    break;
                }
                case 6: {
                    //Sort
                    /*
                    co 2 loai: 
                        - Compareable
                        - Comparetor
                    1. Commpareable - phai implement
                    obj student la noi trien khai
                    muon ten thi phai lam tren class person
                    => chi dc 1 cai 
                    2. Comparetor
                    => linh hoat hon 
                     */
                    studentModel.sort(listStudent);
                    studentModel.display(listStudent);
                    break;
                }
                case 7: {
                    //Display
                    studentModel.display(listStudent);
                    System.out.println("---------------------------------");
                    break;
                }
                case 8: {
                    System.out.print("Enter file name:");
                    String fileName = scan.nextLine();
                    fileMethod.writeDataToFile(listStudent, fileName);
                    System.out.println("Save data success!!!");
                    System.out.println("---------------------------------");
                    break;
                }
                case 9: {
                    break process;
                }
                default:
                    System.out.println("Enter function again");
                    break;
            }
            // Sub menu
            System.out.println("\n");
            System.out.println("1. Back to menu Student");
            System.out.println("2. Exit");
            System.out.print("You choose: ");
            isContinue = Integer.valueOf(scan.nextLine());
            System.out.println("");
            System.out.println("- - - - - - - - - - - -");
        } while (isContinue == 1);
    }
}
