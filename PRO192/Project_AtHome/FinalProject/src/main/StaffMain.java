///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package main;
//
//import entity.Staff;
//import java.util.ArrayList;
//import java.util.Scanner;
//import model.StaffModel;
//import ultis.FileMethodStaff;
///**
// *
// * @author Shado
// */
//public class StaffMain {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int isContinue = 0;
//        ArrayList<Staff> listStaff = new ArrayList<>();
//        StaffModel staffModel = new StaffModel();
//        FileMethodStaff fileMethod = new FileMethodStaff();
//        // start loop
//        process:
//        do {
//            // menu student
//            System.out.println("\n1. Data");
//            System.out.println("2. Add new Staff");
//            System.out.println("3. Update Staff");
//            System.out.println("4. Delete Staff");
//            System.out.println("5. Search ");
//            System.out.println("6. Sort ");
//            System.out.println("7. Display Staffs");
//            System.out.println("8. Save new list");
//            System.out.println("9. Exit");
//            System.out.print("\nYou choose: ");
//            int choose = Integer.valueOf(scan.nextLine());
//
//            System.out.println("- - - - - - - - - - - -");
//            switch (choose) {
//                case 1:
//                    // tim file
//                    System.out.println("\n1. Add new list");
//                    System.out.println("2. Load file");
//                    System.out.print("You choose: ");
//                    int f1 = Integer.valueOf(scan.nextLine());
//                    if (f1 == 1) {
//                        System.out.println("Add new list sucess!!!");
//                    } else {
//                        System.out.print("Enter file name: ");
//                        String fileName = scan.nextLine();
//                        listStaff = new FileMethodStaff().readDatatoFile(fileName);
//                        // viet them check xem co file day hay ko
//                        /*
//                            list=null // tat ca cac obj luu vs contructor ko tg mac dinh la null
//                            list=emtity // 
//                         */
//
//                        if (listStaff != null && listStaff.isEmpty()) {
//                            System.out.println("Load data fail!!!");
//                        } else {
//                            System.out.println("Loat data success!!!");
//                        }
//                        System.out.println("---------------------------------");
//                    }
//                    break;
//                case 2:
//                    // addStudent
//                    System.out.print("\tEnter number staff want to add:");
//                    int number = scan.nextInt();
//                    for (int i = 0; i < number; i++) {
//                        System.out.println("\n\t\tInformation of new staff  " + (i + 1) + "\n");
//                        boolean flag = staffModel.add(listStaff, staffModel.input());
//                        if (flag) {
//                            System.out.println("Add new staff sucess!!");
//                        } else {
//                            System.out.println("Add new staff fail!!");
//                        }
//                        if (i == (number - 1)) {
//                            scan.nextLine();
//                        }
//                        System.out.println("---------------------------------");
//                    }
//                    break;
//                case 3: {
//                    //Update
//                    staffModel.update(listStaff);
//                    System.out.println("---------------------------------");
//                    break;
//                }
//                case 4:
//                    //delete
//                    System.out.print("Enter rollNumber you want to delete :");
//                    String rollNumber = scan.nextLine();
//                    staffModel.delete(listStaff, rollNumber);
//                    System.out.println("---------------------------------");
//                    break;
//
//                case 5: {
//                    //Search
//                    System.out.println("1.Search name");
//                    System.out.println("2.Search salary");
//                    System.out.print("Enter your choose:");
//                    int numberFuntion = Integer.valueOf(scan.nextLine());
//                    switch (numberFuntion) {
//                        case 1: {
//                            System.out.print("Enter name :");
//                            String name = scan.nextLine();
//                            staffModel.search(listStaff, name);
//                            break;
//                        }
//                        case 2: {
//                            System.out.print("Enter mark :");
//                            double mark = Double.valueOf(scan.nextLine());
//                            staffModel.search(listStaff, mark);
//                            break;
//                        }
//                        default: {
//                            System.out.println("Not exsit funtion");
//                            break;
//                        }
//                    }
//                    break;
//                }
//                case 6: {                   
//                    staffModel.sort(listStaff);
//                    staffModel.display(listStaff);
//                    break;
//                }
//                case 7: {
//                    //Display
//                    staffModel.display(listStaff);
//                    System.out.println("---------------------------------");
//                    break;
//                }
//                case 8: {
//                    System.out.print("Enter file name:");
//                    String fileName = scan.nextLine();
//                    fileMethod.writeDataToFile(listStaff, fileName);
//                    System.out.println("Save data success!!!");
//                    System.out.println("---------------------------------");
//                    break;
//                }
//                case 9: {
//                    break process;
//                }
//                default:
//                    System.out.println("Enter function again");
//                    break;
//            }
//            // Sub menu
//            System.out.println("\n");
//            System.out.println("1. Back to menu Staff");
//            System.out.println("2. Exit");
//            System.out.print("You choose: ");
//            isContinue = Integer.valueOf(scan.nextLine());
//            System.out.println("");
//            System.out.println("- - - - - - - - - - - -");
//        } while (isContinue == 1);
//    }
//}
